package cn.navitool;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.view.View;

import com.google.android.material.button.MaterialButton;

/**
 * 模拟功能管理类
 * 用于管理各种模拟信号的触发功能（发动机启动、转向灯等）
 */
public class SimulateFunction {
    private static final String TAG = "SimulateFunction";
    
    // 广播Action常量
    public static final String ACTION_SIMULATE_ENGINE_START = "cn.navitool.ACTION_SIMULATE_ENGINE_START";
    
    private final Context mContext;
    private final Handler mMainHandler = new Handler(Looper.getMainLooper());
    
    // 转向灯模拟状态
    private boolean mIsSimulatingTurnSignal = false;
    private int mTurnSignalState = 0; // 0=关闭, 1=左转, 2=右转, 3=双闪
    private Runnable mTurnSignalRunnable;
    
    public SimulateFunction(Context context) {
        mContext = context;
    }
    
    /**
     * 设置模拟发动机启动按钮
     */
    public void setupEngineStartButton(View btnSimulate) {
        if (btnSimulate == null) return;
        
        btnSimulate.setOnClickListener(v -> {
            DebugLogger.i(TAG, "Simulating Engine Start - Sending broadcast");
            DebugLogger.toast(mContext, "模拟发动机启动");
            Intent intent = new Intent(ACTION_SIMULATE_ENGINE_START);
            intent.setPackage(mContext.getPackageName());
            mContext.sendBroadcast(intent);
        });
    }
    
    /**
     * 设置模拟转向灯按钮
     * 点击循环切换：关闭 -> 左转 -> 右转 -> 双闪 -> 关闭
     */
    public void setupTurnSignalButton(MaterialButton btnTurnSignal) {
        if (btnTurnSignal == null) return;
        
        // 初始化按钮状态
        updateTurnSignalButton(btnTurnSignal, mTurnSignalState);
        
        btnTurnSignal.setOnClickListener(v -> {
            // 循环切换状态
            mTurnSignalState = (mTurnSignalState + 1) % 4;
            updateTurnSignalButton(btnTurnSignal, mTurnSignalState);
            
            // 触发模拟
            simulateTurnSignal(mTurnSignalState);
        });
    }
    
    /**
     * 更新转向灯按钮的显示状态
     */
    private void updateTurnSignalButton(MaterialButton btn, int state) {
        String[] stateTexts = {"模拟转向灯", "模拟左转", "模拟右转", "模拟双闪"};
        int[] iconRes = {R.drawable.ic_close, R.drawable.ic_check, R.drawable.ic_check, R.drawable.ic_check};
        
        btn.setText(stateTexts[state]);
        btn.setIconResource(iconRes[state]);
    }
    
    /**
     * 模拟转向灯信号
     * @param state 0=关闭, 1=左转, 2=右转, 3=双闪
     */
    private void simulateTurnSignal(int state) {
        // 停止之前的模拟
        stopTurnSignalSimulation();
        
        if (state == 0) {
            // 关闭转向灯
            ClusterHudManager.getInstance(mContext).updateTurnSignal(true, false);
            ClusterHudManager.getInstance(mContext).updateTurnSignal(false, false);
            DebugLogger.toast(mContext, "转向灯已关闭");
            return;
        }
        
        mIsSimulatingTurnSignal = true;
        final boolean isLeft = (state == 1);
        final boolean isRight = (state == 2);
        final boolean isHazard = (state == 3);
        
        String msg = isHazard ? "双闪" : (isLeft ? "左转" : "右转");
        DebugLogger.toast(mContext, "模拟" + msg + "灯闪烁");
        DebugLogger.i(TAG, "Simulating Turn Signal: " + msg);
        
        // 创建闪烁效果
        mTurnSignalRunnable = new Runnable() {
            boolean isOn = true;
            
            @Override
            public void run() {
                if (!mIsSimulatingTurnSignal) return;
                
                if (isHazard) {
                    // 双闪：左右同时闪
                    ClusterHudManager.getInstance(mContext).updateTurnSignal(true, isOn);
                    ClusterHudManager.getInstance(mContext).updateTurnSignal(false, isOn);
                } else if (isLeft) {
                    ClusterHudManager.getInstance(mContext).updateTurnSignal(true, isOn);
                    ClusterHudManager.getInstance(mContext).updateTurnSignal(false, false);
                } else {
                    ClusterHudManager.getInstance(mContext).updateTurnSignal(true, false);
                    ClusterHudManager.getInstance(mContext).updateTurnSignal(false, isOn);
                }
                
                isOn = !isOn;
                
                // 继续闪烁（500ms间隔）
                mMainHandler.postDelayed(this, 500);
            }
        };
        
        mMainHandler.post(mTurnSignalRunnable);
    }
    
    /**
     * 停止转向灯模拟
     */
    public void stopTurnSignalSimulation() {
        mIsSimulatingTurnSignal = false;
        if (mTurnSignalRunnable != null) {
            mMainHandler.removeCallbacks(mTurnSignalRunnable);
            mTurnSignalRunnable = null;
        }
    }
    
    /**
     * 释放资源
     */
    public void release() {
        stopTurnSignalSimulation();
    }
    
    // ==================== 静态广播接收器 ====================
    
    /**
     * 模拟发动机点火广播接收器
     * 用于接收模拟发动机启动的广播命令
     * 
     * 在AndroidManifest.xml中注册:
     * <receiver android:name=".SimulateFunction$IgnitionReceiver" android:exported="false">
     *     <intent-filter>
     *         <action android:name="cn.navitool.ACTION_SIMULATE_ENGINE_START" />
     *     </intent-filter>
     * </receiver>
     */
    public static class IgnitionReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (ACTION_SIMULATE_ENGINE_START.equals(intent.getAction())) {
                try {
                    android.widget.Toast.makeText(context, "收到模拟点火广播", android.widget.Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    // 忽略后台线程或上下文问题
                }

                DebugLogger.i("SimulateFunction.IgnitionReceiver", "Received Simulation Broadcast");
                if (KeepAliveAccessibilityService.getInstance() != null) {
                    // 重置点火状态以确保每次请求都能触发
                    KeepAliveAccessibilityService.getInstance().resetIgnitionState();
                    KeepAliveAccessibilityService.getInstance().handleIgnitionDriving();
                } else {
                    DebugLogger.e("SimulateFunction.IgnitionReceiver", "Service is NULL - cannot simulate ignition");
                    try {
                        android.widget.Toast.makeText(context, "错误: 无障碍服务未运行!", android.widget.Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        // 忽略
                    }
                }
            }
        }
    }
}

