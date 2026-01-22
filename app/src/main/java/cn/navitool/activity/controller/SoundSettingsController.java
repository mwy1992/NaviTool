package cn.navitool.activity.controller;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.os.Build;
import android.os.Environment;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.switchmaterial.SwitchMaterial;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cn.navitool.R;
import cn.navitool.managers.ConfigManager;
import cn.navitool.managers.SoundPromptManager;
import cn.navitool.utils.DebugLogger;

public class SoundSettingsController {
    private final Activity mActivity;
    private View mLayoutSound;

    public SoundSettingsController(Activity activity, View layoutSound) {
        this.mActivity = activity;
        this.mLayoutSound = layoutSound;
    }

    public void setupSoundSwitches() {
        if (mLayoutSound == null) return;

        // Master Switch
        SwitchMaterial switchMaster = mLayoutSound.findViewById(R.id.switchSoundMaster);
        View layoutSoundContent = mLayoutSound.findViewById(R.id.layoutSoundContent);

        if (switchMaster != null) {
            // Default to TRUE to maintain backward compatibility
            boolean isMaster = ConfigManager.getInstance().getBoolean("sound_master_enabled", true);
            switchMaster.setChecked(isMaster);

            // [FIX] Initial Visibility
            View layoutSoundHeaderOptions = mLayoutSound.findViewById(R.id.layoutSoundHeaderOptions);
            int v = isMaster ? View.VISIBLE : View.GONE;
            
            if (layoutSoundContent != null) {
                layoutSoundContent.setVisibility(v);
            }
            if (layoutSoundHeaderOptions != null) {
                layoutSoundHeaderOptions.setVisibility(v);
            }

            switchMaster.setOnCheckedChangeListener((vSwitch, isChecked) -> {
                ConfigManager.getInstance().setBoolean("sound_master_enabled", isChecked);
                // [FIX] Toggle Visibility
                int newVisibility = isChecked ? View.VISIBLE : View.GONE;
                if (layoutSoundContent != null) {
                    layoutSoundContent.setVisibility(newVisibility);
                }
                if (layoutSoundHeaderOptions != null) {
                    layoutSoundHeaderOptions.setVisibility(newVisibility);
                }
            });
        }

        // Playback Mode Selection
        RadioGroup rgMode = mLayoutSound.findViewById(R.id.rgSoundPlaybackMode);
        if (rgMode != null) {
            boolean isDirect = ConfigManager.getInstance().getBoolean("sound_playback_mode_direct", false);
            rgMode.check(isDirect ? R.id.rbSoundModeDirect : R.id.rbSoundModeMix);

            // Sync initial state to Manager
            SoundPromptManager.getInstance(mActivity).setPlaybackMode(isDirect);

            rgMode.setOnCheckedChangeListener((group, checkedId) -> {
                boolean direct = (checkedId == R.id.rbSoundModeDirect);
                ConfigManager.getInstance().setBoolean("sound_playback_mode_direct", direct);
                SoundPromptManager.getInstance(mActivity).setPlaybackMode(direct);
            });
        }

        // Sound Channel Selection
        // [ECARX] 使用 ECARX 定义的通道值: CHANNEL_ENT=0 (媒体), CHANNEL_NAVI=1 (导航)
        RadioGroup rgChannel = mLayoutSound.findViewById(R.id.rgSoundChannel);
        if (rgChannel != null) {
            // 默认使用导航通道 (CHANNEL_NAVI = 1)
            int savedChannel = ConfigManager.getInstance().getInt("sound_ecarx_channel",
                    SoundPromptManager.ECARX_CHANNEL_NAVI);
            rgChannel.check(savedChannel == SoundPromptManager.ECARX_CHANNEL_ENT
                    ? R.id.rbSoundChannelMedia
                    : R.id.rbSoundChannelNavi);

            // Sync initial state
            SoundPromptManager.getInstance(mActivity).setEcarxChannel(savedChannel);

            rgChannel.setOnCheckedChangeListener((group, checkedId) -> {
                int channel = (checkedId == R.id.rbSoundChannelMedia)
                        ? SoundPromptManager.ECARX_CHANNEL_ENT
                        : SoundPromptManager.ECARX_CHANNEL_NAVI;
                ConfigManager.getInstance().setInt("sound_ecarx_channel", channel);
                SoundPromptManager.getInstance(mActivity).setEcarxChannel(channel);
            });
        }

        // Sound Items (Refactored to use Card IDs)
        setupSoundItem(R.id.cardSoundStart, R.string.switch_sound_start, "sound_start");
        setupSoundItem(R.id.cardSoundGearD, R.string.switch_sound_gear_d, "sound_gear_d");
        setupSoundItem(R.id.cardSoundGearN, R.string.switch_sound_gear_n, "sound_gear_n");
        setupSoundItem(R.id.cardSoundGearR, R.string.switch_sound_gear_r, "sound_gear_r");
        setupSoundItem(R.id.cardSoundGearP, R.string.switch_sound_gear_p, "sound_gear_p");
        
        setupSoundItem(R.id.cardSoundDoorDriver, R.string.switch_sound_door_driver, "sound_door_driver");
        setupSoundItem(R.id.cardSoundDoorDriverClose, R.string.switch_sound_door_driver_close, "sound_door_driver_close");

        setupSoundItem(R.id.cardSoundDoorPassenger, R.string.switch_sound_door_passenger, "sound_door_passenger");
        setupSoundItem(R.id.cardSoundDoorPassengerClose, R.string.switch_sound_door_passenger_close, "sound_door_passenger_close");
        
        setupSoundItem(R.id.cardSoundDoorPassengerEmpty, R.string.switch_sound_door_passenger_empty, "sound_door_passenger_empty");
        setupSoundItem(R.id.cardSoundDoorPassengerEmptyClose, R.string.switch_sound_door_passenger_empty_close, "sound_door_passenger_empty_close");
        
        setupSoundItem(R.id.cardSoundDoorRearLeft, R.string.switch_sound_door_rear_left, "sound_door_rear_left");
        setupSoundItem(R.id.cardSoundDoorRearLeftClose, R.string.switch_sound_door_rear_left_close, "sound_door_rear_left_close");
        
        setupSoundItem(R.id.cardSoundDoorRearRight, R.string.switch_sound_door_rear_right, "sound_door_rear_right");
        setupSoundItem(R.id.cardSoundDoorRearRightClose, R.string.switch_sound_door_rear_right_close, "sound_door_rear_right_close");
        
        setupSoundItem(R.id.cardSoundDoorHood, R.string.switch_sound_door_hood, "sound_door_hood");
        setupSoundItem(R.id.cardSoundDoorHoodClose, R.string.switch_sound_door_hood_close, "sound_door_hood_close");
        
        setupSoundItem(R.id.cardSoundDoorTrunk, R.string.switch_sound_door_trunk, "sound_door_trunk");
        setupSoundItem(R.id.cardSoundDoorTrunkClose, R.string.switch_sound_door_trunk_close, "sound_door_trunk_close");

        configureTestButtonsVisibility();
    }

    private void setupSoundItem(int cardId, int titleResId, String keyPrefix) {
        View card = mLayoutSound.findViewById(cardId);
        if (card == null) return;

        TextView tvTitle = card.findViewById(R.id.tvSoundTitle);
        if (tvTitle != null) {
            tvTitle.setText(titleResId);
        }

        SwitchMaterial switchView = card.findViewById(R.id.switchSound);
        Button btnSelect = card.findViewById(R.id.btnSelectSound);
        Button btnTest = card.findViewById(R.id.btnTestSound);
        TextView tvFile = card.findViewById(R.id.tvSoundFile);
        
        String enabledKey = keyPrefix + "_enabled";
        String fileKey = keyPrefix + "_file";

        if (switchView != null) {
            switchView.setChecked(ConfigManager.getInstance().getBoolean(enabledKey, false));
            switchView.setOnCheckedChangeListener((buttonView, isChecked) -> {
                ConfigManager.getInstance().setBoolean(enabledKey, isChecked);
            });
        }

        if (tvFile != null) {
            String selectedFile = ConfigManager.getInstance().getString(fileKey, null);
            tvFile.setText(selectedFile != null ? selectedFile : mActivity.getString(R.string.text_default_sound));
        }

        if (btnSelect != null) {
            btnSelect.setOnClickListener(v -> showSoundFileSelector(fileKey, tvFile));
        }

        if (btnTest != null) {
            btnTest.setOnClickListener(
                    v -> testPlaySound(ConfigManager.getInstance().getString(fileKey, null), keyPrefix));
        }
    }

    private void showSoundFileSelector(String fileKey, TextView tvFile) {
        // Check and request storage permission at runtime
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            boolean hasRead = mActivity.checkSelfPermission(
                    Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
            boolean hasWrite = mActivity.checkSelfPermission(
                    Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
            if (!hasRead || !hasWrite) {
                mActivity.requestPermissions(new String[] {
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                }, 200);
                Toast.makeText(mActivity, "权限申请中，同意后请重启APP生效", Toast.LENGTH_LONG).show();
                return;
            }
        }

        // Standard path logic
        File soundDir = new File(Environment.getExternalStorageDirectory(), "NaviTool/Sound");

        DebugLogger.d("SoundSelector", "Path: " + soundDir.getAbsolutePath());

        // Initial check
        if (!soundDir.exists() || !soundDir.isDirectory()) {
            new android.app.AlertDialog.Builder(mActivity)
                    .setTitle(R.string.dialog_title_select_sound)
                    .setMessage(mActivity.getString(R.string.dialog_no_files_message) + "\n\n路径: " + soundDir.getAbsolutePath())
                    .setPositiveButton(android.R.string.ok, null)
                    .show();
            return;
        }

        // Try to list files
        File[] files = soundDir
                .listFiles((dir, name) -> name.toLowerCase().endsWith(".mp3") || name.toLowerCase().endsWith(".wav"));

        // Debug
        DebugLogger.d("SoundSelector", "canRead: " + soundDir.canRead());
        DebugLogger.d("SoundSelector", "listFiles: " + (files != null ? files.length : "null"));

        if (files == null || files.length == 0) {
            String msg = mActivity.getString(R.string.dialog_no_files_message) + "\n\n路径: " + soundDir.getAbsolutePath();

            if (!soundDir.canRead() || files == null) {
                msg += "\n\n【权限错误】无法读取文件列表。\n请尝试 >>彻底重启APP<< (关闭后台进程) 以刷新权限组。";
                msg += "\n(可读: " + soundDir.canRead() + ")";
            }

            // Also list ALL files in directory for debugging if it was just empty filter
            if (files != null && files.length == 0) {
                File[] allFiles = soundDir.listFiles();
                if (allFiles != null && allFiles.length > 0) {
                    msg += "\n\n检测到 " + allFiles.length + " 个非音频文件。";
                } else {
                    msg += "\n\n目录为空。";
                }
            }

            new android.app.AlertDialog.Builder(mActivity)
                    .setTitle(R.string.dialog_title_select_sound)
                    .setMessage(msg)
                    .setPositiveButton(android.R.string.ok, null)
                    .show();
            return;
        }

        String[] fileNames = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            fileNames[i] = files[i].getName();
        }

        new android.app.AlertDialog.Builder(mActivity)
                .setTitle(R.string.dialog_title_select_sound)
                .setItems(fileNames, (dialog, which) -> {
                    String selectedFile = fileNames[which];
                    ConfigManager.getInstance().setString(fileKey, selectedFile);
                    if (tvFile != null) {
                        tvFile.setText(selectedFile);
                    }
                    Toast.makeText(mActivity, mActivity.getString(R.string.toast_sound_selected, selectedFile),
                            Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton(android.R.string.cancel, null)
                .show();
    }

    private void testPlaySound(String filename, String keyPrefix) {
        String finalName = filename;
        if (finalName == null) {
            // Map default filenames based on keys
            if (keyPrefix.equals("sound_start"))
                finalName = "start.mp3";
            else if (keyPrefix.equals("sound_gear_d"))
                finalName = "gear_d.mp3";
            else if (keyPrefix.equals("sound_gear_n"))
                finalName = "gear_n.mp3";
            else if (keyPrefix.equals("sound_gear_r"))
                finalName = "gear_r.mp3";
            else if (keyPrefix.equals("sound_gear_p"))
                finalName = "gear_p.mp3";
            else if (keyPrefix.equals("sound_door_passenger"))
                finalName = "door_passenger.mp3";
        }

        final String resolvedName = finalName;
        File soundFile = new File(Environment.getExternalStorageDirectory(),
                "NaviTool/Sound/" + resolvedName);
        if (soundFile.exists()) {
            // [FIX] Use SoundPromptManager to ensure selected audio channel is respected
            SoundPromptManager.getInstance(mActivity)
                    .playCustomSound(soundFile.getAbsolutePath());
            DebugLogger.d("MainActivity", "Test playing sound via SoundPromptManager: " + resolvedName);
        } else {
            DebugLogger.w("MainActivity", "Sound file not found for test: " + resolvedName);
            Toast.makeText(mActivity, "文件不存在: " + resolvedName, Toast.LENGTH_SHORT).show();
        }
    }

    private void configureTestButtonsVisibility() {
        // [Release] Always show test buttons per user feedback/testing
        // Or if we want to respect the debug flag:
        // int visibility = DebugLogger.isDebugEnabled(mActivity) ? View.VISIBLE : View.GONE;
        int visibility = View.VISIBLE;
        
        int[] cardIds = {
            R.id.cardSoundStart,
            R.id.cardSoundGearD,
            R.id.cardSoundGearN,
            R.id.cardSoundGearR,
            R.id.cardSoundGearP,
            R.id.cardSoundDoorDriver,
            R.id.cardSoundDoorDriverClose,
            R.id.cardSoundDoorPassenger,
            R.id.cardSoundDoorPassengerClose,
            R.id.cardSoundDoorPassengerEmpty,
            R.id.cardSoundDoorPassengerEmptyClose,
            R.id.cardSoundDoorRearLeft,
            R.id.cardSoundDoorRearLeftClose,
            R.id.cardSoundDoorRearRight,
            R.id.cardSoundDoorRearRightClose,
            R.id.cardSoundDoorHood,
            R.id.cardSoundDoorHoodClose,
            R.id.cardSoundDoorTrunk,
            R.id.cardSoundDoorTrunkClose
        };

        for (int cardId : cardIds) {
            View card = mLayoutSound.findViewById(cardId);
            if (card != null) {
                View btnTest = card.findViewById(R.id.btnTestSound);
                if (btnTest != null) {
                    btnTest.setVisibility(visibility);
                }
            }
        }
    }
}
