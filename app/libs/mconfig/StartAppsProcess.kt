package ru.monjaro.mconfig

import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.TableLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager
import ru.monjaro.mconfig.databinding.StartAppsFragmentBinding

class StartAppsProcess  {
    companion object {
        private var preferences: SharedPreferences? = null
        private var appsStarted: Boolean = false
        fun startApps(context: Context?){
            if(context == null){
                return
            }
            if(!appsStarted) {
                val prefs =
                    PreferenceManager.getDefaultSharedPreferences(context.applicationContext);
                if (prefs != null) {
                    preferences = prefs
                }
                if (preferences == null) {
                    return
                }
                appsStarted = true
                if(preferences!!.getBoolean(IdNames.appsEnableStart_key, false)) {
                    for (i in IdNames.appStartQuantity downTo 1) {
                        startApp(context, preferences, i)
                    }
                }
            }
        }

        fun startApp(context: Context?, preferences: SharedPreferences?, i:Int){
            try {
                if (preferences?.getBoolean(
                        IdNames.appStartEnable_key_ + i.toString(),
                        false
                    ) == true
                ) {
                    val app = preferences.getString(IdNames.appStartAppName_key_ + i.toString(), "")
                    val activity =
                        preferences.getString(IdNames.appStartActivity_key_ + i.toString(), "")
                    var delay = preferences.getInt(
                        IdNames.appStartDelay_key_ + i.toString(),
                        IdNames.appStartDelayDefault
                    )
                    var display = preferences.getInt(IdNames.appStartDisplay_key_ + i.toString(), 0)
                    if ((display == 0 || display == 1) && (delay >= 0) && (app != "") && (app != "---")) {
                        if (delay < 3) {
                            delay = 3
                        }
                        Handler(Looper.getMainLooper()).postDelayed({
                            if (display != 0) {
                                display = 3
                            }
                            var ret = false
                            val p = KeysConfigData.getPackageData(app)
                            if (p != null) {
                                var retry = 0
                                while (retry < 2) {
                                    val int = Intent()
                                    if (retry == 0 && activity != null && activity != "") {
                                        int.setClassName(p.name, activity)
                                        retry++
                                    } else {
                                        int.setAction("android.intent.action.MAIN")
                                        int.setClassName(p.name, p.activity)
                                        retry = 10
                                    }
                                    if (display == 0) {
                                        int.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                                    } else {
                                        int.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                                    }
                                    try {
                                        try {
                                            val bundle: ActivityOptions =
                                                ActivityOptions.makeBasic()
                                            bundle.setLaunchDisplayId(display)
                                            context?.startActivity(
                                                int,
                                                bundle.toBundle()
                                            )
                                            ret = true
                                        } catch (_: Exception) {
                                        }
                                    } catch (_: Error) {
                                    }
                                    if (ret) {
                                        break
                                    }
                                }
                            }
                            if (!ret) {
                                Toast.makeText(
                                    context,
                                    "应用启动错误",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                            }
                        }, delay.toLong() * 1000)
                    }
                }
            }catch(_:Exception){}
        }
    }

}