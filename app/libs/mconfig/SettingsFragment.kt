package ru.monjaro.mconfig

import android.content.ClipData
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.graphics.Rect
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ScrollView
import android.widget.Spinner
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager
import com.google.android.material.switchmaterial.SwitchMaterial
import ru.monjaro.mconfig.databinding.SettingsFragmentBinding
import ru.monjaro.mconfig.databinding.SettingsFragmentBinding.*
import java.io.File


class SettingsFragment : Fragment() {

    private val settingsFilename = "mconfigSettings.mcf"

    private var preferences: SharedPreferences? = null
    private lateinit var arrayListPackages: ArrayList<String>
    private var _binding: SettingsFragmentBinding? = null

    private val binding get() = _binding!!

    private var driveKeyToast:Boolean = true

    private fun driveKeyToastFunc(context: Context, position:Int){
        if(driveKeyToast && (position == ItemsSrcClick.DRIVE_SPORT.value || position == ItemsSrcClick.DRIVE_SNOW.value || position == ItemsSrcClick.DRIVE_OFFROAD.value) && preferences?.getBoolean(IdNames.restoreDriveMode_key, false)==false)
        {
            Toast.makeText(context, "驾驶模式按键功能仅在启用\"启动时恢复驾驶模式\"时可用", Toast.LENGTH_LONG ).show()
            driveKeyToast = false
        }
    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val prefs =
            PreferenceManager.getDefaultSharedPreferences(requireContext().applicationContext)
        if (prefs != null) {
            preferences = prefs
        }
        arrayListPackages = MainActivity.getApplicationsList()
        _binding = inflate(inflater, container, false)
        return binding.root
    }

    private fun isExternalStorageReadOnly(): Boolean {
        val extStorageState: String = Environment.getExternalStorageState()
        return if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) {
            true
        } else false
    }

    private fun isExternalStorageAvailable(): Boolean {
        val extStorageState: String = Environment.getExternalStorageState()
        return if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {
            true
        } else false
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val context = requireContext().applicationContext

        val importSett = view.findViewById<TextView>(R.id.importSettings)
        if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {
            importSett.isEnabled = false
        }
        val exportSett = view.findViewById<TextView>(R.id.exportSettings)
        if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {
            exportSett.isEnabled = false
        }


        exportSett.setOnClickListener(View.OnClickListener() {

            val file = File(context.cacheDir, settingsFilename)
            val dataStr = MainActivity.sharedPreferencesToString(preferences)

            file.bufferedWriter().use {
                it.write(dataStr)
            }

            try {
                val fileD = File(
                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                    settingsFilename
                )
                if(fileD.exists()) {
                    fileD.delete()
                }
                fileD.bufferedWriter().use {
                    it.write(dataStr)
                }

            } catch (_: Exception) {
            }

            val uri: Uri? = FileProvider.getUriForFile(context, "ru.monjaro.mconfig", file)
            val intent = Intent(Intent.ACTION_SEND)
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            intent.clipData = ClipData.newRawUri("", uri)
            intent.putExtra(Intent.EXTRA_STREAM, uri)
            intent.putExtra(Intent.EXTRA_TITLE, settingsFilename)
            intent.setType("application/octet-stream");
            startActivity(Intent.createChooser(intent, ""))
        })

        importSett.setOnClickListener(View.OnClickListener() {
            var ret = false
            try{
                try {
                    val fileD = File(
                        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                        settingsFilename
                    )
                    var s="";
                    fileD.bufferedReader().use {
                        s = it.readText()
                    }
                    ret = MainActivity.sharedPreferencesFromString(preferences, s )
                    if(ret) {
                        val pm = context.packageManager
                        val intent = pm.getLaunchIntentForPackage(context.packageName)
                        val mainIntent = Intent.makeRestartActivityTask(intent!!.component)
                        context.startActivity(mainIntent)
                    }
                }catch(_:Exception){
                }
            }catch(_:Error){
            }
            if(!ret){
                Toast.makeText(context, "设置导入错误", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(context, "设置已导入", Toast.LENGTH_LONG).show()
            }
        })

        val aSett = view.findViewById<TextView>(R.id.androidSettings)
        aSett.setOnClickListener(View.OnClickListener() {
            val intent = Intent("android.intent.action.VIEW")
            intent.setClassName("com.android.settings", "com.android.settings.Settings")
            startActivity(intent)
        });

        val eSett = view.findViewById<TextView>(R.id.engSettings)
        eSett.setOnClickListener(View.OnClickListener() {
            val intent = Intent("android.intent.action.VIEW")
            intent.setClassName(
                "com.ecarx.engineeringmodel",
                "com.ecarx.engineeringmodel.EngineeringModelMainActivity"
            )
            startActivity(intent)
        });

        val spinnerSS = view.findViewById<Spinner>(R.id.StartStopSpinner)
        spinnerSS.adapter = ArrayAdapter<CharSequence>(
            context,
            R.layout.spinner_text_item,
            resources.getStringArray(R.array.spinnerItemsOnOff)
        )
        spinnerSS?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                if (preferences?.getInt(IdNames.startstopFuncCfg_key, 0) != position) {
                    preferences?.edit()?.putInt(IdNames.startstopFuncCfg_key, position)?.apply()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        preferences?.getInt(IdNames.startstopFuncCfg_key, 0)?.let {
            spinnerSS?.setSelection(it)
        }

        val spinnerAH = view.findViewById<Spinner>(R.id.autoHoldSpinner)
        spinnerAH.adapter = ArrayAdapter<CharSequence>(
            context,
            R.layout.spinner_text_item,
            resources.getStringArray(R.array.spinnerItemsOnOff)
        )
        spinnerAH?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                if (preferences?.getInt(IdNames.autoholdFuncCfg_key, 0) != position) {
                    preferences?.edit()?.putInt(IdNames.autoholdFuncCfg_key, position)?.apply()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        preferences?.getInt(IdNames.autoholdFuncCfg_key, 1)?.let {
            spinnerAH?.setSelection(it)
        }

        val rdmSwitch = view.findViewById<SwitchMaterial>(R.id.restoreDriveModeSwitch)
        rdmSwitch?.setOnCheckedChangeListener { _, isChecked ->
            if (preferences?.getBoolean(IdNames.restoreDriveMode_key, false) != isChecked) {
                preferences?.edit()?.putBoolean(IdNames.restoreDriveMode_key, isChecked)?.apply()
            }
        }

        preferences?.getBoolean(IdNames.restoreDriveMode_key, true)?.let {
            rdmSwitch?.isChecked = it
        }

        val elkaDisableSwitch = view.findViewById<SwitchMaterial>(R.id.elkaDisableSwitch)
        elkaDisableSwitch?.setOnCheckedChangeListener { _, isChecked ->
            if (preferences?.getBoolean(IdNames.elkaDisable_key, false) != isChecked) {
                preferences?.edit()?.putBoolean(IdNames.elkaDisable_key, isChecked)?.apply()
            }
        }

        preferences?.getBoolean(IdNames.elkaDisable_key, false)?.let {
            elkaDisableSwitch?.isChecked = it
        }

        val windowScreenServicePosSwitch = view.findViewById<SwitchMaterial>(R.id.windowScreenServicePosSwitch)
        windowScreenServicePosSwitch?.setOnCheckedChangeListener { _, isChecked ->
            if (preferences?.getBoolean(IdNames.windowScreenServicePosCfg_key, false) != isChecked) {
                preferences?.edit()?.putBoolean(IdNames.windowScreenServicePosCfg_key, isChecked)?.apply()
            }
        }

        preferences?.getBoolean(IdNames.windowScreenServicePosCfg_key, false)?.let {
            windowScreenServicePosSwitch?.isChecked = it
        }

        val intelligentFuelSaveSwitch = view.findViewById<SwitchMaterial>(R.id.intelligentFuelSaveSwitch)
        intelligentFuelSaveSwitch?.setOnCheckedChangeListener { _, isChecked ->
            if (preferences?.getBoolean(IdNames.intelligentFuelSaveStartCfg_key, false) != isChecked) {
                preferences?.edit()?.putBoolean(IdNames.intelligentFuelSaveStartCfg_key, isChecked)?.apply()
            }
        }

        preferences?.getBoolean(IdNames.intelligentFuelSaveStartCfg_key, false)?.let {
            intelligentFuelSaveSwitch?.isChecked = it
        }

        val panoramaCurtainStartSwitch = view.findViewById<SwitchMaterial>(R.id.panoramaCurtainStartSwitch)
        panoramaCurtainStartSwitch?.setOnCheckedChangeListener { _, isChecked ->
            if (preferences?.getBoolean(IdNames.panoramaCurtainStartCfg_key, false) != isChecked) {
                preferences?.edit()?.putBoolean(IdNames.panoramaCurtainStartCfg_key, isChecked)?.apply()
            }
        }

        preferences?.getBoolean(IdNames.panoramaCurtainStartCfg_key, false)?.let {
            panoramaCurtainStartSwitch?.isChecked = it
        }

        val brightnessReverseSwitch = view.findViewById<SwitchMaterial>(R.id.brightnessReverseSwitch)
        brightnessReverseSwitch?.setOnCheckedChangeListener { _, isChecked ->
            if (preferences?.getBoolean(IdNames.brightnessReverse_key, false) != isChecked) {
                preferences?.edit()?.putBoolean(IdNames.brightnessReverse_key, isChecked)?.apply()
            }
        }

        preferences?.getBoolean(IdNames.brightnessReverse_key, false)?.let {
            brightnessReverseSwitch?.isChecked = it
        }

        val spinnerCamReverseSpeed = view.findViewById<Spinner>(R.id.camReverseSpeed_Spinner)
        spinnerCamReverseSpeed.adapter = ArrayAdapter<CharSequence>(
            context,
            R.layout.spinner_text_item,
            resources.getStringArray(R.array.ItemsCamReverseSpeed)
        )
        val camReverseSpeedArr = intArrayOf(0,7,10,12,15,20)
        spinnerCamReverseSpeed?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                if(position < camReverseSpeedArr.size){
                    if (preferences?.getInt(IdNames.gearReverseSpeedCfg_key, camReverseSpeedArr[0]) != camReverseSpeedArr[position]) {
                        preferences?.edit()?.putInt(IdNames.gearReverseSpeedCfg_key, camReverseSpeedArr[position])?.apply()
                    }
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        preferences?.getInt(IdNames.gearReverseSpeedCfg_key, camReverseSpeedArr[0])?.let { it1 ->
            spinnerCamReverseSpeed?.setSelection(camReverseSpeedArr.indexOf(
                camReverseSpeedArr.first { it == it1 }))
        }

        val spinnerCamReverseTime = view.findViewById<Spinner>(R.id.camReverseTime_Spinner)
        spinnerCamReverseTime.adapter = ArrayAdapter<CharSequence>(
            context,
            R.layout.spinner_text_item,
            resources.getStringArray(R.array.ItemsCamReverseTime)
        )

        val camReverseTimeArr = intArrayOf(0,5,7,10,15,20,30)
        spinnerCamReverseTime?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                if(position < camReverseTimeArr.size){
                    if (preferences?.getInt(IdNames.gearReverseTimeCfg_key, camReverseTimeArr[0]) != camReverseTimeArr[position]) {
                        preferences?.edit()?.putInt(IdNames.gearReverseTimeCfg_key, camReverseTimeArr[position])?.apply()
                    }
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        preferences?.getInt(IdNames.gearReverseTimeCfg_key, camReverseTimeArr[0])?.let { it1 ->
            spinnerCamReverseTime?.setSelection(camReverseTimeArr.indexOf(
                camReverseTimeArr.first { it == it1 }))
        }

        val mediaSwitch = view.findViewById<SwitchMaterial>(R.id.mediaKeysSwitch)
        mediaSwitch?.setOnCheckedChangeListener { _, isChecked ->
            if (preferences?.getBoolean(IdNames.mediaKeys_key, false) != isChecked) {
                preferences?.edit()?.putBoolean(IdNames.mediaKeys_key, isChecked)?.apply()
            }
        }

        preferences?.getBoolean(IdNames.mediaKeys_key, false)?.let {
            mediaSwitch?.isChecked = it
        }

        val srcSwitch = view.findViewById<SwitchMaterial>(R.id.srcKeySwitch)
        val srcOldSwitch = view.findViewById<SwitchMaterial>(R.id.srcKeyOldSwitch)

        srcSwitch?.setOnCheckedChangeListener { _, isChecked ->
            if (preferences?.getBoolean(IdNames.srcKey_key, false) != isChecked) {
                preferences?.edit()?.putBoolean(IdNames.srcKey_key, isChecked)?.apply()
            }
            if(isChecked){
                if(srcOldSwitch.isChecked){
                    srcOldSwitch.isChecked = false
                }
                view.findViewById<TableRow>(R.id.srcPressed3Row).visibility = VISIBLE
                val spinnerSRC3t = view.findViewById<Spinner>(R.id.srcPressed3Spinner)
                if(spinnerSRC3t.selectedItemPosition == ItemsSrcClick.START.value || spinnerSRC3t.selectedItemPosition == ItemsSrcClick.START_ON_DIM.value){
                    view.findViewById<TableRow>(R.id.srcApp3Row).visibility = VISIBLE
                    view.findViewById<TableRow>(R.id.srcIntent3Row).visibility = GONE
                    view.findViewById<TableRow>(R.id.srcPackage3Row).visibility = GONE
                }else if(spinnerSRC3t.selectedItemPosition == ItemsSrcClick.SEND_INTENT.value){
                    view.findViewById<TableRow>(R.id.srcIntent3Row).visibility = VISIBLE
                    view.findViewById<TableRow>(R.id.srcPackage3Row).visibility = VISIBLE
                    view.findViewById<TableRow>(R.id.srcApp3Row).visibility = GONE
                }else if(spinnerSRC3t.selectedItemPosition == ItemsSrcClick.NOT_USED.value || spinnerSRC3t.selectedItemPosition == ItemsSrcClick.DRIVE_SPORT.value){
                    view.findViewById<TableRow>(R.id.srcIntent3Row).visibility = GONE
                    view.findViewById<TableRow>(R.id.srcPackage3Row).visibility = GONE
                    view.findViewById<TableRow>(R.id.srcApp3Row).visibility = GONE
                }

                view.findViewById<TableRow>(R.id.srcPressedLongRow).visibility = VISIBLE
            }else{
                view.findViewById<TableRow>(R.id.srcPressed3Row).visibility = GONE
                view.findViewById<TableRow>(R.id.srcApp3Row).visibility = GONE
                view.findViewById<TableRow>(R.id.srcIntent3Row).visibility = GONE
                view.findViewById<TableRow>(R.id.srcPackage3Row).visibility = GONE

                view.findViewById<TableRow>(R.id.srcPressedLongRow).visibility = GONE
                view.findViewById<TableRow>(R.id.srcAppLongRow).visibility = GONE
                view.findViewById<TableRow>(R.id.srcIntentLongRow).visibility = GONE
                view.findViewById<TableRow>(R.id.srcPackageLongRow).visibility = GONE
            }
        }

        preferences?.getBoolean(IdNames.srcKey_key, true)?.let {
            srcSwitch?.isChecked = it
        }

        srcOldSwitch?.setOnCheckedChangeListener { _, isChecked ->
            if (preferences?.getBoolean(IdNames.srcKeyOld_key, false) != isChecked) {
                preferences?.edit()?.putBoolean(IdNames.srcKeyOld_key, isChecked)?.apply()
            }
            if(isChecked){
                if(srcSwitch.isChecked){
                    srcSwitch.isChecked = false
                }
            }
        }

        preferences?.getBoolean(IdNames.srcKeyOld_key, false)?.let {
            srcOldSwitch?.isChecked = it
        }

        val vaSwitch = view.findViewById<SwitchMaterial>(R.id.vaKeySwitch)
        vaSwitch?.setOnCheckedChangeListener { _, isChecked ->
            if (preferences?.getBoolean(IdNames.voiceAssist_key, false) != isChecked) {
                preferences?.edit()?.putBoolean(IdNames.voiceAssist_key, isChecked)?.apply()
            }
        }

        preferences?.getBoolean(IdNames.voiceAssist_key, false)?.let {
            vaSwitch?.isChecked = it
        }

        val passDisplaySwitch = view.findViewById<SwitchMaterial>(R.id.passDisplayOffSwitch)
        val passDisplayNoPassSwitch = view.findViewById<SwitchMaterial>(R.id.passDisplayOffNoPassSwitch)
        passDisplaySwitch?.setOnCheckedChangeListener { _, isChecked ->
            if (preferences?.getBoolean(IdNames.passDisplayOff_key, false) != isChecked) {
                preferences?.edit()?.putBoolean(IdNames.passDisplayOff_key, isChecked)?.apply()
            }
            if(isChecked){
                if(passDisplayNoPassSwitch.isChecked){
                    passDisplayNoPassSwitch.isChecked = false
                }
            }
        }

        preferences?.getBoolean(IdNames.passDisplayOff_key, false)?.let {
            passDisplaySwitch?.isChecked = it
        }
        passDisplayNoPassSwitch?.setOnCheckedChangeListener { _, isChecked ->
            if (preferences?.getBoolean(IdNames.passDisplayOffNoPass_key, false) != isChecked) {
                preferences?.edit()?.putBoolean(IdNames.passDisplayOffNoPass_key, isChecked)?.apply()
            }
            if(isChecked){
                if(passDisplaySwitch.isChecked){
                    passDisplaySwitch.isChecked = false
                }
            }
        }

        preferences?.getBoolean(IdNames.passDisplayOffNoPass_key, false)?.let {
            passDisplayNoPassSwitch?.isChecked = it
        }

        val debugToastSwitch = view.findViewById<SwitchMaterial>(R.id.debugToastSwitch)
        debugToastSwitch?.setOnCheckedChangeListener { _, isChecked ->
            if (preferences?.getBoolean(IdNames.debugToast_key, false) != isChecked) {
                preferences?.edit()?.putBoolean(IdNames.debugToast_key, isChecked)?.apply()
            }
            if(isChecked) {
                MainActivity.debugToastEnabled = 1
            }else{
                MainActivity.debugToastEnabled = 0
            }
        }

        preferences?.getBoolean(IdNames.debugToast_key, false)?.let {
            debugToastSwitch?.isChecked = it
        }

        var volumeOnStartArray = resources.getStringArray(R.array.ItemsVolumeOnStart)
        val volumeOnStartSpinner = view.findViewById<Spinner>(R.id.volumeOnStartSpinner)
        volumeOnStartSpinner.adapter = ArrayAdapter<CharSequence>(
            context,
            R.layout.spinner_text_item,
            volumeOnStartArray
        )
        volumeOnStartSpinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                if (preferences?.getInt(IdNames.volumeOnStart_key, -1) != (position-1)) {
                    preferences?.edit()?.putInt(IdNames.volumeOnStart_key, (position-1))?.apply()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        preferences?.getInt(IdNames.volumeOnStart_key, -1)?.let {
            volumeOnStartSpinner?.setSelection(it+1)
        }

        var spinnerSRCArray_1Click = resources.getStringArray(R.array.spinnerItemsSRC_1Click)
        var helperInstalled = false
        try {
            context.packageManager.getPackageInfo("ru.monjaro.helper", PackageManager.GET_ACTIVITIES)
            helperInstalled = true
        } catch (_: PackageManager.NameNotFoundException) {

        }
        if(!helperInstalled){
            spinnerSRCArray_1Click= spinnerSRCArray_1Click.dropLast(1).toTypedArray()
        }

        val rowSRCApp1 =  view.findViewById<TableRow>(R.id.srcApp1Row)
        val rowSRCIntent1 =  view.findViewById<TableRow>(R.id.srcIntent1Row)
        val rowSRCPackage1 =  view.findViewById<TableRow>(R.id.srcPackage1Row)

        val spinnerSRC1 = view.findViewById<Spinner>(R.id.srcPressed1Spinner)
        spinnerSRC1.adapter = ArrayAdapter<CharSequence>(
            context,
            R.layout.spinner_text_item,
            spinnerSRCArray_1Click
        )
        spinnerSRC1?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                var positionMod = position
                if((position+1) == ItemsSrcClick.START_ON_DIM.value){
                    positionMod += 1
                }
                if (preferences?.getInt(IdNames.srcClick1Cfg_key, 0) != positionMod) {
                    preferences?.edit()?.putInt(IdNames.srcClick1Cfg_key, positionMod)?.apply()
                }
                driveKeyToastFunc(context, positionMod)
                if(positionMod == ItemsSrcClick.START.value || positionMod == ItemsSrcClick.START_ON_DIM.value){
                    rowSRCApp1.visibility = VISIBLE
                    rowSRCIntent1.visibility = GONE
                    rowSRCPackage1.visibility = GONE
                }else if(positionMod == ItemsSrcClick.SEND_INTENT.value){
                    rowSRCIntent1.visibility = VISIBLE
                    rowSRCPackage1.visibility = VISIBLE
                    rowSRCApp1.visibility = GONE
                }else{
                    rowSRCIntent1.visibility = GONE
                    rowSRCPackage1.visibility = GONE
                    rowSRCApp1.visibility = GONE
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }

        preferences?.getInt(IdNames.srcClick1Cfg_key, 0)?.let {
            if(it == ItemsSrcClick.MULTIMEDIA_MODE.value){
                spinnerSRC1?.setSelection(0)
            }else if(it == ItemsSrcClick.START_ON_DIM.value && ((it-1) < spinnerSRCArray_1Click.size)){
                spinnerSRC1?.setSelection(it-1)
            }else if(it>=spinnerSRCArray_1Click.size){
                spinnerSRC1?.setSelection(0)
            }else {
                spinnerSRC1?.setSelection(it)
            }
        }

        val spinnerSRCApp1 = view.findViewById<Spinner>(R.id.srcApp1Spinner)
        val arrayAdapter: ArrayAdapter<String> = ArrayAdapter<String>(
            requireContext().applicationContext,
            R.layout.spinner_text_item,
            arrayListPackages
        )
        spinnerSRCApp1.adapter = arrayAdapter
        spinnerSRCApp1?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                    if (parentView != null) {
                        if (preferences?.getString(
                                IdNames.srcApp1Cfg_key,
                                ""
                            ) != parentView.getItemAtPosition(position).toString()
                        ) {
                            preferences?.edit()?.putString(
                                IdNames.srcApp1Cfg_key,
                                parentView.getItemAtPosition(position).toString()
                            )?.apply()
                        }
                    }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        var idxApp = arrayListPackages.indexOf(preferences?.getString(IdNames.srcApp1Cfg_key, ""));
        if(idxApp == -1){
            idxApp = 0
        }
        spinnerSRCApp1?.setSelection(idxApp)
        rowSRCApp1.visibility = GONE

        val textSRCIntent1handle = Handler(Looper.getMainLooper())
        val textSRCIntent1 = view.findViewById<EditText>(R.id.srcIntent1EditText)
        textSRCIntent1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(editable: Editable?) {
                textSRCIntent1handle.removeCallbacksAndMessages(null)
                val txt = editable.toString()
                textSRCIntent1handle.postDelayed({
                    if (preferences?.getString(IdNames.srcIntent1Cfg_key, "") != txt) {
                        preferences?.edit()?.putString(IdNames.srcIntent1Cfg_key, txt)?.apply()
                    }
                }, 5000)
            }
        })
        preferences?.getString(IdNames.srcIntent1Cfg_key, IdNames.intentDefaultAction)?.let {
            textSRCIntent1.setText(it)
        }

        rowSRCIntent1.visibility = GONE

        val textSRCPackage1handle = Handler(Looper.getMainLooper())
        val textSRCPackage1 = view.findViewById<EditText>(R.id.srcPackage1EditText)
        textSRCPackage1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(editable: Editable?) {
                textSRCPackage1handle.removeCallbacksAndMessages(null)
                val txt = editable.toString()
                textSRCPackage1handle.postDelayed({
                    if (preferences?.getString(IdNames.srcIntentPackage1Cfg_key, "") != txt) {
                        preferences?.edit()?.putString(IdNames.srcIntentPackage1Cfg_key, txt)
                            ?.apply()
                    }
                }, 5000)
            }
        })
        preferences?.getString(IdNames.srcIntentPackage1Cfg_key, IdNames.intentDefaultPackage)?.let {
            textSRCPackage1.setText(it)
        }
        rowSRCPackage1.visibility = GONE

        var spinnerSRCArray = resources.getStringArray(R.array.spinnerItemsSRC)
        if(!helperInstalled){
            spinnerSRCArray = spinnerSRCArray.dropLast(1).toTypedArray()
        }

        val rowSRCApp2 =  view.findViewById<TableRow>(R.id.srcApp2Row)
        val rowSRCIntent2 =  view.findViewById<TableRow>(R.id.srcIntent2Row)
        val rowSRCPackage2 =  view.findViewById<TableRow>(R.id.srcPackage2Row)

        val spinnerSRC2 = view.findViewById<Spinner>(R.id.srcPressed2Spinner)
        spinnerSRC2.adapter = ArrayAdapter<CharSequence>(
            context,
            R.layout.spinner_text_item,
            spinnerSRCArray
        )
        spinnerSRC2?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                if (preferences?.getInt(IdNames.srcClick2Cfg_key, 0) != position) {
                    preferences?.edit()?.putInt(IdNames.srcClick2Cfg_key, position)?.apply()
                }
                driveKeyToastFunc(context, position)
                if(position == ItemsSrcClick.START.value || position == ItemsSrcClick.START_ON_DIM.value){
                    rowSRCApp2.visibility = VISIBLE
                    rowSRCIntent2.visibility = GONE
                    rowSRCPackage2.visibility = GONE
                }else if(position == ItemsSrcClick.SEND_INTENT.value){
                    rowSRCIntent2.visibility = VISIBLE
                    rowSRCPackage2.visibility = VISIBLE
                    rowSRCApp2.visibility = GONE
                }else{
                    rowSRCIntent2.visibility = GONE
                    rowSRCPackage2.visibility = GONE
                    rowSRCApp2.visibility = GONE
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        preferences?.getInt(IdNames.srcClick2Cfg_key, 0)?.let {
            if(it>=spinnerSRCArray.size){
                spinnerSRC2?.setSelection(0)
            }else {
                spinnerSRC2?.setSelection(it)
            }
        }

        val spinnerSRCApp2 = view.findViewById<Spinner>(R.id.srcApp2Spinner)
        spinnerSRCApp2.adapter = arrayAdapter
        spinnerSRCApp2?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                if (parentView != null) {
                    if (preferences?.getString(
                            IdNames.srcApp2Cfg_key,
                            ""
                        ) != parentView.getItemAtPosition(position).toString()
                    ) {
                        preferences?.edit()?.putString(
                            IdNames.srcApp2Cfg_key,
                            parentView.getItemAtPosition(position).toString()
                        )?.apply()
                    }
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        idxApp = arrayListPackages.indexOf(preferences?.getString(IdNames.srcApp2Cfg_key, ""));
        if(idxApp == -1){
            idxApp = 0
        }
        spinnerSRCApp2?.setSelection(idxApp)
        rowSRCApp2.visibility = GONE

        val textSRCIntent2handle = Handler(Looper.getMainLooper())
        val textSRCIntent2 = view.findViewById<EditText>(R.id.srcIntent2EditText)
        textSRCIntent2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(editable: Editable?) {
                textSRCIntent2handle.removeCallbacksAndMessages(null)
                val txt = editable.toString()
                textSRCIntent2handle.postDelayed({
                    if (preferences?.getString(IdNames.srcIntent2Cfg_key, "") != txt) {
                        preferences?.edit()?.putString(IdNames.srcIntent2Cfg_key, txt)?.apply()
                    }
                }, 5000)
            }
        })
        preferences?.getString(IdNames.srcIntent2Cfg_key, IdNames.intentDefaultAction)?.let {
            textSRCIntent2.setText(it)
        }
        rowSRCIntent2.visibility = GONE

        val textSRCPackage2handle = Handler(Looper.getMainLooper())
        val textSRCPackage2 = view.findViewById<EditText>(R.id.srcPackage2EditText)
        textSRCPackage2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(editable: Editable?) {
                textSRCPackage2handle.removeCallbacksAndMessages(null)
                val txt = editable.toString()
                textSRCPackage2handle.postDelayed({
                    if (preferences?.getString(IdNames.srcIntentPackage2Cfg_key, "") != txt) {
                        preferences?.edit()?.putString(IdNames.srcIntentPackage2Cfg_key, txt)
                            ?.apply()
                    }
                }, 5000)
            }
        })
        preferences?.getString(IdNames.srcIntentPackage2Cfg_key, IdNames.intentDefaultPackage)?.let {
            textSRCPackage2.setText(it)
        }
        rowSRCPackage2.visibility = GONE


        val srcPressed3Row =  view.findViewById<TableRow>(R.id.srcPressed3Row)
        val rowSRCApp3 =  view.findViewById<TableRow>(R.id.srcApp3Row)
        val rowSRCIntent3 =  view.findViewById<TableRow>(R.id.srcIntent3Row)
        val rowSRCPackage3 =  view.findViewById<TableRow>(R.id.srcPackage3Row)

        val spinnerSRC3 = view.findViewById<Spinner>(R.id.srcPressed3Spinner)
        spinnerSRC3.adapter = ArrayAdapter<CharSequence>(
            context,
            R.layout.spinner_text_item,
            spinnerSRCArray
        )
        spinnerSRC3?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                if (preferences?.getInt(IdNames.srcClick3Cfg_key, 0) != position) {
                    preferences?.edit()?.putInt(IdNames.srcClick3Cfg_key, position)?.apply()
                }
                driveKeyToastFunc(context, position)
                if(position == ItemsSrcClick.START.value || position == ItemsSrcClick.START_ON_DIM.value){
                    rowSRCApp3.visibility = VISIBLE
                    rowSRCIntent3.visibility = GONE
                    rowSRCPackage3.visibility = GONE
                }else if(position == ItemsSrcClick.SEND_INTENT.value){
                    rowSRCIntent3.visibility = VISIBLE
                    rowSRCPackage3.visibility = VISIBLE
                    rowSRCApp3.visibility = GONE
                }else{
                    rowSRCIntent3.visibility = GONE
                    rowSRCPackage3.visibility = GONE
                    rowSRCApp3.visibility = GONE
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        preferences?.getInt(IdNames.srcClick3Cfg_key, 0)?.let {
            if(it>=spinnerSRCArray.size){
                spinnerSRC3?.setSelection(0)
            }else {
                spinnerSRC3?.setSelection(it)
            }
        }
        srcPressed3Row.onVisibilityAggregated(isVisible)


        if(!srcSwitch.isChecked){
            srcPressed3Row.visibility = INVISIBLE
        }


        val spinnerSRCApp3 = view.findViewById<Spinner>(R.id.srcApp3Spinner)
        spinnerSRCApp3.adapter = arrayAdapter
        spinnerSRCApp3?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                if (parentView != null) {
                    if (preferences?.getString(
                            IdNames.srcApp3Cfg_key,
                            ""
                        ) != parentView.getItemAtPosition(position).toString()
                    ) {
                        preferences?.edit()?.putString(
                            IdNames.srcApp3Cfg_key,
                            parentView.getItemAtPosition(position).toString()
                        )?.apply()
                    }
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        idxApp = arrayListPackages.indexOf(preferences?.getString(IdNames.srcApp3Cfg_key, ""));
        if(idxApp == -1){
            idxApp = 0
        }
        spinnerSRCApp3?.setSelection(idxApp)
        rowSRCApp3.visibility = GONE

        val textSRCIntent3handle = Handler(Looper.getMainLooper())
        val textSRCIntent3 = view.findViewById<EditText>(R.id.srcIntent3EditText)
        textSRCIntent3.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(editable: Editable?) {
                textSRCIntent3handle.removeCallbacksAndMessages(null)
                val txt = editable.toString()
                textSRCIntent3handle.postDelayed({
                    if (preferences?.getString(IdNames.srcIntent3Cfg_key, "") != txt) {
                        preferences?.edit()?.putString(IdNames.srcIntent3Cfg_key, txt)?.apply()
                    }

                }, 5000)
            }
        })
        preferences?.getString(IdNames.srcIntent3Cfg_key, IdNames.intentDefaultAction)?.let {
            textSRCIntent3.setText(it)
        }
        rowSRCIntent3.visibility = GONE

        val textSRCPackage3handle = Handler(Looper.getMainLooper())
        val textSRCPackage3 = view.findViewById<EditText>(R.id.srcPackage3EditText)
        textSRCPackage3.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(editable: Editable?) {
                textSRCPackage3handle.removeCallbacksAndMessages(null)
                val txt = editable.toString()
                textSRCPackage3handle.postDelayed({
                    if (preferences?.getString(IdNames.srcIntentPackage3Cfg_key, "") != txt) {
                        preferences?.edit()?.putString(IdNames.srcIntentPackage3Cfg_key, txt)
                            ?.apply()
                    }
                }, 5000)
            }
        })
        preferences?.getString(IdNames.srcIntentPackage3Cfg_key, IdNames.intentDefaultPackage)?.let {
            textSRCPackage3.setText(it)
        }
        rowSRCPackage3.visibility = GONE


        val srcPressedLongRow =  view.findViewById<TableRow>(R.id.srcPressedLongRow)
        val rowSRCAppLong =  view.findViewById<TableRow>(R.id.srcAppLongRow)
        val rowSRCIntentLong =  view.findViewById<TableRow>(R.id.srcIntentLongRow)
        val rowSRCPackageLong =  view.findViewById<TableRow>(R.id.srcPackageLongRow)

        val spinnerSRCLong = view.findViewById<Spinner>(R.id.srcPressedLongSpinner)
        spinnerSRCLong.adapter = ArrayAdapter<CharSequence>(
            context,
            R.layout.spinner_text_item,
            spinnerSRCArray
        )
        spinnerSRCLong?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                if (preferences?.getInt(IdNames.srcClickLongCfg_key, 0) != position) {
                    preferences?.edit()?.putInt(IdNames.srcClickLongCfg_key, position)?.apply()
                }
                driveKeyToastFunc(context, position)
                if(position == ItemsSrcClick.START.value || position == ItemsSrcClick.START_ON_DIM.value){
                    rowSRCAppLong.visibility = VISIBLE
                    rowSRCIntentLong.visibility = GONE
                    rowSRCPackageLong.visibility = GONE
                }else if(position == ItemsSrcClick.SEND_INTENT.value){
                    rowSRCIntentLong.visibility = VISIBLE
                    rowSRCPackageLong.visibility = VISIBLE
                    rowSRCAppLong.visibility = GONE
                }else{
                    rowSRCIntentLong.visibility = GONE
                    rowSRCPackageLong.visibility = GONE
                    rowSRCAppLong.visibility = GONE
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        preferences?.getInt(IdNames.srcClickLongCfg_key, 0)?.let {
            if(it>=spinnerSRCArray.size){
                spinnerSRCLong?.setSelection(0)
            }else {
                spinnerSRCLong?.setSelection(it)
            }
        }
        srcPressedLongRow.onVisibilityAggregated(isVisible)


        if(!srcSwitch.isChecked){
            srcPressedLongRow.visibility = INVISIBLE
        }


        val spinnerSRCAppLong = view.findViewById<Spinner>(R.id.srcAppLongSpinner)
        spinnerSRCAppLong.adapter = arrayAdapter
        spinnerSRCAppLong?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                if (parentView != null) {
                    if (preferences?.getString(
                            IdNames.srcAppLongCfg_key,
                            ""
                        ) != parentView.getItemAtPosition(position).toString()
                    ) {
                        preferences?.edit()?.putString(
                            IdNames.srcAppLongCfg_key,
                            parentView.getItemAtPosition(position).toString()
                        )?.apply()
                    }
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        idxApp = arrayListPackages.indexOf(preferences?.getString(IdNames.srcAppLongCfg_key, ""));
        if(idxApp == -1){
            idxApp = 0
        }
        spinnerSRCAppLong?.setSelection(idxApp)
        rowSRCAppLong.visibility = GONE

        val textSRCIntentLonghandle = Handler(Looper.getMainLooper())
        val textSRCIntentLong = view.findViewById<EditText>(R.id.srcIntentLongEditText)
        textSRCIntentLong.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(editable: Editable?) {
                textSRCIntentLonghandle.removeCallbacksAndMessages(null)
                val txt = editable.toString()
                textSRCIntentLonghandle.postDelayed({
                    if (preferences?.getString(IdNames.srcIntentLongCfg_key, "") != txt) {
                        preferences?.edit()?.putString(IdNames.srcIntentLongCfg_key, txt)?.apply()
                    }
                }, 5000)
            }
        })
        preferences?.getString(IdNames.srcIntentLongCfg_key, IdNames.intentDefaultAction)?.let {
            textSRCIntentLong.setText(it)
        }
        rowSRCIntentLong.visibility = GONE

        val textSRCPackageLonghandle = Handler(Looper.getMainLooper())
        val textSRCPackageLong = view.findViewById<EditText>(R.id.srcPackageLongEditText)
        textSRCPackageLong.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(editable: Editable?) {
                textSRCPackageLonghandle.removeCallbacksAndMessages(null)
                val txt = editable.toString()
                textSRCPackageLonghandle.postDelayed({
                    if (preferences?.getString(IdNames.srcIntentPackageLongCfg_key, "") != txt) {
                        preferences?.edit()?.putString(IdNames.srcIntentPackageLongCfg_key, txt)
                            ?.apply()
                    }
                }, 5000)
            }
        })
        preferences?.getString(IdNames.srcIntentPackageLongCfg_key, IdNames.intentDefaultPackage)?.let {
            textSRCPackageLong.setText(it)
        }
        rowSRCPackageLong.visibility = GONE


        //VA
        val rowVAApp1 =  view.findViewById<TableRow>(R.id.vaApp1Row)
        val rowVAIntent1 =  view.findViewById<TableRow>(R.id.vaIntent1Row)
        val rowVAPackage1 =  view.findViewById<TableRow>(R.id.vaPackage1Row)

        val spinnerVA1 = view.findViewById<Spinner>(R.id.vaPressed1Spinner)
        spinnerVA1.adapter = ArrayAdapter<CharSequence>(
            context,
            R.layout.spinner_text_item,
            spinnerSRCArray
        )
        spinnerVA1?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                if (preferences?.getInt(IdNames.vaClick1Cfg_key, 0) != position) {
                    preferences?.edit()?.putInt(IdNames.vaClick1Cfg_key, position)?.apply()
                }
                driveKeyToastFunc(context, position)
                if(position == ItemsSrcClick.START.value || position == ItemsSrcClick.START_ON_DIM.value){
                    rowVAApp1.visibility = VISIBLE
                    rowVAIntent1.visibility = GONE
                    rowVAPackage1.visibility = GONE
                }else if(position == ItemsSrcClick.SEND_INTENT.value){
                    rowVAIntent1.visibility = VISIBLE
                    rowVAPackage1.visibility = VISIBLE
                    rowVAApp1.visibility = GONE
                }else{
                    rowVAIntent1.visibility = GONE
                    rowVAPackage1.visibility = GONE
                    rowVAApp1.visibility = GONE
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        preferences?.getInt(IdNames.vaClick1Cfg_key, 0)?.let {
            if(it>=spinnerSRCArray.size){
                spinnerVA1?.setSelection(0)
            }else {
                spinnerVA1?.setSelection(it)
            }
        }

        val spinnerVAApp1 = view.findViewById<Spinner>(R.id.vaApp1Spinner)
        val arrayVAAdapter: ArrayAdapter<String> = ArrayAdapter<String>(
            requireContext().applicationContext,
            R.layout.spinner_text_item,
            arrayListPackages
        )
        spinnerVAApp1.adapter = arrayVAAdapter
        spinnerVAApp1?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                if (parentView != null) {
                    if (preferences?.getString(
                            IdNames.vaApp1Cfg_key,
                            ""
                        ) != parentView.getItemAtPosition(position).toString()
                    ) {
                        preferences?.edit()?.putString(
                            IdNames.vaApp1Cfg_key,
                            parentView.getItemAtPosition(position).toString()
                        )?.apply()
                    }
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        var idxVAApp = arrayListPackages.indexOf(preferences?.getString(IdNames.vaApp1Cfg_key, ""));
        if(idxVAApp == -1){
            idxVAApp = 0
        }
        spinnerVAApp1?.setSelection(idxVAApp)
        rowVAApp1.visibility = GONE

        val textVAIntent1handle = Handler(Looper.getMainLooper())
        val textVAIntent1 = view.findViewById<EditText>(R.id.vaIntent1EditText)
        textVAIntent1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(editable: Editable?) {
                textVAIntent1handle.removeCallbacksAndMessages(null)
                val txt = editable.toString()
                textVAIntent1handle.postDelayed({
                    if (preferences?.getString(IdNames.vaIntent1Cfg_key, "") != txt) {
                        preferences?.edit()?.putString(IdNames.vaIntent1Cfg_key, txt)?.apply()
                    }
                }, 5000)
            }
        })
        preferences?.getString(IdNames.vaIntent1Cfg_key, IdNames.intentDefaultActionVA)?.let {
            textVAIntent1.setText(it)
        }
        rowVAIntent1.visibility = GONE

        val textVAPackage1handle = Handler(Looper.getMainLooper())
        val textVAPackage1 = view.findViewById<EditText>(R.id.vaPackage1EditText)
        textVAPackage1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(editable: Editable?) {
                textVAPackage1handle.removeCallbacksAndMessages(null)
                val txt = editable.toString()
                textVAPackage1handle.postDelayed({
                    if (preferences?.getString(IdNames.vaIntentPackage1Cfg_key, "") != txt) {
                        preferences?.edit()?.putString(IdNames.vaIntentPackage1Cfg_key, txt)
                            ?.apply()
                    }
                }, 5000)
            }
        })
        preferences?.getString(IdNames.vaIntentPackage1Cfg_key, IdNames.intentDefaultPackage)?.let {
            textVAPackage1.setText(it)
        }
        rowVAPackage1.visibility = GONE


        val rowVAApp2 =  view.findViewById<TableRow>(R.id.vaApp2Row)
        val rowVAIntent2 =  view.findViewById<TableRow>(R.id.vaIntent2Row)
        val rowVAPackage2 =  view.findViewById<TableRow>(R.id.vaPackage2Row)

        val spinnerVA2 = view.findViewById<Spinner>(R.id.vaPressed2Spinner)
        spinnerVA2.adapter = ArrayAdapter<CharSequence>(
            context,
            R.layout.spinner_text_item,
            spinnerSRCArray
        )
        spinnerVA2?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                if (preferences?.getInt(IdNames.vaClick2Cfg_key, 0) != position) {
                    preferences?.edit()?.putInt(IdNames.vaClick2Cfg_key, position)?.apply()
                }
                driveKeyToastFunc(context, position)
                if(position == ItemsSrcClick.START.value || position == ItemsSrcClick.START_ON_DIM.value){
                    rowVAApp2.visibility = VISIBLE
                    rowVAIntent2.visibility = GONE
                    rowVAPackage2.visibility = GONE
                }else if(position == ItemsSrcClick.SEND_INTENT.value){
                    rowVAIntent2.visibility = VISIBLE
                    rowVAPackage2.visibility = VISIBLE
                    rowVAApp2.visibility = GONE
                }else{
                    rowVAIntent2.visibility = GONE
                    rowVAPackage2.visibility = GONE
                    rowVAApp2.visibility = GONE
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        preferences?.getInt(IdNames.vaClick2Cfg_key, 0)?.let {
            if(it>=spinnerSRCArray.size){
                spinnerVA2?.setSelection(0)
            }else {
                spinnerVA2?.setSelection(it)
            }
        }

        val spinnerVAApp2 = view.findViewById<Spinner>(R.id.vaApp2Spinner)
        spinnerVAApp2.adapter = arrayVAAdapter
        spinnerVAApp2?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                if (parentView != null) {
                    if (preferences?.getString(
                            IdNames.vaApp2Cfg_key,
                            ""
                        ) != parentView.getItemAtPosition(position).toString()
                    ) {
                        preferences?.edit()?.putString(
                            IdNames.vaApp2Cfg_key,
                            parentView.getItemAtPosition(position).toString()
                        )?.apply()
                    }
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        idxVAApp = arrayListPackages.indexOf(preferences?.getString(IdNames.vaApp2Cfg_key, ""));
        if(idxVAApp == -1){
            idxVAApp = 0
        }
        spinnerVAApp2?.setSelection(idxVAApp)
        rowVAApp2.visibility = GONE

        val textVAIntent2handle = Handler(Looper.getMainLooper())
        val textVAIntent2 = view.findViewById<EditText>(R.id.vaIntent2EditText)
        textVAIntent2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(editable: Editable?) {
                textVAIntent2handle.removeCallbacksAndMessages(null)
                val txt = editable.toString()
                textVAIntent2handle.postDelayed({
                    if (preferences?.getString(IdNames.vaIntent2Cfg_key, "") != txt) {
                        preferences?.edit()?.putString(IdNames.vaIntent2Cfg_key, txt)?.apply()
                    }
                }, 5000)
            }
        })
        preferences?.getString(IdNames.vaIntent2Cfg_key, IdNames.intentDefaultActionVA)?.let {
            textVAIntent2.setText(it)
        }
        rowVAIntent2.visibility = GONE

        val textVAPackage2handle = Handler(Looper.getMainLooper())
        val textVAPackage2 = view.findViewById<EditText>(R.id.vaPackage2EditText)
        textVAPackage2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(editable: Editable?) {
                textVAPackage2handle.removeCallbacksAndMessages(null)
                val txt = editable.toString()
                textVAPackage2handle.postDelayed({
                    if (preferences?.getString(IdNames.vaIntentPackage2Cfg_key, "") != txt) {
                        preferences?.edit()?.putString(IdNames.vaIntentPackage2Cfg_key, txt)
                            ?.apply()
                    }
                }, 5000)
            }
        })
        preferences?.getString(IdNames.vaIntentPackage2Cfg_key, IdNames.intentDefaultPackage)?.let {
            textVAPackage2.setText(it)
        }
        rowVAPackage2.visibility = GONE


        val rowVAApp3 =  view.findViewById<TableRow>(R.id.vaApp3Row)
        val rowVAIntent3 =  view.findViewById<TableRow>(R.id.vaIntent3Row)
        val rowVAPackage3 =  view.findViewById<TableRow>(R.id.vaPackage3Row)

        val spinnerVA3 = view.findViewById<Spinner>(R.id.vaPressed3Spinner)
        spinnerVA3.adapter = ArrayAdapter<CharSequence>(
            context,
            R.layout.spinner_text_item,
            spinnerSRCArray
        )
        spinnerVA3?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                if (preferences?.getInt(IdNames.vaClick3Cfg_key, 0) != position) {
                    preferences?.edit()?.putInt(IdNames.vaClick3Cfg_key, position)?.apply()
                }
                driveKeyToastFunc(context, position)
                if(position == ItemsSrcClick.START.value || position == ItemsSrcClick.START_ON_DIM.value){
                    rowVAApp3.visibility = VISIBLE
                    rowVAIntent3.visibility = GONE
                    rowVAPackage3.visibility = GONE
                }else if(position == ItemsSrcClick.SEND_INTENT.value){
                    rowVAIntent3.visibility = VISIBLE
                    rowVAPackage3.visibility = VISIBLE
                    rowVAApp3.visibility = GONE
                }else{
                    rowVAIntent3.visibility = GONE
                    rowVAPackage3.visibility = GONE
                    rowVAApp3.visibility = GONE
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        preferences?.getInt(IdNames.vaClick3Cfg_key, 0)?.let {
            if(it>=spinnerSRCArray.size){
                spinnerVA3?.setSelection(0)
            }else {
                spinnerVA3?.setSelection(it)
            }
        }

        val spinnerVAApp3 = view.findViewById<Spinner>(R.id.vaApp3Spinner)
        spinnerVAApp3.adapter = arrayVAAdapter
        spinnerVAApp3?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                if (parentView != null) {
                    if (preferences?.getString(
                            IdNames.vaApp3Cfg_key,
                            ""
                        ) != parentView.getItemAtPosition(position).toString()
                    ) {
                        preferences?.edit()?.putString(
                            IdNames.vaApp3Cfg_key,
                            parentView.getItemAtPosition(position).toString()
                        )?.apply()
                    }
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        idxVAApp = arrayListPackages.indexOf(preferences?.getString(IdNames.vaApp3Cfg_key, ""));
        if(idxVAApp == -1){
            idxVAApp = 0
        }
        spinnerVAApp3?.setSelection(idxVAApp)
        rowVAApp3.visibility = GONE

        val textVAIntent3handle = Handler(Looper.getMainLooper())
        val textVAIntent3 = view.findViewById<EditText>(R.id.vaIntent3EditText)
        textVAIntent3.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(editable: Editable?) {
                textVAIntent3handle.removeCallbacksAndMessages(null)
                val txt = editable.toString()
                textVAIntent3handle.postDelayed({
                    if (preferences?.getString(IdNames.vaIntent3Cfg_key, "") != txt) {
                        preferences?.edit()?.putString(IdNames.vaIntent3Cfg_key, txt)?.apply()
                    }
                }, 5000)
            }
        })
        preferences?.getString(IdNames.vaIntent3Cfg_key, IdNames.intentDefaultActionVA)?.let {
            textVAIntent3.setText(it)
        }
        rowVAIntent3.visibility = GONE

        val textVAPackage3handle = Handler(Looper.getMainLooper())
        val textVAPackage3 = view.findViewById<EditText>(R.id.vaPackage3EditText)
        textVAPackage3.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(editable: Editable?) {
                textVAPackage3handle.removeCallbacksAndMessages(null)
                val txt = editable.toString()
                textVAPackage3handle.postDelayed({
                    if (preferences?.getString(IdNames.vaIntentPackage3Cfg_key, "") != txt) {
                        preferences?.edit()?.putString(IdNames.vaIntentPackage3Cfg_key, txt)
                            ?.apply()
                    }
                }, 5000)
            }
        })
        preferences?.getString(IdNames.vaIntentPackage3Cfg_key, IdNames.intentDefaultPackage)?.let {
            textVAPackage3.setText(it)
        }
        rowVAPackage3.visibility = GONE


        val rowVAAppLong =  view.findViewById<TableRow>(R.id.vaAppLongRow)
        val rowVAIntentLong =  view.findViewById<TableRow>(R.id.vaIntentLongRow)
        val rowVAPackageLong =  view.findViewById<TableRow>(R.id.vaPackageLongRow)

        val spinnerVALong = view.findViewById<Spinner>(R.id.vaPressedLongSpinner)
        spinnerVALong.adapter = ArrayAdapter<CharSequence>(
            context,
            R.layout.spinner_text_item,
            spinnerSRCArray
        )
        spinnerVALong?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                if (preferences?.getInt(IdNames.vaClickLongCfg_key, 0) != position) {
                    preferences?.edit()?.putInt(IdNames.vaClickLongCfg_key, position)?.apply()
                }
                driveKeyToastFunc(context, position)
                if(position == ItemsSrcClick.START.value || position == ItemsSrcClick.START_ON_DIM.value){
                    rowVAAppLong.visibility = VISIBLE
                    rowVAIntentLong.visibility = GONE
                    rowVAPackageLong.visibility = GONE
                }else if(position == ItemsSrcClick.SEND_INTENT.value){
                    rowVAIntentLong.visibility = VISIBLE
                    rowVAPackageLong.visibility = VISIBLE
                    rowVAAppLong.visibility = GONE
                }else{
                    rowVAIntentLong.visibility = GONE
                    rowVAPackageLong.visibility = GONE
                    rowVAAppLong.visibility = GONE
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        preferences?.getInt(IdNames.vaClickLongCfg_key, 0)?.let {
            if(it>=spinnerSRCArray.size){
                spinnerVALong?.setSelection(0)
            }else {
                spinnerVALong?.setSelection(it)
            }
        }

        val spinnerVAAppLong = view.findViewById<Spinner>(R.id.vaAppLongSpinner)
        spinnerVAAppLong.adapter = arrayAdapter
        spinnerVAAppLong?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                if (parentView != null) {
                    if (preferences?.getString(
                            IdNames.vaAppLongCfg_key,
                            ""
                        ) != parentView.getItemAtPosition(position).toString()
                    ) {
                        preferences?.edit()?.putString(
                            IdNames.vaAppLongCfg_key,
                            parentView.getItemAtPosition(position).toString()
                        )?.apply()
                    }
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        idxVAApp = arrayListPackages.indexOf(preferences?.getString(IdNames.vaAppLongCfg_key, ""));
        if(idxVAApp == -1){
            idxVAApp = 0
        }
        spinnerVAAppLong?.setSelection(idxVAApp)
        rowVAAppLong.visibility = GONE

        val textVAIntentLonghandle = Handler(Looper.getMainLooper())
        val textVAIntentLong = view.findViewById<EditText>(R.id.vaIntentLongEditText)
        textVAIntentLong.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(editable: Editable?) {
                textVAIntentLonghandle.removeCallbacksAndMessages(null)
                val txt = editable.toString()
                textVAIntentLonghandle.postDelayed({
                    if (preferences?.getString(IdNames.vaIntentLongCfg_key, "") != txt) {
                        preferences?.edit()?.putString(IdNames.vaIntentLongCfg_key, txt)?.apply()
                    }
                }, 5000)
            }
        })
        preferences?.getString(IdNames.vaIntentLongCfg_key, IdNames.intentDefaultActionVA)?.let {
            textVAIntentLong.setText(it)
        }
        rowVAIntentLong.visibility = GONE

        val textVAPackageLonghandle = Handler(Looper.getMainLooper())
        val textVAPackageLong = view.findViewById<EditText>(R.id.vaPackageLongEditText)
        textVAPackageLong.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(editable: Editable?) {
                textVAPackageLonghandle.removeCallbacksAndMessages(null)
                val txt = editable.toString()
                textVAPackageLonghandle.postDelayed({
                    if (preferences?.getString(IdNames.vaIntentPackageLongCfg_key, "") != txt) {
                        preferences?.edit()?.putString(IdNames.vaIntentPackageLongCfg_key, txt)
                            ?.apply()
                    }
                }, 5000)
            }
        })
        preferences?.getString(IdNames.vaIntentPackageLongCfg_key, IdNames.intentDefaultPackage)?.let {
            textVAPackageLong.setText(it)
        }
        rowVAPackageLong.visibility = GONE

        try{
            MainActivity.instance?.let {
                KeyboardStateEvent.setEventListener(
                    it
                ) {isOpen->
                        if (!isOpen) {
                            binding.root.invalidate()
                            binding.root.requestLayout()
                        }
                }
            }
        }catch(_:Exception){

        }
        binding.root.invalidate()
        binding.root.requestLayout()
  }

    override fun onResume() {
        super.onResume()
        binding.root.invalidate()
        binding.root.requestLayout()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}