package cn.navitool;

import android.content.Context;
import android.util.Base64;
import android.util.Log;

import com.tananaev.adblib.AdbConnection;
import com.tananaev.adblib.AdbCrypto;
import com.tananaev.adblib.AdbStream;

import java.io.File;
import java.net.Socket;
import java.security.KeyPair;
import java.util.concurrent.atomic.AtomicBoolean;

public class AdbShell {
    private static final String TAG = "AdbShell";
    private static final int PORT = 5555;
    private static final String HOST = "localhost";

    private AdbConnection connection;
    private AtomicBoolean isConnected = new AtomicBoolean(false);
    private Context context;

    private static AdbShell instance;

    public static synchronized AdbShell getInstance(Context context) {
        if (instance == null) {
            instance = new AdbShell(context.getApplicationContext());
        }
        return instance;
    }

    private AdbShell(Context context) {
        this.context = context;
    }

    private AtomicBoolean isConnecting = new AtomicBoolean(false);

    public void connect() {
        if (isConnected.get() || isConnecting.get())
            return;

        isConnecting.set(true);
        sendBroadcast("正在连接...");

        new Thread(() -> {
            try {
                DebugLogger.d(TAG, "Connecting to " + HOST + ":" + PORT);
                Socket socket = new Socket(HOST, PORT);

                AdbCrypto crypto = setupCrypto();
                if (crypto == null) {
                    DebugLogger.e(TAG, "Failed to setup crypto");
                    isConnecting.set(false);
                    sendBroadcast("连接失败: 密钥生成错误");
                    return;
                }

                connection = AdbConnection.create(socket, crypto);
                connection.connect();

                isConnected.set(true);
                DebugLogger.i(TAG, "ADB Connected successfully");
                sendBroadcast("已连接");

            } catch (Throwable e) {
                DebugLogger.e(TAG, "ADB Connection failed", e);
                isConnected.set(false);
                sendBroadcast("连接失败: " + e.getMessage());
            } finally {
                isConnecting.set(false);
            }
        }).start();
    }

    private void sendBroadcast(String status) {
        if (context != null) {
            android.content.Intent intent = new android.content.Intent("cn.navitool.ADB_STATUS_CHANGED");
            intent.putExtra("status", status);
            context.sendBroadcast(intent);
        }
    }

    private AdbCrypto setupCrypto() {
        try {
            File privateKeyFile = new File(context.getFilesDir(), "adbkey");
            File publicKeyFile = new File(context.getFilesDir(), "adbkey.pub");

            if (!privateKeyFile.exists()) {
                AdbCrypto crypto = AdbCrypto.generateAdbKeyPair(new AdbBase64Impl());
                crypto.saveAdbKeyPair(privateKeyFile, publicKeyFile);
                return crypto;
            } else {
                return AdbCrypto.loadAdbKeyPair(new AdbBase64Impl(), privateKeyFile, publicKeyFile);
            }
        } catch (Exception e) {
            DebugLogger.e(TAG, "Crypto setup error", e);
            return null;
        }
    }

    public void exec(String command) {
        if (!isConnected.get() || connection == null) {
            DebugLogger.w(TAG, "Not connected, trying to connect...");
            connect();
            // TODO: Queue command or wait? For now just return.
            return;
        }

        new Thread(() -> {
            AdbStream stream = null;
            try {
                stream = connection.open("shell:" + command);
                // Read output to keep stream alive until command finishes
                while (!stream.isClosed()) {
                    try {
                        stream.read();
                    } catch (java.io.IOException e) {
                        // "Stream closed" is often expected EOF from ADB
                        break;
                    }
                }
                DebugLogger.d(TAG, "Executed: " + command);
            } catch (Throwable e) {
                // Log but don't crash
                DebugLogger.e(TAG, "Command execution error (safe to ignore if successful): " + e.getMessage());
            } finally {
                if (stream != null) {
                    try {
                        stream.close();
                    } catch (Exception e) {
                        /* ignore */ }
                }
            }
        }).start();
    }

    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                // Ignore
            }
        }
        isConnected.set(false);
    }

    // Helper class for AdbCrypto
    private static class AdbBase64Impl implements com.tananaev.adblib.AdbBase64 {
        @Override
        public String encodeToString(byte[] data) {
            return Base64.encodeToString(data, Base64.NO_WRAP);
        }
    }

    public void broadcastStatus() {
        if (isConnected.get()) {
            sendBroadcast("已连接");
        } else if (isConnecting.get()) {
            sendBroadcast("正在连接...");
        } else {
            sendBroadcast("未连接");
        }
    }

    // Wrapper for Connection check
    public boolean isConnected() {
        return isConnected.get();
    }
}
