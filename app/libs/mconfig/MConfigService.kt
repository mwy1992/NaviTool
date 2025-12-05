package ru.monjaro.mconfig

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.os.Message
import androidx.core.app.NotificationCompat
import androidx.preference.PreferenceManager

class MConfigStartProc{
    companion object {
        var bootStartService: Boolean = false
        var serviceStarted: Boolean = false

        fun startService(context: Context?, override:Boolean) {
            var needToStart:Boolean? = false
            if(!override) {
                val preferences = context?.let { PreferenceManager.getDefaultSharedPreferences(it) };
                needToStart = preferences?.getBoolean(IdNames.StartService_key, false)
            }else{
                needToStart = true
            }
            if (needToStart == true && context != null && !serviceStarted) {

                context.startForegroundService(
                    Intent(context, MConfigService::class.java)
                )
            }
        }

        fun startInitService(context: Context?) {
            context?.startForegroundService(
                Intent(context, MConfigInitService::class.java)
            )
        }

        fun stopService(context: Context?) {
            context?.startService(Intent(context, MConfigService::class.java).setAction("STOP_SERVICE"))
        }
    }
}

class MConfigService: Service() {
    private val notificationChannelId = "service_notification"
    private var mConfigManager: MConfigManager? = null
    private var handler : Handler? = null
    private var notification: Notification? = null

    private fun notificationCreate(context:Context):Notification{
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager?

        notificationManager!!.createNotificationChannel(
            NotificationChannel(
                notificationChannelId,
                getString(R.string.app_name),
                NotificationManager.IMPORTANCE_HIGH
            )
        )
        val builder: NotificationCompat.Builder = NotificationCompat.Builder(
            context,
            notificationChannelId
        )

        val notifi = builder
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setAutoCancel(true)
            .setContentTitle("MConfig Service")
            .setContentText("MConfig Service started")
            .build()

        return notifi
    }

    @SuppressLint("ForegroundServiceType")
    override fun onCreate() {
        super.onCreate()

        if(notification == null){
            notification = notificationCreate(this)
        }

        startForeground(R.string.app_name, notification)
    }

    @SuppressLint("ForegroundServiceType")
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (intent?.action == "STOP_SERVICE") {
            stopSelf()
            MainActivity.setUpdatedData(IdNames.ERROR, "quit")
        }
        else {
            if (mConfigManager == null && !MConfigStartProc.serviceStarted ) {
                if(notification == null){
                    notification = notificationCreate(this)
                }
                startForeground(R.string.app_name, notification)
                if(handler == null){
                    handler = object : Handler(Looper.getMainLooper()) {
                        override fun handleMessage(msg: Message) {
                            super.handleMessage(msg)
                            try {
                                if (msg.what == IdNames.TOAST) {
                                    MainActivity.debugToast(applicationContext, msg.obj as String)
                                } else {
                                    MainActivity.setUpdatedData(msg.what, msg.obj as String)
                                }
                            }catch(_:Exception){}
                        }
                    }
                }
                mConfigManager = MConfigManager(applicationContext, handler)
                MConfigStartProc.serviceStarted = true
            }else{
                stopSelf()
            }
        }
        return super.onStartCommand(intent, flags, startId)
    }



    override fun onDestroy() {
        super.onDestroy()
        MConfigStartProc.serviceStarted = false
        if(mConfigManager != null) {
            mConfigManager?.destroy()
        }
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }


}