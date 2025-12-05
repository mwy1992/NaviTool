/*     */ package android.car;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class VehiclePropertyIds
/*     */ {
/*     */   public static final int ABS_ACTIVE = 287310858;
/*     */   public static final int AP_POWER_BOOTUP_REASON = 289409538;
/*     */   public static final int AP_POWER_STATE_REPORT = 289475073;
/*     */   public static final int AP_POWER_STATE_REQ = 289475072;
/*     */   public static final int CURRENT_GEAR = 289408001;
/*     */   public static final int DISPLAY_BRIGHTNESS = 289409539;
/*     */   public static final int DOOR_LOCK = 371198722;
/*     */   public static final int DOOR_MOVE = 373295873;
/*     */   public static final int DOOR_POS = 373295872;
/*     */   public static final int ENGINE_COOLANT_TEMP = 291504897;
/*     */   public static final int ENGINE_OIL_LEVEL = 289407747;
/*     */   public static final int ENGINE_OIL_TEMP = 291504900;
/*     */   public static final int ENGINE_RPM = 291504901;
/*     */   public static final int ENV_OUTSIDE_TEMPERATURE = 291505923;
/*     */   public static final int EV_BATTERY_INSTANTANEOUS_CHARGE_RATE = 291504908;
/*     */   public static final int EV_BATTERY_LEVEL = 291504905;
/*     */   public static final int EV_CHARGE_PORT_CONNECTED = 287310603;
/*     */   public static final int EV_CHARGE_PORT_OPEN = 287310602;
/*     */   public static final int FOG_LIGHTS_STATE = 289410562;
/*     */   public static final int FOG_LIGHTS_SWITCH = 289410578;
/*     */   public static final int FUEL_DOOR_OPEN = 287310600;
/*     */   public static final int FUEL_LEVEL = 291504903;
/*     */   public static final int FUEL_LEVEL_LOW = 287310853;
/*     */   public static final int GEAR_SELECTION = 289408000;
/*     */   public static final int HAZARD_LIGHTS_STATE = 289410563;
/*     */   public static final int HAZARD_LIGHTS_SWITCH = 289410579;
/*     */   public static final int HEADLIGHTS_STATE = 289410560;
/*     */   public static final int HEADLIGHTS_SWITCH = 289410576;
/*     */   public static final int HIGH_BEAM_LIGHTS_STATE = 289410561;
/*     */   public static final int HIGH_BEAM_LIGHTS_SWITCH = 289410577;
/*     */   public static final int HVAC_ACTUAL_FAN_SPEED_RPM = 356517135;
/*     */   public static final int HVAC_AC_ON = 354419973;
/*     */   public static final int HVAC_AUTO_ON = 354419978;
/*     */   public static final int HVAC_AUTO_RECIRC_ON = 354419986;
/*     */   public static final int HVAC_DEFROSTER = 320865540;
/*     */   public static final int HVAC_DUAL_ON = 354419977;
/*     */   public static final int HVAC_FAN_DIRECTION = 356517121;
/*     */   public static final int HVAC_FAN_DIRECTION_AVAILABLE = 356582673;
/*     */   public static final int HVAC_FAN_SPEED = 356517120;
/*     */   public static final int HVAC_MAX_AC_ON = 354419974;
/*     */   public static final int HVAC_MAX_DEFROST_ON = 354419975;
/*     */   public static final int HVAC_POWER_ON = 354419984;
/*     */   public static final int HVAC_RECIRC_ON = 354419976;
/*     */   public static final int HVAC_SEAT_TEMPERATURE = 356517131;
/*     */   public static final int HVAC_SEAT_VENTILATION = 356517139;
/*     */   public static final int HVAC_SIDE_MIRROR_HEAT = 339739916;
/*     */   public static final int HVAC_STEERING_WHEEL_HEAT = 289408269;
/*     */   public static final int HVAC_TEMPERATURE_CURRENT = 358614274;
/*     */   public static final int HVAC_TEMPERATURE_DISPLAY_UNITS = 289408270;
/*     */   public static final int HVAC_TEMPERATURE_SET = 358614275;
/*     */   public static final int HW_KEY_INPUT = 289475088;
/*     */   public static final int IGNITION_STATE = 289408009;
/*     */   public static final int INFO_DRIVER_SEAT = 356516106;
/*     */   public static final int INFO_EV_BATTERY_CAPACITY = 291504390;
/*     */   public static final int INFO_EV_CONNECTOR_TYPE = 289472775;
/*     */   public static final int INFO_EV_PORT_LOCATION = 289407241;
/*     */   public static final int INFO_FUEL_CAPACITY = 291504388;
/*     */   public static final int INFO_FUEL_DOOR_LOCATION = 289407240;
/*     */   public static final int INFO_FUEL_TYPE = 289472773;
/*     */   public static final int INFO_MAKE = 286261505;
/*     */   public static final int INFO_MODEL = 286261506;
/*     */   public static final int INFO_MODEL_YEAR = 289407235;
/*     */   public static final int INFO_VIN = 286261504;
/*     */   public static final int INVALID = 0;
/*     */   public static final int MIRROR_FOLD = 287312709;
/*     */   public static final int MIRROR_LOCK = 287312708;
/*     */   public static final int MIRROR_Y_MOVE = 339741507;
/*     */   public static final int MIRROR_Y_POS = 339741506;
/*     */   public static final int MIRROR_Z_MOVE = 339741505;
/*     */   public static final int MIRROR_Z_POS = 339741504;
/*     */   public static final int NIGHT_MODE = 287310855;
/*     */   public static final int OBD2_FREEZE_FRAME = 299896065;
/*     */   public static final int OBD2_FREEZE_FRAME_CLEAR = 299896067;
/*     */   public static final int OBD2_FREEZE_FRAME_INFO = 299896066;
/*     */   public static final int OBD2_LIVE_FRAME = 299896064;
/*     */   public static final int PARKING_BRAKE_AUTO_APPLY = 287310851;
/*     */   public static final int PARKING_BRAKE_ON = 287310850;
/*     */   public static final int PERF_ODOMETER = 291504644;
/*     */   public static final int PERF_VEHICLE_SPEED = 291504647;
/*     */   public static final int RANGE_REMAINING = 291504904;
/*     */   public static final int SEAT_BACKREST_ANGLE_1_MOVE = 356518792;
/*     */   public static final int SEAT_BACKREST_ANGLE_1_POS = 356518791;
/*     */   public static final int SEAT_BACKREST_ANGLE_2_MOVE = 356518794;
/*     */   public static final int SEAT_BACKREST_ANGLE_2_POS = 356518793;
/*     */   public static final int SEAT_BELT_BUCKLED = 354421634;
/*     */   public static final int SEAT_BELT_HEIGHT_MOVE = 356518788;
/*     */   public static final int SEAT_BELT_HEIGHT_POS = 356518787;
/*     */   public static final int SEAT_DEPTH_MOVE = 356518798;
/*     */   public static final int SEAT_DEPTH_POS = 356518797;
/*     */   public static final int SEAT_FORE_AFT_MOVE = 356518790;
/*     */   public static final int SEAT_FORE_AFT_POS = 356518789;
/*     */   public static final int SEAT_HEADREST_ANGLE_MOVE = 356518808;
/*     */   public static final int SEAT_HEADREST_ANGLE_POS = 356518807;
/*     */   public static final int SEAT_HEADREST_FORE_AFT_MOVE = 356518810;
/*     */   public static final int SEAT_HEADREST_FORE_AFT_POS = 356518809;
/*     */   public static final int SEAT_HEADREST_HEIGHT_MOVE = 356518806;
/*     */   public static final int SEAT_HEADREST_HEIGHT_POS = 289409941;
/*     */   public static final int SEAT_HEIGHT_MOVE = 356518796;
/*     */   public static final int SEAT_HEIGHT_POS = 356518795;
/*     */   public static final int SEAT_LUMBAR_FORE_AFT_MOVE = 356518802;
/*     */   public static final int SEAT_LUMBAR_FORE_AFT_POS = 356518801;
/*     */   public static final int SEAT_LUMBAR_SIDE_SUPPORT_MOVE = 356518804;
/*     */   public static final int SEAT_LUMBAR_SIDE_SUPPORT_POS = 356518803;
/*     */   public static final int SEAT_MEMORY_SELECT = 356518784;
/*     */   public static final int SEAT_MEMORY_SET = 356518785;
/*     */   public static final int SEAT_TILT_MOVE = 356518800;
/*     */   public static final int SEAT_TILT_POS = 356518799;
/*     */   public static final int TIRE_PRESSURE = 392168201;
/*     */   public static final int TRACTION_CONTROL_ACTIVE = 287310859;
/*     */   public static final int TURN_SIGNAL_STATE = 289408008;
/*     */   public static final int VEHICLE_MAP_SERVICE = 299895808;
/*     */   public static final int WHEEL_TICK = 290521862;
/*     */   public static final int WINDOW_LOCK = 320867268;
/*     */   public static final int WINDOW_MOVE = 322964417;
/*     */   public static final int WINDOW_POS = 322964416;
/*     */   
/*     */   public static String toString(int paramInt) {
/* 541 */     if (paramInt == 0) {
/* 542 */       return "INVALID";
/*     */     }
/* 544 */     if (paramInt == 286261504) {
/* 545 */       return "INFO_VIN";
/*     */     }
/* 547 */     if (paramInt == 286261505) {
/* 548 */       return "INFO_MAKE";
/*     */     }
/* 550 */     if (paramInt == 286261506) {
/* 551 */       return "INFO_MODEL";
/*     */     }
/* 553 */     if (paramInt == 289407235) {
/* 554 */       return "INFO_MODEL_YEAR";
/*     */     }
/* 556 */     if (paramInt == 291504388) {
/* 557 */       return "INFO_FUEL_CAPACITY";
/*     */     }
/* 559 */     if (paramInt == 289472773) {
/* 560 */       return "INFO_FUEL_TYPE";
/*     */     }
/* 562 */     if (paramInt == 291504390) {
/* 563 */       return "INFO_EV_BATTERY_CAPACITY";
/*     */     }
/* 565 */     if (paramInt == 289472775) {
/* 566 */       return "INFO_EV_CONNECTOR_TYPE";
/*     */     }
/* 568 */     if (paramInt == 289407240) {
/* 569 */       return "INFO_FUEL_DOOR_LOCATION";
/*     */     }
/* 571 */     if (paramInt == 289407241) {
/* 572 */       return "INFO_EV_PORT_LOCATION";
/*     */     }
/* 574 */     if (paramInt == 356516106) {
/* 575 */       return "INFO_DRIVER_SEAT";
/*     */     }
/* 577 */     if (paramInt == 291504644) {
/* 578 */       return "PERF_ODOMETER";
/*     */     }
/* 580 */     if (paramInt == 291504647) {
/* 581 */       return "PERF_VEHICLE_SPEED";
/*     */     }
/* 583 */     if (paramInt == 291504897) {
/* 584 */       return "ENGINE_COOLANT_TEMP";
/*     */     }
/* 586 */     if (paramInt == 289407747) {
/* 587 */       return "ENGINE_OIL_LEVEL";
/*     */     }
/* 589 */     if (paramInt == 291504900) {
/* 590 */       return "ENGINE_OIL_TEMP";
/*     */     }
/* 592 */     if (paramInt == 291504901) {
/* 593 */       return "ENGINE_RPM";
/*     */     }
/* 595 */     if (paramInt == 290521862) {
/* 596 */       return "WHEEL_TICK";
/*     */     }
/* 598 */     if (paramInt == 291504903) {
/* 599 */       return "FUEL_LEVEL";
/*     */     }
/* 601 */     if (paramInt == 287310600) {
/* 602 */       return "FUEL_DOOR_OPEN";
/*     */     }
/* 604 */     if (paramInt == 291504905) {
/* 605 */       return "EV_BATTERY_LEVEL";
/*     */     }
/* 607 */     if (paramInt == 287310602) {
/* 608 */       return "EV_CHARGE_PORT_OPEN";
/*     */     }
/* 610 */     if (paramInt == 287310603) {
/* 611 */       return "EV_CHARGE_PORT_CONNECTED";
/*     */     }
/* 613 */     if (paramInt == 291504908) {
/* 614 */       return "EV_BATTERY_INSTANTANEOUS_CHARGE_RATE";
/*     */     }
/* 616 */     if (paramInt == 291504904) {
/* 617 */       return "RANGE_REMAINING";
/*     */     }
/* 619 */     if (paramInt == 392168201) {
/* 620 */       return "TIRE_PRESSURE";
/*     */     }
/* 622 */     if (paramInt == 289408000) {
/* 623 */       return "GEAR_SELECTION";
/*     */     }
/* 625 */     if (paramInt == 289408001) {
/* 626 */       return "CURRENT_GEAR";
/*     */     }
/* 628 */     if (paramInt == 287310850) {
/* 629 */       return "PARKING_BRAKE_ON";
/*     */     }
/* 631 */     if (paramInt == 287310851) {
/* 632 */       return "PARKING_BRAKE_AUTO_APPLY";
/*     */     }
/* 634 */     if (paramInt == 287310853) {
/* 635 */       return "FUEL_LEVEL_LOW";
/*     */     }
/* 637 */     if (paramInt == 287310855) {
/* 638 */       return "NIGHT_MODE";
/*     */     }
/* 640 */     if (paramInt == 289408008) {
/* 641 */       return "TURN_SIGNAL_STATE";
/*     */     }
/* 643 */     if (paramInt == 289408009) {
/* 644 */       return "IGNITION_STATE";
/*     */     }
/* 646 */     if (paramInt == 287310858) {
/* 647 */       return "ABS_ACTIVE";
/*     */     }
/* 649 */     if (paramInt == 287310859) {
/* 650 */       return "TRACTION_CONTROL_ACTIVE";
/*     */     }
/* 652 */     if (paramInt == 356517120) {
/* 653 */       return "HVAC_FAN_SPEED";
/*     */     }
/* 655 */     if (paramInt == 356517121) {
/* 656 */       return "HVAC_FAN_DIRECTION";
/*     */     }
/* 658 */     if (paramInt == 358614274) {
/* 659 */       return "HVAC_TEMPERATURE_CURRENT";
/*     */     }
/* 661 */     if (paramInt == 358614275) {
/* 662 */       return "HVAC_TEMPERATURE_SET";
/*     */     }
/* 664 */     if (paramInt == 320865540) {
/* 665 */       return "HVAC_DEFROSTER";
/*     */     }
/* 667 */     if (paramInt == 354419973) {
/* 668 */       return "HVAC_AC_ON";
/*     */     }
/* 670 */     if (paramInt == 354419974) {
/* 671 */       return "HVAC_MAX_AC_ON";
/*     */     }
/* 673 */     if (paramInt == 354419975) {
/* 674 */       return "HVAC_MAX_DEFROST_ON";
/*     */     }
/* 676 */     if (paramInt == 354419976) {
/* 677 */       return "HVAC_RECIRC_ON";
/*     */     }
/* 679 */     if (paramInt == 354419977) {
/* 680 */       return "HVAC_DUAL_ON";
/*     */     }
/* 682 */     if (paramInt == 354419978) {
/* 683 */       return "HVAC_AUTO_ON";
/*     */     }
/* 685 */     if (paramInt == 356517131) {
/* 686 */       return "HVAC_SEAT_TEMPERATURE";
/*     */     }
/* 688 */     if (paramInt == 339739916) {
/* 689 */       return "HVAC_SIDE_MIRROR_HEAT";
/*     */     }
/* 691 */     if (paramInt == 289408269) {
/* 692 */       return "HVAC_STEERING_WHEEL_HEAT";
/*     */     }
/* 694 */     if (paramInt == 289408270) {
/* 695 */       return "HVAC_TEMPERATURE_DISPLAY_UNITS";
/*     */     }
/* 697 */     if (paramInt == 356517135) {
/* 698 */       return "HVAC_ACTUAL_FAN_SPEED_RPM";
/*     */     }
/* 700 */     if (paramInt == 354419984) {
/* 701 */       return "HVAC_POWER_ON";
/*     */     }
/* 703 */     if (paramInt == 356582673) {
/* 704 */       return "HVAC_FAN_DIRECTION_AVAILABLE";
/*     */     }
/* 706 */     if (paramInt == 354419986) {
/* 707 */       return "HVAC_AUTO_RECIRC_ON";
/*     */     }
/* 709 */     if (paramInt == 356517139) {
/* 710 */       return "HVAC_SEAT_VENTILATION";
/*     */     }
/* 712 */     if (paramInt == 291505923) {
/* 713 */       return "ENV_OUTSIDE_TEMPERATURE";
/*     */     }
/* 715 */     if (paramInt == 289475072) {
/* 716 */       return "AP_POWER_STATE_REQ";
/*     */     }
/* 718 */     if (paramInt == 289475073) {
/* 719 */       return "AP_POWER_STATE_REPORT";
/*     */     }
/* 721 */     if (paramInt == 289409538) {
/* 722 */       return "AP_POWER_BOOTUP_REASON";
/*     */     }
/* 724 */     if (paramInt == 289409539) {
/* 725 */       return "DISPLAY_BRIGHTNESS";
/*     */     }
/* 727 */     if (paramInt == 289475088) {
/* 728 */       return "HW_KEY_INPUT";
/*     */     }
/* 730 */     if (paramInt == 373295872) {
/* 731 */       return "DOOR_POS";
/*     */     }
/* 733 */     if (paramInt == 373295873) {
/* 734 */       return "DOOR_MOVE";
/*     */     }
/* 736 */     if (paramInt == 371198722) {
/* 737 */       return "DOOR_LOCK";
/*     */     }
/* 739 */     if (paramInt == 339741504) {
/* 740 */       return "MIRROR_Z_POS";
/*     */     }
/* 742 */     if (paramInt == 339741505) {
/* 743 */       return "MIRROR_Z_MOVE";
/*     */     }
/* 745 */     if (paramInt == 339741506) {
/* 746 */       return "MIRROR_Y_POS";
/*     */     }
/* 748 */     if (paramInt == 339741507) {
/* 749 */       return "MIRROR_Y_MOVE";
/*     */     }
/* 751 */     if (paramInt == 287312708) {
/* 752 */       return "MIRROR_LOCK";
/*     */     }
/* 754 */     if (paramInt == 287312709) {
/* 755 */       return "MIRROR_FOLD";
/*     */     }
/* 757 */     if (paramInt == 356518784) {
/* 758 */       return "SEAT_MEMORY_SELECT";
/*     */     }
/* 760 */     if (paramInt == 356518785) {
/* 761 */       return "SEAT_MEMORY_SET";
/*     */     }
/* 763 */     if (paramInt == 354421634) {
/* 764 */       return "SEAT_BELT_BUCKLED";
/*     */     }
/* 766 */     if (paramInt == 356518787) {
/* 767 */       return "SEAT_BELT_HEIGHT_POS";
/*     */     }
/* 769 */     if (paramInt == 356518788) {
/* 770 */       return "SEAT_BELT_HEIGHT_MOVE";
/*     */     }
/* 772 */     if (paramInt == 356518789) {
/* 773 */       return "SEAT_FORE_AFT_POS";
/*     */     }
/* 775 */     if (paramInt == 356518790) {
/* 776 */       return "SEAT_FORE_AFT_MOVE";
/*     */     }
/* 778 */     if (paramInt == 356518791) {
/* 779 */       return "SEAT_BACKREST_ANGLE_1_POS";
/*     */     }
/* 781 */     if (paramInt == 356518792) {
/* 782 */       return "SEAT_BACKREST_ANGLE_1_MOVE";
/*     */     }
/* 784 */     if (paramInt == 356518793) {
/* 785 */       return "SEAT_BACKREST_ANGLE_2_POS";
/*     */     }
/* 787 */     if (paramInt == 356518794) {
/* 788 */       return "SEAT_BACKREST_ANGLE_2_MOVE";
/*     */     }
/* 790 */     if (paramInt == 356518795) {
/* 791 */       return "SEAT_HEIGHT_POS";
/*     */     }
/* 793 */     if (paramInt == 356518796) {
/* 794 */       return "SEAT_HEIGHT_MOVE";
/*     */     }
/* 796 */     if (paramInt == 356518797) {
/* 797 */       return "SEAT_DEPTH_POS";
/*     */     }
/* 799 */     if (paramInt == 356518798) {
/* 800 */       return "SEAT_DEPTH_MOVE";
/*     */     }
/* 802 */     if (paramInt == 356518799) {
/* 803 */       return "SEAT_TILT_POS";
/*     */     }
/* 805 */     if (paramInt == 356518800) {
/* 806 */       return "SEAT_TILT_MOVE";
/*     */     }
/* 808 */     if (paramInt == 356518801) {
/* 809 */       return "SEAT_LUMBAR_FORE_AFT_POS";
/*     */     }
/* 811 */     if (paramInt == 356518802) {
/* 812 */       return "SEAT_LUMBAR_FORE_AFT_MOVE";
/*     */     }
/* 814 */     if (paramInt == 356518803) {
/* 815 */       return "SEAT_LUMBAR_SIDE_SUPPORT_POS";
/*     */     }
/* 817 */     if (paramInt == 356518804) {
/* 818 */       return "SEAT_LUMBAR_SIDE_SUPPORT_MOVE";
/*     */     }
/* 820 */     if (paramInt == 289409941) {
/* 821 */       return "SEAT_HEADREST_HEIGHT_POS";
/*     */     }
/* 823 */     if (paramInt == 356518806) {
/* 824 */       return "SEAT_HEADREST_HEIGHT_MOVE";
/*     */     }
/* 826 */     if (paramInt == 356518807) {
/* 827 */       return "SEAT_HEADREST_ANGLE_POS";
/*     */     }
/* 829 */     if (paramInt == 356518808) {
/* 830 */       return "SEAT_HEADREST_ANGLE_MOVE";
/*     */     }
/* 832 */     if (paramInt == 356518809) {
/* 833 */       return "SEAT_HEADREST_FORE_AFT_POS";
/*     */     }
/* 835 */     if (paramInt == 356518810) {
/* 836 */       return "SEAT_HEADREST_FORE_AFT_MOVE";
/*     */     }
/* 838 */     if (paramInt == 322964416) {
/* 839 */       return "WINDOW_POS";
/*     */     }
/* 841 */     if (paramInt == 322964417) {
/* 842 */       return "WINDOW_MOVE";
/*     */     }
/* 844 */     if (paramInt == 320867268) {
/* 845 */       return "WINDOW_LOCK";
/*     */     }
/* 847 */     if (paramInt == 299895808) {
/* 848 */       return "VEHICLE_MAP_SERVICE";
/*     */     }
/* 850 */     if (paramInt == 299896064) {
/* 851 */       return "OBD2_LIVE_FRAME";
/*     */     }
/* 853 */     if (paramInt == 299896065) {
/* 854 */       return "OBD2_FREEZE_FRAME";
/*     */     }
/* 856 */     if (paramInt == 299896066) {
/* 857 */       return "OBD2_FREEZE_FRAME_INFO";
/*     */     }
/* 859 */     if (paramInt == 299896067) {
/* 860 */       return "OBD2_FREEZE_FRAME_CLEAR";
/*     */     }
/* 862 */     if (paramInt == 289410560) {
/* 863 */       return "HEADLIGHTS_STATE";
/*     */     }
/* 865 */     if (paramInt == 289410561) {
/* 866 */       return "HIGH_BEAM_LIGHTS_STATE";
/*     */     }
/* 868 */     if (paramInt == 289410562) {
/* 869 */       return "FOG_LIGHTS_STATE";
/*     */     }
/* 871 */     if (paramInt == 289410563) {
/* 872 */       return "HAZARD_LIGHTS_STATE";
/*     */     }
/* 874 */     if (paramInt == 289410576) {
/* 875 */       return "HEADLIGHTS_SWITCH";
/*     */     }
/* 877 */     if (paramInt == 289410577) {
/* 878 */       return "HIGH_BEAM_LIGHTS_SWITCH";
/*     */     }
/* 880 */     if (paramInt == 289410578) {
/* 881 */       return "FOG_LIGHTS_SWITCH";
/*     */     }
/* 883 */     if (paramInt == 289410579) {
/* 884 */       return "HAZARD_LIGHTS_SWITCH";
/*     */     }
/* 886 */     StringBuilder stringBuilder = new StringBuilder(); stringBuilder.append("0x"); stringBuilder.append(Integer.toHexString(paramInt)); return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\VehiclePropertyIds.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */