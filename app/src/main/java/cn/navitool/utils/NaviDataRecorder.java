package cn.navitool.utils;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import cn.navitool.interfaces.NaviStatusListener;
import cn.navitool.model.GuideInfo;
import cn.navitool.model.TrafficLightInfo;

public class NaviDataRecorder implements NaviStatusListener {
    private static final String TAG = "NaviDataRecorder";
    private static final String PACKET_TAG = "NaviPacket"; // For Logcat filtering
    private static NaviDataRecorder instance;

    private List<JSONObject> mPacketBuffer;
    private File mCurrentLogFile;
    private int mPacketCount = 0;
    private SimpleDateFormat mTimeFormat;
    private String mExportTime;
    private Context mContext; // Kept for future context needs (e.g. storage checks)

    private NaviDataRecorder() {
        mPacketBuffer = new ArrayList<>();
        mTimeFormat = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
    }

    public static synchronized NaviDataRecorder getInstance() {
        if (instance == null) {
            instance = new NaviDataRecorder();
        }
        return instance;
    }

    public void init(Context context) {
        mContext = context.getApplicationContext();
        createNewLogFile();
    }

    private void createNewLogFile() {
        try {
            SimpleDateFormat fileDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
            mExportTime = fileDateFormat.format(new Date());
            String fileName = "nav_record_" + mExportTime + ".json";

            // User specified path: /sdcard/NaviTool/
            File dir = new File(Environment.getExternalStorageDirectory(), "NaviTool");
            if (!dir.exists()) {
                boolean created = dir.mkdirs();
                if (!created) {
                    Log.e(TAG, "Failed to create log directory: " + dir.getAbsolutePath());
                    return;
                }
            }

            mCurrentLogFile = new File(dir, fileName);
            mPacketCount = 0;
            mPacketBuffer.clear();
            Log.i(TAG, "Created new log file: " + mCurrentLogFile.getAbsolutePath());

            // Write initial JSON structure start
            // To make it valid JSON array or object, we might want to write structure at the end or append carefully.
            // But NaviTest format is an object containing a list. Streaming this is tricky without closing it properly.
            // For simplicity and robustness, we can write the full file on stop or periodically update it.
            // Given the requirement to record, appending to a file is safer against crashes.
            // However, JSON is strict.
            // Strategy: We will buffer in memory effectively, but since mobile memory is limited, 
            // maybe we just append line by line in a specific format or write valid JSON periodically.
            // Let's look at NaviTest format again:
            // { "exportTime": "...", "packetCount": N, "packets": [ ... ] }
            // To do this incrementally, we have to overwrite the file or just log to a text file and convert later.
            // BUT, the user asked for a "record document". 
            // Let's implement immediate write to file for robustness? No, JSON structure breaks.
            // Let's write to file periodically (e.g. every 10 packets) by re-writing the whole VALID JSON envelope if size is small,
            // or just ensure we write properly on stop.
            // For now, let's keep it in memory and flush periodically? No, risk of data loss.
            // DECISION: We will write each packet to Logcat immediately.
            // For the file, we will append to a temporary file (lines) and then wrap it in JSON when needed or just rewrite.
            // Actually, let's rewrite the file every update? Expensive.
            // Let's just keep it simple: Add to a JSON array in memory and save to file every X packets (e.g. 50).
            
        } catch (Exception e) {
            Log.e(TAG, "Error creating log file", e);
        }
    }

    public void stop() {
        saveToFile();
    }

    private synchronized void saveToFile() {
        if (mCurrentLogFile == null) return;

        try {
            JSONObject root = new JSONObject();
            root.put("exportTime", mExportTime);
            root.put("packetCount", mPacketCount);

            JSONArray packetsArray = new JSONArray();
            for (JSONObject p : mPacketBuffer) {
                packetsArray.put(p);
            }
            root.put("packets", packetsArray);

            FileWriter writer = new FileWriter(mCurrentLogFile); // Overwrite mode
            writer.write(root.toString(2)); // Indent 2 for readability
            writer.flush();
            writer.close();
            // Log.d(TAG, "Saved log to file. Packets: " + mPacketCount);
        } catch (Exception e) {
            Log.e(TAG, "Error saving log file", e);
        }
    }

    @Override
    public void onNaviStatusChanged(int status) {
        // No-op for recorder usually, unless we want to log status changes too
    }

    @Override
    public void onTrafficLightUpdate(List<TrafficLightInfo> lights) {
        // No-op
    }

    @Override
    public void onGuideInfoUpdate(GuideInfo info) {
        // No-op
    }

    @Override
    public void onOriginalPacketReceived(String rawJson, JSONObject parsedJson) {
        // 1. Logcat Output
        Log.d(PACKET_TAG, rawJson);

        // 2. File Recording
        try {
            mPacketCount++;
            JSONObject packetEntry = new JSONObject();
            packetEntry.put("index", mPacketCount);
            packetEntry.put("time", mTimeFormat.format(new Date()));
            // We use the parsed object to avoid double escaping strings, 
            // or if rawJson is what we want, we can parse it to object
            if (parsedJson != null) {
                packetEntry.put("data", parsedJson);
            } else {
                 packetEntry.put("data", new JSONObject(rawJson));
            }

            mPacketBuffer.add(packetEntry);

            // Periodically save to disk (e.g. every 20 packets) to prevent data loss on crash
            if (mPacketCount % 20 == 0) {
                saveToFile();
            }

        } catch (Exception e) {
            Log.e(TAG, "Error recording packet", e);
        }
    }
}
