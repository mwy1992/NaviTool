package com.ecarx.xui.adaptapi.device.ext.common;

import com.ecarx.xui.adaptapi.VendorDefinition;

@VendorDefinition(author = "@ECARX", date = "2021-01-18", project = "KX11", requirement = "")
public class BtDef {
  public static final byte AUDIO_TRANSFER_TO_CARKIT = 1;
  
  public static final byte AUDIO_TRANSFER_TO_PHONE = 0;
  
  public static final int AUTO_CONNECT_DISABLE = 0;
  
  public static final int AUTO_CONNECT_WHEN_BT_ON = 1;
  
  public static final int AUTO_CONNECT_WHEN_OOR = 4;
  
  public static final int AUTO_CONNECT_WHEN_PAIRED = 2;
  
  public static final byte AVRCP_BATTERY_STATUS_ID_CRITICAL = 2;
  
  public static final byte AVRCP_BATTERY_STATUS_ID_EXTERNAL = 3;
  
  public static final byte AVRCP_BATTERY_STATUS_ID_FULL = 4;
  
  public static final byte AVRCP_BATTERY_STATUS_ID_NORMAL = 0;
  
  public static final byte AVRCP_BATTERY_STATUS_ID_WARNING = 1;
  
  public static final byte AVRCP_BROWSING_STATUS_ADDRESS_PLAYER_CHANGED = 23;
  
  public static final byte AVRCP_BROWSING_STATUS_INTERNAL_ERROR = 3;
  
  public static final byte AVRCP_BROWSING_STATUS_INVALID_COMMAND = 0;
  
  public static final byte AVRCP_BROWSING_STATUS_INVALID_DIRECTION = 7;
  
  public static final byte AVRCP_BROWSING_STATUS_INVALID_PARAMETER = 1;
  
  public static final byte AVRCP_BROWSING_STATUS_INVALID_PLAYER_ID = 18;
  
  public static final byte AVRCP_BROWSING_STATUS_INVALID_SCOPE = 10;
  
  public static final byte AVRCP_BROWSING_STATUS_MEDIA_IN_USE = 13;
  
  public static final byte AVRCP_BROWSING_STATUS_NOT_DIRECTORY = 8;
  
  public static final byte AVRCP_BROWSING_STATUS_NOT_EXIST = 9;
  
  public static final byte AVRCP_BROWSING_STATUS_NO_AVAILABLE_PLAYERS = 22;
  
  public static final byte AVRCP_BROWSING_STATUS_NO_RESAULTS = 21;
  
  public static final byte AVRCP_BROWSING_STATUS_OPERATION_SUCCESSFUL = 4;
  
  public static final byte AVRCP_BROWSING_STATUS_OUT_OF_BOUNDS = 11;
  
  public static final byte AVRCP_BROWSING_STATUS_PARAMETER_NOT_FOUND = 2;
  
  public static final byte AVRCP_BROWSING_STATUS_PLAYER_NOT_ADDRESSED = 20;
  
  public static final byte AVRCP_BROWSING_STATUS_PLAYER_NOT_BROWSABLE = 19;
  
  public static final byte AVRCP_BROWSING_STATUS_PLAYING_LIST_FULL = 14;
  
  public static final byte AVRCP_BROWSING_STATUS_RESERVERED = 6;
  
  public static final byte AVRCP_BROWSING_STATUS_SEARCH_IN_PROGRESS = 17;
  
  public static final byte AVRCP_BROWSING_STATUS_SEARCH_NOT_SUPPORT = 16;
  
  public static final byte AVRCP_BROWSING_STATUS_UID_CHANGED = 5;
  
  public static final byte AVRCP_BROWSING_STATUS_UID_IS_DIRECTORY = 12;
  
  public static final int AVRCP_CAUSE_LAST_ENTRY = 2;
  
  public static final int AVRCP_CAUSE_NEXT_ENTRY = 1;
  
  public static final int AVRCP_CAUSE_NO_ENTRY = 0;
  
  public static final short AVRCP_ERROR_CODE_BUSY = 256;
  
  public static final short AVRCP_ERROR_CODE_INVALID_COMMAND = 0;
  
  public static final byte AVRCP_EVENT_ID_ADDRESSED_PLAYER_CHANGED = 11;
  
  public static final byte AVRCP_EVENT_ID_AVAILABLE_PLAYERS_CHANGED = 10;
  
  public static final byte AVRCP_EVENT_ID_BATT_STATUS_CHANGED = 6;
  
  public static final byte AVRCP_EVENT_ID_NOW_PLAYING_CONTENT_CHANGED = 9;
  
  public static final byte AVRCP_EVENT_ID_PLAYBACK_POS_CHANGED = 5;
  
  public static final byte AVRCP_EVENT_ID_PLAYBACK_STATUS_CHANGED = 1;
  
  public static final byte AVRCP_EVENT_ID_PLAYER_APPLICATION_SETTING_CHANGED = 8;
  
  public static final byte AVRCP_EVENT_ID_SYSTEM_STATUS_CHANGED = 7;
  
  public static final byte AVRCP_EVENT_ID_TRACK_CHANGED = 2;
  
  public static final byte AVRCP_EVENT_ID_TRACK_REACHED_END = 3;
  
  public static final byte AVRCP_EVENT_ID_TRACK_REACHED_START = 4;
  
  public static final byte AVRCP_EVENT_ID_UIDS_CHANGED = 12;
  
  public static final byte AVRCP_EVENT_ID_VOLUME_CHANGED = 13;
  
  public static final byte AVRCP_FOLDER_DIRECTION_ID_DOWN = 1;
  
  public static final byte AVRCP_FOLDER_DIRECTION_ID_UP = 0;
  
  public static final byte AVRCP_FOLDER_IS_NOT_PLAYABLE = 0;
  
  public static final byte AVRCP_FOLDER_IS_PLAYABLE = 1;
  
  public static final byte AVRCP_FOLDER_TYPE_ALBUMS = 2;
  
  public static final byte AVRCP_FOLDER_TYPE_ARTISTS = 3;
  
  public static final byte AVRCP_FOLDER_TYPE_GENRES = 4;
  
  public static final byte AVRCP_FOLDER_TYPE_MIXED = 0;
  
  public static final byte AVRCP_FOLDER_TYPE_TITLES = 1;
  
  public static final byte AVRCP_MAJOR_PLAYER_TYPE_MASK_AUDIO = 1;
  
  public static final byte AVRCP_MAJOR_PLAYER_TYPE_MASK_BROADCASTING_AUDIO = 4;
  
  public static final byte AVRCP_MAJOR_PLAYER_TYPE_MASK_BROADCASTING_VIDEO = 8;
  
  public static final byte AVRCP_MAJOR_PLAYER_TYPE_MASK_VIDEO = 2;
  
  public static final byte AVRCP_MEDIA_TYPE_AUDIO = 0;
  
  public static final byte AVRCP_MEDIA_TYPE_VIDEO = 1;
  
  public static final int AVRCP_META_ATTRIBUTE_ID_ALBUM = 3;
  
  public static final int AVRCP_META_ATTRIBUTE_ID_ARTIST = 2;
  
  public static final int AVRCP_META_ATTRIBUTE_ID_GENRE = 6;
  
  public static final int AVRCP_META_ATTRIBUTE_ID_NUMBER_OF_MEDIA = 4;
  
  public static final int AVRCP_META_ATTRIBUTE_ID_SONG_LENGTH = 7;
  
  public static final int AVRCP_META_ATTRIBUTE_ID_TITLE = 1;
  
  public static final int AVRCP_META_ATTRIBUTE_ID_TOTAL_NUMBER_OF_MEDIA = 5;
  
  public static final byte AVRCP_META_ERROR_REASON_ERROR = 0;
  
  public static final byte AVRCP_META_ERROR_REASON_IN_A_STATE = 11;
  
  public static final byte AVRCP_META_ERROR_REASON_NOT_IMPLEMENTED = 8;
  
  public static final byte AVRCP_META_ERROR_REASON_REJECTED = 10;
  
  public static final byte AVRCP_PLAYER_SUBTYPE_MASK_AUDIO_BOOK = 1;
  
  public static final byte AVRCP_PLAYER_SUBTYPE_MASK_PODCAST = 2;
  
  public static final byte AVRCP_PLAYING_STATUS_ID_ERROR = -1;
  
  public static final byte AVRCP_PLAYING_STATUS_ID_FWD_SEEK = 3;
  
  public static final byte AVRCP_PLAYING_STATUS_ID_PAUSED = 2;
  
  public static final byte AVRCP_PLAYING_STATUS_ID_PLAYING = 1;
  
  public static final byte AVRCP_PLAYING_STATUS_ID_REW_SEEK = 4;
  
  public static final byte AVRCP_PLAYING_STATUS_ID_STOPPED = 0;
  
  public static final byte AVRCP_SCOPE_ID_MEDIA_PLAYER = 0;
  
  public static final byte AVRCP_SCOPE_ID_NOW_PLAYING = 3;
  
  public static final byte AVRCP_SCOPE_ID_SEARCH = 2;
  
  public static final byte AVRCP_SCOPE_ID_VFS = 1;
  
  public static final byte AVRCP_SETTING_ATTRIBUTE_ID_EQUALIZER = 1;
  
  public static final byte AVRCP_SETTING_ATTRIBUTE_ID_REPEAT_MODE = 2;
  
  public static final byte AVRCP_SETTING_ATTRIBUTE_ID_SCAN = 4;
  
  public static final byte AVRCP_SETTING_ATTRIBUTE_ID_SHUFFLE = 3;
  
  public static final byte AVRCP_SETTING_VALUE_ID_EQUALIZER_OFF = 1;
  
  public static final byte AVRCP_SETTING_VALUE_ID_EQUALIZER_ON = 2;
  
  public static final byte AVRCP_SETTING_VALUE_ID_REPEAT_ALL = 3;
  
  public static final byte AVRCP_SETTING_VALUE_ID_REPEAT_GROUP = 4;
  
  public static final byte AVRCP_SETTING_VALUE_ID_REPEAT_OFF = 1;
  
  public static final byte AVRCP_SETTING_VALUE_ID_REPEAT_SINGLE = 2;
  
  public static final byte AVRCP_SETTING_VALUE_ID_SCAN_ALL = 2;
  
  public static final byte AVRCP_SETTING_VALUE_ID_SCAN_GROUP = 3;
  
  public static final byte AVRCP_SETTING_VALUE_ID_SCAN_OFF = 1;
  
  public static final byte AVRCP_SETTING_VALUE_ID_SHUFFLE_ALL = 2;
  
  public static final byte AVRCP_SETTING_VALUE_ID_SHUFFLE_GROUP = 3;
  
  public static final byte AVRCP_SETTING_VALUE_ID_SHUFFLE_OFF = 1;
  
  public static final byte AVRCP_SYSTEM_STATUS_ID_POWER_OFF = 1;
  
  public static final byte AVRCP_SYSTEM_STATUS_ID_POWER_ON = 0;
  
  public static final byte AVRCP_SYSTEM_STATUS_ID_POWER_UNPLUGGED = 2;
  
  public static final short AVRCP_UID_COUNTER_HAS_NO_DATABASE = 0;
  
  public static final int BOND_BONDED = 332;
  
  public static final int BOND_BONDING = 331;
  
  public static final int BOND_NONE = 330;
  
  public static final int BT_MODE_CONNECTABLE = 311;
  
  public static final int BT_MODE_CONNECTABLE_DISCOVERABLE = 312;
  
  public static final int BT_MODE_NONE = 310;
  
  public static final int BT_SCAN_FINISH = 321;
  
  public static final int BT_SCAN_SCANNING = 322;
  
  public static final int BT_SCAN_START = 320;
  
  public static final int BT_STATE_OFF = 300;
  
  public static final int BT_STATE_ON = 302;
  
  public static final int BT_STATE_TURNING_OFF = 303;
  
  public static final int BT_STATE_TURNING_ON = 301;
  
  public static final int CALL_ACCEPT_HOLD = 1;
  
  public static final int CALL_ACCEPT_NONE = 0;
  
  public static final int CALL_ACCEPT_TERMINATE = 2;
  
  public static final byte CAT_COMPUTER = 1;
  
  public static final byte CAT_MONO_AUDIO = 8;
  
  public static final byte CAT_PAD = 16;
  
  public static final byte CAT_PHONE = 2;
  
  public static final byte CAT_STEREO_AUDIO = 4;
  
  public static final int DEFAULT_DISCOVERABLE_TIMEOUT = 120;
  
  public static final int ERROR = -1;
  
  public static final int ERROR_ADAPTER_FAIL = 2;
  
  public static final int ERROR_BLUETOOTH_DISABLE = 1;
  
  public static final int ERROR_BLUEZ_CONNECT_FAIL = 703;
  
  public static final int ERROR_BLUEZ_PAN_ALREADY_CONNECTED = 707;
  
  public static final int ERROR_BLUEZ_PAN_CONNECT_FAIL = 708;
  
  public static final int ERROR_BLUEZ_PAN_REMOTE_NOT_SUPPORT = 706;
  
  public static final int ERROR_CONNECT_FAIL = 5;
  
  public static final int ERROR_DBUS_SEND_MESSAGE_FAIL = 702;
  
  public static final int ERROR_DEVICE_ADDRESS_INVALID = 3;
  
  public static final int ERROR_DEVICE_PATH_NULL = 700;
  
  public static final int ERROR_DHCP_FAIL = 705;
  
  public static final int ERROR_HID_ACCEPT_FAIL = 709;
  
  public static final int ERROR_HID_CONNECT_FAIL = 708;
  
  public static final int ERROR_HID_CONNECT_REJECT_BY_REMOTE = 711;
  
  public static final int ERROR_HID_DISCONNECT_FAIL = 710;
  
  public static final int ERROR_LOCAL_ADDRESS_NULL = 706;
  
  public static final int ERROR_REMOTE_ADDRESS_NULL = 707;
  
  public static final int ERROR_SERVICE_SHOWDOWN = 4;
  
  public static final int ERROR_STOP_DHCP_FAIL = 704;
  
  public static final int ERROR_UNSATISIFIED_STATE = 701;
  
  public static final int GATT_CHARACTERISTIC_PERMISSION_READ = 1;
  
  public static final int GATT_CHARACTERISTIC_PERMISSION_READ_ENCRYPTED = 2;
  
  public static final int GATT_CHARACTERISTIC_PERMISSION_READ_ENCRYPTED_MITM = 4;
  
  public static final int GATT_CHARACTERISTIC_PERMISSION_WRITE = 16;
  
  public static final int GATT_CHARACTERISTIC_PERMISSION_WRITE_ENCRYPTED = 32;
  
  public static final int GATT_CHARACTERISTIC_PERMISSION_WRITE_ENCRYPTED_MITM = 64;
  
  public static final int GATT_CHARACTERISTIC_PERMISSION_WRITE_SIGNED = 128;
  
  public static final int GATT_CHARACTERISTIC_PERMISSION_WRITE_SIGNED_MITM = 256;
  
  public static final int GATT_CHARACTERISTIC_PROPERTY_BROADCAST = 1;
  
  public static final int GATT_CHARACTERISTIC_PROPERTY_EXTENDED_PROPS = 128;
  
  public static final int GATT_CHARACTERISTIC_PROPERTY_INDICATE = 32;
  
  public static final int GATT_CHARACTERISTIC_PROPERTY_NOTIFY = 16;
  
  public static final int GATT_CHARACTERISTIC_PROPERTY_READ = 2;
  
  public static final int GATT_CHARACTERISTIC_PROPERTY_SIGNED_WRITE = 64;
  
  public static final int GATT_CHARACTERISTIC_PROPERTY_WRITE = 8;
  
  public static final int GATT_CHARACTERISTIC_PROPERTY_WRITE_NO_RESPONSE = 4;
  
  public static final int GATT_CHARACTERISTIC_WRITE_TYPE_DEFAULT = 2;
  
  public static final int GATT_CHARACTERISTIC_WRITE_TYPE_NO_RESPONSE = 1;
  
  public static final int GATT_CHARACTERISTIC_WRITE_TYPE_SIGNED = 4;
  
  public static final int GATT_DESCRIPTOR_PERMISSION_READ = 1;
  
  public static final int GATT_DESCRIPTOR_PERMISSION_READ_ENCRYPTED = 2;
  
  public static final int GATT_DESCRIPTOR_PERMISSION_READ_ENCRYPTED_MITM = 4;
  
  public static final int GATT_DESCRIPTOR_PERMISSION_WRITE = 16;
  
  public static final int GATT_DESCRIPTOR_PERMISSION_WRITE_ENCRYPTED = 32;
  
  public static final int GATT_DESCRIPTOR_PERMISSION_WRITE_ENCRYPTED_MITM = 64;
  
  public static final int GATT_DESCRIPTOR_PERMISSION_WRITE_SIGNED = 128;
  
  public static final int GATT_DESCRIPTOR_PERMISSION_WRITE_SIGNED_MITM = 256;
  
  public static final int GATT_SERVICE_TYPE_PRIMARY = 0;
  
  public static final int GATT_SERVICE_TYPE_SECONDARY = 1;
  
  public static final int GATT_STATUS_ALREADY_OPEN = 141;
  
  public static final int GATT_STATUS_AUTH_FAIL = 137;
  
  public static final int GATT_STATUS_BUSY = 132;
  
  public static final int GATT_STATUS_CANCEL = 142;
  
  public static final int GATT_STATUS_CMD_STARTED = 134;
  
  public static final int GATT_STATUS_DB_FULL = 131;
  
  public static final int GATT_STATUS_DUP_REG = 140;
  
  public static final int GATT_STATUS_ERROR = 133;
  
  public static final int GATT_STATUS_ERR_UNLIKELY = 14;
  
  public static final int GATT_STATUS_ILLEGAL_PARAMETER = 135;
  
  public static final int GATT_STATUS_INSUF_AUTHENTICATION = 5;
  
  public static final int GATT_STATUS_INSUF_AUTHORIZATION = 8;
  
  public static final int GATT_STATUS_INSUF_ENCRYPTION = 15;
  
  public static final int GATT_STATUS_INSUF_KEY_SIZE = 12;
  
  public static final int GATT_STATUS_INSUF_RESOURCE = 17;
  
  public static final int GATT_STATUS_INTERNAL_ERROR = 129;
  
  public static final int GATT_STATUS_INVALID_ATTR_LEN = 13;
  
  public static final int GATT_STATUS_INVALID_CFG = 139;
  
  public static final int GATT_STATUS_INVALID_HANDLE = 1;
  
  public static final int GATT_STATUS_INVALID_OFFSET = 7;
  
  public static final int GATT_STATUS_INVALID_PDU = 4;
  
  public static final int GATT_STATUS_MORE = 138;
  
  public static final int GATT_STATUS_NOT_FOUND = 10;
  
  public static final int GATT_STATUS_NOT_LONG = 11;
  
  public static final int GATT_STATUS_NO_RESOURCES = 128;
  
  public static final int GATT_STATUS_PENDING = 136;
  
  public static final int GATT_STATUS_PREPARE_Q_FULL = 9;
  
  public static final int GATT_STATUS_READ_NOT_PERMIT = 2;
  
  public static final int GATT_STATUS_REQ_NOT_SUPPORTED = 6;
  
  public static final int GATT_STATUS_SUCCESS = 0;
  
  public static final int GATT_STATUS_UNSUPPORT_GRP_TYPE = 16;
  
  public static final int GATT_STATUS_WRITE_NOT_PERMIT = 3;
  
  public static final int GATT_STATUS_WRONG_STATE = 130;
  
  public static final int HANDLER_EVENT_SCO_ON_CLOSED = 11;
  
  public static final byte HFP_CHLD_ADD_HELD_CALL_TO_CONVERSATION = 3;
  
  public static final byte HFP_CHLD_HOLD_ALL_ACTIVE_CALLS_ACCEPT_THEOTHER = 2;
  
  public static final byte HFP_CHLD_RELEASE_ALL_ACTIVE_CALLS_ACCEPT_THEOTHER = 1;
  
  public static final byte HFP_CHLD_RELEASE_ALL_HELD_CALLS = 0;
  
  public static final byte HFP_CHLD_SET_USER_BUSY_FOR_WAITING_CALL = 0;
  
  public static final int HID_DISCONNECT_BY_REMOTE = 904;
  
  public static final int HID_PACKET_COMPLETE = 900;
  
  public static final int MAP_DOWNLOAD_BUSY = 2;
  
  public static final int MAP_DOWNLOAD_COMPLETE = 1;
  
  public static final int MAP_DOWNLOAD_FAIL = -1;
  
  public static final int MAP_DOWNLOAD_INTERRUPT = 3;
  
  public static final int MAP_FOLDER_STRUCTURE_DELETED = 2;
  
  public static final int MAP_FOLDER_STRUCTURE_DRAFT = 4;
  
  public static final int MAP_FOLDER_STRUCTURE_INBOX = 0;
  
  public static final int MAP_FOLDER_STRUCTURE_OUTBOX = 3;
  
  public static final int MAP_FOLDER_STRUCTURE_SENT = 1;
  
  public static final int MAP_REASON_BAD_PARAMS = 1;
  
  public static final int MAP_REASON_DELETE_BAD_PARAMS = 1;
  
  public static final int MAP_REASON_DELETE_FAIL = 3;
  
  public static final int MAP_REASON_DELETE_NONE = 0;
  
  public static final int MAP_REASON_DELETE_TIME_OUT = 2;
  
  public static final int MAP_REASON_DISCONNECT_BY_PEER = 3;
  
  public static final int MAP_REASON_DISCONNECT_FROM_LOCAL = 2;
  
  public static final int MAP_REASON_DOWNLOAD_FAIL = 8;
  
  public static final int MAP_REASON_DOWNLOAD_FINISH = 5;
  
  public static final int MAP_REASON_INTERRUPT = 4;
  
  public static final int MAP_REASON_NONE = 0;
  
  public static final int MAP_REASON_PEER_NO_MAP_SERVICE = 6;
  
  public static final int MAP_REASON_TIMEOUT = 7;
  
  public static final int MAP_SEND_STATUS_BAD_PARAMS = 1;
  
  public static final int MAP_SEND_STATUS_SUCCESS = 0;
  
  public static final int MAP_SEND_STATUS_TIME_OUT = 2;
  
  public static final int MAP_TYPE_SMS_CDMA = 1;
  
  public static final int MAP_TYPE_SMS_EMAIL = 3;
  
  public static final int MAP_TYPE_SMS_GSM = 0;
  
  public static final int MAP_TYPE_SMS_MMS = 2;
  
  public static final int PBAP_ADDRESS_TYPE_DOM = 1;
  
  public static final int PBAP_ADDRESS_TYPE_HOME = 6;
  
  public static final int PBAP_ADDRESS_TYPE_INTL = 2;
  
  public static final int PBAP_ADDRESS_TYPE_NULL = 0;
  
  public static final int PBAP_ADDRESS_TYPE_PARCEL = 4;
  
  public static final int PBAP_ADDRESS_TYPE_POSTAL = 3;
  
  public static final int PBAP_ADDRESS_TYPE_WORK = 5;
  
  public static final int PBAP_CLEAN_TABLE_COMPLETE = 99;
  
  public static final int PBAP_EMAIL_TYPE_HOME = 5;
  
  public static final int PBAP_EMAIL_TYPE_INTERNET = 2;
  
  public static final int PBAP_EMAIL_TYPE_NULL = 0;
  
  public static final int PBAP_EMAIL_TYPE_PREF = 1;
  
  public static final int PBAP_EMAIL_TYPE_WORK = 4;
  
  public static final int PBAP_EMAIL_TYPE_X400 = 3;
  
  public static final int PBAP_NUMBER_TYPE_CELL = 7;
  
  public static final int PBAP_NUMBER_TYPE_FAX = 5;
  
  public static final int PBAP_NUMBER_TYPE_HOME = 3;
  
  public static final int PBAP_NUMBER_TYPE_MSG = 6;
  
  public static final int PBAP_NUMBER_TYPE_NULL = 0;
  
  public static final int PBAP_NUMBER_TYPE_PAGER = 8;
  
  public static final int PBAP_NUMBER_TYPE_PREF = 1;
  
  public static final int PBAP_NUMBER_TYPE_VOICE = 4;
  
  public static final int PBAP_NUMBER_TYPE_WORK = 2;
  
  public static final int PBAP_PHONE_MEMORY_UNSUPPORTED = -3;
  
  public static final int PBAP_PHOTO_TYPE_GIF = 4;
  
  public static final int PBAP_PHOTO_TYPE_JPEG = 3;
  
  public static final int PBAP_PHOTO_TYPE_NULL = 0;
  
  public static final int PBAP_PHOTO_TYPE_URI = 1;
  
  public static final int PBAP_PHOTO_TYPE_URL = 2;
  
  public static final int PBAP_PROPERTY_MASK_ADR = 32;
  
  public static final int PBAP_PROPERTY_MASK_AGENT = 32768;
  
  public static final int PBAP_PROPERTY_MASK_BDAY = 16;
  
  public static final int PBAP_PROPERTY_MASK_CATEGORIES = 16777216;
  
  public static final int PBAP_PROPERTY_MASK_CLASS = 67108864;
  
  public static final int PBAP_PROPERTY_MASK_EMAIL = 256;
  
  public static final int PBAP_PROPERTY_MASK_FN = 2;
  
  public static final int PBAP_PROPERTY_MASK_GEO = 2048;
  
  public static final int PBAP_PROPERTY_MASK_KEY = 4194304;
  
  public static final int PBAP_PROPERTY_MASK_LABEL = 64;
  
  public static final int PBAP_PROPERTY_MASK_LOGO = 16384;
  
  public static final int PBAP_PROPERTY_MASK_MAILER = 512;
  
  public static final int PBAP_PROPERTY_MASK_N = 4;
  
  public static final int PBAP_PROPERTY_MASK_NICKNAME = 8388608;
  
  public static final int PBAP_PROPERTY_MASK_NOTE = 131072;
  
  public static final int PBAP_PROPERTY_MASK_ORG = 65536;
  
  public static final int PBAP_PROPERTY_MASK_PHOTO = 8;
  
  public static final int PBAP_PROPERTY_MASK_PROID = 33554432;
  
  public static final int PBAP_PROPERTY_MASK_REV = 262144;
  
  public static final int PBAP_PROPERTY_MASK_ROLE = 8192;
  
  public static final int PBAP_PROPERTY_MASK_SORT_STRING = 134217728;
  
  public static final int PBAP_PROPERTY_MASK_SOUND = 524288;
  
  public static final int PBAP_PROPERTY_MASK_TEL = 128;
  
  public static final int PBAP_PROPERTY_MASK_TIME_STAMP = 268435456;
  
  public static final int PBAP_PROPERTY_MASK_TITLE = 4096;
  
  public static final int PBAP_PROPERTY_MASK_TZ = 1024;
  
  public static final int PBAP_PROPERTY_MASK_UID = 2097152;
  
  public static final int PBAP_PROPERTY_MASK_URL = 1048576;
  
  public static final int PBAP_PROPERTY_MASK_VERSION = 1;
  
  public static final int PBAP_RFCOMM_FAIL = -1;
  
  public static final int PBAP_SIM1_UNSUPPORTED = -2;
  
  public static final int PBAP_STORAGE_CALL_LOGS = 8;
  
  public static final int PBAP_STORAGE_DIALED_CALLS = 7;
  
  public static final int PBAP_STORAGE_FAVORITE = 4;
  
  public static final int PBAP_STORAGE_MISSED_CALLS = 5;
  
  public static final int PBAP_STORAGE_PHONE_MEMORY = 2;
  
  public static final int PBAP_STORAGE_RECEIVED_CALLS = 6;
  
  public static final int PBAP_STORAGE_SIM = 1;
  
  public static final int PBAP_STORAGE_SPEEDDIAL = 3;
  
  public static final int PROFILE_A2DP = 4;
  
  public static final int PROFILE_AVRCP = 32;
  
  public static final int PROFILE_AVRCP_13 = 256;
  
  public static final int PROFILE_AVRCP_14 = 512;
  
  public static final int PROFILE_BLUETOOTH = 0;
  
  public static final int PROFILE_DUN = 4096;
  
  public static final int PROFILE_FTP = 64;
  
  public static final int PROFILE_HFP = 2;
  
  public static final int PROFILE_HID = 16384;
  
  public static final int PROFILE_HSP = 1;
  
  public static final int PROFILE_IAP = 8192;
  
  public static final int PROFILE_MAP = 128;
  
  public static final int PROFILE_NAP = 2048;
  
  public static final int PROFILE_PANU = 1024;
  
  public static final int PROFILE_PBAP = 16;
  
  public static final int PROFILE_SPP = 8;
  
  public static final int REASON_DOWNLOAD_FAILED = 2;
  
  public static final int REASON_DOWNLOAD_FULL_CONTENT_COMPLETED = 1;
  
  public static final int REASON_DOWNLOAD_INTERRUPTED = 8;
  
  public static final int REASON_DOWNLOAD_NEW_MESSAGE_COMPLETED = 4;
  
  public static final int REASON_DOWNLOAD_OUTLINE_COMPLETED = 2;
  
  public static final int REASON_DOWNLOAD_SINGLE_MESSAGE_COMPLETED = 3;
  
  public static final int REASON_DOWNLOAD_TIMEOUT = 3;
  
  public static final int REASON_DOWNLOAD_USER_REJECT = 4;
  
  public static final int REASON_OPP_DOWNLOAD_FILEPATH_ERROR = 3;
  
  public static final int REASON_OPP_DOWNLOAD_INTERRUPTED = 2;
  
  public static final int REASON_OPP_DOWNLOAD_REJECT = 1;
  
  public static final int REASON_OPP_SUCCESS = 0;
  
  public static final int REASON_REGISTER_TIMEOUT = 7;
  
  public static final int REASON_UNREGISTER_COMPLETED = 9;
  
  public static final short REQ_AVRCP_13_GET_CAPABILITIES_SUPPORT_EVENT = 16;
  
  public static final short REQ_AVRCP_13_GET_ELEMENT_ATTRIBUTES_PLAYING = 32;
  
  public static final short REQ_AVRCP_13_GET_PLAYER_SETTING_ATTRIBUTES_LIST = 17;
  
  public static final short REQ_AVRCP_13_GET_PLAYER_SETTING_CURRENT_VALUES = 18;
  
  public static final short REQ_AVRCP_13_GET_PLAYER_SETTING_VALUE = 19;
  
  public static final short REQ_AVRCP_13_GET_PLAY_STATUS = 48;
  
  public static final short REQ_AVRCP_13_NEXT_GROUP = 33;
  
  public static final short REQ_AVRCP_13_PREVIOUS_GROUP = 34;
  
  public static final short REQ_AVRCP_14_ADD_TO_NOW_PLAYING = 144;
  
  public static final short REQ_AVRCP_14_CHANGE_PATH = 114;
  
  public static final short REQ_AVRCP_14_GET_FOLDER_ITEMS = 113;
  
  public static final short REQ_AVRCP_14_GET_ITEM_ATTRIBUTES = 115;
  
  public static final short REQ_AVRCP_14_PLAY_SELECTED_ITEM = 116;
  
  public static final short REQ_AVRCP_14_SEARCH = 128;
  
  public static final short REQ_AVRCP_14_SET_ABSOLUTE_VOLUME = 80;
  
  public static final short REQ_AVRCP_14_SET_ADDRESSED_PLAYER = 96;
  
  public static final short REQ_AVRCP_14_SET_BROWSED_PLAYER = 112;
  
  public static final short REQ_AVRCP_CT_ABORT_METADATA_RECEIVING = 65;
  
  public static final short REQ_AVRCP_CT_GET_PLAYER_APP_SETTING_ATTRIBUTE_TEXT = 21;
  
  public static final short REQ_AVRCP_CT_GET_PLAYER_APP_SETTING_VALUE_TEXT = 22;
  
  public static final short REQ_AVRCP_CT_INFORM_BATTERY_STATUS_OF_CT = 24;
  
  public static final short REQ_AVRCP_CT_INFORM_DISPLAYABLE_CHARSET = 23;
  
  public static final short REQ_AVRCP_CT_SET_PLAYER_APP_SETTING_VALUE = 20;
  
  public static final short REQ_AVRCP_REGISTER_EVENT_WATCHER = 49;
  
  public static final short REQ_AVRCP_UNREGISTER_EVENT_WATCHER = 256;
  
  public static final int SQL_QUERY_FIND_CONTAIN = 0;
  
  public static final int SQL_QUERY_FIND_HEAD = 1;
  
  public static final int SQL_QUERY_FIND_TAIL = 2;
  
  public static final int SQL_QUERY_LIKE_FIND_CONTAIN = 0;
  
  public static final int SQL_QUERY_LIKE_FIND_HEAD = 1;
  
  public static final int SQL_QUERY_LIKE_FIND_TAIL = 2;
  
  public static final int STATE_BROWSING = 145;
  
  public static final int STATE_CONNECTED = 140;
  
  public static final int STATE_CONNECTED_AND_REGISTED = 150;
  
  public static final int STATE_CONNECTING = 120;
  
  public static final int STATE_DISCONNECTING = 125;
  
  public static final int STATE_DOWNLOADED = 142;
  
  public static final int STATE_DOWNLOADING = 160;
  
  public static final int STATE_DOWNLOAD_COMPLETED = 110;
  
  public static final int STATE_DOWNLOAD_PAUSE = 140;
  
  public static final int STATE_DOWNLOAD_START = 120;
  
  public static final int STATE_DOWNLOAD_STOP = 141;
  
  public static final int STATE_LISTENING = 130;
  
  public static final int STATE_NOT_INITIALIZED = 100;
  
  public static final int STATE_READY = 110;
  
  public static final int STATE_SIGNALLING_ACTIVE = 130;
  
  public static final int STATE_STREAMING = 150;
  
  public static final int STATE_UPLOADING = 170;
  
  public static final int TIME_EVENT_SCO_ON_CLOSED_MS = 25;
  
  public static final byte VOLUME_ATTRIBUTE_MIC = 2;
  
  public static final byte VOLUME_ATTRIBUTE_SPEAKER = 1;
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\device\ext\common\BtDef.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */