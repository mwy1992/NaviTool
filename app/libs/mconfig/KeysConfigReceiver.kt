package ru.monjaro.mconfig

import android.app.ActivityOptions
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.content.Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP
import android.content.Intent.FLAG_INCLUDE_STOPPED_PACKAGES
import android.media.AudioManager
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import android.view.KeyEvent
import android.widget.Toast
import androidx.preference.PreferenceManager
import com.ecarx.xui.adaptapi.diminteraction.DimInteraction
import com.ecarx.xui.adaptapi.diminteraction.IDimMenuInteraction
import com.ecarx.xui.adaptapi.input.KeyCode.KEYCODE_R_SRC
import ecarx.dimprotocol.DIMProtocolManager
import ru.monjaro.mconfig.KeysConfigReceiver.PackageData


data object  KeysConfigData{
    var timeStamp :Long = 0
    val handler = Handler(Looper.getMainLooper())
    val handlerSRCLong = Handler(Looper.getMainLooper())
    val handlerSRCShort = Handler(Looper.getMainLooper())
    var blockSRC:Boolean = false
    var delayedSRCLong:Boolean = false
    var pressedSRC:Int = 0

    val handlerVALong = Handler(Looper.getMainLooper())
    val handlerVAShort = Handler(Looper.getMainLooper())
    var blockVA:Boolean = false
    var delayedVALong:Boolean = false
    var pressedVA:Int = 0

    var iDimMenuInteraction: IDimMenuInteraction? = null

    var SRC_mode_default: Int = 0
    var SRC_mode_not_replaced: Boolean = false

    fun getPackageData(s: String?): PackageData? {
        val sA = s?.split(" [")
        if (sA != null && sA.size > 1 && sA[1] != "") {
            val i = sA[1].indexOf("]")
            if (i == (sA[1].length - 1)) {
                val s1 = sA[1].substring(0, sA[1].length - 1)
                val sA1 = s1.split(" / ");
                return PackageData(sA1[0], sA1[1])
            }
        }
        return null
    }

}

class KeysConfigReceiver : BroadcastReceiver() {
    data class PackageData(val name: String, val activity: String)

    private fun executeSrcCommand(context: Context?, v: Int?, s: String?) {
        if (context != null) {
            when (v) {
                ItemsSrcClick.START.value -> {
                    val p = KeysConfigData.getPackageData(s)
                    if (p != null) {
                        val int = Intent()
                        int.setAction("android.intent.action.MAIN")
                        int.setClassName(p.name, p.activity)
                        int.setFlags(FLAG_ACTIVITY_NEW_TASK)
                        var ret = false
                        try {
                            try {
                                val bundle: ActivityOptions = ActivityOptions.makeBasic()
                                bundle.setLaunchDisplayId(0)
                                context.startActivity(
                                    int,
                                    bundle.toBundle()
                                )
                                ret = true
                            } catch (_: Exception) { }
                        }catch (_: Error) {
                        }

                        if(!ret){
                            Toast.makeText(
                                context,
                                "应用启动错误",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        }
                    }
                }

                ItemsSrcClick.DRIVE_SPORT.value -> {
                    MConfigManager.sendMessageToThread(
                        IdNames.DRIVE_SPORT_KEYPRESSED,
                        "pressed"
                    )
                }

                ItemsSrcClick.DRIVE_SNOW.value -> {
                    MConfigManager.sendMessageToThread(
                        IdNames.DRIVE_SNOW_KEYPRESSED,
                        "pressed"
                    )
                }

                ItemsSrcClick.DRIVE_OFFROAD.value -> {
                    MConfigManager.sendMessageToThread(
                        IdNames.DRIVE_OFFROAD_KEYPRESSED,
                        "pressed"
                    )
                }

                ItemsSrcClick.MULTIMEDIA_MODE.value -> {
                    if(KeysConfigData.SRC_mode_not_replaced){
                        KeysConfigData.SRC_mode_default = 0
                    }else {
                        KeysConfigData.SRC_mode_default++
                        if (KeysConfigData.SRC_mode_default == 1) {
                            Toast.makeText(context, "SRC multimedia", Toast.LENGTH_SHORT).show()
                            for(i in 0 until 2){
                                val intD = Intent("android.intent.action.MEDIA_BUTTON")
                                intD.setFlags(FLAG_INCLUDE_STOPPED_PACKAGES)
                                intD.addFlags(FLAG_ACTIVITY_PREVIOUS_IS_TOP)
                                intD.addCategory("android.intent.category.DEFAULT")
                                val ke = KeyEvent(SystemClock.uptimeMillis(),SystemClock.uptimeMillis(), if(i==0) KeyEvent.ACTION_DOWN else KeyEvent.ACTION_UP,KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE, 0)
                                intD.putExtra("android.intent.extra.KEY_EVENT", ke)
                                context.sendBroadcast(intD)
                            }
                        }else{
                            Toast.makeText(context,"SRC android media",Toast.LENGTH_SHORT).show()
                            KeysConfigData.SRC_mode_default = 0
                            context.getSystemService(AudioManager::class.java)?.dispatchMediaKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE))
                            context.getSystemService(AudioManager::class.java)?.dispatchMediaKeyEvent(KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE))

                        }
                    }
                    //save that to prefs
                }

                ItemsSrcClick.SEND_INTENT.value -> {
                    val arr = s?.split(" / ")
                    if(arr!= null && arr[0] != "") {
                        val int = Intent(arr[0])
                        if(arr[1] != "") {
                            int.setPackage(arr[1])
                        }
                        int.setFlags(FLAG_ACTIVITY_NEW_TASK)
                        int.addFlags(FLAG_ACTIVITY_PREVIOUS_IS_TOP)
                        context.sendBroadcast(int)
                    }
                    return
                }

                ItemsSrcClick.START_ON_DIM.value -> {
                    var ret = false
                    try {
                        try {
                            val p = KeysConfigData.getPackageData(s) ?: return
                            val dimProtocol: DIMProtocolManager? =
                                DIMProtocolManager.getInstance(context)
                            if (KeysConfigData.iDimMenuInteraction == null) {
                                val dimInteraction = DimInteraction.create(context)
                                KeysConfigData.iDimMenuInteraction =
                                    dimInteraction?.dimMenuInteraction
                            }

                            if (dimProtocol != null && KeysConfigData.iDimMenuInteraction != null) {
                                if (KeysConfigData.iDimMenuInteraction?.naviMode != 3) {
                                    if(PnAccessibilityService.topPackageName != null && PnAccessibilityService.topPackageName != p.name) {
                                        MainActivity.debugToast(context, PnAccessibilityService.topPackageName)
                                    }
                                    if (PnAccessibilityService.topPackageName == null || PnAccessibilityService.topPackageName == p.name) {
                                        KeysConfigData.iDimMenuInteraction!!.switchNaviMode(3)
                                        Thread.sleep(100)
                                        dimProtocol.sendMessageToDIM(
                                            2.toByte(),
                                            8.toByte(),
                                            8.toByte(),
                                            byteArrayOf(1)
                                        )
                                        Thread.sleep(200)
                                        val int = Intent("action.RESTART")
                                        int.setPackage("ru.monjaro.helper")
                                        int.putExtra("packageName", p.name)
                                        int.putExtra("packageActivity", p.activity)
                                        int.putExtra("displayId", 2)
                                        context.sendBroadcast(int)
                                    } else {
                                        val int = Intent("action.START")
                                        int.setPackage("ru.monjaro.helper")
                                        int.putExtra("packageName", p.name)
                                        int.putExtra("packageActivity", p.activity)
                                        context.sendBroadcast(int)
                                    }
                                } else {
                                    KeysConfigData.iDimMenuInteraction!!.switchNaviMode(1);
                                    Thread.sleep(100)
                                    dimProtocol.sendMessageToDIM(
                                        2.toByte(),
                                        8.toByte(),
                                        8.toByte(),
                                        byteArrayOf(1)
                                    );
                                    Thread.sleep(200)
                                    val int = Intent("action.RESTART")
                                    int.setPackage("ru.monjaro.helper")
                                    int.putExtra("packageName", p.name)
                                    int.putExtra("packageActivity", p.activity)
                                    context.sendBroadcast(int)
                                }
                            }
                            ret = true
                        } catch (_: Exception) {
                        }
                    }catch (_: Error) {
                    }
                    if(!ret){
                        Toast.makeText(
                            context,
                            "函数执行错误",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                }
            }
        }
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        var enabledSRC = false
        var enabledOldSRC = false
        var enabledMedia = false
        var enabledVA = false
        val preferences = context?.let { PreferenceManager.getDefaultSharedPreferences(it) };
        if (preferences != null) {
            if (preferences.getBoolean(IdNames.srcKey_key, false)) {
                enabledSRC = true
            }
            if (preferences.getBoolean(IdNames.voiceAssist_key, false)) {
                enabledVA = true
            }
        }
        if (intent != null) {

            if (enabledSRC) {
                if (("ecarx.intent.action.ECARX_KEY_RSRC_EVENT_DOWN" == intent.action && KeysConfigData.SRC_mode_default==0) || ("ecarx.intent.action.ECARX_KEY_ISRC_EVENT_DOWN" == intent.action)) {
                    if("ecarx.intent.action.ECARX_KEY_RSRC_EVENT_DOWN" == intent.action){
                        KeysConfigData.SRC_mode_not_replaced = true
                    }else{
                        KeysConfigData.SRC_mode_not_replaced = false
                    }
                    if(KeysConfigData.blockSRC){
                        return
                    }
                    KeysConfigData.delayedSRCLong = true
                    KeysConfigData.handlerSRCLong.removeCallbacksAndMessages(null)
                    KeysConfigData.handlerSRCLong.postDelayed({
                        KeysConfigData.delayedSRCLong = false
                        KeysConfigData.pressedSRC = 0

                        var v = preferences?.getInt(
                            IdNames.srcClickLongCfg_key,
                            ItemsSrcClick.NOT_USED.value
                        )
                        if (ItemsSrcClick.entries.firstOrNull { it.value == v } == null) {
                            v = ItemsSrcClick.NOT_USED.value
                        }
                        var s: String? = null
                        if(v==ItemsSrcClick.START.value || v==ItemsSrcClick.START_ON_DIM.value){
                            s = preferences?.getString(IdNames.srcAppLongCfg_key, "")
                        }else if(v==ItemsSrcClick.SEND_INTENT.value){
                            s = preferences?.getString(IdNames.srcIntentLongCfg_key, IdNames.intentDefaultAction)+" / "+preferences?.getString(IdNames.srcIntentPackageLongCfg_key, IdNames.intentDefaultPackage)
                        }else if(v!=ItemsSrcClick.DRIVE_SPORT.value && v!=ItemsSrcClick.DRIVE_SNOW.value && v!=ItemsSrcClick.DRIVE_OFFROAD.value && v!=ItemsSrcClick.MULTIMEDIA_MODE.value){
                            return@postDelayed
                        }

                        if (context != null) {
                            MainActivity.debugToast(context, "SRC Long Pressed")
                            executeSrcCommand(context.applicationContext, v, s)
                        }
                    }, 1400)

                    KeysConfigData.handlerSRCShort.removeCallbacksAndMessages(null)
                    KeysConfigData.pressedSRC++
                    return
                }
                if (("ecarx.intent.action.ECARX_KEY_RSRC_EVENT_UP" == intent.action && KeysConfigData.SRC_mode_default==0) || ("ecarx.intent.action.ECARX_KEY_ISRC_EVENT_UP" == intent.action)) {
                    if("ecarx.intent.action.ECARX_KEY_RSRC_EVENT_UP" == intent.action){
                        KeysConfigData.SRC_mode_not_replaced = true
                    }else{
                        KeysConfigData.SRC_mode_not_replaced = false
                    }
                    KeysConfigData.handlerSRCLong.removeCallbacksAndMessages(null)
                    if(!KeysConfigData.delayedSRCLong){
                        return
                    }

                    KeysConfigData.handlerSRCShort.postDelayed({
                        when(KeysConfigData.pressedSRC){
                            1 -> {
                                if(KeysConfigData.SRC_mode_default != 0){
                                    if (context != null) {
                                        MainActivity.debugToast(context, "SRC 1 Pressed")
                                        val int = Intent("ecarx.intent.action.ECARX_KEY_RSRC_EVENT")
                                        int.setFlags(FLAG_ACTIVITY_NEW_TASK)
                                        int.addFlags(FLAG_ACTIVITY_PREVIOUS_IS_TOP)
                                        int.addCategory("android.intent.category.DEFAULT")
                                        int.putExtra("ecarx.extra.ECARX_KEY_EVENT_TYPE", KEYCODE_R_SRC)
                                        context.sendBroadcast(int)
                                    }
                                }else{
                                    var v = preferences?.getInt(
                                        IdNames.srcClick1Cfg_key,
                                        ItemsSrcClick.NOT_USED.value
                                    )
                                    if (ItemsSrcClick.entries.firstOrNull { it.value == v } == null) {
                                        v = ItemsSrcClick.NOT_USED.value
                                    }
                                    var s: String? = null
                                    if(v==ItemsSrcClick.START.value || v==ItemsSrcClick.START_ON_DIM.value){
                                        s = preferences?.getString(IdNames.srcApp1Cfg_key, "")
                                    }else if(v==ItemsSrcClick.SEND_INTENT.value){
                                        s = preferences?.getString(IdNames.srcIntent1Cfg_key, IdNames.intentDefaultAction)+" / "+preferences?.getString(IdNames.srcIntentPackage1Cfg_key, IdNames.intentDefaultPackage)
                                    }else if(v!=ItemsSrcClick.DRIVE_SPORT.value && v!=ItemsSrcClick.DRIVE_SNOW.value && v!=ItemsSrcClick.DRIVE_OFFROAD.value){
                                        return@postDelayed
                                    }
                                    if (context != null) {
                                        MainActivity.debugToast(context, "SRC 1 Pressed")
                                        executeSrcCommand(context.applicationContext, v, s)
                                    }
                                }
                                KeysConfigData.blockSRC = true
                            }
                            2 -> {
                                var v = preferences?.getInt(
                                    IdNames.srcClick2Cfg_key,
                                    ItemsSrcClick.NOT_USED.value
                                )
                                if (ItemsSrcClick.entries.firstOrNull { it.value == v } == null) {
                                    v = ItemsSrcClick.NOT_USED.value
                                }
                                var s: String? = null
                                if(v==ItemsSrcClick.START.value || v==ItemsSrcClick.START_ON_DIM.value){
                                    s = preferences?.getString(IdNames.srcApp2Cfg_key, "")
                                }else if(v==ItemsSrcClick.SEND_INTENT.value){
                                    s = preferences?.getString(IdNames.srcIntent2Cfg_key, IdNames.intentDefaultAction)+" / "+preferences?.getString(IdNames.srcIntentPackage2Cfg_key, IdNames.intentDefaultPackage)
                                }else if(v!=ItemsSrcClick.DRIVE_SPORT.value && v!=ItemsSrcClick.DRIVE_SNOW.value && v!=ItemsSrcClick.DRIVE_OFFROAD.value && v!=ItemsSrcClick.MULTIMEDIA_MODE.value){
                                    return@postDelayed
                                }
                                if (context != null) {
                                    MainActivity.debugToast(context, "SRC 2 Pressed")
                                    executeSrcCommand(context.applicationContext, v, s)
                                }
                            }
                            3 -> {
                                var v = preferences?.getInt(
                                    IdNames.srcClick3Cfg_key,
                                    ItemsSrcClick.NOT_USED.value
                                )
                                if (ItemsSrcClick.entries.firstOrNull { it.value == v } == null) {
                                    v = ItemsSrcClick.NOT_USED.value
                                }
                                var s: String? = null
                                if(v==ItemsSrcClick.START.value || v==ItemsSrcClick.START_ON_DIM.value){
                                    s = preferences?.getString(IdNames.srcApp3Cfg_key, "")
                                }else if(v==ItemsSrcClick.SEND_INTENT.value){
                                    s = preferences?.getString(IdNames.srcIntent3Cfg_key, IdNames.intentDefaultAction)+" / "+preferences?.getString(IdNames.srcIntentPackage3Cfg_key, IdNames.intentDefaultPackage)
                                }else if(v!=ItemsSrcClick.DRIVE_SPORT.value && v!=ItemsSrcClick.DRIVE_SNOW.value && v!=ItemsSrcClick.DRIVE_OFFROAD.value && v!=ItemsSrcClick.MULTIMEDIA_MODE.value){
                                    return@postDelayed
                                }
                                if (context != null) {
                                    MainActivity.debugToast(context, "SRC 2 Pressed")
                                    executeSrcCommand(context.applicationContext, v, s)
                                }
                                KeysConfigData.blockSRC = true
                            }
                        }
                        KeysConfigData.pressedSRC = 0
                        if(KeysConfigData.blockSRC){
                            KeysConfigData.handlerSRCShort.postDelayed({
                                KeysConfigData.blockSRC = false
                            }, 500)
                        }
                    }, 900)
                    return
                }
            }else {
                if (("ecarx.intent.action.ECARX_KEY_RSRC_EVENT" == intent.action && KeysConfigData.SRC_mode_default==0) || ("ecarx.intent.action.ECARX_KEY_ISRC_EVENT" == intent.action)) {
                    if (preferences != null) {
                        if (preferences.getBoolean(IdNames.srcKeyOld_key, false)) {
                            enabledOldSRC = true
                        }
                    }
                    if (enabledOldSRC) {
                        if("ecarx.intent.action.ECARX_KEY_RSRC_EVENT" == intent.action){
                            KeysConfigData.SRC_mode_not_replaced = true
                        }else{
                            KeysConfigData.SRC_mode_not_replaced = false
                        }
                        if (System.currentTimeMillis() - KeysConfigData.timeStamp < 900) {
                            KeysConfigData.handler.removeCallbacksAndMessages(null)
                            var v =
                                preferences?.getInt(
                                    IdNames.srcClick2Cfg_key,
                                    ItemsSrcClick.NOT_USED.value
                                )
                            if (ItemsSrcClick.entries.firstOrNull { it.value == v } == null) {
                                v = ItemsSrcClick.NOT_USED.value
                            }
                            var s: String? = null
                            if(v==ItemsSrcClick.START.value || v==ItemsSrcClick.START_ON_DIM.value){
                                s = preferences?.getString(IdNames.srcApp2Cfg_key, "")
                            }else if(v==ItemsSrcClick.SEND_INTENT.value){
                                s = preferences?.getString(IdNames.srcIntent2Cfg_key, IdNames.intentDefaultAction)+" / "+preferences?.getString(IdNames.srcIntentPackage2Cfg_key, IdNames.intentDefaultPackage)
                            }else if(v!=ItemsSrcClick.DRIVE_SPORT.value && v!=ItemsSrcClick.DRIVE_SNOW.value && v!=ItemsSrcClick.DRIVE_OFFROAD.value && v!=ItemsSrcClick.MULTIMEDIA_MODE.value){
                                return
                            }
                            if (context != null) {
                                MainActivity.debugToast(context, "SRC Old 2 Pressed")
                                executeSrcCommand(context.applicationContext, v, s)
                            }
                        } else {
                            KeysConfigData.handler.postDelayed({
                                var v = preferences?.getInt(
                                    IdNames.srcClick1Cfg_key,
                                    ItemsSrcClick.NOT_USED.value
                                )
                                if (ItemsSrcClick.entries.firstOrNull { it.value == v } == null) {
                                    v = ItemsSrcClick.NOT_USED.value
                                }
                                var s: String? = null
                                if(v==ItemsSrcClick.START.value || v==ItemsSrcClick.START_ON_DIM.value){
                                    s = preferences?.getString(IdNames.srcApp1Cfg_key, "")
                                }else if(v==ItemsSrcClick.SEND_INTENT.value){
                                    s = preferences?.getString(IdNames.srcIntent1Cfg_key, IdNames.intentDefaultAction)+" / "+preferences?.getString(IdNames.srcIntentPackage1Cfg_key, IdNames.intentDefaultPackage)
                                }else if(v!=ItemsSrcClick.DRIVE_SPORT.value && v!=ItemsSrcClick.DRIVE_SNOW.value && v!=ItemsSrcClick.DRIVE_OFFROAD.value){
                                    return@postDelayed
                                }
                                if (context != null) {
                                    MainActivity.debugToast(context, "SRC Old 1 Pressed")
                                    executeSrcCommand(context.applicationContext, v, s)
                                }
                            }, 1200)
                        }
                        KeysConfigData.timeStamp = System.currentTimeMillis()
                        return
                    } else if ("ecarx.intent.action.ECARX_KEY_ISRC_EVENT" == intent.action) {
                        val int = Intent("ecarx.intent.action.ECARX_KEY_RSRC_EVENT")
                        int.setFlags(FLAG_ACTIVITY_NEW_TASK)
                        int.addFlags(FLAG_ACTIVITY_PREVIOUS_IS_TOP)
                        int.addCategory("android.intent.category.DEFAULT")
                        int.putExtra("ecarx.extra.ECARX_KEY_EVENT_TYPE", KEYCODE_R_SRC)
                        context?.sendBroadcast(int)
                        return
                    }
                    return
                }
            }

            if (("android.intent.action.IEDIA_BUTTON" == intent.action) || ("android.intent.action.MEDIA_BUTTON" == intent.action && KeysConfigData.SRC_mode_default==0)) {
                if (preferences != null) {
                    if (preferences.getBoolean(IdNames.mediaKeys_key, false)) {
                        enabledMedia = true
                    }
                }
                if (enabledMedia){
                    if(KeysConfigData.SRC_mode_default <= 0) {
                        if (intent.extras != null) {
                            val keyEvent =
                                intent.extras!!.get("android.intent.extra.KEY_EVENT") as KeyEvent
                            context?.getSystemService(AudioManager::class.java)
                                ?.dispatchMediaKeyEvent(keyEvent)
                            if (context != null) {
                                MainActivity.debugToast(context, "Media key Pressed")
                            }
                        }
                    }else{
                        val int = Intent("android.intent.action.MEDIA_BUTTON")
                        int.setFlags(FLAG_INCLUDE_STOPPED_PACKAGES)
                        int.addFlags(FLAG_ACTIVITY_PREVIOUS_IS_TOP)
                        int.addCategory("android.intent.category.DEFAULT")
                        int.putExtra(
                            "android.intent.extra.KEY_EVENT",
                            intent.extras!!.get("android.intent.extra.KEY_EVENT") as KeyEvent
                        )
                        if (context != null) {
                            MainActivity.debugToast(context, "Media key (default mode) Pressed")
                        }
                        context?.sendBroadcast(int)
                    }
                } else if ("android.intent.action.IEDIA_BUTTON" == intent.action) {
                    val int = Intent("android.intent.action.MEDIA_BUTTON")
                    int.setFlags(FLAG_INCLUDE_STOPPED_PACKAGES)
                    int.addFlags(FLAG_ACTIVITY_PREVIOUS_IS_TOP)
                    int.addCategory("android.intent.category.DEFAULT")
                    int.putExtra(
                        "android.intent.extra.KEY_EVENT",
                        intent.extras!!.get("android.intent.extra.KEY_EVENT") as KeyEvent
                    )
                    context?.sendBroadcast(int)
                }
                return
            }

            if (enabledVA) {
                if ("ecarx.intent.action.vr_pressed" == intent.action) {
                    if (context != null) {
                        MainActivity.debugToast(context, "VA intent vr_pressed")
                    }
                    if(KeysConfigData.blockVA){
                        return
                    }
                    KeysConfigData.delayedVALong = true
                    KeysConfigData.handlerVALong.removeCallbacksAndMessages(null)
                    KeysConfigData.handlerVALong.postDelayed({
                        KeysConfigData.delayedVALong = false
                        KeysConfigData.pressedVA = 0

                        var v = preferences?.getInt(
                            IdNames.vaClickLongCfg_key,
                            ItemsSrcClick.NOT_USED.value
                        )
                        if (ItemsSrcClick.entries.firstOrNull { it.value == v } == null) {
                            v = ItemsSrcClick.NOT_USED.value
                        }
                        var s: String? = null
                        if(v==ItemsSrcClick.START.value || v==ItemsSrcClick.START_ON_DIM.value){
                            s = preferences?.getString(IdNames.vaAppLongCfg_key, "")
                        }else if(v==ItemsSrcClick.SEND_INTENT.value){
                            s = preferences?.getString(IdNames.vaIntentLongCfg_key, IdNames.intentDefaultAction)+" / "+preferences?.getString(IdNames.vaIntentPackageLongCfg_key, IdNames.intentDefaultPackage)
                        }else if(v!=ItemsSrcClick.DRIVE_SPORT.value && v!=ItemsSrcClick.DRIVE_SNOW.value && v!=ItemsSrcClick.DRIVE_OFFROAD.value && v!=ItemsSrcClick.MULTIMEDIA_MODE.value){
                            return@postDelayed
                        }
                        if (context != null) {
                            MainActivity.debugToast(context, "VA Long Pressed")
                            executeSrcCommand(context.applicationContext, v, s)
                        }
                    }, 1400)

                    KeysConfigData.handlerVAShort.removeCallbacksAndMessages(null)
                    KeysConfigData.pressedVA++
                }
                if ("ecarx.intent.action.vr_released" == intent.action) {
                    if (context != null) {
                        MainActivity.debugToast(context, "VA intent vr_released")
                    }

                    KeysConfigData.handlerVALong.removeCallbacksAndMessages(null)
                    if(!KeysConfigData.delayedVALong){
                        return
                    }
                    KeysConfigData.handlerVAShort.postDelayed({
                        when(KeysConfigData.pressedVA){
                            1 -> {
                                var v = preferences?.getInt(
                                    IdNames.vaClick1Cfg_key,
                                    ItemsSrcClick.NOT_USED.value
                                )
                                if (ItemsSrcClick.entries.firstOrNull { it.value == v } == null) {
                                    v = ItemsSrcClick.NOT_USED.value
                                }
                                var s: String? = null
                                if(v==ItemsSrcClick.START.value || v==ItemsSrcClick.START_ON_DIM.value){
                                    s = preferences?.getString(IdNames.vaApp1Cfg_key, "")
                                }else if(v==ItemsSrcClick.SEND_INTENT.value){
                                    s = preferences?.getString(IdNames.vaIntent1Cfg_key, IdNames.intentDefaultAction)+" / "+preferences?.getString(IdNames.vaIntentPackage1Cfg_key, IdNames.intentDefaultPackage)
                                }else if(v!=ItemsSrcClick.DRIVE_SPORT.value && v!=ItemsSrcClick.DRIVE_SNOW.value && v!=ItemsSrcClick.DRIVE_OFFROAD.value && v!=ItemsSrcClick.MULTIMEDIA_MODE.value){
                                    return@postDelayed
                                }
                                if (context != null) {
                                    MainActivity.debugToast(context, "VA 1 Pressed")
                                    executeSrcCommand(context.applicationContext, v, s)
                                }
                                KeysConfigData.blockVA = true
                            }
                            2 -> {
                                var v = preferences?.getInt(
                                    IdNames.vaClick2Cfg_key,
                                    ItemsSrcClick.NOT_USED.value
                                )
                                if (ItemsSrcClick.entries.firstOrNull { it.value == v } == null) {
                                    v = ItemsSrcClick.NOT_USED.value
                                }
                                var s: String? = null
                                if(v==ItemsSrcClick.START.value || v==ItemsSrcClick.START_ON_DIM.value){
                                    s = preferences?.getString(IdNames.vaApp2Cfg_key, "")
                                }else if(v==ItemsSrcClick.SEND_INTENT.value){
                                    s = preferences?.getString(IdNames.vaIntent2Cfg_key, IdNames.intentDefaultAction)+" / "+preferences?.getString(IdNames.vaIntentPackage2Cfg_key, IdNames.intentDefaultPackage)
                                }else if(v!=ItemsSrcClick.DRIVE_SPORT.value && v!=ItemsSrcClick.DRIVE_SNOW.value && v!=ItemsSrcClick.DRIVE_OFFROAD.value && v!=ItemsSrcClick.MULTIMEDIA_MODE.value){
                                    return@postDelayed
                                }
                                if (context != null) {
                                    MainActivity.debugToast(context, "VA 2 Pressed")
                                    executeSrcCommand(context.applicationContext, v, s)
                                }
                            }
                            3 -> {
                                var v = preferences?.getInt(
                                    IdNames.vaClick3Cfg_key,
                                    ItemsSrcClick.NOT_USED.value
                                )
                                if (ItemsSrcClick.entries.firstOrNull { it.value == v } == null) {
                                    v = ItemsSrcClick.NOT_USED.value
                                }
                                var s: String? = null
                                if(v==ItemsSrcClick.START.value || v==ItemsSrcClick.START_ON_DIM.value){
                                    s = preferences?.getString(IdNames.vaApp3Cfg_key, "")
                                }else if(v==ItemsSrcClick.SEND_INTENT.value){
                                    s = preferences?.getString(IdNames.vaIntent3Cfg_key, IdNames.intentDefaultAction)+" / "+preferences?.getString(IdNames.vaIntentPackage3Cfg_key, IdNames.intentDefaultPackage)
                                }else if(v!=ItemsSrcClick.DRIVE_SPORT.value && v!=ItemsSrcClick.DRIVE_SNOW.value && v!=ItemsSrcClick.DRIVE_OFFROAD.value && v!=ItemsSrcClick.MULTIMEDIA_MODE.value){
                                    return@postDelayed
                                }
                                if (context != null) {
                                    MainActivity.debugToast(context, "VA 3 Pressed")
                                    executeSrcCommand(context.applicationContext, v, s)
                                }
                                KeysConfigData.blockVA = true
                            }
                        }
                        KeysConfigData.pressedVA = 0
                        if(KeysConfigData.blockVA){
                            KeysConfigData.handlerVAShort.postDelayed({
                                KeysConfigData.blockVA = false
                            }, 500)
                        }
                    }, 900)
                }
            }
        }
    }
}
