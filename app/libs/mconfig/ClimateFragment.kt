package ru.monjaro.mconfig

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TableRow
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager
import com.google.android.material.switchmaterial.SwitchMaterial
import ru.monjaro.mconfig.databinding.ClimateFragmentBinding
import kotlin.math.floor


class ClimateFragment : Fragment() {
    private var _binding: ClimateFragmentBinding? = null
    private var preferences: SharedPreferences? = null
    private val binding get() = _binding!!
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
        _binding = ClimateFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
   }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val context = requireContext().applicationContext
        binding.root.requestLayout()

        val climateGClean = view.findViewById<SwitchMaterial>(R.id.climateGCleanSwitch)
        climateGClean?.setOnCheckedChangeListener { _, isChecked ->
            if (preferences?.getBoolean(IdNames.climateGCleanCfg_key, false) != isChecked) {
                preferences?.edit()?.putBoolean(IdNames.climateGCleanCfg_key, isChecked)?.apply()
            }
        }
        preferences?.getBoolean(IdNames.climateGCleanCfg_key, true)?.let {
            climateGClean?.isChecked = it
        }

        //启动时自动模式
        val climateStart_Auto = view.findViewById<SwitchMaterial>(R.id.climateStart_Auto_Switch)
        val climateStart_Speed_Spinner = view.findViewById<Spinner>(R.id.climateStart_Speed_Spinner)

        climateStart_Auto?.setOnCheckedChangeListener { _, isChecked ->
            if (preferences?.getBoolean(IdNames.climateStartAutoCfg_key, false) != isChecked) {
                preferences?.edit()?.putBoolean(IdNames.climateStartAutoCfg_key, isChecked)?.apply()
            }

            view.findViewById<Spinner>(R.id.climateStart_Speed_Spinner).adapter = ArrayAdapter<CharSequence>(
                context,
                R.layout.spinner_text_item,
                if(isChecked) resources.getStringArray(R.array.ItemsClimateAutoFan) else resources.getStringArray(R.array.ItemsClimateFan)
            )
            if(isChecked) {
                preferences?.getInt(
                    IdNames.climateStartSpeedCfg_key,
                    ItemsClimateAutoFan.NOT_USED.value
                )?.let { it1 ->
                    climateStart_Speed_Spinner?.setSelection(
                        ItemsClimateAutoFan.entries.indexOf(
                            ItemsClimateAutoFan.entries.firstOrNull { it.value == it1 })
                    )
                }
            }else{
                preferences?.getInt(
                    IdNames.climateStartSpeedCfg_key,
                    ItemsClimateFan.NOT_USED.value
                )?.let { it1 ->
                    climateStart_Speed_Spinner?.setSelection(
                        ItemsClimateFan.entries.indexOf(
                            ItemsClimateFan.entries.firstOrNull { it.value == it1 })
                    )
                }
            }
        }

        //启动时风速

        climateStart_Speed_Spinner.adapter = ArrayAdapter<CharSequence>(
            context,
            R.layout.spinner_text_item,
            if(climateStart_Auto.isChecked) resources.getStringArray(R.array.ItemsClimateAutoFan) else resources.getStringArray(R.array.ItemsClimateFan)
        )
        climateStart_Speed_Spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                if(climateStart_Auto.isChecked) {
                    if (preferences?.getInt(IdNames.climateStartSpeedCfg_key,-1) != ItemsClimateAutoFan.entries[position].value) {
                        preferences?.edit()?.putInt(IdNames.climateStartSpeedCfg_key,ItemsClimateAutoFan.entries[position].value)?.apply()
                    }
                }else{
                    if (preferences?.getInt(IdNames.climateStartSpeedCfg_key,-1) != ItemsClimateFan.entries[position].value) {
                        preferences?.edit()?.putInt(IdNames.climateStartSpeedCfg_key,ItemsClimateFan.entries[position].value)?.apply()
                    }
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        //在这里初始化 climateStart_Auto，之后添加 climateStart_Speed_Spinner?.onItemSelectedListener
        preferences?.getBoolean(IdNames.climateStartAutoCfg_key, false)?.let {
            climateStart_Auto?.isChecked = it
        }

        if(climateStart_Auto.isChecked) {
            preferences?.getInt(
                IdNames.climateStartSpeedCfg_key,
                ItemsClimateAutoFan.NOT_USED.value
            )?.let { it1 ->
                climateStart_Speed_Spinner?.setSelection(
                    ItemsClimateAutoFan.entries.indexOf(
                        ItemsClimateAutoFan.entries.firstOrNull { it.value == it1 })
                )
            }
        }else{
            preferences?.getInt(
                IdNames.climateStartSpeedCfg_key,
                ItemsClimateFan.NOT_USED.value
            )?.let { it1 ->
                climateStart_Speed_Spinner?.setSelection(
                    ItemsClimateFan.entries.indexOf(
                        ItemsClimateFan.entries.firstOrNull { it.value == it1 })
                )
            }
        }

        val climateStart_AC_Spinner = view.findViewById<Spinner>(R.id.climateStartAC_Spinner)
        climateStart_AC_Spinner.adapter = ArrayAdapter<CharSequence>(
            context,
            R.layout.spinner_text_item,
            resources.getStringArray(R.array.ItemsClimateAC)
        )
        climateStart_AC_Spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                if (preferences?.getInt(IdNames.climateStart_AC_Cfg_key, -1) != ItemsClimateAC.entries[position].value) {
                    preferences?.edit()?.putInt(IdNames.climateStart_AC_Cfg_key, ItemsClimateAC.entries[position].value)?.apply()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        preferences?.getInt(IdNames.climateStart_AC_Cfg_key, ItemsClimateAC.NOT_USED.value)?.let { it1 ->
            climateStart_AC_Spinner?.setSelection(ItemsClimateAC.entries.indexOf(
                ItemsClimateAC.entries.firstOrNull { it.value == it1 }))
        }



        //启动时送风模式
        val climateStart_Mode_Spinner = view.findViewById<Spinner>(R.id.climateStart_Mode_Spinner)
        climateStart_Mode_Spinner.adapter = ArrayAdapter<CharSequence>(
            context,
            R.layout.spinner_text_item,
            resources.getStringArray(R.array.ItemsClimateModes)
        )
        climateStart_Mode_Spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                if (preferences?.getInt(IdNames.climateStart_Mode_Cfg_key, -1) != ItemsClimateModes.entries[position].value) {
                    preferences?.edit()?.putInt(IdNames.climateStart_Mode_Cfg_key, ItemsClimateModes.entries[position].value)?.apply()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        preferences?.getInt(IdNames.climateStart_Mode_Cfg_key, ItemsClimateModes.NOT_USED.value)?.let { it1 ->
            climateStart_Mode_Spinner?.setSelection(ItemsClimateModes.entries.indexOf(
                ItemsClimateModes.entries.firstOrNull { it.value == it1 }))
        }

        val climateStart_Mode128_Spinner = view.findViewById<Spinner>(R.id.climateStart_Mode128_Spinner)
        climateStart_Mode128_Spinner.adapter = ArrayAdapter<CharSequence>(
            context,
            R.layout.spinner_text_item,
            resources.getStringArray(R.array.ItemsClimateModes128)
        )
        climateStart_Mode128_Spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                if (preferences?.getInt(IdNames.climateStart_Mode128_Cfg_key, -1) != ItemsClimateModes128.entries[position].value) {
                    preferences?.edit()?.putInt(IdNames.climateStart_Mode128_Cfg_key, ItemsClimateModes128.entries[position].value)?.apply()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        preferences?.getInt(IdNames.climateStart_Mode128_Cfg_key, ItemsClimateModes128.NOT_USED.value)?.let { it1 ->
            climateStart_Mode128_Spinner?.setSelection(ItemsClimateModes128.entries.indexOf(
                ItemsClimateModes128.entries.firstOrNull { it.value == it1 }))
        }

        //启动时3区自动运行模式
        val climateStart_Auto128 = view.findViewById<SwitchMaterial>(R.id.climateStart_Auto128_Switch)
        climateStart_Auto128?.setOnCheckedChangeListener { _, isChecked ->
            if (preferences?.getBoolean(IdNames.climateStartAuto128Cfg_key, false) != isChecked) {
                preferences?.edit()?.putBoolean(IdNames.climateStartAuto128Cfg_key, isChecked)?.apply()
            }
        }
        preferences?.getBoolean(IdNames.climateStartAuto128Cfg_key, false)?.let {
            climateStart_Auto128?.isChecked = it
        }

        //启动时的空调设置Spinner（最后一个，以便处理子块）
        val climateStart_Spinner = view.findViewById<Spinner>(R.id.climateStart_Spinner)
        climateStart_Spinner.adapter = ArrayAdapter<CharSequence>(
            context,
            R.layout.spinner_text_item,
            resources.getStringArray(R.array.ItemsClimateStart)
        )
        climateStart_Spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                if (preferences?.getInt(IdNames.climateStartCfg_key, 0) != ItemsClimateStart.entries[position].value) {
                    preferences?.edit()?.putInt(IdNames.climateStartCfg_key, ItemsClimateStart.entries[position].value)?.apply()
                }
                if(ItemsClimateStart.entries[position] != ItemsClimateStart.NOT_USED){
                    view.findViewById<TableRow>(R.id.climateStart_Auto_TableRow).visibility = VISIBLE
                    view.findViewById<TableRow>(R.id.climateStart_Speed_TableRow).visibility = VISIBLE
                    view.findViewById<TableRow>(R.id.climateStart_Mode_TableRow).visibility = VISIBLE
                    view.findViewById<TableRow>(R.id.climateStart_Auto128_TableRow).visibility = VISIBLE
                    view.findViewById<TableRow>(R.id.climateStart_Mode128_TableRow).visibility = VISIBLE

                }else{
                    view.findViewById<TableRow>(R.id.climateStart_Auto_TableRow).visibility = GONE
                    view.findViewById<TableRow>(R.id.climateStart_Speed_TableRow).visibility = GONE
                    view.findViewById<TableRow>(R.id.climateStart_Mode_TableRow).visibility = GONE
                    view.findViewById<TableRow>(R.id.climateStart_Auto128_TableRow).visibility = GONE
                    view.findViewById<TableRow>(R.id.climateStart_Mode128_TableRow).visibility = GONE
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        preferences?.getInt(IdNames.climateStartCfg_key, ItemsClimateStart.NOT_USED.value)?.let { it1 ->
            climateStart_Spinner?.setSelection(ItemsClimateStart.entries.indexOf(
                ItemsClimateStart.entries.firstOrNull { it.value == it1 }))
        }

        //前挡风玻璃加热
        val climateDefrozeTemp_Spinner = view.findViewById<Spinner>(R.id.climateDefrozeTemp_Spinner)
        climateDefrozeTemp_Spinner.adapter = ArrayAdapter<CharSequence>(
            context,
            R.layout.spinner_text_item,
            resources.getStringArray(R.array.ItemsClimateDefrozeTemps)
        )
        var tempDefrozeArr = resources.getStringArray(R.array.ItemsClimateDefrozeTemps)
        tempDefrozeArr[0] = "-100.0"
        climateDefrozeTemp_Spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                val d = preferences?.getFloat(IdNames.climateDefrozeTempCfg_key, tempDefrozeArr[0].toFloat())

                if (d==null || floor(d.toDouble()) != floor(tempDefrozeArr[position].toDouble())){
                    preferences?.edit()?.putFloat(IdNames.climateDefrozeTempCfg_key, floor(tempDefrozeArr[position].toDouble()).toFloat())?.apply()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        preferences?.getFloat(IdNames.climateDefrozeTempCfg_key, tempDefrozeArr[0].toFloat())?.let { it1 ->
            climateDefrozeTemp_Spinner?.setSelection(tempDefrozeArr.indexOf(
                tempDefrozeArr.firstOrNull { floor(it.toDouble()) == floor(it1.toDouble()) }))
        }

        val climateDefrozePeriod_Spinner = view.findViewById<Spinner>(R.id.climateDefrozePeriod_Spinner)
        climateDefrozePeriod_Spinner.adapter = ArrayAdapter<CharSequence>(
            context,
            R.layout.spinner_text_item,
            resources.getStringArray(R.array.ItemsClimateDefrozePeriods)
        )
        climateDefrozePeriod_Spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                if (preferences?.getInt(IdNames.climateDefrozePeriodCfg_key, 0) != ItemsClimateDefrozePeriods.entries[position].value) {
                    preferences?.edit()?.putInt(IdNames.climateDefrozePeriodCfg_key, ItemsClimateDefrozePeriods.entries[position].value)?.apply()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        preferences?.getInt(IdNames.climateDefrozePeriodCfg_key, ItemsClimateDefrozePeriods.NOT_USED.value)?.let { it1 ->
            climateDefrozePeriod_Spinner?.setSelection(ItemsClimateDefrozePeriods.entries.indexOf(
                ItemsClimateDefrozePeriods.entries.firstOrNull { it.value == it1 }))
        }

        val climateDefrozePeriodTemp_Spinner = view.findViewById<Spinner>(R.id.climateDefrozePeriodTemp_Spinner)
        climateDefrozePeriodTemp_Spinner.adapter = ArrayAdapter<CharSequence>(
            context,
            R.layout.spinner_text_item,
            resources.getStringArray(R.array.ItemsClimateDefrozeTemps)
        )
        climateDefrozePeriodTemp_Spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                val d = preferences?.getFloat(IdNames.climateDefrozePeriodTempCfg_key, tempDefrozeArr[0].toFloat())

                if (d==null || floor(d.toDouble()) != floor(tempDefrozeArr[position].toDouble())){
                    preferences?.edit()?.putFloat(IdNames.climateDefrozePeriodTempCfg_key, floor(tempDefrozeArr[position].toDouble()).toFloat())?.apply()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        preferences?.getFloat(IdNames.climateDefrozePeriodTempCfg_key, tempDefrozeArr[0].toFloat())?.let { it1 ->
            climateDefrozePeriodTemp_Spinner?.setSelection(tempDefrozeArr.indexOf(
                tempDefrozeArr.firstOrNull { floor(it.toDouble()) == floor(it1.toDouble()) }))
        }

        //后挡风玻璃加热
        val climateDefrozeRearTemp_Spinner = view.findViewById<Spinner>(R.id.climateDefrozeRearTemp_Spinner)
        climateDefrozeRearTemp_Spinner.adapter = ArrayAdapter<CharSequence>(
            context,
            R.layout.spinner_text_item,
            resources.getStringArray(R.array.ItemsClimateDefrozeTemps)
        )
        climateDefrozeRearTemp_Spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                val d = preferences?.getFloat(IdNames.climateDefrozeRearTempCfg_key, tempDefrozeArr[0].toFloat())

                if (d==null || floor(d.toDouble()) != floor(tempDefrozeArr[position].toDouble())){
                    preferences?.edit()?.putFloat(IdNames.climateDefrozeRearTempCfg_key, floor(tempDefrozeArr[position].toDouble()).toFloat())?.apply()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        preferences?.getFloat(IdNames.climateDefrozeRearTempCfg_key, tempDefrozeArr[0].toFloat())?.let { it1 ->
            climateDefrozeRearTemp_Spinner?.setSelection(tempDefrozeArr.indexOf(
                tempDefrozeArr.firstOrNull { floor(it.toDouble()) == floor(it1.toDouble()) }))
        }


        //驾驶员座椅加热
        // 0
        val climateSeatDr_Spinner = view.findViewById<Spinner>(R.id.climateSeatDr_Spinner)
        climateSeatDr_Spinner.adapter = ArrayAdapter<CharSequence>(
            context,
            R.layout.spinner_text_item,
            resources.getStringArray(R.array.ItemsClimateSeatModes)
        )
        climateSeatDr_Spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                if (preferences?.getInt(IdNames.climateSeatDrLevelCfg_key, 0) != ItemsClimateSeatModes.entries[position].value) {
                    preferences?.edit()?.putInt(IdNames.climateSeatDrLevelCfg_key, ItemsClimateSeatModes.entries[position].value)?.apply()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        preferences?.getInt(IdNames.climateSeatDrLevelCfg_key, ItemsClimateSeatModes.NOT_USED.value)?.let { it1 ->
            climateSeatDr_Spinner?.setSelection(ItemsClimateSeatModes.entries.indexOf(
                ItemsClimateSeatModes.entries.firstOrNull { it.value == it1 }))
        }

        val climateSeatDrTemp_Spinner = view.findViewById<Spinner>(R.id.climateSeatDrTemp_Spinner)
        climateSeatDrTemp_Spinner.adapter = ArrayAdapter<CharSequence>(
            context,
            R.layout.spinner_text_item,
            resources.getStringArray(R.array.ItemsClimateSeatTemps)
        )
        val tempSeatArr = resources.getStringArray(R.array.ItemsClimateSeatTemps)
        climateSeatDrTemp_Spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                val d = preferences?.getFloat(IdNames.climateSeatDrIntTempCfg_key, tempSeatArr[0].toFloat())

                if (d==null || floor(d.toDouble()) != floor(tempSeatArr[position].toDouble())){
                    preferences?.edit()?.putFloat(IdNames.climateSeatDrIntTempCfg_key, floor(tempSeatArr[position].toDouble()).toFloat())?.apply()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        preferences?.getFloat(IdNames.climateSeatDrIntTempCfg_key, tempSeatArr[0].toFloat())?.let { it1 ->
            climateSeatDrTemp_Spinner?.setSelection(tempSeatArr.indexOf(
                tempSeatArr.firstOrNull { floor(it.toDouble()) == floor(it1.toDouble()) }))
        }

        // 1
        val climateSeatDr1_Spinner = view.findViewById<Spinner>(R.id.climateSeatDr1_Spinner)
        climateSeatDr1_Spinner.adapter = ArrayAdapter<CharSequence>(
            context,
            R.layout.spinner_text_item,
            resources.getStringArray(R.array.ItemsClimateSeatModes)
        )
        climateSeatDr1_Spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                if (preferences?.getInt(IdNames.climateSeatDrLevel1Cfg_key, 0) != ItemsClimateSeatModes.entries[position].value) {
                    preferences?.edit()?.putInt(IdNames.climateSeatDrLevel1Cfg_key, ItemsClimateSeatModes.entries[position].value)?.apply()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        preferences?.getInt(IdNames.climateSeatDrLevel1Cfg_key, ItemsClimateSeatModes.NOT_USED.value)?.let { it1 ->
            climateSeatDr1_Spinner?.setSelection(ItemsClimateSeatModes.entries.indexOf(
                ItemsClimateSeatModes.entries.firstOrNull { it.value == it1 }))
        }

        val climateSeatDrTemp1_Spinner = view.findViewById<Spinner>(R.id.climateSeatDrTemp1_Spinner)
        climateSeatDrTemp1_Spinner.adapter = ArrayAdapter<CharSequence>(
            context,
            R.layout.spinner_text_item,
            resources.getStringArray(R.array.ItemsClimateSeatTemps)
        )

        climateSeatDrTemp1_Spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                val d = preferences?.getFloat(IdNames.climateSeatDrIntTemp1Cfg_key, tempSeatArr[0].toFloat())

                if (d==null || floor(d.toDouble()) != floor(tempSeatArr[position].toDouble())){
                    preferences?.edit()?.putFloat(IdNames.climateSeatDrIntTemp1Cfg_key, floor(tempSeatArr[position].toDouble()).toFloat())?.apply()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        preferences?.getFloat(IdNames.climateSeatDrIntTemp1Cfg_key, tempSeatArr[0].toFloat())?.let { it1 ->
            climateSeatDrTemp1_Spinner?.setSelection(tempSeatArr.indexOf(
                tempSeatArr.firstOrNull { floor(it.toDouble()) == floor(it1.toDouble()) }))
        }

        //Z
        val climateSeatDrOut_Spinner = view.findViewById<Spinner>(R.id.climateSeatDrOut_Spinner)
        climateSeatDrOut_Spinner.adapter = ArrayAdapter<CharSequence>(
            context,
            R.layout.spinner_text_item,
            resources.getStringArray(R.array.ItemsClimateSeatModes)
        )
        climateSeatDrOut_Spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                if (preferences?.getInt(IdNames.climateSeatDrLevelOutCfg_key, 0) != ItemsClimateSeatModes.entries[position].value) {
                    preferences?.edit()?.putInt(IdNames.climateSeatDrLevelOutCfg_key, ItemsClimateSeatModes.entries[position].value)?.apply()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        preferences?.getInt(IdNames.climateSeatDrLevelOutCfg_key, ItemsClimateSeatModes.NOT_USED.value)?.let { it1 ->
            climateSeatDrOut_Spinner?.setSelection(ItemsClimateSeatModes.entries.indexOf(
                ItemsClimateSeatModes.entries.firstOrNull { it.value == it1 }))
        }

        val climateSeatDrTempOut_Spinner = view.findViewById<Spinner>(R.id.climateSeatDrTempOut_Spinner)
        climateSeatDrTempOut_Spinner.adapter = ArrayAdapter<CharSequence>(
            context,
            R.layout.spinner_text_item,
            resources.getStringArray(R.array.ItemsClimateSeatTemps)
        )

        climateSeatDrTempOut_Spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                val d = preferences?.getFloat(IdNames.climateSeatDrOutTempCfg_key, tempSeatArr[0].toFloat())

                if (d==null || floor(d.toDouble()) != floor(tempSeatArr[position].toDouble())){
                    preferences?.edit()?.putFloat(IdNames.climateSeatDrOutTempCfg_key, floor(tempSeatArr[position].toDouble()).toFloat())?.apply()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        preferences?.getFloat(IdNames.climateSeatDrOutTempCfg_key, tempSeatArr[0].toFloat())?.let { it1 ->
            climateSeatDrTempOut_Spinner?.setSelection(tempSeatArr.indexOf(
                tempSeatArr.firstOrNull { floor(it.toDouble()) == floor(it1.toDouble()) }))
        }

        //乘客座椅加热
        // 0
        val climateSeatPass_Spinner = view.findViewById<Spinner>(R.id.climateSeatPass_Spinner)
        climateSeatPass_Spinner.adapter = ArrayAdapter<CharSequence>(
            context,
            R.layout.spinner_text_item,
            resources.getStringArray(R.array.ItemsClimateSeatModes)
        )
        climateSeatPass_Spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                if (preferences?.getInt(IdNames.climateSeatPassLevelCfg_key, 0) != ItemsClimateSeatModes.entries[position].value) {
                    preferences?.edit()?.putInt(IdNames.climateSeatPassLevelCfg_key, ItemsClimateSeatModes.entries[position].value)?.apply()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        preferences?.getInt(IdNames.climateSeatPassLevelCfg_key, ItemsClimateSeatModes.NOT_USED.value)?.let { it1 ->
            climateSeatPass_Spinner?.setSelection(ItemsClimateSeatModes.entries.indexOf(
                ItemsClimateSeatModes.entries.firstOrNull { it.value == it1 }))
        }

        val climateSeatPassTemp_Spinner = view.findViewById<Spinner>(R.id.climateSeatPassTemp_Spinner)
        climateSeatPassTemp_Spinner.adapter = ArrayAdapter<CharSequence>(
            context,
            R.layout.spinner_text_item,
            resources.getStringArray(R.array.ItemsClimateSeatTemps)
        )


        climateSeatPassTemp_Spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                val d = preferences?.getFloat(IdNames.climateSeatPassIntTempCfg_key, tempSeatArr[0].toFloat())

                if (d==null || floor(d.toDouble()) != floor(tempSeatArr[position].toDouble())){
                    preferences?.edit()?.putFloat(IdNames.climateSeatPassIntTempCfg_key, floor(tempSeatArr[position].toDouble()).toFloat())?.apply()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        preferences?.getFloat(IdNames.climateSeatPassIntTempCfg_key, tempSeatArr[0].toFloat())?.let { it1 ->
            climateSeatPassTemp_Spinner?.setSelection(tempSeatArr.indexOf(
                tempSeatArr.firstOrNull { floor(it.toDouble()) == floor(it1.toDouble()) }))
        }

        // 1
        val climateSeatPass1_Spinner = view.findViewById<Spinner>(R.id.climateSeatPass1_Spinner)
        climateSeatPass1_Spinner.adapter = ArrayAdapter<CharSequence>(
            context,
            R.layout.spinner_text_item,
            resources.getStringArray(R.array.ItemsClimateSeatModes)
        )
        climateSeatPass1_Spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                if (preferences?.getInt(IdNames.climateSeatPassLevel1Cfg_key, 0) != ItemsClimateSeatModes.entries[position].value) {
                    preferences?.edit()?.putInt(IdNames.climateSeatPassLevel1Cfg_key, ItemsClimateSeatModes.entries[position].value)?.apply()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        preferences?.getInt(IdNames.climateSeatPassLevel1Cfg_key, ItemsClimateSeatModes.NOT_USED.value)?.let { it1 ->
            climateSeatPass1_Spinner?.setSelection(ItemsClimateSeatModes.entries.indexOf(
                ItemsClimateSeatModes.entries.firstOrNull { it.value == it1 }))
        }

        val climateSeatPassTemp1_Spinner = view.findViewById<Spinner>(R.id.climateSeatPassTemp1_Spinner)
        climateSeatPassTemp1_Spinner.adapter = ArrayAdapter<CharSequence>(
            context,
            R.layout.spinner_text_item,
            resources.getStringArray(R.array.ItemsClimateSeatTemps)
        )

        climateSeatPassTemp1_Spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                val d = preferences?.getFloat(IdNames.climateSeatPassIntTemp1Cfg_key, tempSeatArr[0].toFloat())

                if (d==null || floor(d.toDouble()) != floor(tempSeatArr[position].toDouble())){
                    preferences?.edit()?.putFloat(IdNames.climateSeatPassIntTemp1Cfg_key, floor(tempSeatArr[position].toDouble()).toFloat())?.apply()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        preferences?.getFloat(IdNames.climateSeatPassIntTemp1Cfg_key, tempSeatArr[0].toFloat())?.let { it1 ->
            climateSeatPassTemp1_Spinner?.setSelection(tempSeatArr.indexOf(
                tempSeatArr.firstOrNull { floor(it.toDouble()) == floor(it1.toDouble()) }))
        }

        //Z
        val climateSeatPassOut_Spinner = view.findViewById<Spinner>(R.id.climateSeatPassOut_Spinner)
        climateSeatPassOut_Spinner.adapter = ArrayAdapter<CharSequence>(
            context,
            R.layout.spinner_text_item,
            resources.getStringArray(R.array.ItemsClimateSeatModes)
        )
        climateSeatPassOut_Spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                if (preferences?.getInt(IdNames.climateSeatPassLevelOutCfg_key, 0) != ItemsClimateSeatModes.entries[position].value) {
                    preferences?.edit()?.putInt(IdNames.climateSeatPassLevelOutCfg_key, ItemsClimateSeatModes.entries[position].value)?.apply()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        preferences?.getInt(IdNames.climateSeatPassLevelOutCfg_key, ItemsClimateSeatModes.NOT_USED.value)?.let { it1 ->
            climateSeatPassOut_Spinner?.setSelection(ItemsClimateSeatModes.entries.indexOf(
                ItemsClimateSeatModes.entries.firstOrNull { it.value == it1 }))
        }

        val climateSeatPassTempOut_Spinner = view.findViewById<Spinner>(R.id.climateSeatPassTempOut_Spinner)
        climateSeatPassTempOut_Spinner.adapter = ArrayAdapter<CharSequence>(
            context,
            R.layout.spinner_text_item,
            resources.getStringArray(R.array.ItemsClimateSeatTemps)
        )

        climateSeatPassTempOut_Spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                val d = preferences?.getFloat(IdNames.climateSeatPassOutTempCfg_key, tempSeatArr[0].toFloat())

                if (d==null || floor(d.toDouble()) != floor(tempSeatArr[position].toDouble())){
                    preferences?.edit()?.putFloat(IdNames.climateSeatPassOutTempCfg_key, floor(tempSeatArr[position].toDouble()).toFloat())?.apply()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        preferences?.getFloat(IdNames.climateSeatPassOutTempCfg_key, tempSeatArr[0].toFloat())?.let { it1 ->
            climateSeatPassTempOut_Spinner?.setSelection(tempSeatArr.indexOf(
                tempSeatArr.firstOrNull { floor(it.toDouble()) == floor(it1.toDouble()) }))
        }

        //方向盘加热
        // 0
        val climateWheel_Spinner = view.findViewById<Spinner>(R.id.climateWheel_Spinner)
        climateWheel_Spinner.adapter = ArrayAdapter<CharSequence>(
            context,
            R.layout.spinner_text_item,
            resources.getStringArray(R.array.ItemsClimateWheelModes)
        )
        climateWheel_Spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                if (preferences?.getInt(IdNames.climateWheelLevelCfg_key, 0) != ItemsClimateWheelModes.entries[position].value) {
                    preferences?.edit()?.putInt(IdNames.climateWheelLevelCfg_key, ItemsClimateWheelModes.entries[position].value)?.apply()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        preferences?.getInt(IdNames.climateWheelLevelCfg_key, ItemsClimateWheelModes.NOT_USED.value)?.let { it1 ->
            climateWheel_Spinner?.setSelection(ItemsClimateWheelModes.entries.indexOf(
                ItemsClimateWheelModes.entries.firstOrNull { it.value == it1 }))
        }

        val climateWheelTemp_Spinner = view.findViewById<Spinner>(R.id.climateWheelTemp_Spinner)
        climateWheelTemp_Spinner.adapter = ArrayAdapter<CharSequence>(
            context,
            R.layout.spinner_text_item,
            resources.getStringArray(R.array.ItemsClimateWheelTemps)
        )
        val tempWheelArr = resources.getStringArray(R.array.ItemsClimateWheelTemps)
        climateWheelTemp_Spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                val d = preferences?.getFloat(IdNames.climateWheelIntTempCfg_key, tempWheelArr[0].toFloat())

                if (d==null || floor(d.toDouble()) != floor(tempWheelArr[position].toDouble())){
                    preferences?.edit()?.putFloat(IdNames.climateWheelIntTempCfg_key, floor(tempWheelArr[position].toDouble()).toFloat())?.apply()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        preferences?.getFloat(IdNames.climateWheelIntTempCfg_key, tempWheelArr[0].toFloat())?.let { it1 ->
            climateWheelTemp_Spinner?.setSelection(tempWheelArr.indexOf(
                tempWheelArr.firstOrNull { floor(it.toDouble()) == floor(it1.toDouble()) }))
        }

        // 1
        val climateWheel1_Spinner = view.findViewById<Spinner>(R.id.climateWheel1_Spinner)
        climateWheel1_Spinner.adapter = ArrayAdapter<CharSequence>(
            context,
            R.layout.spinner_text_item,
            resources.getStringArray(R.array.ItemsClimateWheelModes)
        )
        climateWheel1_Spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                if (preferences?.getInt(IdNames.climateWheelLevel1Cfg_key, 0) != ItemsClimateWheelModes.entries[position].value) {
                    preferences?.edit()?.putInt(IdNames.climateWheelLevel1Cfg_key, ItemsClimateWheelModes.entries[position].value)?.apply()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        preferences?.getInt(IdNames.climateWheelLevel1Cfg_key, ItemsClimateWheelModes.NOT_USED.value)?.let { it1 ->
            climateWheel1_Spinner?.setSelection(ItemsClimateWheelModes.entries.indexOf(
                ItemsClimateWheelModes.entries.firstOrNull { it.value == it1 }))
        }

        val climateWheelTemp1_Spinner = view.findViewById<Spinner>(R.id.climateWheelTemp1_Spinner)
        climateWheelTemp1_Spinner.adapter = ArrayAdapter<CharSequence>(
            context,
            R.layout.spinner_text_item,
            resources.getStringArray(R.array.ItemsClimateWheelTemps)
        )

        climateWheelTemp1_Spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                val d = preferences?.getFloat(IdNames.climateWheelIntTemp1Cfg_key, tempWheelArr[0].toFloat())

                if (d==null || floor(d.toDouble()) != floor(tempWheelArr[position].toDouble())){
                    preferences?.edit()?.putFloat(IdNames.climateWheelIntTemp1Cfg_key, floor(tempWheelArr[position].toDouble()).toFloat())?.apply()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        preferences?.getFloat(IdNames.climateWheelIntTemp1Cfg_key, tempWheelArr[0].toFloat())?.let { it1 ->
            climateWheelTemp1_Spinner?.setSelection(tempWheelArr.indexOf(
                tempWheelArr.firstOrNull { floor(it.toDouble()) == floor(it1.toDouble()) }))
        }

        //Z
        val climateWheelOut_Spinner = view.findViewById<Spinner>(R.id.climateWheelOut_Spinner)
        climateWheelOut_Spinner.adapter = ArrayAdapter<CharSequence>(
            context,
            R.layout.spinner_text_item,
            resources.getStringArray(R.array.ItemsClimateWheelModes)
        )
        climateWheelOut_Spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                if (preferences?.getInt(IdNames.climateWheelLevelOutCfg_key, 0) != ItemsClimateWheelModes.entries[position].value) {
                    preferences?.edit()?.putInt(IdNames.climateWheelLevelOutCfg_key, ItemsClimateWheelModes.entries[position].value)?.apply()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        preferences?.getInt(IdNames.climateWheelLevelOutCfg_key, ItemsClimateWheelModes.NOT_USED.value)?.let { it1 ->
            climateWheelOut_Spinner?.setSelection(ItemsClimateWheelModes.entries.indexOf(
                ItemsClimateWheelModes.entries.firstOrNull { it.value == it1 }))
        }

        val climateWheelTempOut_Spinner = view.findViewById<Spinner>(R.id.climateWheelTempOut_Spinner)
        climateWheelTempOut_Spinner.adapter = ArrayAdapter<CharSequence>(
            context,
            R.layout.spinner_text_item,
            resources.getStringArray(R.array.ItemsClimateWheelTemps)
        )
        climateWheelTempOut_Spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                val d = preferences?.getFloat(IdNames.climateWheelOutTempCfg_key, tempWheelArr[0].toFloat())

                if (d==null || floor(d.toDouble()) != floor(tempWheelArr[position].toDouble())){
                    preferences?.edit()?.putFloat(IdNames.climateWheelOutTempCfg_key, floor(tempWheelArr[position].toDouble()).toFloat())?.apply()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        preferences?.getFloat(IdNames.climateWheelOutTempCfg_key, tempWheelArr[0].toFloat())?.let { it1 ->
            climateWheelTempOut_Spinner?.setSelection(tempWheelArr.indexOf(
                tempWheelArr.firstOrNull { floor(it.toDouble()) == floor(it1.toDouble()) }))
        }

        //驾驶员座椅通风
        // 0
        val climateVentDr_Spinner = view.findViewById<Spinner>(R.id.climateVentDr_Spinner)
        climateVentDr_Spinner.adapter = ArrayAdapter<CharSequence>(
            context,
            R.layout.spinner_text_item,
            resources.getStringArray(R.array.ItemsClimateVentModes)
        )
        climateVentDr_Spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                if (preferences?.getInt(IdNames.climateVentDrLevelCfg_key, 0) != ItemsClimateVentModes.entries[position].value) {
                    preferences?.edit()?.putInt(IdNames.climateVentDrLevelCfg_key, ItemsClimateVentModes.entries[position].value)?.apply()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        preferences?.getInt(IdNames.climateVentDrLevelCfg_key, ItemsClimateVentModes.NOT_USED.value)?.let { it1 ->
            climateVentDr_Spinner?.setSelection(ItemsClimateVentModes.entries.indexOf(
                ItemsClimateVentModes.entries.firstOrNull { it.value == it1 }))
        }

        val climateVentDrTemp_Spinner = view.findViewById<Spinner>(R.id.climateVentDrTemp_Spinner)
        climateVentDrTemp_Spinner.adapter = ArrayAdapter<CharSequence>(
            context,
            R.layout.spinner_text_item,
            resources.getStringArray(R.array.ItemsClimateVentTemps)
        )
        val tempVentArr = resources.getStringArray(R.array.ItemsClimateVentTemps)
        climateVentDrTemp_Spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                val d = preferences?.getFloat(IdNames.climateVentDrIntTempCfg_key, tempVentArr[tempVentArr.size-1].toFloat())

                if (d==null || floor(d.toDouble()) != floor(tempVentArr[position].toDouble())){
                    preferences?.edit()?.putFloat(IdNames.climateVentDrIntTempCfg_key, floor(tempVentArr[position].toDouble()).toFloat())?.apply()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        preferences?.getFloat(IdNames.climateVentDrIntTempCfg_key, tempVentArr[0].toFloat())?.let { it1 ->
            climateVentDrTemp_Spinner?.setSelection(tempVentArr.indexOf(
                tempVentArr.firstOrNull { floor(it.toDouble()) == floor(it1.toDouble()) }))
        }

        // 1
        val climateVentDr1_Spinner = view.findViewById<Spinner>(R.id.climateVentDr1_Spinner)
        climateVentDr1_Spinner.adapter = ArrayAdapter<CharSequence>(
            context,
            R.layout.spinner_text_item,
            resources.getStringArray(R.array.ItemsClimateVentModes)
        )
        climateVentDr1_Spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                if (preferences?.getInt(IdNames.climateVentDrLevel1Cfg_key, 0) != ItemsClimateVentModes.entries[position].value) {
                    preferences?.edit()?.putInt(IdNames.climateVentDrLevel1Cfg_key, ItemsClimateVentModes.entries[position].value)?.apply()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        preferences?.getInt(IdNames.climateVentDrLevel1Cfg_key, ItemsClimateVentModes.NOT_USED.value)?.let { it1 ->
            climateVentDr1_Spinner?.setSelection(ItemsClimateVentModes.entries.indexOf(
                ItemsClimateVentModes.entries.firstOrNull { it.value == it1 }))
        }

        val climateVentDrTemp1_Spinner = view.findViewById<Spinner>(R.id.climateVentDrTemp1_Spinner)
        climateVentDrTemp1_Spinner.adapter = ArrayAdapter<CharSequence>(
            context,
            R.layout.spinner_text_item,
            resources.getStringArray(R.array.ItemsClimateVentTemps)
        )

        climateVentDrTemp1_Spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                val d = preferences?.getFloat(IdNames.climateVentDrIntTemp1Cfg_key, tempVentArr[tempVentArr.size-1].toFloat())

                if (d==null || floor(d.toDouble()) != floor(tempVentArr[position].toDouble())){
                    preferences?.edit()?.putFloat(IdNames.climateVentDrIntTemp1Cfg_key, floor(tempVentArr[position].toDouble()).toFloat())?.apply()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        preferences?.getFloat(IdNames.climateVentDrIntTemp1Cfg_key, tempVentArr[0].toFloat())?.let { it1 ->
            climateVentDrTemp1_Spinner?.setSelection(tempVentArr.indexOf(
                tempVentArr.firstOrNull { floor(it.toDouble()) == floor(it1.toDouble()) }))
        }

        val climateVentDrTempOut_Spinner = view.findViewById<Spinner>(R.id.climateVentDrTempOut_Spinner)
        climateVentDrTempOut_Spinner.adapter = ArrayAdapter<CharSequence>(
            context,
            R.layout.spinner_text_item,
            resources.getStringArray(R.array.ItemsClimateVentTempsOut)
        )

        val tempOutVentArr = resources.getStringArray(R.array.ItemsClimateVentTempsOut)

        climateVentDrTempOut_Spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                val d = preferences?.getFloat(IdNames.climateVentDrOutTempCfg_key, tempOutVentArr[tempOutVentArr.size-1].toFloat())

                if (d==null || floor(d.toDouble()) != floor(tempOutVentArr[position].toDouble())){
                    preferences?.edit()?.putFloat(IdNames.climateVentDrOutTempCfg_key, floor(tempOutVentArr[position].toDouble()).toFloat())?.apply()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        preferences?.getFloat(IdNames.climateVentDrOutTempCfg_key, tempOutVentArr[0].toFloat())?.let { it1 ->
            climateVentDrTempOut_Spinner?.setSelection(tempOutVentArr.indexOf(
                tempOutVentArr.firstOrNull { floor(it.toDouble()) == floor(it1.toDouble()) }))
        }

        val climateVentDrCorrection_Switch = view.findViewById<SwitchMaterial>(R.id.climateVentDrCorrection_Switch)
        climateVentDrCorrection_Switch?.setOnCheckedChangeListener { _, isChecked ->
            if (preferences?.getBoolean(IdNames.climateVentDrCorrectionCfg_key, false) != isChecked) {
                preferences?.edit()?.putBoolean(IdNames.climateVentDrCorrectionCfg_key, isChecked)?.apply()
            }
        }
        preferences?.getBoolean(IdNames.climateVentDrCorrectionCfg_key, true)?.let {
            climateVentDrCorrection_Switch?.isChecked = it
        }

        //乘客座椅通风
        // 0
        val climateVentPass_Spinner = view.findViewById<Spinner>(R.id.climateVentPass_Spinner)
        climateVentPass_Spinner.adapter = ArrayAdapter<CharSequence>(
            context,
            R.layout.spinner_text_item,
            resources.getStringArray(R.array.ItemsClimateVentModes)
        )
        climateVentPass_Spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                if (preferences?.getInt(IdNames.climateVentPassLevelCfg_key, 0) != ItemsClimateVentModes.entries[position].value) {
                    preferences?.edit()?.putInt(IdNames.climateVentPassLevelCfg_key, ItemsClimateVentModes.entries[position].value)?.apply()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        preferences?.getInt(IdNames.climateVentPassLevelCfg_key, ItemsClimateVentModes.NOT_USED.value)?.let { it1 ->
            climateVentPass_Spinner?.setSelection(ItemsClimateVentModes.entries.indexOf(
                ItemsClimateVentModes.entries.firstOrNull { it.value == it1 }))
        }

        val climateVentPassTemp_Spinner = view.findViewById<Spinner>(R.id.climateVentPassTemp_Spinner)
        climateVentPassTemp_Spinner.adapter = ArrayAdapter<CharSequence>(
            context,
            R.layout.spinner_text_item,
            resources.getStringArray(R.array.ItemsClimateVentTemps)
        )


        climateVentPassTemp_Spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                val d = preferences?.getFloat(IdNames.climateVentPassIntTempCfg_key, tempVentArr[tempVentArr.size-1].toFloat())

                if (d==null || floor(d.toDouble()) != floor(tempVentArr[position].toDouble())){
                    preferences?.edit()?.putFloat(IdNames.climateVentPassIntTempCfg_key, floor(tempVentArr[position].toDouble()).toFloat())?.apply()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        preferences?.getFloat(IdNames.climateVentPassIntTempCfg_key, tempVentArr[0].toFloat())?.let { it1 ->
            climateVentPassTemp_Spinner?.setSelection(tempVentArr.indexOf(
                tempVentArr.firstOrNull { floor(it.toDouble()) == floor(it1.toDouble()) }))
        }

        // 1
        val climateVentPass1_Spinner = view.findViewById<Spinner>(R.id.climateVentPass1_Spinner)
        climateVentPass1_Spinner.adapter = ArrayAdapter<CharSequence>(
            context,
            R.layout.spinner_text_item,
            resources.getStringArray(R.array.ItemsClimateVentModes)
        )
        climateVentPass1_Spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                if (preferences?.getInt(IdNames.climateVentPassLevel1Cfg_key, 0) != ItemsClimateVentModes.entries[position].value) {
                    preferences?.edit()?.putInt(IdNames.climateVentPassLevel1Cfg_key, ItemsClimateVentModes.entries[position].value)?.apply()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        preferences?.getInt(IdNames.climateVentPassLevel1Cfg_key, ItemsClimateVentModes.NOT_USED.value)?.let { it1 ->
            climateVentPass1_Spinner?.setSelection(ItemsClimateVentModes.entries.indexOf(
                ItemsClimateVentModes.entries.firstOrNull { it.value == it1 }))
        }

        val climateVentPassTemp1_Spinner = view.findViewById<Spinner>(R.id.climateVentPassTemp1_Spinner)
        climateVentPassTemp1_Spinner.adapter = ArrayAdapter<CharSequence>(
            context,
            R.layout.spinner_text_item,
            resources.getStringArray(R.array.ItemsClimateVentTemps)
        )

        climateVentPassTemp1_Spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                val d = preferences?.getFloat(IdNames.climateVentPassIntTemp1Cfg_key, tempVentArr[tempVentArr.size-1].toFloat())

                if (d==null || floor(d.toDouble()) != floor(tempVentArr[position].toDouble())){
                    preferences?.edit()?.putFloat(IdNames.climateVentPassIntTemp1Cfg_key, floor(tempVentArr[position].toDouble()).toFloat())?.apply()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        preferences?.getFloat(IdNames.climateVentPassIntTemp1Cfg_key, tempVentArr[0].toFloat())?.let { it1 ->
            climateVentPassTemp1_Spinner?.setSelection(tempVentArr.indexOf(
                tempVentArr.firstOrNull { floor(it.toDouble()) == floor(it1.toDouble()) }))
        }


        val climateVentPassTempOut_Spinner = view.findViewById<Spinner>(R.id.climateVentPassTempOut_Spinner)
        climateVentPassTempOut_Spinner.adapter = ArrayAdapter<CharSequence>(
            context,
            R.layout.spinner_text_item,
            resources.getStringArray(R.array.ItemsClimateVentTempsOut)
        )

        climateVentPassTempOut_Spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                val d = preferences?.getFloat(IdNames.climateVentPassOutTempCfg_key, tempOutVentArr[tempOutVentArr.size-1].toFloat())

                if (d==null || floor(d.toDouble()) != floor(tempOutVentArr[position].toDouble())){
                    preferences?.edit()?.putFloat(IdNames.climateVentPassOutTempCfg_key, floor(tempOutVentArr[position].toDouble()).toFloat())?.apply()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        preferences?.getFloat(IdNames.climateVentPassOutTempCfg_key, tempOutVentArr[0].toFloat())?.let { it1 ->
            climateVentPassTempOut_Spinner?.setSelection(tempOutVentArr.indexOf(
                tempOutVentArr.firstOrNull { floor(it.toDouble()) == floor(it1.toDouble()) }))
        }

        val climateVentPassCorrection_Switch = view.findViewById<SwitchMaterial>(R.id.climateVentPassCorrection_Switch)
        climateVentPassCorrection_Switch?.setOnCheckedChangeListener { _, isChecked ->
            if (preferences?.getBoolean(IdNames.climateVentPassCorrectionCfg_key, false) != isChecked) {
                preferences?.edit()?.putBoolean(IdNames.climateVentPassCorrectionCfg_key, isChecked)?.apply()
            }
        }
        preferences?.getBoolean(IdNames.climateVentPassCorrectionCfg_key, true)?.let {
            climateVentPassCorrection_Switch?.isChecked = it
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