package dev.lizarraga.syncsqlitemysql

object Constants {
    const val DB_NAME = "NamesDB"
    const val TABLE_NAME = "names"
    const val COLUMN_ID = "id"
    const val COLUMN_NAME = "name"
    const val COLUMN_STATUS = "status"
    const val DB_VERSION = 1

    const val URL_BASE = "https://mobiletrainingbo.000webhostapp.com/names"
    const val URL_SAVE_NAME = "$URL_BASE/saveName.php"
    const val NAME_SYNCED_WITH_SERVER = 1
    const val NAME_NOT_SYNCED_WITH_SERVER = 0
    const val DATA_SAVED_BROADCAST = "dev.lizarraga.demosync"
}