package ru.monjaro.mconfig

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.OnSharedPreferenceChangeListener
import android.os.Handler
import android.os.HandlerThread
import android.os.Looper
import android.os.Message
import android.os.SystemClock
import androidx.preference.PreferenceManager
import com.ecarx.xui.adaptapi.FunctionStatus
import com.ecarx.xui.adaptapi.car.Car
import com.ecarx.xui.adaptapi.car.base.ICarFunction
import com.ecarx.xui.adaptapi.car.hvac.IHvac.AUTO_FAN_SETTING_NORMAL
import com.ecarx.xui.adaptapi.car.hvac.IHvac.AUTO_FAN_SETTING_QUIETER
import com.ecarx.xui.adaptapi.car.hvac.IHvac.FAN_SPEED_OFF
import com.ecarx.xui.adaptapi.car.hvac.IHvac.HVAC_FUNC_AC
import com.ecarx.xui.adaptapi.car.hvac.IHvac.HVAC_FUNC_AUTO
import com.ecarx.xui.adaptapi.car.hvac.IHvac.HVAC_FUNC_AUTO_FAN_SETTING
import com.ecarx.xui.adaptapi.car.hvac.IHvac.HVAC_FUNC_BLOWING_MODE
import com.ecarx.xui.adaptapi.car.hvac.IHvac.HVAC_FUNC_DEFROST_FRONT
import com.ecarx.xui.adaptapi.car.hvac.IHvac.HVAC_FUNC_DEFROST_REAR
import com.ecarx.xui.adaptapi.car.hvac.IHvac.HVAC_FUNC_FAN_SPEED
import com.ecarx.xui.adaptapi.car.hvac.IHvac.HVAC_FUNC_G_CLEAN
import com.ecarx.xui.adaptapi.car.hvac.IHvac.HVAC_FUNC_SEAT_HEATING
import com.ecarx.xui.adaptapi.car.hvac.IHvac.HVAC_FUNC_SEAT_VENTILATION
import com.ecarx.xui.adaptapi.car.hvac.IHvac.HVAC_FUNC_STEERING_WHEEL_HEAT
import com.ecarx.xui.adaptapi.car.hvac.IHvac.SEAT_HEATING_OFF
import com.ecarx.xui.adaptapi.car.hvac.IHvac.SEAT_VENTILATION_OFF
import com.ecarx.xui.adaptapi.car.hvac.IHvac.STEERING_WHEEL_HEAT_OFF
import com.ecarx.xui.adaptapi.car.sensor.ISensor
import com.ecarx.xui.adaptapi.car.sensor.ISensor.ISensorListener
import com.ecarx.xui.adaptapi.car.sensor.ISensor.SENSOR_TYPE_CAR_SPEED
import com.ecarx.xui.adaptapi.car.sensor.ISensor.SENSOR_TYPE_DAY_NIGHT
import com.ecarx.xui.adaptapi.car.sensor.ISensor.SENSOR_TYPE_ENGINE_OIL_LEVEL
import com.ecarx.xui.adaptapi.car.sensor.ISensor.SENSOR_TYPE_FUEL_LEVEL
import com.ecarx.xui.adaptapi.car.sensor.ISensor.SENSOR_TYPE_GEAR
import com.ecarx.xui.adaptapi.car.sensor.ISensor.SENSOR_TYPE_IGNITION_STATE
import com.ecarx.xui.adaptapi.car.sensor.ISensor.SENSOR_TYPE_RPM
import com.ecarx.xui.adaptapi.car.sensor.ISensor.SENSOR_TYPE_SEAT_OCCUPATION_STATUS_PASSENGER
import com.ecarx.xui.adaptapi.car.sensor.ISensor.SENSOR_TYPE_TEMPERATURE_AMBIENT
import com.ecarx.xui.adaptapi.car.sensor.ISensor.SENSOR_TYPE_TEMPERATURE_INDOOR
import com.ecarx.xui.adaptapi.car.sensor.ISensorEvent.DAY_NIGHT_MODE_NIGHT
import com.ecarx.xui.adaptapi.car.sensor.ISensorEvent.ENGINE_OIL_LEVEL_HIGH
import com.ecarx.xui.adaptapi.car.sensor.ISensorEvent.ENGINE_OIL_LEVEL_LOW_1
import com.ecarx.xui.adaptapi.car.sensor.ISensorEvent.ENGINE_OIL_LEVEL_LOW_2
import com.ecarx.xui.adaptapi.car.sensor.ISensorEvent.ENGINE_OIL_LEVEL_OK
import com.ecarx.xui.adaptapi.car.sensor.ISensorEvent.ENGINE_OIL_LEVEL_UNKNOWN
import com.ecarx.xui.adaptapi.car.sensor.ISensorEvent.GEAR_DRIVE
import com.ecarx.xui.adaptapi.car.sensor.ISensorEvent.GEAR_EIGHTH
import com.ecarx.xui.adaptapi.car.sensor.ISensorEvent.GEAR_FIFTH
import com.ecarx.xui.adaptapi.car.sensor.ISensorEvent.GEAR_FIRST
import com.ecarx.xui.adaptapi.car.sensor.ISensorEvent.GEAR_FOURTH
import com.ecarx.xui.adaptapi.car.sensor.ISensorEvent.GEAR_NEUTRAL
import com.ecarx.xui.adaptapi.car.sensor.ISensorEvent.GEAR_NINTH
import com.ecarx.xui.adaptapi.car.sensor.ISensorEvent.GEAR_PARK
import com.ecarx.xui.adaptapi.car.sensor.ISensorEvent.GEAR_REVERSE
import com.ecarx.xui.adaptapi.car.sensor.ISensorEvent.GEAR_SECOND
import com.ecarx.xui.adaptapi.car.sensor.ISensorEvent.GEAR_SEVENTH
import com.ecarx.xui.adaptapi.car.sensor.ISensorEvent.GEAR_SIXTH
import com.ecarx.xui.adaptapi.car.sensor.ISensorEvent.GEAR_TENTH
import com.ecarx.xui.adaptapi.car.sensor.ISensorEvent.GEAR_THIRD
import com.ecarx.xui.adaptapi.car.sensor.ISensorEvent.GEAR_UNKNOWN
import com.ecarx.xui.adaptapi.car.sensor.ISensorEvent.IGNITION_STATE_ACC
import com.ecarx.xui.adaptapi.car.sensor.ISensorEvent.IGNITION_STATE_DRIVING
import com.ecarx.xui.adaptapi.car.sensor.ISensorEvent.IGNITION_STATE_LOCK
import com.ecarx.xui.adaptapi.car.sensor.ISensorEvent.IGNITION_STATE_OFF
import com.ecarx.xui.adaptapi.car.sensor.ISensorEvent.IGNITION_STATE_ON
import com.ecarx.xui.adaptapi.car.sensor.ISensorEvent.IGNITION_STATE_START
import com.ecarx.xui.adaptapi.car.sensor.ISensorEvent.SEAT_OCCUPATION_STATUS_FAULT
import com.ecarx.xui.adaptapi.car.sensor.ISensorEvent.SEAT_OCCUPATION_STATUS_NONE
import com.ecarx.xui.adaptapi.car.sensor.ISensorEvent.SEAT_OCCUPATION_STATUS_OCCUPIED
import com.ecarx.xui.adaptapi.car.vehicle.IBcm.BCM_FUNC_DOOR
import com.ecarx.xui.adaptapi.car.vehicle.IBcm.BCM_FUNC_WINDOW_POS
import com.ecarx.xui.adaptapi.car.vehicle.IDayMode.SETTING_FUNC_BRIGHTNESS_DAYMODE

import com.ecarx.xui.adaptapi.car.vehicle.IDriveMode.DM_FUNC_DRIVE_MODE_SELECT
import com.ecarx.xui.adaptapi.car.vehicle.IDriveMode.DRIVE_MODE_SELECTION_COMFORT
import com.ecarx.xui.adaptapi.car.vehicle.IDriveMode.DRIVE_MODE_SELECTION_DYNAMIC
import com.ecarx.xui.adaptapi.car.vehicle.IDriveMode.DRIVE_MODE_SELECTION_OFFROAD
import com.ecarx.xui.adaptapi.car.vehicle.IDriveMode.DRIVE_MODE_SELECTION_SNOW

import com.ecarx.xui.adaptapi.car.vehicle.IPAS
import com.ecarx.xui.adaptapi.car.vehicle.IVehicle.DAYMODE_SETTING_AUTO

import com.ecarx.xui.adaptapi.car.vehicle.IVehicle.DAYMODE_SETTING_NIGHT
import com.ecarx.xui.adaptapi.car.vehicle.IVehicle.SETTING_FUNC_AUTO_HOLD

import com.ecarx.xui.adaptapi.car.vehicle.IVehicle.SETTING_FUNC_BRIGHTNESS_NIGHT
import com.ecarx.xui.adaptapi.car.vehicle.IVehicle.SETTING_FUNC_EMGY_LANE_KEEP_AID
import com.ecarx.xui.adaptapi.car.vehicle.IVehicle.SETTING_FUNC_ENGINE_STOP_START
import com.ecarx.xui.adaptapi.car.vehicle.IVehicle.SETTING_FUNC_PSD_SCREEN_SWITCH

import com.ecarx.xui.adaptapi.vehicle.VehicleSeat.SEAT_ROW_1_LEFT
import com.ecarx.xui.adaptapi.vehicle.VehicleSeat.SEAT_ROW_1_RIGHT
import com.ecarx.xui.adaptapi.car.vehicle.IVehicle.SETTING_FUNC_INTELLIGENT_FUEL_SAVE

import com.ecarx.xui.adaptapi.car.vehicle.IVehicle.SETTING_FUNC_WINDSCREEN_SERVICE_POSITION

import java.util.concurrent.atomic.AtomicBoolean

class MConfigManager(applicationContext: Context, handler: Handler?) {

    private var threadWithRunnable: Thread? = null
    private var needToStop: AtomicBoolean = AtomicBoolean(false)
    private var needToUpdateData: AtomicBoolean = AtomicBoolean(true)
    var context = applicationContext
    private var handlerFromThread = handler
    private val lockObject = Object()

    companion object {

        var handleToThread : Handler? = null
        fun sendMessageToThread(what:Int, s:String){
            if(handleToThread != null) {
                val msg: Message = handleToThread!!.obtainMessage()
                msg.what = what
                msg.obj = s
                handleToThread!!.sendMessage(msg)
            }
        }
    }


    init{
        threadWithRunnable = Thread(MConfigThread())
        threadWithRunnable!!.start()
    }

    fun destroy() {
        if(threadWithRunnable != null){
            needToStop.set(true)
            threadWithRunnable!!.join()
            threadWithRunnable = null
        }
        needToStop.set(false)

    }

    inner class MConfigThread: Runnable {
        private var changesPreferences: ChangesPreferences? = null
        private var preferences: SharedPreferences?=null

        private var iCarFunction: ICarFunction? = null
        private var iCarSensors: ISensor? = null
        private var iSensorListener: ISensorListener? = null
        private var iFunctionValueWatcher: ICarFunction.IFunctionValueWatcher? = null

        private var ignitionStateValue:Int = -1


        private var gearValue:Int = -1
        private var gearReversePreValue:Int = -1
        private var pasFuncPacActivationValue:Int = -1
        private var rpmValue:Int = 0
        private var speedValueInt:Int = 0
        private var rpmValueNotZerro:Int = 0
        private var rpmValueTimestamp = System.currentTimeMillis()
        private var startstopFuncValue:Int = -1
        private var autoholdFuncValue:Int = -1
        private var autoholdFuncTimestamp = System.currentTimeMillis()
        private var driveModeValue:Int = -1
        private var driveModeTimestamp = System.currentTimeMillis()
        private var driveModeByKeySet:Int = -1

        private var passDisplayValue:Int = -1

        private var elkaValue:Int = 0
        private var elkaSetCounts:Int = 0

        //preferences config
        private var startstopFuncCfg:Int = ItemsOnOffPlus.NOT_USED.value
        private var autoholdFuncCfg:Int = ItemsOnOffPlus.NOT_USED.value
        private var driveModeRestoreCfg:Boolean = false
        private var brightnessReverseCfg:Boolean = false
        private var driveModeCfg:Int = DRIVE_MODE_SELECTION_COMFORT
        private var climateOffBlockFlag:AtomicBoolean = AtomicBoolean(true)

        private var climateSeatHeatDrBlockFlag:AtomicBoolean = AtomicBoolean(false)
        private var climateSeatHeatPassBlockFlag:AtomicBoolean = AtomicBoolean(false)
        private var climateWheelHeatPassBlockFlag:AtomicBoolean = AtomicBoolean(false)
        private var climateSeatVentDrBlockFlag:AtomicBoolean = AtomicBoolean(false)
        private var climateSeatVentPassBlockFlag:AtomicBoolean = AtomicBoolean(false)

        private var elkaDisableCfg:Boolean = false

        private var gearReverseSpeedCfg:Int = 0
        private var gearReverseTimeCfg:Int = 0

        private var passDisplayOffCfg:Boolean = false
        private var passDisplayOffNoPassCfg:Boolean = false
        private var passDisplayOnOffFlag:Int = 0
        private var passSeatOccupationForDisplay:Int = -1

        private var climateGCleanCfg:Boolean = false
        private var climateStartCfg:Int = -1
        private var climateStartAutoCfg:Boolean = false
        private var climateStartACCfg:Int = -1
        private var climateStartSpeedCfg:Int = -1
        private var climateStart_Mode_Cfg:Int = -1
        private var climateStartAuto128Cfg:Boolean = false
        private var climateStart_Mode128_Cfg:Int = -1

        private var climateIntTemperature: Double = -100.0
        private var climateIntTemperatureArr: Array<Int> = Array<Int>(15){0}
        private var climateIntTemperatureIdx:Int = 0
        private var climateIntTemperaturePresent: AtomicBoolean = AtomicBoolean(false)

        private var climateOutTemperature: Double = -100.0
        private var climateOutTemperatureArr: Array<Int> = Array<Int>(15){0}
        private var climateOutTemperatureIdx:Int = 0
        private var climateOutTemperaturePresent: AtomicBoolean = AtomicBoolean(false)


        private var climateDefrozeTempCfg:Double = -100.0
        private var climateDefrozePeriodTempCfg:Double = -100.0
        private var climateDefrozePeriodCfg:Int = -1
        private var climateDefrozeTimestamp = System.currentTimeMillis()

        private var climateDefrozeRearTempCfg:Double = -100.0

        private var climateSeatDrIntTempCfg:Double = -100.0
        private var climateSeatDrLevelCfg:Int = -1
        private var climateSeatDrIntTemp1Cfg:Double = -100.0
        private var climateSeatDrLevel1Cfg:Int = -1
        private var climateSeatDrOutTempCfg:Double = -100.0
        private var climateSeatDrLevelOutCfg:Int = -1

        private var climateSeatPassIntTempCfg:Double = -100.0
        private var climateSeatPassLevelCfg:Int = -1
        private var climateSeatPassIntTemp1Cfg:Double = -100.0
        private var climateSeatPassLevel1Cfg:Int = -1
        private var climateSeatPassOutTempCfg:Double = -100.0
        private var climateSeatPassLevelOutCfg:Int = -1

        private var climateWheelIntTempCfg:Double = -100.0
        private var climateWheelLevelCfg:Int = -1
        private var climateWheelIntTemp1Cfg:Double = -100.0
        private var climateWheelLevel1Cfg:Int = -1
        private var climateWheelOutTempCfg:Double = -100.0
        private var climateWheelLevelOutCfg:Int = -1

        private var climateVentDrIntTempCfg:Double = -100.0
        private var climateVentDrLevelCfg:Int = -1
        private var climateVentDrIntTemp1Cfg:Double = -100.0
        private var climateVentDrLevel1Cfg:Int = -1
        private var climateVentDrOutTempCfg:Double = -100.0
        private var climateVentDrCorrectionCfg:Boolean = false

        private var climateVentPassIntTempCfg:Double = -100.0
        private var climateVentPassLevelCfg:Int = -1
        private var climateVentPassIntTemp1Cfg:Double = -100.0
        private var climateVentPassLevel1Cfg:Int = -1
        private var climateVentPassOutTempCfg:Double = -100.0
        private var climateVentPassCorrectionCfg:Boolean = false

        private var driveModeListenerFlag:AtomicBoolean = AtomicBoolean(false)

        private var passSeatOccupationCurrent:Int = -1
        private var passSeatOccupationChanged:AtomicBoolean = AtomicBoolean(false)
        private var passSeatOccupationTimestamp = System.currentTimeMillis()

        private var windowScreenServicePosCfg:Boolean = false
        private var handlerWindowScreenServicePos: Handler? = null
        private var handlerIgnitionDriverDelay: Handler? = null

        private var panoramaCurtainStartCfg:Boolean = false
        private var intelligentFuelSaveStartCfg:Boolean = false

        private var ht:HandlerThread? = null

        @Synchronized fun sendMessageToUI(what:Int, s:String){
            if (handlerFromThread != null) {
                val msg: Message = handlerFromThread!!.obtainMessage()
                msg.what = what
                msg.obj = s
                handlerFromThread!!.sendMessage(msg)
            }
        }

        private fun initICarFunction():Int {
            var ret = -1
            try {
                try {
                    iCarFunction = Car.create(context).iCarFunction
                    ret = 0
                } catch (_: Exception) {}
            } catch (_: Error) {}
            return ret
        }

        private fun initICarSensors():Int {
            var ret = -1
            try {
                try {
                    iCarSensors = Car.create(context).sensorManager
                    ret = 0
                } catch (_: Exception) { }
            } catch (_: Error) {}
            return ret
        }

        private fun isICarFunctionAvailable(i: Int): Boolean {
            return if (this.iCarFunction != null) {
                try {
                    val isFunctionSupported: FunctionStatus = this.iCarFunction!!.isFunctionSupported(i)
                    var z = false
                    if(isFunctionSupported == FunctionStatus.active){
                        z = true
                    }
                    z
                } catch (_: Exception) {
                    false
                }
            } else false
        }
        private fun isICarFunctionAvailable(i: Int, i1: Int): Boolean {
            return if (this.iCarFunction != null) {
                try {
                    val isFunctionSupported: FunctionStatus = this.iCarFunction!!.isFunctionSupported(i, i1)
                    var z = false
                    if(isFunctionSupported == FunctionStatus.active){
                        z = true
                    }
                    z
                } catch (_: Exception) {
                    false
                }
            } else false
        }

        private fun isICarSensorAvailable(i: Int): Boolean {
            return if (this.iCarSensors != null) {
                try {
                    val isSensorSupported: FunctionStatus = iCarSensors!!.isSensorSupported(i)
                    var z = false
                    if(isSensorSupported != FunctionStatus.notavailable && isSensorSupported != FunctionStatus.error){
                        z = true
                    }
                    z
                } catch (_: Exception) {
                    false
                }
            } else false
        }

        private fun getSensorEvent(v: Int): Int {
            try {
                if (this.iCarSensors != null) {
                    val sensorEvent = this.iCarSensors!!.getSensorEvent(v);
                    return sensorEvent;
                }
            }catch(_:Exception){

            }
            return -1;
        }

        private fun getSensorValue(v: Int): Float {
            try {
                if (this.iCarSensors != null) {
                    val sensorValue = this.iCarSensors!!.getSensorLatestValue(v);
                    return sensorValue;
                }
            }catch(_:Exception){

            }
            return 0.toFloat()
        }

        private fun getFunctionValue(v: Int): Int {
            try {
                if (this.iCarFunction != null) {
                    val functionValue = this.iCarFunction!!.getFunctionValue(v);
                    return functionValue;
                }
            }catch(_:Exception){

            }
            return -1;
        }

        private fun getFunctionValue(v: Int, v1: Int): Int {
            try {
                if (this.iCarFunction != null) {
                    val functionValue = this.iCarFunction!!.getFunctionValue(v, v1);
                    return functionValue;
                }
            }catch(_:Exception){

            }
            return -1;
        }

        private fun getCustomizeFunctionValue(v: Int): Float {
            try {
                if (this.iCarFunction != null) {
                    val functionValue = this.iCarFunction!!.getCustomizeFunctionValue(v);
                    return functionValue;
                }
            }catch(_:Exception){

            }
            return -1.0F
        }

        private fun getCustomizeFunctionValue(v: Int, v1: Int): Float {
            try {
                if (this.iCarFunction != null) {
                    val functionValue = this.iCarFunction!!.getCustomizeFunctionValue(v, v1);
                    return functionValue;
                }
            }catch(_:Exception){

            }
            return -1.0F
        }

        private fun setFunctionValue(i: Int, i2: Int) {
            try {
                if (this.iCarFunction != null) {
                    this.iCarFunction!!.setFunctionValue(i, i2)
                }
            }catch(_:Exception){

            }
        }

        private fun setFunctionValue(i: Int, i2: Int, i3: Int) {
            try {
                if (this.iCarFunction != null) {
                    this.iCarFunction!!.setFunctionValue(i, i2, i3)
                }
            }catch(_:Exception){

            }
        }

        private fun setCustomizeFunctionValue(i: Int, i2: Float) {
            try {
                if (this.iCarFunction != null) {
                    this.iCarFunction!!.setCustomizeFunctionValue(i, i2)
                }
            }catch(_:Exception){

            }
        }

        private fun setCustomizeFunctionValue(i: Int, i2: Int, i3: Float) {
            try {
                if (this.iCarFunction != null) {
                    this.iCarFunction!!.setCustomizeFunctionValue(i, i2, i3)
                }
            }catch(_:Exception){

            }
        }

        private inner class ChangesPreferences : OnSharedPreferenceChangeListener {
            override fun onSharedPreferenceChanged(
                sharedPreferences: SharedPreferences,
                key: String?
            ) {
                when (key) {
                    IdNames.startstopFuncCfg_key -> {
                        var v = sharedPreferences.getInt(key, ItemsOnOffPlus.NOT_USED.value)
                        if(ItemsOnOffPlus.entries.firstOrNull { it.value == v } == null){
                            v = ItemsOnOffPlus.NOT_USED.value
                        }
                        startstopFuncCfg = v

                    }
                    IdNames.autoholdFuncCfg_key -> {
                        var v = sharedPreferences.getInt(key, ItemsOnOffPlus.NOT_USED.value)
                        if(ItemsOnOffPlus.entries.firstOrNull { it.value == v } == null){
                            v = ItemsOnOffPlus.NOT_USED.value
                        }
                        autoholdFuncCfg = v
                    }
                    "driveModeCfg"  -> {
                        driveModeCfg = sharedPreferences.getInt(key, DRIVE_MODE_SELECTION_COMFORT)
                    }
                    IdNames.restoreDriveMode_key -> {
                        driveModeRestoreCfg = sharedPreferences.getBoolean(key, false)
                    }

                    IdNames.elkaDisable_key -> {
                        elkaDisableCfg = sharedPreferences.getBoolean(key, false)
                    }

                    IdNames.gearReverseSpeedCfg_key -> {
                        gearReverseSpeedCfg = sharedPreferences.getInt(key,0)
                    }

                    IdNames.gearReverseTimeCfg_key -> {
                        gearReverseTimeCfg = sharedPreferences.getInt(key, 0)
                    }


                    IdNames.brightnessReverse_key -> {
                        brightnessReverseCfg = sharedPreferences.getBoolean(key, false)
                    }

                    IdNames.passDisplayOff_key -> {
                        val prev = passDisplayOffCfg
                        passDisplayOffCfg = sharedPreferences.getBoolean(key, false)
                        if(!passDisplayOffCfg && prev){
                            passDisplayOnOffFlag = 2
                        }else if(passDisplayOffCfg && !prev){
                            passDisplayOnOffFlag = 1
                        }
                    }
                    IdNames.passDisplayOffNoPass_key -> {
                        val prev = passDisplayOffNoPassCfg
                        passDisplayOffNoPassCfg = sharedPreferences.getBoolean(key, false)
                        if(!passDisplayOffNoPassCfg && prev){
                            passDisplayOnOffFlag = 2
                        }else if(passDisplayOffNoPassCfg && !prev){
                            passDisplayOnOffFlag = 1
                        }
                    }
                    IdNames.climateGCleanCfg_key -> {
                        climateGCleanCfg = sharedPreferences.getBoolean(key, false)
                    }

                    IdNames.climateStartCfg_key -> {
                        var v = sharedPreferences.getInt(key, ItemsClimateStart.NOT_USED.value)
                        if(ItemsClimateStart.entries.firstOrNull { it.value == v } == null){
                            v = ItemsClimateStart.NOT_USED.value
                        }
                        climateStartCfg = v
                    }
                    IdNames.climateStartAutoCfg_key -> {
                        climateStartAutoCfg = sharedPreferences.getBoolean(key, false)
                    }
                    IdNames.climateStart_AC_Cfg_key -> {
                        var v = sharedPreferences.getInt(key, ItemsClimateAC.NOT_USED.value)
                        if(ItemsClimateAC.entries.firstOrNull { it.value == v } == null){
                            v = ItemsClimateStart.NOT_USED.value
                        }
                        climateStartACCfg = v
                    }
                    IdNames.climateStartSpeedCfg_key -> {
                        var v = sharedPreferences.getInt(key, ItemsClimateAutoFan.NOT_USED.value)
                        if(ItemsClimateAutoFan.entries.firstOrNull { it.value == v } == null && ItemsClimateFan.entries.firstOrNull { it.value == v } == null){
                            v = ItemsClimateStart.NOT_USED.value
                        }
                        climateStartSpeedCfg = v
                    }

                    IdNames.climateStart_Mode_Cfg_key -> {
                        var v = sharedPreferences.getInt(key, ItemsClimateModes.NOT_USED.value)
                        if(ItemsClimateModes.entries.firstOrNull { it.value == v } == null){
                            v = ItemsClimateModes.NOT_USED.value
                        }
                        climateStart_Mode_Cfg = v
                    }

                    IdNames.climateStartAuto128Cfg_key -> {
                        climateStartAuto128Cfg = sharedPreferences.getBoolean(key, false)
                    }

                    IdNames.climateStart_Mode128_Cfg_key -> {
                        var v = sharedPreferences.getInt(key, ItemsClimateModes128.NOT_USED.value)
                        if(ItemsClimateModes128.entries.firstOrNull { it.value == v } == null){
                            v = ItemsClimateModes128.NOT_USED.value
                        }
                        climateStart_Mode128_Cfg = v
                    }

                    IdNames.climateDefrozeTempCfg_key -> {
                        climateDefrozeTempCfg = sharedPreferences.getFloat(key,(-100.0).toFloat()).toDouble()
                    }

                    IdNames.climateDefrozePeriodCfg_key -> {
                        var v = sharedPreferences.getInt(key, ItemsClimateDefrozePeriods.NOT_USED.value)
                        if(ItemsClimateDefrozePeriods.entries.firstOrNull { it.value == v } == null){
                            v = ItemsClimateDefrozePeriods.NOT_USED.value
                        }
                        climateDefrozePeriodCfg = v
                        climateDefrozeTimestamp = System.currentTimeMillis()
                    }
                    IdNames.climateDefrozePeriodTempCfg_key -> {
                        climateDefrozePeriodTempCfg = sharedPreferences.getFloat(key,(-100.0).toFloat()).toDouble()
                    }

                    IdNames.climateDefrozeRearTempCfg_key -> {
                        climateDefrozeRearTempCfg = sharedPreferences.getFloat(key,(-100.0).toFloat()).toDouble()
                    }

                    IdNames.climateSeatDrLevelCfg_key -> {
                        var v = sharedPreferences.getInt(key, ItemsClimateSeatModes.NOT_USED.value)
                        if(ItemsClimateSeatModes.entries.firstOrNull { it.value == v } == null){
                            v = ItemsClimateSeatModes.NOT_USED.value
                        }
                        climateSeatDrLevelCfg = v
                    }
                    IdNames.climateSeatDrIntTempCfg_key -> {
                        climateSeatDrIntTempCfg = sharedPreferences.getFloat(key,(-100.0).toFloat()).toDouble()
                    }
                    IdNames.climateSeatDrLevel1Cfg_key -> {
                        var v = sharedPreferences.getInt(key, ItemsClimateSeatModes.NOT_USED.value)
                        if(ItemsClimateSeatModes.entries.firstOrNull { it.value == v } == null){
                            v = ItemsClimateSeatModes.NOT_USED.value
                        }
                        climateSeatDrLevel1Cfg = v
                    }
                    IdNames.climateSeatDrIntTemp1Cfg_key -> {
                        climateSeatDrIntTemp1Cfg = sharedPreferences.getFloat(key,(-100.0).toFloat()).toDouble()
                    }

                    IdNames.climateSeatDrLevelOutCfg_key -> {
                        var v = sharedPreferences.getInt(key, ItemsClimateSeatModes.NOT_USED.value)
                        if(ItemsClimateSeatModes.entries.firstOrNull { it.value == v } == null){
                            v = ItemsClimateSeatModes.NOT_USED.value
                        }
                        climateSeatDrLevelOutCfg = v
                    }
                    IdNames.climateSeatDrOutTempCfg_key -> {
                        climateSeatDrOutTempCfg = sharedPreferences.getFloat(key,(-100.0).toFloat()).toDouble()
                    }

                    IdNames.climateSeatPassLevelCfg_key -> {
                        var v = sharedPreferences.getInt(key, ItemsClimateSeatModes.NOT_USED.value)
                        if(ItemsClimateSeatModes.entries.firstOrNull { it.value == v } == null){
                            v = ItemsClimateSeatModes.NOT_USED.value
                        }
                        climateSeatPassLevelCfg = v
                    }
                    IdNames.climateSeatPassIntTempCfg_key -> {
                        climateSeatPassIntTempCfg = sharedPreferences.getFloat(key,(-100.0).toFloat()).toDouble()
                    }
                    IdNames.climateSeatPassLevel1Cfg_key -> {
                        var v = sharedPreferences.getInt(key, ItemsClimateSeatModes.NOT_USED.value)
                        if(ItemsClimateSeatModes.entries.firstOrNull { it.value == v } == null){
                            v = ItemsClimateSeatModes.NOT_USED.value
                        }
                        climateSeatPassLevel1Cfg = v
                    }
                    IdNames.climateSeatPassIntTemp1Cfg_key -> {
                        climateSeatPassIntTemp1Cfg = sharedPreferences.getFloat(key,(-100.0).toFloat()).toDouble()
                    }
                    IdNames.climateSeatPassLevelOutCfg_key -> {
                        var v = sharedPreferences.getInt(key, ItemsClimateSeatModes.NOT_USED.value)
                        if(ItemsClimateSeatModes.entries.firstOrNull { it.value == v } == null){
                            v = ItemsClimateSeatModes.NOT_USED.value
                        }
                        climateSeatPassLevelOutCfg = v
                    }
                    IdNames.climateSeatPassOutTempCfg_key -> {
                        climateSeatPassOutTempCfg = sharedPreferences.getFloat(key,(-100.0).toFloat()).toDouble()
                    }

                    IdNames.climateWheelLevelCfg_key -> {
                        var v = sharedPreferences.getInt(key, ItemsClimateWheelModes.NOT_USED.value)
                        if(ItemsClimateWheelModes.entries.firstOrNull { it.value == v } == null){
                            v = ItemsClimateWheelModes.NOT_USED.value
                        }
                        climateWheelLevelCfg = v
                    }
                    IdNames.climateWheelIntTempCfg_key -> {
                        climateWheelIntTempCfg = sharedPreferences.getFloat(key,(-100.0).toFloat()).toDouble()
                    }
                    IdNames.climateWheelLevel1Cfg_key -> {
                        var v = sharedPreferences.getInt(key, ItemsClimateWheelModes.NOT_USED.value)
                        if(ItemsClimateWheelModes.entries.firstOrNull { it.value == v } == null){
                            v = ItemsClimateWheelModes.NOT_USED.value
                        }
                        climateWheelLevel1Cfg = v
                    }
                    IdNames.climateWheelIntTemp1Cfg_key -> {
                        climateWheelIntTemp1Cfg = sharedPreferences.getFloat(key,(-100.0).toFloat()).toDouble()
                    }

                    IdNames.climateWheelLevelOutCfg_key -> {
                        var v = sharedPreferences.getInt(key, ItemsClimateWheelModes.NOT_USED.value)
                        if(ItemsClimateWheelModes.entries.firstOrNull { it.value == v } == null){
                            v = ItemsClimateWheelModes.NOT_USED.value
                        }
                        climateWheelLevelOutCfg = v
                    }
                    IdNames.climateWheelOutTempCfg_key -> {
                        climateWheelOutTempCfg = sharedPreferences.getFloat(key,(-100.0).toFloat()).toDouble()
                    }

                    IdNames.climateVentDrLevelCfg_key -> {
                        var v = sharedPreferences.getInt(key, ItemsClimateVentModes.NOT_USED.value)
                        if(ItemsClimateVentModes.entries.firstOrNull { it.value == v } == null){
                            v = ItemsClimateVentModes.NOT_USED.value
                        }
                        climateVentDrLevelCfg = v
                    }
                    IdNames.climateVentDrIntTempCfg_key -> {
                        climateVentDrIntTempCfg = sharedPreferences.getFloat(key,(-100.0).toFloat()).toDouble()
                    }
                    IdNames.climateVentDrLevel1Cfg_key -> {
                        var v = sharedPreferences.getInt(key, ItemsClimateVentModes.NOT_USED.value)
                        if(ItemsClimateVentModes.entries.firstOrNull { it.value == v } == null){
                            v = ItemsClimateVentModes.NOT_USED.value
                        }
                        climateVentDrLevel1Cfg = v
                    }
                    IdNames.climateVentDrIntTemp1Cfg_key -> {
                        climateVentDrIntTemp1Cfg = sharedPreferences.getFloat(key,(-100.0).toFloat()).toDouble()
                    }

                    IdNames.climateVentDrOutTempCfg_key -> {
                        climateVentDrOutTempCfg = sharedPreferences.getFloat(key,(-100.0).toFloat()).toDouble()
                    }
                    IdNames.climateVentDrCorrectionCfg_key -> {
                        climateVentDrCorrectionCfg = sharedPreferences.getBoolean(key, false)
                    }

                    IdNames.climateVentPassLevelCfg_key -> {
                        var v = sharedPreferences.getInt(key, ItemsClimateVentModes.NOT_USED.value)
                        if(ItemsClimateVentModes.entries.firstOrNull { it.value == v } == null){
                            v = ItemsClimateVentModes.NOT_USED.value
                        }
                        climateVentPassLevelCfg = v
                    }
                    IdNames.climateVentPassIntTempCfg_key -> {
                        climateVentPassIntTempCfg = sharedPreferences.getFloat(key,(-100.0).toFloat()).toDouble()
                    }
                    IdNames.climateVentPassLevel1Cfg_key -> {
                        var v = sharedPreferences.getInt(key, ItemsClimateVentModes.NOT_USED.value)
                        if(ItemsClimateVentModes.entries.firstOrNull { it.value == v } == null){
                            v = ItemsClimateVentModes.NOT_USED.value
                        }
                        climateVentPassLevel1Cfg = v
                    }
                    IdNames.climateVentPassIntTemp1Cfg_key -> {
                        climateVentPassIntTemp1Cfg = sharedPreferences.getFloat(key,(-100.0).toFloat()).toDouble()
                    }

                    IdNames.climateVentPassOutTempCfg_key -> {
                        climateVentPassOutTempCfg = sharedPreferences.getFloat(key,(-100.0).toFloat()).toDouble()
                    }
                    IdNames.climateVentPassCorrectionCfg_key -> {
                        climateVentPassCorrectionCfg = sharedPreferences.getBoolean(key, false)
                    }
                    IdNames.windowScreenServicePosCfg_key -> {
                        windowScreenServicePosCfg = sharedPreferences.getBoolean(key, false)
                    }
                    IdNames.intelligentFuelSaveStartCfg_key -> {
                        intelligentFuelSaveStartCfg = sharedPreferences.getBoolean(key, false)
                    }
                    IdNames.panoramaCurtainStartCfg_key -> {
                        panoramaCurtainStartCfg = sharedPreferences.getBoolean(key, false)
                    }

                }
            }
        }

        fun setFunctionValueChecked(type:Int, zone:Int, value:Int)
        {
            for (i in 0 until 3) {
                if (isICarFunctionAvailable(type, zone)) {
                    setFunctionValue(type, zone, value)
                    for (j in 0 until 2){
                        Thread.sleep((200+100*j).toLong())
                        val ret = getFunctionValue(type, zone)
                        if (ret == value) {
                            return
                        }
                    }
                }else{
                    Thread.sleep(200)
                }
            }
        }
        fun setFunctionValueChecked(type:Int, value:Int)
        {
            for (i in 0 until 3) {
                if (isICarFunctionAvailable(type)) {
                    setFunctionValue(type, value)
 //                   sendMessageToUI(IdNames.TOAST, "$type, v: $value")
                    for (j in 0 until 2){
                        Thread.sleep((200+100*j).toLong())
                        val ret = getFunctionValue(type)
                        if (ret == value) {
                            return
                        }
                    }
                }else{
                    Thread.sleep(200)
                }
            }
        }


        fun setFunctionValueReadChecked(type:Int, zone:Int, value:Int)
        {
            for (i in 0 until 3) {
                if (isICarFunctionAvailable(type, zone)) {
                    for (j in 0 until 2){
                        val ret = getFunctionValue(type, zone)
                        if (ret == value) {
                            return
                        }
                        setFunctionValue(type, zone, value)
                        Thread.sleep((200+100*j).toLong())
                    }
                }else{
                    Thread.sleep(500)
                }
            }
        }
        fun setFunctionValueReadChecked(type:Int, value:Int)
        {
            for (i in 0 until 3) {
                if (isICarFunctionAvailable(type)) {
                    for (j in 0 until 2){
                        val ret = getFunctionValue(type)
                        if (ret == value) {
                            return;
                        }
                        setFunctionValue(type, value)
                        Thread.sleep((200+100*j).toLong())
                    }
                }else{
                    Thread.sleep(500)
                }
            }
        }

        private fun setFunctionValueNoChecked(type:Int, zone:Int, value:Int)
        {
            for (i in 0 until 2) {
                if (isICarFunctionAvailable(type,zone)) {
                    setFunctionValue(type, zone, value)
                    return
                }else{
                    Thread.sleep(200)
                }
            }
        }
        private fun setFunctionValueNoChecked(type:Int, value:Int)
        {
            for (i in 0 until 2) {
                if (isICarFunctionAvailable(type)) {
                    setFunctionValue(type, value)
                    return
                }else{
                    Thread.sleep(200)
                }
            }
        }

        override fun run() {
            //start
            preferences = PreferenceManager.getDefaultSharedPreferences(context);
            if(preferences==null){
                sendMessageToUI(IdNames.ERROR, "error_quit")
                return
            }
            val sUpTime = SystemClock.uptimeMillis()
            var tm = if(sUpTime<17000) (17000-sUpTime) else 100
            if(tm<100){
                tm = 100
            }
            Thread.sleep(tm)
            if(ht==null){
                ht = HandlerThread("MConfigHandlerThread")
                ht!!.start()
            }

            changesPreferences = ChangesPreferences()
            //init preferences
            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.startstopFuncCfg_key)
            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.autoholdFuncCfg_key)
            changesPreferences!!.onSharedPreferenceChanged(preferences!!, "driveModeCfg")
            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.restoreDriveMode_key)
            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.elkaDisable_key)
            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.brightnessReverse_key)
            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.passDisplayOff_key)
            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.passDisplayOffNoPass_key)
            passDisplayOnOffFlag = 0
            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.gearReverseSpeedCfg_key)
            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.gearReverseTimeCfg_key)
            //climate
            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.climateGCleanCfg_key)
            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.climateStartCfg_key)
            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.climateStartAutoCfg_key)
            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.climateStart_AC_Cfg_key)
            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.climateStartSpeedCfg_key)
            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.climateStart_Mode_Cfg_key)
            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.climateStartAuto128Cfg_key)
            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.climateStart_Mode128_Cfg_key)

            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.climateDefrozeTempCfg_key)
            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.climateDefrozePeriodCfg_key)
            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.climateDefrozePeriodTempCfg_key)
            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.climateDefrozeRearTempCfg_key)

            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.climateSeatDrLevelCfg_key)
            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.climateSeatDrIntTempCfg_key)
            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.climateSeatDrLevel1Cfg_key)
            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.climateSeatDrIntTemp1Cfg_key)
            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.climateSeatDrLevelOutCfg_key)
            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.climateSeatDrOutTempCfg_key)

            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.climateSeatPassLevelCfg_key)
            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.climateSeatPassIntTempCfg_key)
            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.climateSeatPassLevel1Cfg_key)
            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.climateSeatPassIntTemp1Cfg_key)
            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.climateSeatPassLevelOutCfg_key)
            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.climateSeatPassOutTempCfg_key)

            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.climateWheelLevelCfg_key)
            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.climateWheelIntTempCfg_key)
            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.climateWheelLevel1Cfg_key)
            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.climateWheelIntTemp1Cfg_key)
            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.climateWheelLevelOutCfg_key)
            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.climateWheelOutTempCfg_key)

            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.climateVentDrLevelCfg_key)
            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.climateVentDrIntTempCfg_key)
            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.climateVentDrLevel1Cfg_key)
            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.climateVentDrIntTemp1Cfg_key)
            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.climateVentDrOutTempCfg_key)
            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.climateVentDrCorrectionCfg_key)

            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.climateVentPassLevelCfg_key)
            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.climateVentPassIntTempCfg_key)
            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.climateVentPassLevel1Cfg_key)
            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.climateVentPassIntTemp1Cfg_key)
            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.climateVentPassOutTempCfg_key)
            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.climateVentPassCorrectionCfg_key)
            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.windowScreenServicePosCfg_key)
            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.intelligentFuelSaveStartCfg_key)
            changesPreferences!!.onSharedPreferenceChanged(preferences!!, IdNames.panoramaCurtainStartCfg_key)

            preferences!!.registerOnSharedPreferenceChangeListener(changesPreferences)

            handleToThread = object : Handler(Looper.getMainLooper()) {
                override fun handleMessage(msg: Message) {
                    super.handleMessage(msg)
                    if(msg.what == IdNames.DRIVE_SPORT_KEYPRESSED){
                        driveModeByKeySet = DRIVE_MODE_SELECTION_DYNAMIC
                    }else if(msg.what == IdNames.DRIVE_SNOW_KEYPRESSED){
                        driveModeByKeySet = DRIVE_MODE_SELECTION_SNOW
                    }else if(msg.what == IdNames.DRIVE_OFFROAD_KEYPRESSED){
                        driveModeByKeySet = DRIVE_MODE_SELECTION_OFFROAD
                    }
                    else if(msg.what == IdNames.UPDATE_UI){
                        needToUpdateData.set(true)
                    }
                }
            }
//            while(true){
//                if (needToStop.get()) {
//                    sendMessageToUI(IdNames.ERROR, if (!needToStop.get()) "error_quit" else "quit")
//                    //exit
//                    needToStop.set(false)
//                    return
//                }
//                Thread.sleep(1000)
//            }

            try {
                var carInitialized:Boolean = false
                for(i in 1 until 4) {
                    if (initICarFunction() == 0 && iCarFunction != null && initICarSensors() == 0 && iCarSensors != null) {
                        carInitialized = true
                        break
                    }
                    Thread.sleep((500*i).toLong())
                }


                if(carInitialized) {

                    handlerWindowScreenServicePos = Handler(ht!!.looper)
                    handlerIgnitionDriverDelay = Handler(ht!!.looper)

                    iSensorListener = ISensorListenerClass()
                    iCarSensors?.registerListener(iSensorListener, SENSOR_TYPE_IGNITION_STATE)
                    iCarSensors?.registerListener(iSensorListener, SENSOR_TYPE_TEMPERATURE_AMBIENT)
                    iCarSensors?.registerListener(iSensorListener, SENSOR_TYPE_TEMPERATURE_INDOOR)
                    iCarSensors?.registerListener(iSensorListener, SENSOR_TYPE_FUEL_LEVEL)
                    iCarSensors?.registerListener(iSensorListener, SENSOR_TYPE_CAR_SPEED)
                    iCarSensors?.registerListener(iSensorListener, SENSOR_TYPE_RPM)
                    iCarSensors?.registerListener(iSensorListener, SENSOR_TYPE_ENGINE_OIL_LEVEL)
                    iCarSensors?.registerListener(
                        iSensorListener,
                        SENSOR_TYPE_SEAT_OCCUPATION_STATUS_PASSENGER
                    )
                    iCarSensors?.registerListener(iSensorListener, SENSOR_TYPE_GEAR)

                    iFunctionValueWatcher = IFunctionValueWatcherClass()
                    iCarFunction?.registerFunctionValueWatcher(
                        SETTING_FUNC_ENGINE_STOP_START,
                        iFunctionValueWatcher
                    )
                    iCarFunction?.registerFunctionValueWatcher(
                        SETTING_FUNC_AUTO_HOLD,
                        iFunctionValueWatcher
                    )
                    iCarFunction?.registerFunctionValueWatcher(
                        DM_FUNC_DRIVE_MODE_SELECT,
                        iFunctionValueWatcher
                    )
                    iCarFunction?.registerFunctionValueWatcher(
                        SETTING_FUNC_PSD_SCREEN_SWITCH,
                        iFunctionValueWatcher
                    )

                    //climate
                    iCarFunction?.registerFunctionValueWatcher(
                        HVAC_FUNC_AUTO,
                        iFunctionValueWatcher
                    )
                    iCarFunction?.registerFunctionValueWatcher(
                        HVAC_FUNC_BLOWING_MODE,
                        iFunctionValueWatcher
                    )
                    iCarFunction?.registerFunctionValueWatcher(
                        HVAC_FUNC_AUTO_FAN_SETTING,
                        iFunctionValueWatcher
                    )
                    iCarFunction?.registerFunctionValueWatcher(
                        HVAC_FUNC_G_CLEAN,
                        iFunctionValueWatcher
                    )
                    iCarFunction?.registerFunctionValueWatcher(
                        HVAC_FUNC_SEAT_HEATING,
                        iFunctionValueWatcher
                    )
                    iCarFunction?.registerFunctionValueWatcher(
                        HVAC_FUNC_STEERING_WHEEL_HEAT,
                        iFunctionValueWatcher
                    )
                    iCarFunction?.registerFunctionValueWatcher(
                        HVAC_FUNC_SEAT_VENTILATION,
                        iFunctionValueWatcher
                    )
                    iCarFunction?.registerFunctionValueWatcher(
                        SETTING_FUNC_EMGY_LANE_KEEP_AID,
                        iFunctionValueWatcher
                    )
                    iCarFunction?.registerFunctionValueWatcher(
                        IPAS.PAS_FUNC_PAC_ACTIVATION,
                        iFunctionValueWatcher
                    )
                    iCarFunction?.registerFunctionValueWatcher(
                        BCM_FUNC_DOOR,
                        iFunctionValueWatcher
                    )

                    Thread.sleep(2000)

                    rpmValueTimestamp = System.currentTimeMillis()
                    rpmValueTimestamp = System.currentTimeMillis()
                    autoholdFuncTimestamp = System.currentTimeMillis()
                    driveModeTimestamp = System.currentTimeMillis()
                    climateDefrozeTimestamp = System.currentTimeMillis()
                    passSeatOccupationTimestamp = System.currentTimeMillis()

                    try {
                        var v: Int = getSensorEvent(SENSOR_TYPE_IGNITION_STATE)
                        (iSensorListener as ISensorListenerClass).onSensorEventChanged(
                            SENSOR_TYPE_IGNITION_STATE,
                            v
                        )

                        v = getSensorEvent(SENSOR_TYPE_ENGINE_OIL_LEVEL)
                        (iSensorListener as ISensorListenerClass).onSensorEventChanged(
                            SENSOR_TYPE_ENGINE_OIL_LEVEL,
                            v
                        )

                        v = getSensorEvent(SENSOR_TYPE_SEAT_OCCUPATION_STATUS_PASSENGER)
                        (iSensorListener as ISensorListenerClass).onSensorEventChanged(
                            SENSOR_TYPE_SEAT_OCCUPATION_STATUS_PASSENGER,
                            v
                        )

                        v = getSensorEvent(SENSOR_TYPE_GEAR)
                        (iSensorListener as ISensorListenerClass).onSensorEventChanged(
                            SENSOR_TYPE_GEAR,
                            v
                        )
                        gearReversePreValue = v

                    }catch(_:Exception){}


                    needToUpdateData.set(true)


                    //main loop
                    while (true) {
                        if (needToStop.get()) {
                            break
                        }
                        if (needToUpdateData.compareAndSet(true, false)) {
                            try {
                                var v: Int = getSensorEvent(SENSOR_TYPE_IGNITION_STATE)
                                sendMessageToUI(IdNames.IGNITION_STATE, onIgnitionStateChanged(v))

                                v = getSensorEvent(SENSOR_TYPE_ENGINE_OIL_LEVEL)
                                (iSensorListener as ISensorListenerClass).onSensorEventChanged(
                                    SENSOR_TYPE_ENGINE_OIL_LEVEL,
                                    v
                                )

                                v = getSensorEvent(SENSOR_TYPE_SEAT_OCCUPATION_STATUS_PASSENGER)
                                sendMessageToUI(IdNames.SEAT_OCCUPATION_STATUS_PASSENGER, onSeatOccupationStateChanged(v))

                                v = getSensorEvent(SENSOR_TYPE_GEAR)
                                sendMessageToUI(IdNames.SENSOR_TYPE_GEAR, onGearStateChanged(v))

                                var f: Float
                                f = if (isICarSensorAvailable(SENSOR_TYPE_TEMPERATURE_AMBIENT)) {
                                    getSensorValue(SENSOR_TYPE_TEMPERATURE_AMBIENT)
                                } else {
                                    0.toFloat()
                                }
                                (iSensorListener as ISensorListenerClass).onSensorValueChanged(
                                    SENSOR_TYPE_TEMPERATURE_AMBIENT,
                                    f
                                )
                                f = if (isICarSensorAvailable(SENSOR_TYPE_TEMPERATURE_INDOOR)) {
                                    getSensorValue(SENSOR_TYPE_TEMPERATURE_INDOOR)
                                } else {
                                    0.toFloat()
                                }
                                (iSensorListener as ISensorListenerClass).onSensorValueChanged(
                                    SENSOR_TYPE_TEMPERATURE_INDOOR,
                                    f
                                )
                                f = if (isICarSensorAvailable(SENSOR_TYPE_FUEL_LEVEL)) {
                                    getSensorValue(SENSOR_TYPE_FUEL_LEVEL)
                                } else {
                                    0.toFloat()
                                }
                                (iSensorListener as ISensorListenerClass).onSensorValueChanged(
                                    SENSOR_TYPE_FUEL_LEVEL,
                                    f
                                )
                                f = if (isICarSensorAvailable(SENSOR_TYPE_CAR_SPEED)) {
                                    getSensorValue(SENSOR_TYPE_CAR_SPEED)
                                } else {
                                    0.toFloat()
                                }
                                (iSensorListener as ISensorListenerClass).onSensorValueChanged(
                                    SENSOR_TYPE_CAR_SPEED,
                                    f
                                )
                                f = if (isICarSensorAvailable(SENSOR_TYPE_RPM)) {
                                    getSensorValue(SENSOR_TYPE_RPM)
                                } else {
                                    0.toFloat()
                                }
                                (iSensorListener as ISensorListenerClass).onSensorValueChanged(
                                    SENSOR_TYPE_RPM,
                                    f
                                )
                            } catch (_: Exception) {
                            }
                        }

                        //Start-Stop
                        if (startstopFuncCfg != ItemsOnOffPlus.NOT_USED.value) {
                            if (startstopFuncValue == -1) {
                                if (isICarFunctionAvailable(SETTING_FUNC_ENGINE_STOP_START)) {
                                    startstopFuncValue =
                                        getFunctionValue(SETTING_FUNC_ENGINE_STOP_START)
                                }
                            }
                            var st=startstopFuncValue
                            if ((st == 0 && (startstopFuncCfg == ItemsOnOffPlus.ALWAYS_ON.value || startstopFuncCfg == ItemsOnOffPlus.ONSTART_ON.value)) ||
                                (st == 1 && (startstopFuncCfg == ItemsOnOffPlus.ALWAYS_OFF.value || startstopFuncCfg == ItemsOnOffPlus.ONSTART_OFF.value))
                            ) {
                                if (isICarFunctionAvailable(SETTING_FUNC_ENGINE_STOP_START)) {
                                    st=if (startstopFuncCfg == ItemsOnOffPlus.ALWAYS_ON.value || startstopFuncCfg == ItemsOnOffPlus.ONSTART_ON.value) 1 else 0
                                    startstopFuncValue = st
                                    sendMessageToUI(IdNames.TOAST, "SETTING_FUNC_ENGINE_STOP_START, v: $startstopFuncValue")
                                    setFunctionValueChecked(
                                        SETTING_FUNC_ENGINE_STOP_START,
                                        st
                                    )
                                } else {
                                    startstopFuncValue = -1
                                }
                            }
                        }
                        if (ignitionStateValue == IGNITION_STATE_ON || ignitionStateValue == IGNITION_STATE_DRIVING  || ignitionStateValue == IGNITION_STATE_START) {
                            //Auto-Hold
                            if ((System.currentTimeMillis() - autoholdFuncTimestamp) >= 3000) {
                                autoholdFuncTimestamp = System.currentTimeMillis();
                                if (autoholdFuncCfg != ItemsOnOffPlus.NOT_USED.value) {
                                    if (autoholdFuncValue == -1) {
                                        if (isICarFunctionAvailable(SETTING_FUNC_AUTO_HOLD)) {
                                            autoholdFuncValue =
                                                getFunctionValue(SETTING_FUNC_AUTO_HOLD)
                                        }
                                    }
                                    var st = autoholdFuncValue
                                    if ((st == 0 && (autoholdFuncCfg == ItemsOnOffPlus.ALWAYS_ON.value || autoholdFuncCfg == ItemsOnOffPlus.ONSTART_ON.value)) ||
                                        (st == 1 && (autoholdFuncCfg == ItemsOnOffPlus.ALWAYS_OFF.value || autoholdFuncCfg == ItemsOnOffPlus.ONSTART_OFF.value))
                                    ) {
                                        if (isICarFunctionAvailable(SETTING_FUNC_AUTO_HOLD)) {
                                            st = if (autoholdFuncCfg == ItemsOnOffPlus.ALWAYS_ON.value || autoholdFuncCfg == ItemsOnOffPlus.ONSTART_ON.value) 1 else 0
                                            autoholdFuncValue = st
                                            sendMessageToUI(IdNames.TOAST, "SETTING_FUNC_AUTO_HOLD, v: $autoholdFuncValue")
                                            setFunctionValueChecked(
                                                SETTING_FUNC_AUTO_HOLD,
                                                st
                                            )
                                        } else {
                                            autoholdFuncValue = -1
                                        }
                                    }
                                }
                            }
                        } else {
                            autoholdFuncTimestamp = System.currentTimeMillis()
                        }

                        //RestoreDrivingMode
                        if (driveModeRestoreCfg && (ignitionStateValue == IGNITION_STATE_DRIVING)) {
                            if (driveModeByKeySet != -1) {
                                if(driveModeByKeySet == DRIVE_MODE_SELECTION_DYNAMIC) {
                                    if (driveModeCfg != DRIVE_MODE_SELECTION_DYNAMIC) {
                                        driveModeCfg = DRIVE_MODE_SELECTION_DYNAMIC
                                        driveModeValue = -1
                                    } else {
                                        changesPreferences!!.onSharedPreferenceChanged(
                                            preferences!!,
                                            "driveModeCfg"
                                        )
                                        driveModeValue = -1
                                    }
                                }else if(driveModeByKeySet == DRIVE_MODE_SELECTION_SNOW){
                                    if (driveModeCfg != DRIVE_MODE_SELECTION_SNOW) {
                                        driveModeCfg = DRIVE_MODE_SELECTION_SNOW
                                        driveModeValue = -1
                                    } else {
                                        changesPreferences!!.onSharedPreferenceChanged(
                                            preferences!!,
                                            "driveModeCfg"
                                        )
                                        driveModeValue = -1
                                    }
                                }else if(driveModeByKeySet == DRIVE_MODE_SELECTION_OFFROAD){
                                    if (driveModeCfg != DRIVE_MODE_SELECTION_OFFROAD) {
                                        driveModeCfg = DRIVE_MODE_SELECTION_OFFROAD
                                        driveModeValue = -1
                                    } else {
                                        changesPreferences!!.onSharedPreferenceChanged(
                                            preferences!!,
                                            "driveModeCfg"
                                        )
                                        driveModeValue = -1
                                    }
                                }
                                driveModeByKeySet = -1
                            }
                            if (driveModeValue != driveModeCfg) {
                                if (driveModeValue == -1) {   //first time equals -1, then updated
                                    if (isICarFunctionAvailable(DM_FUNC_DRIVE_MODE_SELECT)) {
                                        sendMessageToUI(IdNames.TOAST, "DM_FUNC_DRIVE_MODE_SELECT restore, v: $driveModeCfg")
                                        setFunctionValue(DM_FUNC_DRIVE_MODE_SELECT, driveModeCfg)
                                        driveModeListenerFlag.set(true)
                                        driveModeValue = driveModeCfg
                                        if (startstopFuncCfg == ItemsOnOffPlus.ONSTART_OFF.value || startstopFuncCfg == ItemsOnOffPlus.ONSTART_ON.value) {
                                            Handler(ht!!.looper).postDelayed({
                                                startstopFuncValue = -1
                                            }, 2000)
                                        }
                                        if (autoholdFuncCfg == ItemsOnOffPlus.ONSTART_OFF.value || autoholdFuncCfg == ItemsOnOffPlus.ONSTART_ON.value) {
                                            Handler(ht!!.looper).postDelayed({
                                                autoholdFuncValue = -1
                                                autoholdFuncTimestamp = System.currentTimeMillis();
                                            }, 2000)
                                        }
                                    }
                                } else {

                                    //SaveDrivingMode
                                    if ((System.currentTimeMillis() - driveModeTimestamp) >= 2500) {

                                        sendMessageToUI(IdNames.TOAST, "M_FUNC_DRIVE_MODE_SELECT save, v: $driveModeCfg")
                                        driveModeCfg = driveModeValue
                                        preferences?.edit()?.putInt("driveModeCfg", driveModeValue)
                                            ?.apply()
                                        driveModeTimestamp = System.currentTimeMillis()
                                        if (startstopFuncCfg == ItemsOnOffPlus.ONSTART_OFF.value || startstopFuncCfg == ItemsOnOffPlus.ONSTART_ON.value) {
                                            Handler(ht!!.looper).postDelayed({
                                                startstopFuncValue = -1
                                            }, 2000)
                                        }
                                        if (autoholdFuncCfg == ItemsOnOffPlus.ONSTART_OFF.value || autoholdFuncCfg == ItemsOnOffPlus.ONSTART_ON.value) {
                                            Handler(ht!!.looper).postDelayed({
                                                autoholdFuncValue = -1
                                                autoholdFuncTimestamp = System.currentTimeMillis();
                                            }, 2000)
                                        }
                                        intelligentFuelSaveReload()
                                    }
                                }
                            }
                        } else {
                            driveModeByKeySet = -1
                            driveModeValue = -1
                            driveModeTimestamp = System.currentTimeMillis()
                        }
                        if (ignitionStateValue == IGNITION_STATE_DRIVING) {
                            if (elkaValue == -1) {   //first time equals -1, then updated
                                if (isICarFunctionAvailable(SETTING_FUNC_EMGY_LANE_KEEP_AID)) {
                                    elkaValue = getFunctionValue(SETTING_FUNC_EMGY_LANE_KEEP_AID)
                                }
                            }
                            if (elkaDisableCfg){
                                if(elkaValue != 0 && elkaSetCounts < 6) {
                                    elkaValue = 0
                                    elkaSetCounts++
                                    sendMessageToUI(IdNames.TOAST, "SETTING_FUNC_EMGY_LANE_KEEP_AID, v: 0")
                                    setFunctionValue(SETTING_FUNC_EMGY_LANE_KEEP_AID, 0)
                                }
                            }
                        } else {
                            elkaValue = -1
                            elkaSetCounts=0
                        }

                        if (passSeatOccupationCurrent==-1 || (passSeatOccupationCurrent==0 && passSeatOccupationChanged.get()) || (passSeatOccupationCurrent==1 && !passSeatOccupationChanged.get())) {
                            if (System.currentTimeMillis() - passSeatOccupationTimestamp >= 2000) {
                                passSeatOccupationTimestamp = System.currentTimeMillis()
                                passSeatOccupationCurrent = if(passSeatOccupationChanged.get()) 1 else 0
                                sendMessageToUI(IdNames.TOAST, "PassSeatOccupation, v: $passSeatOccupationCurrent")
                                if(passSeatOccupationCurrent == 1){
                                    val ps = passSeatOccupationForDisplay
                                    passSeatOccupationForDisplay = 1
                                    if(passDisplayOffNoPassCfg && ps <= 0){
                                        passDisplayDoorOpened.set(false)
                                        Thread.sleep(100)
                                        sendMessageToUI(IdNames.TOAST, "SETTING_FUNC_PSD_SCREEN_SWITCH, v: 1")
                                        setFunctionValueReadChecked(SETTING_FUNC_PSD_SCREEN_SWITCH, 1)
                                    }
                                }else{
                                    val ps = passSeatOccupationForDisplay
                                    passSeatOccupationForDisplay = 0
                                    if(passDisplayOffNoPassCfg && ps == -1){
                                        passDisplayDoorOpened.set(false)
                                        Thread.sleep(100)
                                        sendMessageToUI(IdNames.TOAST, "SETTING_FUNC_PSD_SCREEN_SWITCH, v: 0")
                                        setFunctionValueReadChecked(SETTING_FUNC_PSD_SCREEN_SWITCH, 0)
                                    }
                                }
                            }
                        } else {
                            passSeatOccupationTimestamp = System.currentTimeMillis()
                        }

                        if (passDisplayOnOffFlag==1 && (passDisplayOffCfg || passDisplayOffNoPassCfg)) {
                            passDisplayOnOffFlag = 0
                            sendMessageToUI(IdNames.TOAST, "SETTING_FUNC_PSD_SCREEN_SWITCH, v: 0")
                            setFunctionValueReadChecked(SETTING_FUNC_PSD_SCREEN_SWITCH, 0)
                        }

                        if (passDisplayOnOffFlag==2 && (!passDisplayOffCfg && !passDisplayOffNoPassCfg)) {
                            passDisplayOnOffFlag = 0
                            passDisplayValue = -1
                            sendMessageToUI(IdNames.TOAST, "SETTING_FUNC_PSD_SCREEN_SWITCH, v: 1")
                            setFunctionValueReadChecked(SETTING_FUNC_PSD_SCREEN_SWITCH, 1)
                        }

                        if (climateIntTemperaturePresent.get()) {
                            val arr = climateIntTemperatureArr.copyOf()
                            arr.sort();
                            climateIntTemperature = arr[7].toDouble()/1000
                        }

                        if (climateOutTemperaturePresent.get()) {
                            val arr = climateOutTemperatureArr.copyOf()
                            arr.sort();
                            climateOutTemperature =  arr[7].toDouble()/1000
                        }

                        if ((rpmValue == 0 && rpmValueNotZerro > 0) || (rpmValue > 0 && rpmValueNotZerro == 0)) {
                            if (System.currentTimeMillis() - rpmValueTimestamp >= 1000) {
                                rpmValueTimestamp = System.currentTimeMillis()
                                rpmValueNotZerro = rpmValue
                            }
                        } else {
                            rpmValueTimestamp = System.currentTimeMillis()
                        }
                        updateHeatingAndVentValues()
                        panoramaCurtainOpenAtStart()
                        intelligentFuelSave()
                        reverseCamOffWorker()
                        brightnessWorker()
                        climateDefrozeWorker()
                        climateSeatWorker()
                        climateWheelWorker()
                        climateVentWorker()
                        climateStartWorker()

                        Thread.sleep(150)
                    }
                }
            } catch (_:Exception){

            }
            preferences!!.unregisterOnSharedPreferenceChangeListener(changesPreferences)
            sendMessageToUI(IdNames.ERROR, if (!needToStop.get()) "error_quit" else "quit")
            //exit
            needToStop.set(false)
            if(ht!=null){
                ht!!.quit()
                ht = null
            }
            iCarSensors?.unregisterListener(iSensorListener)
            iCarFunction?.unregisterFunctionValueWatcher(iFunctionValueWatcher)
            handleToThread?.removeMessages(0)

        }

        private var gearReverseTimestamp = System.currentTimeMillis()
        private fun reverseCamOffWorker(){
            if ((gearReverseTimeCfg != 0 || gearReverseSpeedCfg != 0) && gearValue != GEAR_REVERSE && gearReversePreValue == GEAR_REVERSE) {
                if((gearReverseSpeedCfg != 0 && speedValueInt > 0 && speedValueInt >= gearReverseSpeedCfg) || (gearReverseTimeCfg != 0 && (System.currentTimeMillis() -  gearReverseTimestamp) >= gearReverseTimeCfg*1000)) {
                    gearReversePreValue = -1
                    if (getFunctionValue(IPAS.PAS_FUNC_PAC_ACTIVATION) == 1) {
                        setFunctionValue(IPAS.PAS_FUNC_PAC_ACTIVATION, 1)   //hack !!!!!!
                    }
                }
            }else{
                gearReverseTimestamp = System.currentTimeMillis()
            }
        }

        private var brightnessValueNight:Int = -1

        private fun brightnessWorker(){
            if(brightnessReverseCfg) {
                if(pasFuncPacActivationValue == -1){
                    pasFuncPacActivationValue = if (isICarFunctionAvailable(IPAS.PAS_FUNC_PAC_ACTIVATION)) {
                        getFunctionValue(IPAS.PAS_FUNC_PAC_ACTIVATION)
                    } else {
                        0
                    }
                }
                if (pasFuncPacActivationValue == 1) {
                    if (brightnessValueNight == -1){
                        brightnessValueNight = -2
                        if(getSensorEvent(SENSOR_TYPE_DAY_NIGHT) == DAY_NIGHT_MODE_NIGHT) {
                            val v =getFunctionValue(688062976)
                            if(v == DAYMODE_SETTING_NIGHT || v == DAYMODE_SETTING_AUTO) {
                                brightnessValueNight = getCustomizeFunctionValue(SETTING_FUNC_BRIGHTNESS_NIGHT,1).toInt()
                                setCustomizeFunctionValue(SETTING_FUNC_BRIGHTNESS_NIGHT, 1, 15.0F)
                                sendMessageToUI(IdNames.TOAST, "SETTING_FUNC_BRIGHTNESS_NIGHT, v: 15")
                            }
                        }
                    }
                }
                else if ((brightnessValueNight >= 0) && pasFuncPacActivationValue == 0) {
                    if (getSensorEvent(SENSOR_TYPE_DAY_NIGHT) == DAY_NIGHT_MODE_NIGHT) {
                        sendMessageToUI(IdNames.TOAST, "SETTING_FUNC_BRIGHTNESS_NIGHT, v: "+brightnessValueNight.toFloat())
                        setCustomizeFunctionValue(SETTING_FUNC_BRIGHTNESS_NIGHT,1,brightnessValueNight.toFloat())
                    } else {
                        val v = getFunctionValue(SETTING_FUNC_BRIGHTNESS_DAYMODE)
                        if (v != DAYMODE_SETTING_NIGHT) {
                            sendMessageToUI(IdNames.TOAST, "SETTING_FUNC_BRIGHTNESS_NIGHT, not night, v: "+brightnessValueNight.toFloat())
                            setFunctionValue(SETTING_FUNC_BRIGHTNESS_DAYMODE, DAYMODE_SETTING_NIGHT)
                            Thread.sleep(300)
                            setCustomizeFunctionValue(SETTING_FUNC_BRIGHTNESS_NIGHT,1, brightnessValueNight.toFloat())
                            Thread.sleep(300)
                            setFunctionValue(SETTING_FUNC_BRIGHTNESS_DAYMODE, v)
                        }
                    }
                    brightnessValueNight = -1
                }
            }else{
                brightnessValueNight = -1
            }
        }


        private var climateAuto1_8:Int = -1
        private var climateAuto128:Int = -1
        private var climateStartValue:AtomicBoolean = AtomicBoolean(false)

        private var climateBlowingModeSavedValue1:Int = -1
        private var climateBlowingModeSavedValue8:Int = -1
        private var climateBlowingModeSavedValue128:Int = -1

        private var climateGCleanSpeedLast:Int = -1
        private var climateGCleanOnLast:AtomicBoolean = AtomicBoolean(false)

        private fun climateStartWorker()
        {
            if (ignitionStateValue == IGNITION_STATE_ON || ignitionStateValue == IGNITION_STATE_DRIVING || ignitionStateValue == IGNITION_STATE_START) {
                if (climateStartValue.compareAndSet(false, true)) {
                    if( climateStartCfg != ItemsClimateStart.NOT_USED.value){
                        var set = true
                        if(climateStartCfg == ItemsClimateStart.IF_NOT_AUTO.value){
                            if (isICarFunctionAvailable(HVAC_FUNC_AUTO)) {
                                if (getFunctionValue(HVAC_FUNC_AUTO) == 1){
                                    set = false
                                }
                            }
                        }else if(climateStartCfg == ItemsClimateStart.IF_WAS_OFF.value){
                            if (isICarFunctionAvailable(HVAC_FUNC_FAN_SPEED,8)) {
                                if (getFunctionValue(HVAC_FUNC_FAN_SPEED,8) != FAN_SPEED_OFF){
                                    set = false
                                }
                            }else if (isICarFunctionAvailable(HVAC_FUNC_AUTO_FAN_SETTING,8)) {
                                if (getFunctionValue(HVAC_FUNC_AUTO_FAN_SETTING,8) != 0){
                                    set = false
                                }
                            }
                        }
                        if(set) {
                            //set mode
                            if(!climateStartAutoCfg){
                                if (climateStart_Mode_Cfg != -1) {
                                    setFunctionValueReadChecked(HVAC_FUNC_BLOWING_MODE, 1,climateStart_Mode_Cfg)
                                    setFunctionValueReadChecked(HVAC_FUNC_BLOWING_MODE, 8,climateStart_Mode_Cfg)
                                    sendMessageToUI(IdNames.TOAST, "HVAC_FUNC_BLOWING_MODE, ZONE 1,8 v: $climateStart_Mode_Cfg")
                                }
                            }else if (climateStart_Mode_Cfg != -1){
                                climateBlowingModeSavedValue1 = climateStart_Mode_Cfg
                                climateBlowingModeSavedValue8 = climateStart_Mode_Cfg
                            }
                            if(!climateStartAuto128Cfg){
                                if (climateStart_Mode128_Cfg != -1) {
                                    setFunctionValueReadChecked(HVAC_FUNC_BLOWING_MODE, 128, climateStart_Mode128_Cfg)//1 times, no check
                                    sendMessageToUI(IdNames.TOAST, "HVAC_FUNC_BLOWING_MODE, ZONE 128 v: $climateStart_Mode128_Cfg")
                                }
                            }else if (climateStart_Mode128_Cfg != -1){
                                climateBlowingModeSavedValue128 = climateStart_Mode128_Cfg
                            }
                            //set auto
                            if(climateStartAutoCfg){
                                setFunctionValueReadChecked(HVAC_FUNC_AUTO, 1)
                                sendMessageToUI(IdNames.TOAST, "HVAC_FUNC_AUTO, v: 1")
                            }

                            Thread.sleep(200)

                            if(climateStartAuto128Cfg){
                                setFunctionValueReadChecked(HVAC_FUNC_AUTO, 128, 1) //1 times, no check
                                sendMessageToUI(IdNames.TOAST, "HVAC_FUNC_AUTO, ZONE 128 v: 1")
                            }
                            //设置速度
                            if(climateStartSpeedCfg != -1){
                                if(climateStartAutoCfg){
                                    var v = climateStartSpeedCfg
                                    if(ItemsClimateAutoFan.entries.firstOrNull { it.value == v } == null){
                                        v = ItemsClimateAutoFan.AUTO_FAN_SETTING_NORMAL.value
                                    }
                                    setFunctionValueReadChecked(HVAC_FUNC_AUTO_FAN_SETTING, 8,v)
                                    sendMessageToUI(IdNames.TOAST, "HVAC_FUNC_AUTO_FAN_SETTING, ZONE 8 v: $v")
                                }else{
                                    var v = climateStartSpeedCfg
                                    if(ItemsClimateFan.entries.firstOrNull { it.value == v } == null){
                                        v = ItemsClimateFan.FAN_SPEED_LEVEL_3.value
                                    }
                                    setFunctionValueReadChecked(HVAC_FUNC_FAN_SPEED, 8, v)
                                    sendMessageToUI(IdNames.TOAST, "HVAC_FUNC_FAN_SPEED, ZONE 8 v: $v")
                                }
                            }

                        }else{
                            if(climateStartAuto128Cfg){
                                if (isICarFunctionAvailable(HVAC_FUNC_AUTO,128)) {
                                    if (getFunctionValue(HVAC_FUNC_AUTO,128) != 1){
                                        setFunctionValue(HVAC_FUNC_AUTO, 128, 1)
                                        sendMessageToUI(IdNames.TOAST, "HVAC_FUNC_AUTO, ZONE 128 v: 1")
                                    }
                                }
                            }
                        }
                    }
                    Handler(ht!!.looper).postDelayed({
                        if(climateStartACCfg == ItemsClimateAC.ON.value) {
                            setFunctionValueReadChecked(HVAC_FUNC_AC, 1)
                            sendMessageToUI(IdNames.TOAST, "HVAC_FUNC_AC, 1")
                        }else if (climateStartACCfg == ItemsClimateAC.OFF.value)  {
                            setFunctionValueReadChecked(HVAC_FUNC_AC, 0)
                            sendMessageToUI(IdNames.TOAST, "HVAC_FUNC_AC, 0")
                        }
                    },500)
                }
            }
        }

        private var panoramaCurtainStartFlag:Int = 0
        private var panoramaCurtainStartTries:Int = 0
        private fun panoramaCurtainOpenAtStart(){
            if(panoramaCurtainStartCfg){
                if(panoramaCurtainStartFlag == 0){
                    if(++panoramaCurtainStartTries < 10){
                        if (isICarFunctionAvailable(BCM_FUNC_WINDOW_POS, 8)) {
                            if (getCustomizeFunctionValue(BCM_FUNC_WINDOW_POS,8).toDouble() != 100.0) {
                                sendMessageToUI(IdNames.TOAST, "BCM_FUNC_WINDOW_POS, v: 100.0")
                                setCustomizeFunctionValue(BCM_FUNC_WINDOW_POS, 8, (100.0).toFloat())
                            }
                            panoramaCurtainStartFlag = 2
                        }
                    }
                }
            }else{
                panoramaCurtainStartFlag = 0
            }
        }

        private var intelligentFuelSaveStartValue:Boolean = false
        private var intelligentFuelSaveStartCounts:Int = 0
        private var intelligentFuelSaveStartTimestamp = System.currentTimeMillis()-2001
        private fun intelligentFuelSaveReload()
        {
            intelligentFuelSaveStartTimestamp = System.currentTimeMillis()-2001
            intelligentFuelSaveStartCounts = 0
            intelligentFuelSaveStartValue = false
        }
        private fun intelligentFuelSave()
        {
            if (intelligentFuelSaveStartCfg) {
                if (!intelligentFuelSaveStartValue && (System.currentTimeMillis() - intelligentFuelSaveStartTimestamp >= 2000)) {
                    intelligentFuelSaveStartTimestamp = System.currentTimeMillis()
                    if(intelligentFuelSaveStartCounts++ < 3){
                        if(getFunctionValue(SETTING_FUNC_INTELLIGENT_FUEL_SAVE) == 0) {
                            sendMessageToUI(IdNames.TOAST, "SETTING_FUNC_INTELLIGENT_FUEL_SAVE, v: 1")
                            setFunctionValue(SETTING_FUNC_INTELLIGENT_FUEL_SAVE, 1)
                        }else{
                            intelligentFuelSaveStartValue = true
                        }
                    }else{
                        intelligentFuelSaveStartValue = true
                    }
                }
            }else{
                intelligentFuelSaveStartValue = false
            }
        }


        private var climateDefrozeStartValue:Boolean = false
        private fun climateDefrozeWorker(){
            if (climateOutTemperature > -70.0 && climateIntTemperature > -70.0 && ignitionStateValue == IGNITION_STATE_DRIVING) {
                if (!climateDefrozeStartValue) {
                    climateDefrozeStartValue = true
                    climateDefrozeTimestamp = System.currentTimeMillis()
                    if(climateDefrozeTempCfg != -100.0 && (climateOutTemperature <= climateDefrozeTempCfg) && (climateIntTemperature < 21.0))
                    {
                        sendMessageToUI(IdNames.TOAST, "HVAC_FUNC_DEFROST_FRONT, v: 1")
                        setFunctionValueNoChecked(HVAC_FUNC_DEFROST_FRONT, 1)
                    }
                    if(climateDefrozeRearTempCfg != -100.0 && (climateOutTemperature <= climateDefrozeRearTempCfg) && (climateIntTemperature < 21.0))
                    {
                        sendMessageToUI(IdNames.TOAST, "HVAC_FUNC_DEFROST_REAR, v: 1")
                        setFunctionValueNoChecked(HVAC_FUNC_DEFROST_REAR, 1)
                    }
                }
                if(climateDefrozePeriodCfg > 10){ //必须大于10分钟
                    if((climateOutTemperature <= climateDefrozePeriodTempCfg) && climateDefrozePeriodTempCfg != -100.0 && (System.currentTimeMillis() - climateDefrozeTimestamp >= (climateDefrozePeriodCfg*60*1000))){
                        climateDefrozeTimestamp = System.currentTimeMillis()
                        sendMessageToUI(IdNames.TOAST, "HVAC_FUNC_DEFROST_FRONT, v: 1")
                        setFunctionValueNoChecked(HVAC_FUNC_DEFROST_FRONT, 1)
                    }
                }else {
                        climateDefrozeTimestamp = System.currentTimeMillis()
                 }
            }
        }

        private var climateSeatDrLevelCfgCurrent:Int = -1
        private var climateSeatDrLevelCfgCurrent1:Int = -1
        private var climateSeatDrValue:Int = -1
        private var climateSeatDrFirstFlag:AtomicBoolean = AtomicBoolean(true)
        private var climateSeatDrTimestamp = System.currentTimeMillis()
        private var climateSeatDrBlock:Boolean = false
        private var climateSeatDrIntActiveFlag:Boolean = false
        private var climateSeatDrOutFlag:Boolean = false

        private var climateSeatPassLevelCfgCurrent:Int = -1
        private var climateSeatPassLevelCfgCurrent1:Int = -1
        private var climateSeatPassValue:Int = -1
        private var climateSeatPassFirstFlag:AtomicBoolean = AtomicBoolean(true)
        private var climateSeatPassTimestamp = System.currentTimeMillis()
        private var climateSeatPassBlock:Boolean = false

        private var climateSeatPassIntActiveFlag:Boolean = false
        private var climateSeatPassOutFlag:Boolean = false

        private fun climateSeatWorkerReinit(){
            synchronized(lockObject)
            {
                climateSeatDrLevelCfgCurrent = -1
                climateSeatDrFirstFlag.set(true)
                climateSeatDrValue = -1
                climateSeatDrOutFlag = false
                climateSeatDrLevelCfgCurrent = -1
                climateSeatPassFirstFlag.set(true)
                climateSeatPassValue = -1
                climateSeatPassOutFlag = false
            }
        }

        private fun climateSeatWorker(){
            if (ignitionStateValue == IGNITION_STATE_DRIVING && climateIntTemperature > -70.0 && climateOutTemperature > -70.0){
                //主驾加热
                if(!climateSeatDrBlock && climateSeatDrValue != -1) {
                    climateSeatDrIntActiveFlag = false
                    if (climateIntTemperaturePresent.get() && climateOutTemperaturePresent.get() && climateSeatDrFirstFlag.get() && (climateSeatDrLevelCfg != ItemsClimateSeatModes.NOT_USED.value || climateSeatDrLevel1Cfg != ItemsClimateSeatModes.NOT_USED.value || climateSeatDrLevelOutCfg != ItemsClimateSeatModes.NOT_USED.value)) {
                        var climateSeatDrIntTempMax = climateSeatDrIntTempCfg
                        var climateSeatDrIntTempMin = climateSeatDrIntTemp1Cfg
                        var climateSeatDrIntLevelMax = climateSeatDrLevelCfg
                        var climateSeatDrIntLevelMin = climateSeatDrLevel1Cfg
                        if (climateSeatDrIntTempMax > climateSeatDrIntTempMin) {
                            climateSeatDrIntTempMax = climateSeatDrIntTemp1Cfg
                            climateSeatDrIntTempMin = climateSeatDrIntTempCfg
                            climateSeatDrIntLevelMax = climateSeatDrLevel1Cfg
                            climateSeatDrIntLevelMin = climateSeatDrLevelCfg
                        }

                        //如果超过上限，则
                        if (climateIntTemperature < climateSeatDrIntTempMax && climateSeatDrIntLevelMax != ItemsClimateSeatModes.NOT_USED.value) {
                            climateSeatDrOutFlag = false
                            if (climateSeatDrValue != climateSeatDrIntLevelMax) {
                                synchronized(lockObject)
                                {
                                    climateSeatDrValue = climateSeatDrIntLevelMax
                                    climateSeatDrTimestamp = System.currentTimeMillis()
                                    climateSeatDrLevelCfgCurrent = climateSeatDrIntLevelMax
                                    climateSeatDrLevelCfgCurrent1 = climateSeatDrIntLevelMax
                                }
                                sendMessageToUI(IdNames.TOAST, "HVAC_FUNC_SEAT_HEATING, Driver, v: $climateSeatDrIntLevelMax")
                                climateSeatHeatDrBlockFlag.set(true)
                                Handler(ht!!.looper).postDelayed({
                                    climateSeatHeatDrBlockFlag.set(false)
                                }, 3000)
                                setFunctionValueReadChecked(HVAC_FUNC_SEAT_HEATING,1,climateSeatDrIntLevelMax)
                            }
                        }
                        //否则，如果比上限低1度以内，或未使用上限，则
                        else if ((climateIntTemperature > (climateSeatDrIntTempMax + 2.0)) || climateSeatDrValue != climateSeatDrIntLevelMax || climateSeatDrIntLevelMax == ItemsClimateSeatModes.NOT_USED.value) {
                            //Е如果超过下限，则
                            if (climateIntTemperature < climateSeatDrIntTempMin && climateSeatDrIntLevelMin != ItemsClimateSeatModes.NOT_USED.value) {
                                climateSeatDrOutFlag = false
                                if (climateSeatDrValue != climateSeatDrIntLevelMin) {
                                    synchronized(lockObject)
                                    {
                                        climateSeatDrValue = climateSeatDrIntLevelMin
                                        climateSeatDrLevelCfgCurrent = climateSeatDrIntLevelMin
                                        climateSeatDrLevelCfgCurrent1 = climateSeatDrIntLevelMin
                                        climateSeatDrTimestamp = System.currentTimeMillis()
                                    }
                                    sendMessageToUI(IdNames.TOAST, "HVAC_FUNC_SEAT_HEATING, Driver, v: $climateSeatDrIntLevelMin")
                                    climateSeatHeatDrBlockFlag.set(true)
                                    Handler(ht!!.looper).postDelayed({
                                        climateSeatHeatDrBlockFlag.set(false)
                                    }, 3000)
                                    setFunctionValueReadChecked(HVAC_FUNC_SEAT_HEATING,1,climateSeatDrIntLevelMin)
                                }
                            } else if ((climateIntTemperature > (climateSeatDrIntTempMin + 3.0)) || (climateSeatDrValue == SEAT_HEATING_OFF) || (climateSeatDrIntLevelMax != ItemsClimateSeatModes.NOT_USED.value && climateSeatDrIntLevelMin == ItemsClimateSeatModes.NOT_USED.value)) {
                                climateSeatDrIntActiveFlag = true
                            }
                        }

                        if (climateSeatDrIntActiveFlag || (climateSeatDrIntLevelMax == ItemsClimateSeatModes.NOT_USED.value && climateSeatDrIntLevelMin == ItemsClimateSeatModes.NOT_USED.value)) {
                            if ((climateOutTemperature <= climateSeatDrOutTempCfg) && climateSeatDrLevelOutCfg != ItemsClimateSeatModes.NOT_USED.value) {
                                climateSeatDrOutFlag = true
                                if (climateSeatDrValue != climateSeatDrLevelOutCfg) {
                                    synchronized(lockObject)
                                    {
                                        climateSeatDrValue = climateSeatDrLevelOutCfg
                                        climateSeatDrTimestamp = System.currentTimeMillis()
                                        climateSeatDrLevelCfgCurrent = climateSeatDrLevelOutCfg
                                        climateSeatDrLevelCfgCurrent1 = climateSeatDrLevelOutCfg
                                    }
                                    sendMessageToUI(IdNames.TOAST, "HVAC_FUNC_SEAT_HEATING, Driver, v: $climateSeatDrLevelOutCfg")
                                    climateSeatHeatDrBlockFlag.set(true)
                                    Handler(ht!!.looper).postDelayed({
                                        climateSeatHeatDrBlockFlag.set(false)
                                    }, 3000)
                                    setFunctionValueReadChecked(HVAC_FUNC_SEAT_HEATING,1,climateSeatDrLevelOutCfg)
                                }
                            } else if (((climateOutTemperature > (climateSeatDrOutTempCfg + 2.0)) && climateSeatDrValue != SEAT_HEATING_OFF) || !climateSeatDrOutFlag || (climateSeatDrLevelOutCfg == ItemsClimateSeatModes.NOT_USED.value)) {

                                climateSeatDrTimestamp = System.currentTimeMillis()
                                if(climateSeatDrValue != SEAT_HEATING_OFF) {
                                    synchronized(lockObject)
                                    {
                                        climateSeatDrValue = SEAT_HEATING_OFF
                                        climateSeatDrLevelCfgCurrent = SEAT_HEATING_OFF
                                    }
                                    sendMessageToUI(IdNames.TOAST, "HVAC_FUNC_SEAT_HEATING, Driver, v: $SEAT_HEATING_OFF")
                                    climateSeatHeatDrBlockFlag.set(true)
                                    Handler(ht!!.looper).postDelayed({
                                        climateSeatHeatDrBlockFlag.set(false)
                                    }, 3000)
                                    setFunctionValueReadChecked(HVAC_FUNC_SEAT_HEATING,1,SEAT_HEATING_OFF)
                                }
                            }
                        }

                        if (System.currentTimeMillis() - climateSeatDrTimestamp >= 28 * 60 * 1000) {
                            climateSeatDrTimestamp = System.currentTimeMillis()
                            if (isICarFunctionAvailable(HVAC_FUNC_SEAT_HEATING, 1)) {
                                if (getFunctionValue(
                                        HVAC_FUNC_SEAT_HEATING,
                                        1
                                    ) != SEAT_HEATING_OFF
                                ) {
                                    synchronized(lockObject)
                                    {
                                        climateSeatDrValue = SEAT_HEATING_OFF
                                        climateSeatDrLevelCfgCurrent = SEAT_HEATING_OFF
                                    }
                                    climateSeatHeatDrBlockFlag.set(true)
                                    Handler(ht!!.looper).postDelayed({
                                        climateSeatHeatDrBlockFlag.set(false)
                                    }, 3000)
                                    for(i in 0 until 2) {
                                        sendMessageToUI(IdNames.TOAST, "HVAC_FUNC_SEAT_HEATING, Driver, v: $SEAT_HEATING_OFF")
                                        setFunctionValue(
                                            HVAC_FUNC_SEAT_HEATING,
                                            1,
                                            SEAT_HEATING_OFF
                                        )
                                        Thread.sleep(300)
                                        if (getFunctionValue(HVAC_FUNC_SEAT_HEATING,1) == SEAT_HEATING_OFF) {
                                            break;
                                        }
                                    }
                                    climateSeatDrBlock = true
                               //     sendMessageToUI(IdNames.TOAST, "climateSeatDrOff 14min")
                                    Handler(ht!!.looper).postDelayed({
                                        climateSeatDrBlock = false
                                        if (climateSeatDrLevelCfgCurrent1 != -1 && isICarFunctionAvailable(
                                                HVAC_FUNC_SEAT_HEATING,
                                                1
                                            )
                                        ) {
                                            synchronized(lockObject)
                                            {
                                                climateSeatDrValue = climateSeatDrLevelCfgCurrent1
                                                climateSeatDrLevelCfgCurrent = climateSeatDrLevelCfgCurrent1
                                                climateSeatDrTimestamp = System.currentTimeMillis()
                                            }
                                            sendMessageToUI(IdNames.TOAST, "HVAC_FUNC_SEAT_HEATING, Driver, v: $climateSeatDrLevelCfgCurrent1")
                                            climateSeatHeatDrBlockFlag.set(true)
                                            Handler(ht!!.looper).postDelayed({
                                                climateSeatHeatDrBlockFlag.set(false)
                                            }, 3000)
                                            setFunctionValueReadChecked(HVAC_FUNC_SEAT_HEATING,1,climateSeatDrLevelCfgCurrent1)
                                        }
                                    }, 7000)
                                }
                            }
                        }
                    }
                }
                //副驾座椅加热
                if(!climateSeatPassBlock && climateSeatPassValue != -1) {
                    climateSeatPassIntActiveFlag = false
                    if (climateIntTemperaturePresent.get() && climateOutTemperaturePresent.get() && climateSeatPassFirstFlag.get() && (climateSeatPassLevelCfg != ItemsClimateSeatModes.NOT_USED.value || climateSeatPassLevel1Cfg != ItemsClimateSeatModes.NOT_USED.value)) {
                        var climateSeatPassIntTempMax = climateSeatPassIntTempCfg
                        var climateSeatPassIntTempMin = climateSeatPassIntTemp1Cfg
                        var climateSeatPassIntLevelMax = climateSeatPassLevelCfg
                        var climateSeatPassIntLevelMin = climateSeatPassLevel1Cfg
                        if (climateSeatPassIntTempMax > climateSeatPassIntTempMin) {
                            climateSeatPassIntTempMax = climateSeatPassIntTemp1Cfg
                            climateSeatPassIntTempMin = climateSeatPassIntTempCfg
                            climateSeatPassIntLevelMax = climateSeatPassLevel1Cfg
                            climateSeatPassIntLevelMin = climateSeatPassLevelCfg
                        }

                        //如果超过上限，则
                        if (climateIntTemperature < climateSeatPassIntTempMax && climateSeatPassIntLevelMax != ItemsClimateSeatModes.NOT_USED.value) {
                            if (climateSeatPassValue != climateSeatPassIntLevelMax) {
                                synchronized(lockObject)
                                {
                                    climateSeatPassValue = climateSeatPassIntLevelMax
                                    climateSeatPassLevelCfgCurrent = climateSeatPassIntLevelMax
                                    climateSeatPassLevelCfgCurrent1 = climateSeatPassIntLevelMax
                                }
                                climateSeatPassTimestamp = System.currentTimeMillis()
                                sendMessageToUI(IdNames.TOAST, "HVAC_FUNC_SEAT_HEATING, Passenger, v: $climateSeatPassIntLevelMax")
                                climateSeatHeatPassBlockFlag.set(true)
                                Handler(ht!!.looper).postDelayed({
                                    climateSeatHeatPassBlockFlag.set(false)
                                }, 3000)
                                setFunctionValueReadChecked( HVAC_FUNC_SEAT_HEATING,4,climateSeatPassIntLevelMax)
                            }
                        }
                        //否则，如果比上限低1度以内，或未使用上限，则
                        else if ((climateIntTemperature > (climateSeatPassIntTempMax + 2.0)) || climateSeatPassValue != climateSeatPassIntLevelMax || climateSeatPassIntLevelMax == ItemsClimateSeatModes.NOT_USED.value) {
                            //如果超过下限，则
                            if (climateIntTemperature < climateSeatPassIntTempMin && climateSeatPassIntLevelMin != ItemsClimateSeatModes.NOT_USED.value) {
                                if (climateSeatPassValue != climateSeatPassIntLevelMin) {
                                    synchronized(lockObject)
                                    {
                                        climateSeatPassValue = climateSeatPassIntLevelMin
                                        climateSeatPassLevelCfgCurrent = climateSeatPassIntLevelMin
                                        climateSeatPassLevelCfgCurrent1 = climateSeatPassIntLevelMin
                                    }
                                    climateSeatPassTimestamp = System.currentTimeMillis()

                                    sendMessageToUI(IdNames.TOAST, "HVAC_FUNC_SEAT_HEATING, Passenger, v: $climateSeatPassIntLevelMin")
                                    climateSeatHeatPassBlockFlag.set(true)
                                    Handler(ht!!.looper).postDelayed({
                                        climateSeatHeatPassBlockFlag.set(false)
                                    }, 3000)
                                    setFunctionValueReadChecked(HVAC_FUNC_SEAT_HEATING,4,climateSeatPassIntLevelMin)
                                }
                            }
                            else if ((climateIntTemperature > (climateSeatPassIntTempMin + 3.0)) || (climateSeatPassValue == SEAT_HEATING_OFF) || (climateSeatPassIntLevelMax != ItemsClimateSeatModes.NOT_USED.value && climateSeatPassIntLevelMin == ItemsClimateSeatModes.NOT_USED.value)) {
                                climateSeatPassIntActiveFlag = true
                            }
                        }

                        if (climateSeatPassIntActiveFlag || (climateSeatPassIntLevelMax == ItemsClimateSeatModes.NOT_USED.value && climateSeatPassIntLevelMin == ItemsClimateSeatModes.NOT_USED.value)) {
                            if ((climateOutTemperature <= climateSeatPassOutTempCfg) && climateSeatPassLevelOutCfg != ItemsClimateSeatModes.NOT_USED.value) {
                                climateSeatPassOutFlag = true
                                if (climateSeatPassValue != climateSeatPassLevelOutCfg) {
                                    synchronized(lockObject)
                                    {
                                        climateSeatPassLevelCfgCurrent = climateSeatPassLevelOutCfg
                                        climateSeatPassLevelCfgCurrent1 = climateSeatPassLevelOutCfg
                                        climateSeatPassValue = climateSeatPassLevelOutCfg
                                        climateSeatPassTimestamp = System.currentTimeMillis()
                                    }
                                    sendMessageToUI(IdNames.TOAST, "HVAC_FUNC_SEAT_HEATING, Passenger, v: $climateSeatPassLevelOutCfg")
                                    climateSeatHeatPassBlockFlag.set(true)
                                    Handler(ht!!.looper).postDelayed({
                                        climateSeatHeatPassBlockFlag.set(false)
                                    }, 3000)
                                    setFunctionValueReadChecked(HVAC_FUNC_SEAT_HEATING,4,climateSeatPassLevelOutCfg)
                                }
                            } else if (((climateOutTemperature > (climateSeatPassOutTempCfg + 2.0)) && climateSeatPassValue != SEAT_HEATING_OFF) || !climateSeatPassOutFlag || (climateSeatPassLevelOutCfg == ItemsClimateSeatModes.NOT_USED.value)) {
                                if(climateSeatPassValue != SEAT_HEATING_OFF) {
                                    sendMessageToUI(IdNames.TOAST, "HVAC_FUNC_SEAT_HEATING, Passenger, v: $SEAT_HEATING_OFF")
                                    synchronized(lockObject)
                                    {
                                        climateSeatPassValue = SEAT_HEATING_OFF
                                        climateSeatPassLevelCfgCurrent = SEAT_HEATING_OFF
                                        climateSeatPassTimestamp = System.currentTimeMillis()
                                    }
                                    climateSeatHeatPassBlockFlag.set(true)
                                    Handler(ht!!.looper).postDelayed({
                                        climateSeatHeatPassBlockFlag.set(false)
                                    }, 3000)
                                    setFunctionValueReadChecked(HVAC_FUNC_SEAT_HEATING,4,SEAT_HEATING_OFF)
                                }
                            }
                        }

                        if (System.currentTimeMillis() - climateSeatPassTimestamp >= 28 * 60 * 1000) {
                            climateSeatPassOutFlag = false
                            if (isICarFunctionAvailable(HVAC_FUNC_SEAT_HEATING, 4)) {
                                if (getFunctionValue(
                                        HVAC_FUNC_SEAT_HEATING,
                                        4
                                    ) != SEAT_HEATING_OFF
                                ) {
                                    synchronized(lockObject)
                                    {
                                        climateSeatPassTimestamp = System.currentTimeMillis()
                                        climateSeatPassLevelCfgCurrent = SEAT_HEATING_OFF
                                        climateSeatPassValue = SEAT_HEATING_OFF
                                    }
                                    climateSeatHeatPassBlockFlag.set(true)
                                    Handler(ht!!.looper).postDelayed({
                                        climateSeatHeatPassBlockFlag.set(false)
                                    }, 3000)
                                    for(i in 0 until 2) {
                                        sendMessageToUI(IdNames.TOAST, "HVAC_FUNC_SEAT_HEATING, Passenger, v: $SEAT_HEATING_OFF")
                                        setFunctionValue(
                                            HVAC_FUNC_SEAT_HEATING,
                                            4,
                                            SEAT_HEATING_OFF
                                        )
                                        Thread.sleep(300)
                                        if (getFunctionValue(HVAC_FUNC_SEAT_HEATING,4) == SEAT_HEATING_OFF) {
                                            break;
                                        }
                                    }
                                    climateSeatPassBlock = true
                                    Handler(ht!!.looper).postDelayed({
                                        if (climateSeatPassLevelCfgCurrent1!=-1 && isICarFunctionAvailable(HVAC_FUNC_SEAT_HEATING, 4)) {
                                            if (getFunctionValue(
                                                    HVAC_FUNC_SEAT_HEATING,
                                                    4
                                                ) != climateSeatPassLevelCfgCurrent1
                                            ) {
                                                synchronized(lockObject)
                                                {
                                                    climateSeatPassValue = climateSeatPassLevelCfgCurrent1
                                                    climateSeatPassLevelCfgCurrent = climateSeatPassLevelCfgCurrent1
                                                    climateSeatPassTimestamp = System.currentTimeMillis()
                                                }
                                                sendMessageToUI(IdNames.TOAST, "HVAC_FUNC_SEAT_HEATING, Passenger, v: $climateSeatPassLevelCfgCurrent1")
                                                climateSeatHeatPassBlockFlag.set(true)
                                                Handler(ht!!.looper).postDelayed({
                                                    climateSeatHeatPassBlockFlag.set(false)
                                                }, 3000)
                                                setFunctionValueReadChecked(HVAC_FUNC_SEAT_HEATING,4,climateSeatPassLevelCfgCurrent1)
                                            }
                                        }
                                        climateSeatPassBlock = false
                                    }, 7000)
                                }
                            }
                        }
                    }
                }
            }
        }

        private var climateWheelLevelCfgCurrent:Int = -1
        private var climateWheelValue:Int = -1
        private var climateWheelFirstFlag:AtomicBoolean = AtomicBoolean(true)
        private var climateWheelIntActiveFlag:Boolean = false
        private var climateWheelOutFlag:Boolean = false

        private fun climateWheelWorkerReinit(){
            synchronized(lockObject)
            {
                climateWheelValue = -1
                climateWheelLevelCfgCurrent = -1
                climateWheelFirstFlag.set(true)
                climateWheelOutFlag = false
            }
        }

        private fun climateWheelWorker(){
            climateWheelIntActiveFlag = false
            if (ignitionStateValue == IGNITION_STATE_DRIVING && climateIntTemperature > -70.0 && climateOutTemperature > -70.0){
                //方向盘加热
                if (climateWheelValue != -1) {
                    if (climateIntTemperaturePresent.get() && climateOutTemperaturePresent.get() && climateWheelFirstFlag.get() && (climateWheelLevelCfg != ItemsClimateWheelModes.NOT_USED.value || climateWheelLevel1Cfg != ItemsClimateWheelModes.NOT_USED.value || climateWheelLevelOutCfg != ItemsClimateWheelModes.NOT_USED.value)) {
                        var climateWheelIntTempMax = climateWheelIntTempCfg
                        var climateWheelIntTempMin = climateWheelIntTemp1Cfg
                        var climateWheelIntLevelMax = climateWheelLevelCfg
                        var climateWheelIntLevelMin = climateWheelLevel1Cfg
                        if (climateWheelIntTempMax > climateWheelIntTempMin) {
                            climateWheelIntTempMax = climateWheelIntTemp1Cfg
                            climateWheelIntTempMin = climateWheelIntTempCfg
                            climateWheelIntLevelMax = climateWheelLevel1Cfg
                            climateWheelIntLevelMin = climateWheelLevelCfg
                        }

                        //如果超过上限，则
                        if (climateIntTemperature < climateWheelIntTempMax && climateWheelIntLevelMax != ItemsClimateWheelModes.NOT_USED.value) {
                            climateWheelOutFlag = false
                            if (climateWheelValue != climateWheelIntLevelMax) {
                                synchronized(lockObject)
                                {
                                    climateWheelValue = climateWheelIntLevelMax
                                    climateWheelLevelCfgCurrent = climateWheelIntLevelMax
                                }
                                sendMessageToUI(IdNames.TOAST, "HVAC_FUNC_STEERING_WHEEL_HEAT, v: $climateWheelIntLevelMax")
                                climateWheelHeatPassBlockFlag.set(true)
                                Handler(ht!!.looper).postDelayed({
                                    climateWheelHeatPassBlockFlag.set(false)
                                }, 3000)
                                setFunctionValueReadChecked(HVAC_FUNC_STEERING_WHEEL_HEAT,climateWheelIntLevelMax)
                            }
                        }
                        //否则，如果比上限低1度以内，或未使用上限，则
                        else if ((climateIntTemperature > (climateWheelIntTempMax + 2.0)) || climateWheelValue != climateWheelIntLevelMax || climateWheelIntLevelMax == ItemsClimateWheelModes.NOT_USED.value) {
                            //如果超过下限，则
                            if (climateIntTemperature < climateWheelIntTempMin && climateWheelIntLevelMin != ItemsClimateWheelModes.NOT_USED.value) {
                                climateWheelOutFlag = false
                                if (climateWheelValue != climateWheelIntLevelMin) {
                                    synchronized(lockObject)
                                    {
                                        climateWheelValue = climateWheelIntLevelMin
                                        climateWheelLevelCfgCurrent = climateWheelIntLevelMin
                                    }
                                    sendMessageToUI(IdNames.TOAST, "HVAC_FUNC_STEERING_WHEEL_HEAT, v: $climateWheelIntLevelMin")
                                    climateWheelHeatPassBlockFlag.set(true)
                                    Handler(ht!!.looper).postDelayed({
                                        climateWheelHeatPassBlockFlag.set(false)
                                    }, 3000)
                                    setFunctionValueReadChecked(HVAC_FUNC_STEERING_WHEEL_HEAT,climateWheelIntLevelMin)
                                }
                            } else if ((climateIntTemperature > (climateWheelIntTempMin + 3.0)) || (climateWheelValue == STEERING_WHEEL_HEAT_OFF) || (climateWheelIntLevelMax != ItemsClimateWheelModes.NOT_USED.value && climateWheelIntLevelMin == ItemsClimateSeatModes.NOT_USED.value)) {
                                climateWheelIntActiveFlag = true
                            }
                        }

                        if (climateWheelIntActiveFlag || (climateWheelIntLevelMax == ItemsClimateWheelModes.NOT_USED.value && climateWheelIntLevelMin == ItemsClimateWheelModes.NOT_USED.value)) {
                            if (climateOutTemperature <= climateWheelOutTempCfg && climateWheelLevelOutCfg != ItemsClimateWheelModes.NOT_USED.value) {
                                climateWheelOutFlag = true
                                if (climateWheelValue != climateWheelLevelOutCfg) {
                                    synchronized(lockObject)
                                    {
                                        climateWheelLevelCfgCurrent = climateWheelLevelOutCfg
                                        climateWheelValue = climateWheelLevelOutCfg
                                    }
                                    sendMessageToUI(IdNames.TOAST, "HVAC_FUNC_STEERING_WHEEL_HEAT, v: $climateWheelLevelOutCfg")
                                    climateWheelHeatPassBlockFlag.set(true)
                                    Handler(ht!!.looper).postDelayed({
                                        climateWheelHeatPassBlockFlag.set(false)
                                    }, 3000)
                                    setFunctionValueReadChecked(HVAC_FUNC_STEERING_WHEEL_HEAT, climateWheelLevelOutCfg)
                                }
                            } else if (((climateOutTemperature > (climateWheelOutTempCfg + 2.0)) && climateWheelValue != STEERING_WHEEL_HEAT_OFF) || !climateWheelOutFlag || (climateWheelLevelOutCfg == ItemsClimateWheelModes.NOT_USED.value)) {
                                if (climateWheelValue != STEERING_WHEEL_HEAT_OFF) {
                                    synchronized(lockObject)
                                    {
                                        climateWheelValue = STEERING_WHEEL_HEAT_OFF
                                        climateWheelLevelCfgCurrent = STEERING_WHEEL_HEAT_OFF
                                    }
                                    sendMessageToUI(IdNames.TOAST, "HVAC_FUNC_STEERING_WHEEL_HEAT, v: $STEERING_WHEEL_HEAT_OFF")
                                    climateWheelHeatPassBlockFlag.set(true)
                                    Handler(ht!!.looper).postDelayed({
                                        climateWheelHeatPassBlockFlag.set(false)
                                    }, 3000)
                                    setFunctionValueReadChecked(HVAC_FUNC_STEERING_WHEEL_HEAT,STEERING_WHEEL_HEAT_OFF)
                                }
                            }
                        }
                    }
                }
            }
        }

        private var climateVentDrLevelCfgCurrent:Int = -1
        private var climateVentDrLevelCfgCurrent1:Int = -1
        private var climateVentDrValue:Int = -1
        private var climateVentDrFirstFlag:AtomicBoolean = AtomicBoolean(true)
        private var climateVentDrTimestamp = System.currentTimeMillis()
        private var climateVentDrBlock:Boolean = false

        private var climateVentDrOutTempEnableFlag:Boolean = false

        private var climateVentDrCorrectionTimestamp = System.currentTimeMillis()

        private var passSeatOccupationFlag:Boolean = false
        private var climateVentPassLevelCfgCurrent:Int = -1
        private var climateVentPassLevelCfgCurrent1:Int = -1
        private var climateVentPassValue:Int = -1
        private var climateVentPassFirstFlag:AtomicBoolean = AtomicBoolean(true)
        private var climateVentPassTimestamp = System.currentTimeMillis()
        private var climateVentPassBlock:Boolean = false

        private var climateVentPassOutTempEnableFlag:Boolean = false

        private var climateVentPassCorrectionTimestamp = System.currentTimeMillis()

        private fun climateVentWorkerReinit(){
            synchronized(lockObject)
            {
                climateVentDrFirstFlag.set(true)
                if (climateVentDrValue <= 0) {
                    climateVentDrTimestamp = System.currentTimeMillis()
                }
                climateVentDrValue = -1
                climateVentDrOutTempEnableFlag = false
                climateVentPassFirstFlag.set(true)
                if (climateVentPassValue <= 0) {
                    climateVentPassTimestamp = System.currentTimeMillis()
                }
                climateVentPassValue = -1
                climateVentPassOutTempEnableFlag = false
            }
        }

        private fun climateVentWorker(){
            if (ignitionStateValue == IGNITION_STATE_DRIVING) {
                //driver vent
                if(climateVentDrValue != -1){
                    //外部温度限制
                    if (climateOutTemperature >= -70.0 && climateOutTemperature >= climateVentDrOutTempCfg) {
                        climateVentDrOutTempEnableFlag = true
                    } else if (climateOutTemperature < (climateVentDrOutTempCfg - 4.0)) {
                        climateVentDrOutTempEnableFlag = false
                    }

                    if (climateVentDrOutTempEnableFlag) {
                        if (!climateVentDrBlock) {

                            if (climateIntTemperaturePresent.get() && climateVentDrFirstFlag.get() && (climateVentDrLevelCfg != ItemsClimateVentModes.NOT_USED.value || climateVentDrLevel1Cfg != ItemsClimateVentModes.NOT_USED.value)) {

                                var climateVentDrIntTempMax = climateVentDrIntTempCfg
                                var climateVentDrIntTempMin = climateVentDrIntTemp1Cfg
                                var climateVentDrIntLevelMax = climateVentDrLevelCfg
                                var climateVentDrIntLevelMin = climateVentDrLevel1Cfg
                                if (climateVentDrIntTempMax < climateVentDrIntTempMin) {
                                    climateVentDrIntTempMax = climateVentDrIntTemp1Cfg
                                    climateVentDrIntTempMin = climateVentDrIntTempCfg
                                    climateVentDrIntLevelMax = climateVentDrLevel1Cfg
                                    climateVentDrIntLevelMin = climateVentDrLevelCfg
                                }

                                if (climateVentDrCorrectionCfg) {
                                    var climateVentDrCorrectionValue = 0.0

                                    if (System.currentTimeMillis() - climateVentDrCorrectionTimestamp >= 40 * 60 * 1000) {
                                        if (System.currentTimeMillis() - climateVentDrCorrectionTimestamp >= 80 * 60 * 1000) {
                                            climateVentDrCorrectionValue = 1.0
                                        } else {
                                            climateVentDrCorrectionValue = 2.0
                                        }
                                    }
                                    climateVentDrIntTempMax += climateVentDrCorrectionValue
                                    climateVentDrIntTempMin += climateVentDrCorrectionValue
                                }

                                //如果超过上限，则
                                if (climateIntTemperature > climateVentDrIntTempMax && climateVentDrIntLevelMax != ItemsClimateVentModes.NOT_USED.value) {
                                    if (climateVentDrValue != climateVentDrIntLevelMax) {
                                        synchronized(lockObject)
                                        {
                                            climateVentDrLevelCfgCurrent = climateVentDrIntLevelMax
                                            climateVentDrLevelCfgCurrent1 = climateVentDrIntLevelMax
                                            climateVentDrValue = climateVentDrIntLevelMax
                                            climateVentDrTimestamp = System.currentTimeMillis()
                                        }
                                        sendMessageToUI(IdNames.TOAST,"HVAC_FUNC_SEAT_VENTILATION, Driver, v: $climateVentDrIntLevelMax")
                                        climateSeatVentDrBlockFlag.set(true)
                                        Handler(ht!!.looper).postDelayed({
                                            climateSeatVentDrBlockFlag.set(false)
                                        }, 3000)
                                        setFunctionValueReadChecked(HVAC_FUNC_SEAT_VENTILATION, 1, climateVentDrIntLevelMax)
                                    }
                                }
                                //否则，如果比上限低1度以内，或未使用上限，则
                                else if ((climateIntTemperature < (climateVentDrIntTempMax - 2.0)) || climateVentDrValue != climateVentDrIntLevelMax || climateVentDrIntLevelMax == ItemsClimateVentModes.NOT_USED.value) {
                                    //如果超过下限，则
                                    if (climateIntTemperature > climateVentDrIntTempMin && climateVentDrIntLevelMin != ItemsClimateVentModes.NOT_USED.value) {
                                        if (climateVentDrValue != climateVentDrIntLevelMin) {
                                            synchronized(lockObject)
                                            {
                                                climateVentDrLevelCfgCurrent = climateVentDrIntLevelMin
                                                climateVentDrLevelCfgCurrent1 = climateVentDrIntLevelMin
                                                climateVentDrValue = climateVentDrIntLevelMin
                                                climateVentDrTimestamp = System.currentTimeMillis()
                                            }
                                            sendMessageToUI(IdNames.TOAST,"HVAC_FUNC_SEAT_VENTILATION, Driver, v: $climateVentDrIntLevelMin")
                                            climateSeatVentDrBlockFlag.set(true)
                                            Handler(ht!!.looper).postDelayed({
                                                climateSeatVentDrBlockFlag.set(false)
                                            }, 3000)
                                            setFunctionValueReadChecked(HVAC_FUNC_SEAT_VENTILATION,1,climateVentDrIntLevelMin)
                                        }
                                    } else if (((climateIntTemperature < (climateVentDrIntTempMin - 1.0)) && climateVentDrValue != SEAT_VENTILATION_OFF) || (climateVentDrIntLevelMax != ItemsClimateVentModes.NOT_USED.value && climateVentDrIntLevelMin == ItemsClimateVentModes.NOT_USED.value)) {
                                        if (climateVentDrValue != SEAT_VENTILATION_OFF) {
                                            sendMessageToUI(IdNames.TOAST,"HVAC_FUNC_SEAT_VENTILATION, Driver, v: $SEAT_VENTILATION_OFF")
                                            synchronized(lockObject)
                                            {
                                                climateVentDrValue = SEAT_VENTILATION_OFF
                                                climateVentDrLevelCfgCurrent = SEAT_VENTILATION_OFF
                                                climateVentDrTimestamp = System.currentTimeMillis()
                                            }
                                            climateSeatVentDrBlockFlag.set(true)
                                            Handler(ht!!.looper).postDelayed({
                                                climateSeatVentDrBlockFlag.set(false)
                                            }, 3000)
                                            setFunctionValueReadChecked(HVAC_FUNC_SEAT_VENTILATION,1,SEAT_VENTILATION_OFF)
                                        }
                                    }
                                }
                                if (System.currentTimeMillis() - climateVentDrTimestamp >= 28 * 60 * 1000) {
                                    climateVentDrTimestamp = System.currentTimeMillis()

                                    if (isICarFunctionAvailable(HVAC_FUNC_SEAT_VENTILATION, 1)) {
                                        if (getFunctionValue(
                                                HVAC_FUNC_SEAT_VENTILATION,
                                                1
                                            ) != SEAT_VENTILATION_OFF
                                        ) {
                                            synchronized(lockObject)
                                            {
                                                climateVentDrValue = SEAT_VENTILATION_OFF
                                                climateVentDrLevelCfgCurrent = SEAT_VENTILATION_OFF
                                            }
                                            climateSeatVentDrBlockFlag.set(true)
                                            Handler(ht!!.looper).postDelayed({
                                                climateSeatVentDrBlockFlag.set(false)
                                            }, 3000)
                                            for (i in 0 until 2) {
                                                sendMessageToUI(
                                                    IdNames.TOAST,
                                                    "HVAC_FUNC_SEAT_VENTILATION, Driver, v: $SEAT_VENTILATION_OFF"
                                                )
                                                setFunctionValue(
                                                    HVAC_FUNC_SEAT_VENTILATION,
                                                    1,
                                                    SEAT_VENTILATION_OFF
                                                )
                                                Thread.sleep(300)
                                                if (getFunctionValue(HVAC_FUNC_SEAT_VENTILATION,1) == SEAT_VENTILATION_OFF) {
                                                    break;
                                                }
                                            }
                                            climateVentDrBlock = true
                                            Handler(ht!!.looper).postDelayed({
                                                climateVentDrBlock = false
                                                if (climateVentDrLevelCfgCurrent1 != -1 && isICarFunctionAvailable(
                                                        HVAC_FUNC_SEAT_VENTILATION,
                                                        1
                                                    )
                                                ) {
                                                    if (getFunctionValue(
                                                            HVAC_FUNC_SEAT_VENTILATION,
                                                            1
                                                        ) != climateVentDrLevelCfgCurrent1
                                                    ) {
                                                        synchronized(lockObject)
                                                        {
                                                            climateVentDrValue = climateVentDrLevelCfgCurrent1
                                                            climateVentDrLevelCfgCurrent = climateVentDrLevelCfgCurrent1
                                                            climateVentDrTimestamp = System.currentTimeMillis()
                                                        }
                                                        sendMessageToUI(IdNames.TOAST,"HVAC_FUNC_SEAT_VENTILATION, Driver, v: $climateVentDrLevelCfgCurrent1")
                                                        climateSeatVentDrBlockFlag.set(true)
                                                        Handler(ht!!.looper).postDelayed({
                                                            climateSeatVentDrBlockFlag.set(false)
                                                        }, 3000)
                                                        setFunctionValueReadChecked( HVAC_FUNC_SEAT_VENTILATION,1,climateVentDrLevelCfgCurrent1)
                                                    }
                                                }
                                            }, 7000)
                                        }
                                    }
                                }
                            }
                        }
                    } else if (climateVentDrFirstFlag.get() && climateVentDrValue != SEAT_VENTILATION_OFF) {
                        climateVentDrTimestamp = System.currentTimeMillis()
                        if (climateVentDrValue != SEAT_VENTILATION_OFF) {
                            sendMessageToUI(
                                IdNames.TOAST,
                                "HVAC_FUNC_SEAT_VENTILATION, Driver, v: $SEAT_VENTILATION_OFF"
                            )
                            synchronized(lockObject)
                            {
                                climateVentDrValue = SEAT_VENTILATION_OFF
                                climateVentDrLevelCfgCurrent = SEAT_VENTILATION_OFF
                                climateVentDrLevelCfgCurrent1 = -1
                            }
                            climateSeatVentDrBlockFlag.set(true)
                            Handler(ht!!.looper).postDelayed({
                                climateSeatVentDrBlockFlag.set(false)
                            }, 3000)
                            setFunctionValueReadChecked(
                                HVAC_FUNC_SEAT_VENTILATION,
                                1,
                                SEAT_VENTILATION_OFF
                            )
                        }
                    }
                }

                //pass vent
                if(climateVentPassValue != -1) {
                    //外部温度限制
                    if (climateOutTemperature >= -70.0 && climateOutTemperature >= climateVentPassOutTempCfg) {
                        climateVentPassOutTempEnableFlag = true
                    } else if (climateOutTemperature < (climateVentPassOutTempCfg - 4.0)) {
                        climateVentPassOutTempEnableFlag = false
                    }

                    if (climateVentPassOutTempEnableFlag) {
                        if (!climateVentPassBlock) {
                            if (rpmValueNotZerro > 0 && passSeatOccupationCurrent==1) {
                                passSeatOccupationFlag = true

                                if (climateIntTemperaturePresent.get() && climateVentPassFirstFlag.get() && (climateVentPassLevelCfg != ItemsClimateVentModes.NOT_USED.value || climateVentPassLevel1Cfg != ItemsClimateVentModes.NOT_USED.value)) {
                                    var climateVentPassIntTempMax = climateVentPassIntTempCfg
                                    var climateVentPassIntTempMin = climateVentPassIntTemp1Cfg
                                    var climateVentPassIntLevelMax = climateVentPassLevelCfg
                                    var climateVentPassIntLevelMin = climateVentPassLevel1Cfg
                                    if (climateVentPassIntTempMax < climateVentPassIntTempMin) {
                                        climateVentPassIntTempMax = climateVentPassIntTemp1Cfg
                                        climateVentPassIntTempMin = climateVentPassIntTempCfg
                                        climateVentPassIntLevelMax = climateVentPassLevel1Cfg
                                        climateVentPassIntLevelMin = climateVentPassLevelCfg
                                    }

                                    if (climateVentPassCorrectionCfg) {
                                        var climateVentPassCorrectionValue = 0.0

                                        if (System.currentTimeMillis() - climateVentPassCorrectionTimestamp >= 40 * 60 * 1000) {
                                            if (System.currentTimeMillis() - climateVentPassCorrectionTimestamp >= 80 * 60 * 1000) {
                                                climateVentPassCorrectionValue = 1.0
                                            } else {
                                                climateVentPassCorrectionValue = 2.0
                                            }
                                        }

                                        climateVentPassIntTempMax += climateVentPassCorrectionValue
                                        climateVentPassIntTempMin += climateVentPassCorrectionValue
                                    }

                                    //如果超过上限，则
                                    if (climateIntTemperature > climateVentPassIntTempMax && climateVentPassIntLevelMax != ItemsClimateVentModes.NOT_USED.value) {
                                        if (climateVentPassValue != climateVentPassIntLevelMax) {
                                            synchronized(lockObject)
                                            {
                                                climateVentPassValue = climateVentPassIntLevelMax
                                                climateVentPassTimestamp = System.currentTimeMillis()
                                                climateVentPassLevelCfgCurrent = climateVentPassIntLevelMax
                                                climateVentPassLevelCfgCurrent1 = climateVentPassIntLevelMax
                                            }
                                            sendMessageToUI(IdNames.TOAST,"HVAC_FUNC_SEAT_VENTILATION, Passenger, v: $climateVentPassIntLevelMax")
                                            climateSeatVentPassBlockFlag.set(true)
                                            Handler(ht!!.looper).postDelayed({
                                                climateSeatVentPassBlockFlag.set(false)
                                            }, 3000)
                                            setFunctionValueReadChecked(HVAC_FUNC_SEAT_VENTILATION,4, climateVentPassIntLevelMax)
                                        }
                                    }
                                    //否则，如果比上限低1度以内，或未使用上限，则
                                    else if ((climateIntTemperature < (climateVentPassIntTempMax - 2.0)) || climateVentPassValue != climateVentPassIntLevelMax || climateVentPassIntLevelMax == ItemsClimateVentModes.NOT_USED.value) {
                                        //如果超过下限，则
                                        if (climateIntTemperature > climateVentPassIntTempMin && climateVentPassIntLevelMin != ItemsClimateVentModes.NOT_USED.value) {

                                            if (climateVentPassValue != climateVentPassIntLevelMin) {
                                                synchronized(lockObject)
                                                {
                                                    climateVentPassValue = climateVentPassIntLevelMin
                                                    climateVentPassLevelCfgCurrent = climateVentPassIntLevelMin
                                                    climateVentPassLevelCfgCurrent1 = climateVentPassIntLevelMin
                                                }
                                                climateVentPassTimestamp = System.currentTimeMillis()
                                                sendMessageToUI(IdNames.TOAST,"HVAC_FUNC_SEAT_VENTILATION, Passenger, v: $climateVentPassIntLevelMin")
                                                climateSeatVentPassBlockFlag.set(true)
                                                Handler(ht!!.looper).postDelayed({
                                                    climateSeatVentPassBlockFlag.set(false)
                                                }, 3000)
                                                setFunctionValueReadChecked(HVAC_FUNC_SEAT_VENTILATION,4,climateVentPassIntLevelMin)
                                            }
                                        } else if (((climateIntTemperature < (climateVentPassIntTempMin - 1.0)) && climateVentPassValue != SEAT_VENTILATION_OFF) || (climateVentPassIntLevelMax != ItemsClimateVentModes.NOT_USED.value && climateVentPassIntLevelMin == ItemsClimateVentModes.NOT_USED.value)) {
                                            climateVentPassTimestamp = System.currentTimeMillis()
                                            if (climateVentPassValue != SEAT_VENTILATION_OFF) {
                                                sendMessageToUI(IdNames.TOAST,"HVAC_FUNC_SEAT_VENTILATION, Passenger, v: $SEAT_VENTILATION_OFF")
                                                 synchronized(lockObject)
                                                {
                                                    climateVentPassValue = SEAT_VENTILATION_OFF
                                                    climateVentPassLevelCfgCurrent = SEAT_VENTILATION_OFF
                                                }
                                                climateSeatVentPassBlockFlag.set(true)
                                                Handler(ht!!.looper).postDelayed({
                                                    climateSeatVentPassBlockFlag.set(false)
                                                }, 3000)
                                                setFunctionValueReadChecked(HVAC_FUNC_SEAT_VENTILATION,4, SEAT_VENTILATION_OFF)
                                            }

                                        }
                                    }
                                    if (System.currentTimeMillis() - climateVentPassTimestamp >= 28 * 60 * 1000) {
                                        climateVentPassTimestamp = System.currentTimeMillis()

                                        if (isICarFunctionAvailable(HVAC_FUNC_SEAT_VENTILATION,4)
                                        ) {
                                            if (getFunctionValue(HVAC_FUNC_SEAT_VENTILATION, 4) != SEAT_VENTILATION_OFF) {
                                                synchronized(lockObject)
                                                {
                                                    climateVentPassValue = SEAT_VENTILATION_OFF
                                                    climateVentPassLevelCfgCurrent = SEAT_VENTILATION_OFF
                                                }
                                                climateSeatVentPassBlockFlag.set(true)
                                                Handler(ht!!.looper).postDelayed({
                                                    climateSeatVentPassBlockFlag.set(false)
                                                }, 3000)
                                                for (i in 0 until 2) {
                                                    sendMessageToUI(
                                                        IdNames.TOAST,
                                                        "HVAC_FUNC_SEAT_VENTILATION, Passenger, v: $SEAT_VENTILATION_OFF"
                                                    )
                                                    setFunctionValue(HVAC_FUNC_SEAT_VENTILATION,4,SEAT_VENTILATION_OFF)
                                                    Thread.sleep(300)
                                                    if (getFunctionValue(HVAC_FUNC_SEAT_VENTILATION,4) == SEAT_VENTILATION_OFF) {
                                                        break;
                                                    }
                                                }
                                                climateVentPassBlock = true
                                                Handler(ht!!.looper).postDelayed({
                                                    if (climateVentPassLevelCfgCurrent1 != -1 && isICarFunctionAvailable(HVAC_FUNC_SEAT_VENTILATION,4)) {
                                                        if (getFunctionValue(
                                                                HVAC_FUNC_SEAT_VENTILATION,
                                                                4
                                                            ) != climateVentPassLevelCfgCurrent1
                                                        ) {
                                                            synchronized(lockObject)
                                                            {
                                                                climateVentPassValue = climateVentPassLevelCfgCurrent1
                                                                climateVentPassLevelCfgCurrent = climateVentPassLevelCfgCurrent1
                                                                climateVentPassTimestamp = System.currentTimeMillis()
                                                            }
                                                            sendMessageToUI(
                                                                IdNames.TOAST,
                                                                "HVAC_FUNC_SEAT_VENTILATION, Passenger, v: $climateVentPassLevelCfgCurrent1"
                                                            )
                                                            climateSeatVentPassBlockFlag.set(true)
                                                            Handler(ht!!.looper).postDelayed({
                                                                climateSeatVentPassBlockFlag.set(false)
                                                            }, 3000)
                                                            setFunctionValueReadChecked(
                                                                HVAC_FUNC_SEAT_VENTILATION,
                                                                4,
                                                                climateVentPassLevelCfgCurrent1
                                                            )
                                                        }
                                                    }
                                                    climateVentPassBlock = false
                                                }, 7000)
                                            }
                                        }
                                    }
                                }
                            } else {
                                if (passSeatOccupationFlag) {
                                    passSeatOccupationFlag = false

                                    if (climateVentPassValue != SEAT_VENTILATION_OFF) {
                                        sendMessageToUI(
                                            IdNames.TOAST,
                                            "HVAC_FUNC_SEAT_VENTILATION, Passenger, v: $SEAT_VENTILATION_OFF"
                                        )
                                        synchronized(lockObject)
                                        {
                                            climateVentPassValue = SEAT_VENTILATION_OFF
                                            climateVentPassLevelCfgCurrent = SEAT_VENTILATION_OFF
                                        }
                                        climateSeatVentPassBlockFlag.set(true)
                                        Handler(ht!!.looper).postDelayed({
                                            climateSeatVentPassBlockFlag.set(false)
                                        }, 3000)
                                        setFunctionValueReadChecked(
                                            HVAC_FUNC_SEAT_VENTILATION,
                                            4,
                                            SEAT_VENTILATION_OFF
                                        )
                                    }
                                }
                                climateVentPassFirstFlag.set(true)
                                climateVentPassTimestamp = System.currentTimeMillis()
                            }
                        }
                    } else if (climateVentPassFirstFlag.get() && climateVentPassValue != SEAT_VENTILATION_OFF) {
                        climateVentPassTimestamp = System.currentTimeMillis()
                        if (climateVentPassValue != SEAT_VENTILATION_OFF) {
                            synchronized(lockObject)
                            {
                                climateVentPassValue = SEAT_VENTILATION_OFF
                                climateVentPassLevelCfgCurrent = SEAT_VENTILATION_OFF
                                climateVentPassLevelCfgCurrent1 = -1
                            }
                            climateSeatVentPassBlockFlag.set(true)
                            Handler(ht!!.looper).postDelayed({
                                climateSeatVentPassBlockFlag.set(false)
                            }, 3000)
                            setFunctionValueReadChecked(
                                HVAC_FUNC_SEAT_VENTILATION,
                                4,
                                SEAT_VENTILATION_OFF
                            )
                        }
                    }
                }
            }
        }

        private var updateHeatingAndVentValuesFlag:AtomicBoolean = AtomicBoolean(false)
        private var updateHeatingAndVentValuesCounts:Int = 0
        private var updateHeatingAndVentValuesTimeout = System.currentTimeMillis()

        private fun updateHeatingAndVentValues(){
            if(updateHeatingAndVentValuesFlag.get()){
                if(System.currentTimeMillis()-updateHeatingAndVentValuesTimeout >= 500) {
                    updateHeatingAndVentValuesTimeout = System.currentTimeMillis()
                    if (updateHeatingAndVentValuesCounts++ <= 8) {
                        sendMessageToUI(IdNames.TOAST,"IGNITION_STATE_DRIVING: updateHeatingAndVentValues")
                        if (climateSeatDrValue == -1) {
                            if (isICarFunctionAvailable(HVAC_FUNC_SEAT_HEATING, 1)) {
                                val value = getFunctionValue(HVAC_FUNC_SEAT_HEATING, 1)
                                synchronized(lockObject)
                                {
                                    climateSeatDrLevelCfgCurrent = value
                                    climateSeatDrLevelCfgCurrent1 = value
                                    climateSeatDrValue = value
                                    if (climateSeatDrValue == 0) {
                                        climateSeatDrTimestamp = System.currentTimeMillis()
                                    }
                                    climateSeatDrFirstFlag.set(true)
                                }
                            } else return
                        }

                        if (climateSeatPassValue == -1) {
                            if (isICarFunctionAvailable(HVAC_FUNC_SEAT_HEATING, 4)) {
                                val value = getFunctionValue(HVAC_FUNC_SEAT_HEATING, 4)
                                synchronized(lockObject)
                                {
                                    climateSeatPassLevelCfgCurrent = value
                                    climateSeatPassLevelCfgCurrent1 = value
                                    climateSeatPassValue = value
                                    if (climateSeatPassValue == 0) {
                                        climateSeatPassTimestamp = System.currentTimeMillis()
                                    }
                                    climateSeatPassFirstFlag.set(true)
                                }
                            } else return
                        }

                        if (climateVentDrValue == -1) {
                            if (isICarFunctionAvailable(HVAC_FUNC_SEAT_VENTILATION, 1)) {
                                val value = getFunctionValue(HVAC_FUNC_SEAT_VENTILATION, 1)
                                synchronized(lockObject)
                                {
                                    climateVentDrLevelCfgCurrent = value
                                    climateVentDrLevelCfgCurrent1 = value
                                    climateVentDrValue = value
                                    if (climateVentDrValue == 0) {
                                        climateVentDrTimestamp = System.currentTimeMillis()
                                    }
                                    climateVentDrFirstFlag.set(true)
                                }
                            } else return
                        }

                        if (climateVentPassValue == -1) {
                            if (isICarFunctionAvailable(HVAC_FUNC_SEAT_VENTILATION, 4)) {
                                val value = getFunctionValue(HVAC_FUNC_SEAT_VENTILATION, 4)
                                synchronized(lockObject)
                                {
                                    climateVentPassLevelCfgCurrent = value
                                    climateVentPassLevelCfgCurrent1 = value
                                    climateVentPassValue = value
                                    if (climateVentPassValue == 0) {
                                        climateVentPassTimestamp = System.currentTimeMillis()
                                    }
                                    climateVentPassFirstFlag.set(true)
                                }
                            }
                        }

                        if (climateWheelValue == -1) {
                            if (isICarFunctionAvailable(HVAC_FUNC_STEERING_WHEEL_HEAT)) {
                                val value = getFunctionValue(HVAC_FUNC_STEERING_WHEEL_HEAT)
                                synchronized(lockObject)
                                {
                                    climateWheelLevelCfgCurrent = value
                                    climateWheelValue = value
                                    climateWheelFirstFlag.set(true)
                                }
                            } else return
                        }
                        updateHeatingAndVentValuesFlag.set(false)
                    }
                }
            }else{
                updateHeatingAndVentValuesTimeout = System.currentTimeMillis()
            }
        }

        private fun onIgnitionStateChanged(i2: Int):String{
            val s:String = when (i2)  {
                IGNITION_STATE_ACC -> {"IGNITION_STATE_ACC"}
                IGNITION_STATE_DRIVING -> {"IGNITION_STATE_DRIVING" }
                IGNITION_STATE_LOCK -> {"IGNITION_STATE_LOCK"}
                IGNITION_STATE_OFF -> {"IGNITION_STATE_OFF"}
                IGNITION_STATE_ON -> {"IGNITION_STATE_ON"}
                IGNITION_STATE_START -> {"IGNITION_STATE_START"}
                else -> {"IGNITION_STATE_UNDEFINED"}
            }
            return s
        }

        private fun onSeatOccupationStateChanged(i2: Int):String{
            val s:String = when (i2) {
                SEAT_OCCUPATION_STATUS_FAULT  -> {"STATUS_FAULT"}
                SEAT_OCCUPATION_STATUS_NONE  -> {"STATUS_NONE"}
                SEAT_OCCUPATION_STATUS_OCCUPIED  -> {"STATUS_OCCUPIED"}
                else -> {"STATUS_UNDEFINED"}
            }
            return s
        }

        private fun onGearStateChanged(i2: Int):String{
            val s:String = when (i2) {
                GEAR_DRIVE  -> {"DRIVE"}
                GEAR_EIGHTH  -> {"EIGHTH"}
                GEAR_FIFTH  -> {"FIFTH"}
                GEAR_FIRST  -> {"FIRST"}
                GEAR_FOURTH  -> {"FOURTH"}
                GEAR_NEUTRAL  -> {"NEUTRAL"}
                GEAR_NINTH  -> {"NINTH"}
                GEAR_PARK  -> {"PARK"}
                GEAR_REVERSE  -> {"REVERSE"}
                GEAR_SECOND  -> {"SECOND"}
                GEAR_SEVENTH  -> {"SEVENTH"}
                GEAR_SIXTH  -> {"SIXTH"}
                GEAR_TENTH  -> {"TENTH"}
                GEAR_THIRD  -> {"THIRD"}
                GEAR_UNKNOWN  -> {"UNKNOWN"}
                else -> {"UNDEFINED"}
            }
            return s
        }

        private var ignitionDrivingValue:Int = -1
        private var ignitionStateWasNotDrivingFlag:Boolean = true
        private var passDisplayDoorOpened:AtomicBoolean = AtomicBoolean(true) // for display off at start
        private var climateStartWasONFlag:Boolean = false


        private inner class ISensorListenerClass : ISensorListener
        {
            override fun onSensorEventChanged(i: Int, i2: Int) {
                var s:String = ""
                var what:Int=0
                when (i) {
                    SENSOR_TYPE_IGNITION_STATE -> {
                        what = IdNames.IGNITION_STATE
                        s = onIgnitionStateChanged(i2)
                        try{
                            climateOffBlockFlag.set(true)
                            if (i2 == IGNITION_STATE_DRIVING) {
                                val sUpTime = SystemClock.uptimeMillis()
                                var tm:Long = 3000
                                if(sUpTime<20000){
                                    tm = 20000-sUpTime
                                    if(tm<5000){
                                        tm = 5000
                                    }
                                }
                                Handler(ht!!.looper).postDelayed({
                                    climateOffBlockFlag.set(false)
                                }, tm)

                                if (climateStartWasONFlag) {
                                    climateStartWasONFlag = false
                                    climateStartValue.set(false)
                                }
                                ignitionDrivingValue = i2
                                if (panoramaCurtainStartFlag == 1) {
                                    panoramaCurtainStartFlag = 0
                                }
                                if (ignitionStateWasNotDrivingFlag) {
                                    ignitionStateWasNotDrivingFlag = false
                                    updateHeatingAndVentValuesCounts = 0
                                    updateHeatingAndVentValuesTimeout = System.currentTimeMillis()
                                    updateHeatingAndVentValuesFlag.set(true)
                                }
                            } else {
                                ignitionStateWasNotDrivingFlag = true
                                climateSeatWorkerReinit()
                                climateWheelWorkerReinit()
                                climateVentWorkerReinit()
                            }
                            if (i2 != IGNITION_STATE_OFF) {
                                handlerIgnitionDriverDelay?.postDelayed({
                                    ignitionStateValue = i2
                                }, 1000)
                                handlerWindowScreenServicePos?.removeCallbacksAndMessages(null)
                            } else {
                                handlerIgnitionDriverDelay?.removeCallbacksAndMessages(null)
                                ignitionStateValue = i2
                            }
                            if (i2 == IGNITION_STATE_LOCK) {
                                climateStartWasONFlag = false
                                Handler(ht!!.looper).postDelayed({
                                    climateStartValue.set(false)
                                    autoholdFuncValue = -1
                                    autoholdFuncTimestamp = System.currentTimeMillis()
                                    startstopFuncValue = -1
                                }, 500)
                            } else if (i2 == IGNITION_STATE_ON) {
                                climateStartWasONFlag = true
                                Handler(ht!!.looper).postDelayed({
                                    climateStartValue.set(false)
                                    autoholdFuncValue = -1
                                    startstopFuncValue = -1
                                    ignitionDrivingValue = -1
                                }, 500)
                            } else if (i2 == IGNITION_STATE_OFF) {
                                climateStartWasONFlag = false
                                Handler(ht!!.looper).postDelayed({
                                    climateStartValue.set(false)
                                    autoholdFuncValue = -1
                                    autoholdFuncTimestamp = System.currentTimeMillis()
                                    startstopFuncValue = -1
                                }, 500)

                                if (ignitionDrivingValue == IGNITION_STATE_DRIVING) {
                                    panoramaCurtainStartFlag = 1
                                }
                                if (windowScreenServicePosCfg) {
                                    if (ignitionDrivingValue == IGNITION_STATE_DRIVING) {
                                        handlerWindowScreenServicePos?.postDelayed({
                                            sendMessageToUI(
                                                IdNames.TOAST,
                                                "SETTING_FUNC_WINDSCREEN_SERVICE_POSITION, v: 1"
                                            )
                                            setFunctionValue(
                                                SETTING_FUNC_WINDSCREEN_SERVICE_POSITION,
                                                1
                                            )
                                        }, 3000)
                                    }
                                }
                                ignitionDrivingValue = -1
                            }
                        }catch(_:Exception){}
                    }
                    SENSOR_TYPE_ENGINE_OIL_LEVEL -> {

                        what=IdNames.SENSOR_OIL_LEVEL
                        s = when (i2) {
                            ENGINE_OIL_LEVEL_HIGH  -> {"ENGINE_OIL_LEVEL_HIGH "}
                            ENGINE_OIL_LEVEL_LOW_1 -> {"ENGINE_OIL_LEVEL_LOW_1"}
                            ENGINE_OIL_LEVEL_LOW_2 -> {"ENGINE_OIL_LEVEL_LOW_2"}
                            ENGINE_OIL_LEVEL_OK -> {"ENGINE_OIL_LEVEL_OK"}
                            ENGINE_OIL_LEVEL_UNKNOWN -> {"ENGINE_OIL_LEVEL_UNKNOWN"}
                            else -> { // Note the block
                                "ENGINE_OIL_LEVEL_UNDEFINED"
                            }
                        }
                    }
                    SENSOR_TYPE_SEAT_OCCUPATION_STATUS_PASSENGER -> {
                        what=IdNames.SEAT_OCCUPATION_STATUS_PASSENGER
                        s=onSeatOccupationStateChanged(i2)
                        when (i2) {
                            SEAT_OCCUPATION_STATUS_FAULT  -> {passSeatOccupationChanged.set(false)}
                            SEAT_OCCUPATION_STATUS_NONE  -> {passSeatOccupationChanged.set(false)}
                            SEAT_OCCUPATION_STATUS_OCCUPIED  -> {passSeatOccupationChanged.set(true)}
                        }
                    }
                    SENSOR_TYPE_GEAR -> {
                        what=IdNames.SENSOR_TYPE_GEAR
                        s=onGearStateChanged(i2)
                        if( i2 == GEAR_REVERSE){
                            gearReversePreValue = GEAR_REVERSE
                        }else if(i2 == GEAR_PARK){
                            gearReversePreValue = -1
                        }
                        gearValue = i2;
                    }
                }
                sendMessageToUI(what, s)
            }

            override fun onSensorSupportChanged(i: Int, functionStatus: FunctionStatus?) {

            }

            override fun onSensorValueChanged(i: Int, f: Float) {

                val s:String
                val what:Int
                when (i) {
                    SENSOR_TYPE_TEMPERATURE_AMBIENT ->          {what=IdNames.AMBIENT_TEMPERATURE; s = String.format("%.1f", f); climateOutTemperatureArr[climateOutTemperatureIdx++] = (f*1000).toInt();if(climateOutTemperatureIdx>=15) {climateOutTemperatureIdx=0;climateOutTemperaturePresent.set(true);}}
                    SENSOR_TYPE_TEMPERATURE_INDOOR ->           {what=IdNames.INT_TEMPERATURE; s = String.format("%.1f", f); climateIntTemperatureArr[climateIntTemperatureIdx++] = (f*1000).toInt();if(climateIntTemperatureIdx>=15) {climateIntTemperatureIdx=0;climateIntTemperaturePresent.set(true);}}
                    SENSOR_TYPE_FUEL_LEVEL ->                   {what=IdNames.FUEL_LEVEL; s = String.format("%.1f", f/1000)}
                    SENSOR_TYPE_CAR_SPEED ->                    {what=IdNames.CAR_SPEED; s = String.format("%.1f", f*3.72); speedValueInt = (f*3.72).toInt()}
                    SENSOR_TYPE_RPM ->                          {what=IdNames.SENSOR_RPM; s = String.format("%d", f.toInt()); rpmValue = f.toInt()}
                    else -> { // Note the block
                        return
                    }
                }
                sendMessageToUI(what, s)
            }
        }


        private inner class IFunctionValueWatcherClass : ICarFunction.IFunctionValueWatcher {
            override fun onCustomizeFunctionValueChanged(i: Int, i2: Int, f: Float){

            }

            override fun onFunctionChanged(i: Int){

            }

            override fun onFunctionValueChanged(i: Int, i2: Int, i3: Int){
                when (i) {
                    SETTING_FUNC_ENGINE_STOP_START ->   {
                        if((startstopFuncCfg == ItemsOnOffPlus.ALWAYS_OFF.value || startstopFuncCfg == ItemsOnOffPlus.ALWAYS_ON.value))   {
                            startstopFuncValue = i3
                        }
                    }
                    SETTING_FUNC_AUTO_HOLD ->   {
                        if((autoholdFuncCfg == ItemsOnOffPlus.ALWAYS_OFF.value || autoholdFuncCfg == ItemsOnOffPlus.ALWAYS_ON.value)) {
                            autoholdFuncValue = i3
                        }
                    }
                    DM_FUNC_DRIVE_MODE_SELECT -> {
                        if(driveModeListenerFlag.get()) {
                            driveModeValue = i3
                            driveModeTimestamp = System.currentTimeMillis()
                        }
                    }

                    SETTING_FUNC_EMGY_LANE_KEEP_AID-> {
                        elkaValue = i3
                    }
                    IPAS.PAS_FUNC_PAC_ACTIVATION->{
                        pasFuncPacActivationValue = i3
                    }

                    HVAC_FUNC_AUTO-> {
                        if(i2 == 128) {
                            climateAuto128 = i3
                            if(i3==0) {
                                if (climateBlowingModeSavedValue128 == -1){
                                    climateBlowingModeSavedValue128 = climateStart_Mode128_Cfg
                                }
                                if (climateBlowingModeSavedValue128 != -1) {
                                    if (isICarFunctionAvailable(HVAC_FUNC_BLOWING_MODE, 128)) {
                                        if (getFunctionValue(
                                                HVAC_FUNC_BLOWING_MODE,
                                                128
                                            ) != climateBlowingModeSavedValue128
                                        ) {
                                            setFunctionValue(
                                                HVAC_FUNC_BLOWING_MODE, 128,
                                                climateBlowingModeSavedValue128
                                            )
                                        }
                                    }
                                }
                            }
                        }else {
                            climateAuto1_8 = i3
                            if(i3==0) {
                                if (climateBlowingModeSavedValue1 == -1){
                                    climateBlowingModeSavedValue1 = climateStart_Mode_Cfg
                                }
                                if(climateBlowingModeSavedValue1 != -1) {
                                    if (isICarFunctionAvailable(HVAC_FUNC_BLOWING_MODE,1)) {
                                        if(getFunctionValue(HVAC_FUNC_BLOWING_MODE, 1) != climateBlowingModeSavedValue1) {
                                            setFunctionValue(
                                                HVAC_FUNC_BLOWING_MODE, 1,
                                                climateBlowingModeSavedValue1
                                            )
                                        }
                                    }
                                }
                                if (climateBlowingModeSavedValue8 == -1){
                                    climateBlowingModeSavedValue8 = climateStart_Mode_Cfg
                                }
                                if(climateBlowingModeSavedValue8 != -1) {
                                    if (isICarFunctionAvailable(HVAC_FUNC_BLOWING_MODE,8)) {
                                        if(getFunctionValue(HVAC_FUNC_BLOWING_MODE, 8) != climateBlowingModeSavedValue8) {
                                            setFunctionValue(
                                                HVAC_FUNC_BLOWING_MODE, 8,
                                                climateBlowingModeSavedValue8
                                            )
                                        }
                                    }
                                }
                            }
                            else{
                                 if(climateGCleanCfg){
                                     Handler(ht!!.looper).postDelayed({
                                         if (isICarFunctionAvailable(HVAC_FUNC_G_CLEAN)) {
                                             setFunctionValue(
                                                 HVAC_FUNC_G_CLEAN,
                                                 1
                                             )
                                         }
                                     }, 300)
                                 }
                            }
                        }
                    }
                    HVAC_FUNC_G_CLEAN ->{
                        if(i3 == 1){
                            climateGCleanOnLast.set(true)
                            if(climateGCleanCfg){
                                if(climateGCleanSpeedLast == -1){
                                    climateGCleanSpeedLast = AUTO_FAN_SETTING_NORMAL
                                }
                                setFunctionValue(
                                    HVAC_FUNC_AUTO_FAN_SETTING, 8, climateGCleanSpeedLast
                                )
                            }
                        }else{
                            climateGCleanOnLast.set(false)
                        }
                    }
                    HVAC_FUNC_AUTO_FAN_SETTING ->{
                        if ( i2==8 && !(i3==AUTO_FAN_SETTING_QUIETER && climateGCleanOnLast.get() && climateGCleanCfg)){
                            climateGCleanSpeedLast = i3
                        }
                    }
                    HVAC_FUNC_BLOWING_MODE -> {
                        if(i2 == 128 && climateAuto128 == 0){
                            climateBlowingModeSavedValue128 = i3
                        }else if(i2 == 1 && climateAuto1_8 == 0){
                            climateBlowingModeSavedValue1 = i3
                        }else if(i2 == 8 && climateAuto1_8 == 0){
                            climateBlowingModeSavedValue8 = i3
                        }
                    }
                    HVAC_FUNC_SEAT_HEATING-> {
                        if(i2 == SEAT_ROW_1_LEFT){
                            if((!climateSeatHeatDrBlockFlag.get() && !climateOffBlockFlag.get()) || i3!=0) {
                                synchronized(lockObject)
                                {
                                    if (i3 != climateSeatDrLevelCfgCurrent && climateSeatDrLevelCfgCurrent != -1 && climateSeatDrValue >= 0 && rpmValueNotZerro > 0 && climateSeatDrValue >= 0) {
                                        climateSeatDrFirstFlag.set(false)
                                    }
                                }
                            }
                            sendMessageToUI(IdNames.TOAST, "climateSeatFirstFlag !reset: $i2 "+ climateSeatDrFirstFlag.get()+", $i3 ==? $climateSeatDrLevelCfgCurrent")
                        }else if(i2 ==  SEAT_ROW_1_RIGHT) {
                            if((!climateSeatHeatPassBlockFlag.get() && !climateOffBlockFlag.get()) || i3!=0) {
                                synchronized(lockObject)
                                {
                                    if (i3 != climateSeatPassLevelCfgCurrent && climateSeatPassLevelCfgCurrent != -1 && climateSeatPassValue >= 0 && rpmValueNotZerro > 0) {
                                        climateSeatPassFirstFlag.set(false)

                                    }
                                }
                            }
                            sendMessageToUI(IdNames.TOAST, "climateSeatFirstFlag !reset: $i2 "+ climateSeatPassFirstFlag.get()+", $i3 ==? $climateSeatPassLevelCfgCurrent")
                        }
                    }

                    HVAC_FUNC_STEERING_WHEEL_HEAT-> {
                        if((!climateWheelHeatPassBlockFlag.get() && !climateOffBlockFlag.get()) || i3!=0){
                            synchronized(lockObject)
                            {
                                if(i3!=climateWheelLevelCfgCurrent && climateWheelLevelCfgCurrent != -1 && climateWheelValue  >= 0){
                                    climateWheelFirstFlag.set(false)
                                }
                            }
                        }
                        sendMessageToUI(IdNames.TOAST, "climateWheelFirstFlag !reset: "+ climateWheelFirstFlag.get()+", $i3 ==? $climateWheelLevelCfgCurrent")
                    }

                    HVAC_FUNC_SEAT_VENTILATION-> {
                        if(i2 == 1){
                            if((!climateSeatVentDrBlockFlag.get() && !climateOffBlockFlag.get()) || i3!=0) {
                                synchronized(lockObject)
                                {
                                    if (i3 != climateVentDrLevelCfgCurrent && climateVentDrLevelCfgCurrent != -1 && climateVentDrValue >= 0) {
                                        climateVentDrFirstFlag.set(false)
                                    }
                                }
                                sendMessageToUI(IdNames.TOAST, "climateVentFirstFlag !reset: $i2 "+ climateVentDrFirstFlag.get()+", $i3 ==? $climateVentDrLevelCfgCurrent")
                            }

                        }else if(i2 == 4) {
                            if((!climateSeatVentPassBlockFlag.get() && !climateOffBlockFlag.get()) || i3!=0) {
                                synchronized(lockObject)
                                {
                                    if (i3 != climateVentPassLevelCfgCurrent && climateVentPassLevelCfgCurrent != -1 && climateVentPassValue >= 0 && rpmValueNotZerro > 0) {
                                        climateVentPassFirstFlag.set(false)
                                    }
                                }
                            }
                            sendMessageToUI(IdNames.TOAST, "climateVentFirstFlag !reset: $i2 "+ climateVentPassFirstFlag.get()+", $i3 ==? $climateVentPassLevelCfgCurrent")
                        }

                    }
                    SETTING_FUNC_PSD_SCREEN_SWITCH -> {
                        if(passDisplayOffCfg){
                            Handler(ht!!.looper).postDelayed({
                                passDisplayValue = i3
                                if(passDisplayDoorOpened.compareAndSet(true,false)){
                                    if(i3 != 0) {
                                        sendMessageToUI(IdNames.TOAST,"SETTING_FUNC_PSD_SCREEN_SWITCH, v: 0")
                                        setFunctionValueReadChecked(
                                            SETTING_FUNC_PSD_SCREEN_SWITCH,
                                            0
                                        )
                                    }
                                }
                            }, 300)
                        }else if (passDisplayOffNoPassCfg){
                            if(passSeatOccupationForDisplay >= 0){
                                Handler(ht!!.looper).postDelayed({
                                    passDisplayValue = i3
                                    if(passDisplayDoorOpened.compareAndSet(true,false)){
                                        if(i3 != 0 && passSeatOccupationForDisplay==0) {
                                            sendMessageToUI(IdNames.TOAST,"SETTING_FUNC_PSD_SCREEN_SWITCH, v: 0")
                                            setFunctionValueReadChecked(
                                                SETTING_FUNC_PSD_SCREEN_SWITCH,
                                                0
                                            )
                                        }
                                    }
                                }, 300)
                            }
                        }




//                        else if (passDisplayOffNoPassCfg){
//                            var tm:Long = 300
//                            if(passSeatOccupationForDisplay == -1){
//                                tm = 3000
//                            }
//                            Handler(ht!!.looper).postDelayed({
//                                if(passSeatOccupationForDisplay<0){
//                                    passSeatOccupationForDisplay = 0
//                                }
//                                passDisplayValue = i3
//                                if(passDisplayDoorOpened.compareAndSet(true,false)){
//                                    if(passSeatOccupationForDisplay == 0){
//                                        if(i3 != 0) {
//                                            sendMessageToUI(IdNames.TOAST,"SETTING_FUNC_PSD_SCREEN_SWITCH, v: 0")
//                                            setFunctionValueReadChecked(
//                                                SETTING_FUNC_PSD_SCREEN_SWITCH,
//                                                0
//                                            )
//                                        }
//                                    }
//                                }
//                            }, tm)
//                        }
                    }
                    BCM_FUNC_DOOR-> {
                        if (i2 == 4) {
                            if(i3==1){
                                if(passDisplayValue==0) {
                                    passDisplayDoorOpened.set(true)
                                }
                            }
                        }
                    }
                }
            }

            override fun onSupportedFunctionStatusChanged(i: Int, i2: Int, functionStatus: FunctionStatus?){

            }

            override fun onSupportedFunctionValueChanged(i: Int, iArr: IntArray?){

            }
        }
    }

}


