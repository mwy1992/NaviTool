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
import com.google.android.material.switchmaterial.SwitchMaterial
import ru.monjaro.mconfig.databinding.StartAppsFragmentBinding


class StartAppsFragment : Fragment() {
    private var _binding: StartAppsFragmentBinding? = null
    private var preferences: SharedPreferences? = null
    private val binding get() = _binding!!
    private lateinit var arrayListPackages: ArrayList<String>


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val prefs =
            PreferenceManager.getDefaultSharedPreferences(requireContext().applicationContext);
        if (prefs != null) {
            preferences = prefs
        }
        arrayListPackages = MainActivity.getApplicationsList()
        _binding = StartAppsFragmentBinding.inflate(inflater, container, false)
        return binding.root
   }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val context = requireContext().applicationContext
        binding.root.requestLayout()

        val appStartEnableSettings = view.findViewById<SwitchMaterial>(R.id.appStartEnableSettings)
        appStartEnableSettings?.setOnCheckedChangeListener { _, isChecked ->
            if (preferences?.getBoolean(IdNames.appsEnableStart_key, false) != isChecked) {
                preferences?.edit()?.putBoolean(IdNames.appsEnableStart_key, isChecked)?.apply()
            }
        }
        preferences?.getBoolean(IdNames.appsEnableStart_key, false)?.let {
            appStartEnableSettings?.isChecked = it
        }

        val addAppSettings = view.findViewById<TextView>(R.id.addAppSettings)
        addAppSettings.setOnClickListener {
            var iDx:Int = -1
            for(i in 1 until (IdNames.appStartQuantity+1)) {
                if (preferences?.getBoolean(IdNames.appStartEnable_key_+i.toString(),false) == false){
                    iDx = i
                    break
                }
            }
            if(iDx <= 0){
                Toast.makeText(context, "已达到应用数量限制", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            addAppSettingsClick(view,iDx,true)
        }

        for(i in 1 until (IdNames.appStartQuantity+1)) {
            if (preferences?.getBoolean(IdNames.appStartEnable_key_+i.toString(),false) == true) {
                addAppSettingsClick(view, i, false)
            }
        }
        try{
            MainActivity.instance?.let {
                KeyboardStateEvent.setEventListener(
                    it
                ) {isOpen->
                    if(!isOpen) {
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

    fun addAppSettingsClick(view: View, iDx:Int, new:Boolean){
        if(iDx <= 0 || iDx > IdNames.appStartQuantity){
            return
        }
        if (preferences?.getBoolean(IdNames.appStartEnable_key_+iDx.toString(),false) == false) {
            preferences?.edit()?.putBoolean(IdNames.appStartEnable_key_+iDx.toString(), true)?.apply()
        }
        val li = view.findViewById<LinearLayout>(R.id.appsContainerLayout)
        val appsFragment = View.inflate(context, R.layout.app_container, null) as LinearLayout

        //delete button
        val removeAppSettings = appsFragment.findViewById<TextView>(R.id.removeAppSettings)
        removeAppSettings.setOnClickListener {
            preferences?.edit()?.putBoolean(IdNames.appStartEnable_key_+iDx.toString(), false)?.apply()
            preferences?.edit()?.putString(IdNames.appStartAppName_key_+iDx.toString(), "")?.apply()
            preferences?.edit()?.putString(IdNames.appStartActivity_key_ + iDx.toString(), "")?.apply()
            preferences?.edit()?.putInt(IdNames.appStartDelay_key_+iDx.toString(), IdNames.appStartDelayDefault)?.apply()
            preferences?.edit()?.putInt(IdNames.appStartDisplay_key_+iDx.toString(), 0)?.apply()

            li.removeView(removeAppSettings.parent.parent as ViewGroup)

            binding.root.invalidate()
            binding.root.requestLayout()
        }

        //test button
        val appTestSettings = appsFragment.findViewById<TextView>(R.id.appTestSettings)
        appTestSettings.setOnClickListener {
            StartAppsProcess.startApp(context, preferences, iDx)
        }

        //app Name
        val appSpinner = appsFragment.findViewById<Spinner>(R.id.appSpinner)
        val arrayAdapter: ArrayAdapter<String> = ArrayAdapter<String>(
            requireContext().applicationContext,
            R.layout.spinner_text_item,
            arrayListPackages
        )
        appSpinner.adapter = arrayAdapter
        appSpinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                if (parentView != null) {
                    if (preferences?.getString(IdNames.appStartAppName_key_+iDx.toString(),"") != parentView.getItemAtPosition(position).toString()
                    ) {
                        preferences?.edit()?.putString(IdNames.appStartAppName_key_+iDx.toString(),parentView.getItemAtPosition(position).toString())?.apply()
                    }
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        var idxApp = 0
        if(!new){
            idxApp = arrayListPackages.indexOf(preferences?.getString(IdNames.appStartAppName_key_+iDx.toString(), ""));
            if(idxApp == -1){
                idxApp = 0
            }
        }
        appSpinner?.setSelection(idxApp)

        //activity
        val appActivityHandle = Handler(Looper.getMainLooper())
        val appActivityEditText = appsFragment.findViewById<EditText>(R.id.appActivityEditText)
        appActivityEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(editable: Editable?) {
                appActivityHandle.removeCallbacksAndMessages(null)
                val txt = editable.toString()
                appActivityHandle.postDelayed({
                    if (preferences?.getString(IdNames.appStartActivity_key_+iDx.toString(), "") != txt) {
                        preferences?.edit()?.putString(IdNames.appStartActivity_key_+iDx.toString(), txt)?.apply()
                    }
                }, 3000)
            }
        })
        if(new)
        {
            appActivityEditText.setText("")
        }else {
            preferences?.getString(IdNames.appStartActivity_key_ + iDx.toString(), "")?.let {
                appActivityEditText.setText(it)
            }
        }

        //delay
        val appDelayHandle = Handler(Looper.getMainLooper())
        val appDelayEditText = appsFragment.findViewById<EditText>(R.id.appDelayEditText)
        appDelayEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(editable: Editable?) {
                appDelayHandle.removeCallbacksAndMessages(null)
                var txt = IdNames.appStartDelayDefault
                try {
                    txt = editable.toString().toInt()
                }catch (_:Exception){}
                appDelayHandle.postDelayed({
                    if (preferences?.getInt(IdNames.appStartDelay_key_+iDx.toString(), IdNames.appStartDelayDefault) != txt) {
                        preferences?.edit()?.putInt(IdNames.appStartDelay_key_+iDx.toString(), txt)?.apply()
                    }
                }, 3000)
            }
        })
        if(new){
            appDelayEditText.setText(IdNames.appStartDelayDefault.toString())
        }else {
            preferences?.getInt(IdNames.appStartDelay_key_ + iDx.toString(),IdNames.appStartDelayDefault)?.let {
                appDelayEditText.setText(it.toString())
            }
        }

        //display
        val appDisplaySpinner = appsFragment.findViewById<Spinner>(R.id.appDisplaySpinner)
        val appDisplayAdapter: ArrayAdapter<String> = ArrayAdapter<String>(
            requireContext().applicationContext,
            R.layout.spinner_text_item,
            resources.getStringArray(R.array.spinnerDisplay)
        )
        appDisplaySpinner.adapter = appDisplayAdapter
        appDisplaySpinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                if (parentView != null) {
                    if (preferences?.getInt(IdNames.appStartDisplay_key_+iDx.toString(),0) != position) {
                        preferences?.edit()?.putInt(IdNames.appStartDisplay_key_+iDx.toString(),position)?.apply()
                    }
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        if(new){
            appDisplaySpinner?.setSelection(0)
        }else{
            preferences?.getInt(IdNames.appStartDisplay_key_+iDx.toString(), 0)?.let {
                appDisplaySpinner?.setSelection(it)
            }
        }

        var count = 0
        for (x in 0 until li.childCount) {
            if (li.getChildAt(x) is LinearLayout) {
                count++
            }
        }
        if(count>=iDx){ //id=0 is PLUS button
            li.addView(appsFragment,iDx)
        }else{
            li.addView(appsFragment)
        }
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