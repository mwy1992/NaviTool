package ru.monjaro.mconfig


class IdNames  {
    companion object {
        val ERROR:Int = -1
        val TOAST:Int = -2
        val UPDATE_UI:Int = -3
        val IGNITION_STATE: Int = 1
        val AMBIENT_TEMPERATURE: Int = 2
        val INT_TEMPERATURE: Int = 3
        val FUEL_LEVEL: Int = 4
        val CAR_SPEED: Int = 5
        val SENSOR_RPM: Int = 6
        val SENSOR_OIL_LEVEL: Int = 7
        val DRIVE_SPORT_KEYPRESSED: Int = 8
        val DRIVE_SNOW_KEYPRESSED: Int = 9
        val DRIVE_OFFROAD_KEYPRESSED: Int = 10
        val SEAT_OCCUPATION_STATUS_PASSENGER: Int = 11
        val SENSOR_TYPE_GEAR: Int = 12

        val data_string: String = "数据"
        val settings_string: String = "通用设置"
        val climate_string: String = "空调设置"
        val startApp_string: String = "应用启动"

        val StartService_key: String = "StartService"
        val startstopFuncCfg_key: String = "startstopFuncCfg"
        val autoholdFuncCfg_key: String = "autoholdFuncCfg"
        val restoreDriveMode_key: String = "restoreDriveMode"
        val elkaDisable_key: String = "elkaDisable"
        val brightnessReverse_key: String = "brightnessReverse"
        val srcKey_key: String = "srcKeyCfg"
        val srcKeyOld_key: String = "srcKeyOldCfg"
        val mediaKeys_key: String = "mediaKeysCfg"
        val voiceAssist_key: String = "voiceAssistCfg"

        val passDisplayOff_key: String = "passDisplayOff"
        val passDisplayOffNoPass_key: String = "passDisplayOffNoPass"
        val debugToast_key: String = "debugToastCfg"
        val srcClick1Cfg_key: String = "srcClick1Cfg"
        val srcApp1Cfg_key: String = "srcApp1Cfg_key"
        val srcIntent1Cfg_key: String = "srcIntent1Cfg"
        val srcIntentPackage1Cfg_key: String = "srcIntentPackage1Cfg"
        val srcClick2Cfg_key: String = "srcClick2Cfg"
        val srcApp2Cfg_key: String = "srcApp2Cfg_key"
        val srcIntent2Cfg_key: String = "srcIntent2Cfg"
        val srcIntentPackage2Cfg_key: String = "srcIntentPackage2Cfg"
        val srcClick3Cfg_key: String = "srcClick3Cfg"
        val srcApp3Cfg_key: String = "srcApp3Cfg"
        val srcIntent3Cfg_key: String = "srcIntent3Cfg"
        val srcIntentPackage3Cfg_key: String = "srcIntentPackage3Cfg"
        val srcClickLongCfg_key: String = "srcClickLongCfg"
        val srcAppLongCfg_key: String = "srcAppLongCfg"
        val srcIntentLongCfg_key: String = "srcIntentLongCfg"
        val srcIntentPackageLongCfg_key: String = "srcIntentPackageLongCfg"

        val vaClick1Cfg_key: String = "vaClick1Cfg"
        val vaApp1Cfg_key: String = "vaApp1Cfg_key"
        val vaIntent1Cfg_key: String = "vaIntent1Cfg"
        val vaIntentPackage1Cfg_key: String = "vaIntentPackage1Cfg"

        val vaClick2Cfg_key: String = "vaClick2Cfg"
        val vaApp2Cfg_key: String = "vaApp2Cfg_key"
        val vaIntent2Cfg_key: String = "vaIntent2Cfg"
        val vaIntentPackage2Cfg_key: String = "vaIntentPackage2Cfg"

        val vaClick3Cfg_key: String = "vaClick3Cfg"
        val vaApp3Cfg_key: String = "vaApp2Cfg_key"
        val vaIntent3Cfg_key: String = "vaIntent3Cfg"
        val vaIntentPackage3Cfg_key: String = "vaIntentPackage3Cfg"

        val vaClickLongCfg_key: String = "vaClickLongCfg"
        val vaAppLongCfg_key: String = "vaAppLongCfg_key"
        val vaIntentLongCfg_key: String = "vaIntentLongCfg"
        val vaIntentPackageLongCfg_key: String = "vaIntentPackageLongCfg"

        val intentDefaultAction:String = "ru.monjaro.mconfig.SRC_ACTION"
        val intentDefaultActionVA:String = "ru.monjaro.mconfig.VA_ACTION"
        val intentDefaultPackage:String = "com.arlosoft.macrodroid"

        val climateGCleanCfg_key: String = "climateGCleanCfg"

        val climateStartCfg_key: String = "climateStartCfg"
        val climateStartAutoCfg_key: String = "climateStartAutoCfg"
        val climateStart_AC_Cfg_key: String = "climateStartACCfg"
        val climateStartSpeedCfg_key: String = "climateStartSpeedCfg"
        val climateStart_Mode_Cfg_key: String = "climateStart_Mode_Cfg"
        val climateStartAuto128Cfg_key: String = "climateStartAuto128Cfg"
        val climateStart_Mode128_Cfg_key: String = "climateStart_Mode128_Cfg"

        val climateDefrozeTempCfg_key: String = "climateDefrozeTempCfg"
        val climateDefrozePeriodCfg_key: String = "climateDefrozePeriodCfg"
        val climateDefrozePeriodTempCfg_key: String = "climateDefrozePeriodTempCfg"
        val climateDefrozeRearTempCfg_key: String = "climateDefrozeRearTempCfg"
        val gearReverseSpeedCfg_key: String = "gearReverseSpeedCfg"
        val gearReverseTimeCfg_key: String = "gearReverseTimeCfg"

        val climateSeatDrLevelCfg_key: String = "climateSeatDrLevelCfg"
        val climateSeatDrIntTempCfg_key: String = "climateSeatDrIntTempCfg"
        val climateSeatDrLevel1Cfg_key: String = "climateSeatDrLevel1Cfg"
        val climateSeatDrIntTemp1Cfg_key: String = "climateSeatDrIntTemp1Cfg"
        val climateSeatDrLevelOutCfg_key: String = "climateSeatDrLevelOutCfg"
        val climateSeatDrOutTempCfg_key: String = "climateSeatDrOutTempCfg"

        val climateSeatPassLevelCfg_key: String = "climateSeatPassLevelCfg"
        val climateSeatPassIntTempCfg_key: String = "climateSeatPassIntTempCfg"
        val climateSeatPassLevel1Cfg_key: String = "climateSeatPassLevel1Cfg"
        val climateSeatPassIntTemp1Cfg_key: String = "climateSeatPassIntTemp1Cfg"
        val climateSeatPassLevelOutCfg_key: String = "climateSeatPassLevelOutCfg"
        val climateSeatPassOutTempCfg_key: String = "climateSeatPassOutTempCfg"

        val climateWheelLevelCfg_key: String = "climateWheelLevelCfg"
        val climateWheelIntTempCfg_key: String = "climateWheelIntTempCfg"
        val climateWheelLevel1Cfg_key: String = "climateWheelLevel1Cfg"
        val climateWheelIntTemp1Cfg_key: String = "climateWheelIntTemp1Cfg"
        val climateWheelLevelOutCfg_key: String = "climateWheelLevelOutCfg"
        val climateWheelOutTempCfg_key: String = "climateWheelOutTempCfg"


        val climateVentDrLevelCfg_key: String = "climateVentDrLevelCfg"
        val climateVentDrIntTempCfg_key: String = "climateVentDrIntTempCfg"
        val climateVentDrLevel1Cfg_key: String = "climateVentDrLevel1Cfg"
        val climateVentDrIntTemp1Cfg_key: String = "climateVentDrIntTemp1Cfg"
        val climateVentDrOutTempCfg_key: String = "climateVentDrOutTempCfg"
        val climateVentDrCorrectionCfg_key: String = "climateVentDrCorrectionCfg"

        val climateVentPassLevelCfg_key: String = "climateVentPassLevelCfg"
        val climateVentPassIntTempCfg_key: String = "climateVentPassIntTempCfg"
        val climateVentPassLevel1Cfg_key: String = "climateVentPassLevel1Cfg"
        val climateVentPassIntTemp1Cfg_key: String = "climateVentPassIntTemp1Cfg"
        val climateVentPassOutTempCfg_key: String = "climateVentPassOutTempCfg"
        val climateVentPassCorrectionCfg_key: String = "climateVentPassCorrectionCfg"

        val windowScreenServicePosCfg_key: String = "windowScreenServicePosCfg"
        val intelligentFuelSaveStartCfg_key: String = "intelligentFuelSaveStartCfg"
        val panoramaCurtainStartCfg_key: String = "panoramaCurtainStartCfg"

        val appsEnableStart_key: String = "appsEnableStart"
        val appStartEnable_key_: String = "appStartEnable_"
        val appStartAppName_key_: String = "appStartAppName_key_"
        val appStartActivity_key_: String = "appStartActivity_key_"
        val appStartDelay_key_: String = "appStartDelay_"
        val appStartDisplay_key_: String = "appStartDisplay_key_"

        val volumeOnStart_key: String = "volumeOnStart"


        val appStartQuantity: Int = 10
        val appStartDelayDefault: Int = 7
    }
}

enum class ItemsOnOffPlus(val value: Int) {
    NOT_USED(0),
    ALWAYS_OFF(1),
    ALWAYS_ON(2),
    ONSTART_OFF(3),
    ONSTART_ON(4),
}

enum class ItemsSrcClick(val value: Int) {
    NOT_USED(0),
    START(1),
    DRIVE_SPORT(2),
    DRIVE_SNOW(3),
    DRIVE_OFFROAD(4),
    SEND_INTENT(5),
    MULTIMEDIA_MODE(6),
    START_ON_DIM(7),
}

enum class ItemsClimateStart(val value: Int) {
    NOT_USED(0),
    ALWAYS_ON( 1),
    IF_NOT_AUTO( 2),
    IF_WAS_OFF( 3),
}

enum class ItemsClimateAC(val value: Int) {
    NOT_USED(0),
    ON(1),
    OFF(2),
}

enum class ItemsClimateAutoFan(val value: Int) {
    NOT_USED(-1),
    AUTO_FAN_SETTING_QUIETER(268567044),
    AUTO_FAN_SETTING_SILENT(268567041),
    AUTO_FAN_SETTING_NORMAL(268567042),
    AUTO_FAN_SETTING_HIGHER (268567045),
    AUTO_FAN_SETTING_HIGH(268567043),
}

enum class ItemsClimateFan(val value: Int) {
    NOT_USED(-1),
    FAN_SPEED_LEVEL_1(268566785),
    FAN_SPEED_LEVEL_2(268566786),
    FAN_SPEED_LEVEL_3(268566787),
    FAN_SPEED_LEVEL_4(268566788),
    FAN_SPEED_LEVEL_5(268566789),
    FAN_SPEED_LEVEL_6(268566790),
    FAN_SPEED_LEVEL_7(268566791),
    FAN_SPEED_LEVEL_8(268566792),
    FAN_SPEED_LEVEL_9(268566793),
    FAN_SPEED_OFF(0),
}

enum class ItemsClimateModes(val value: Int) {
    NOT_USED(-1),
    BLOWING_ALL( 268894471),
    BLOWING_MODE_LEG_AND_FRONT_WINDOW( 268894470),
    BLOWING_MODE_FACE_AND_LEG( 268894467),
    BLOWING_MODE_FACE(268894465),
    BLOWING_MODE_LEG(268894466),
    BLOWING_MODE_FRONT_WINDOW (268894468),
    BLOWING_MODE_FACE_AND_FRONT_WINDOW(268894469),
    BLOWING_MODE_AUTO_SWITCH(268894472),
    BLOWING_MODE_OFF(0)
}

enum class ItemsClimateModes128(val value: Int) {
    NOT_USED(-1),
    BLOWING_MODE_FACE_AND_LEG( 268894467),
    BLOWING_MODE_FACE(268894465),
    BLOWING_MODE_LEG(268894466),
    BLOWING_MODE_OFF(0)
}

enum class ItemsClimateDefrozePeriods(val value: Int) {
    NOT_USED(-1),
    PERIOD_15MIN(15),
    PERIOD_20MIN(20),
    PERIOD_30MIN(30),
    PERIOD_40MIN(40),
    PERIOD_60MIN(60),
}

enum class ItemsClimateSeatModes(val value: Int) {
    NOT_USED(-1),
    SEAT_HEATING_LEVEL_1(268763649),
    SEAT_HEATING_LEVEL_2(268763650),
    SEAT_HEATING_LEVEL_3(268763651),
}

enum class ItemsClimateWheelModes(val value: Int) {
    NOT_USED(-1),
    STEERING_WHEEL_HEAT_LOW(269025537),
    STEERING_WHEEL_HEAT_MID(269025538),
    STEERING_WHEEL_HEAT_HIGH(269025539),
}

enum class ItemsClimateVentModes(val value: Int) {
    NOT_USED(-1),
    SEAT_VENTILATION_LEVEL_1(268763393),
    SEAT_VENTILATION_LEVEL_2(268763394),
    SEAT_VENTILATION_LEVEL_3(268763395),
}