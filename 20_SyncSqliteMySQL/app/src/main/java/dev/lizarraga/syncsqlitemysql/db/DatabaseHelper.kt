package dev.lizarraga.syncsqlitemysql.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import dev.lizarraga.syncsqlitemysql.Constants.COLUMN_ID
import dev.lizarraga.syncsqlitemysql.Constants.COLUMN_NAME
import dev.lizarraga.syncsqlitemysql.Constants.COLUMN_STATUS
import dev.lizarraga.syncsqlitemysql.Constants.DB_NAME
import dev.lizarraga.syncsqlitemysql.Constants.DB_VERSION
import dev.lizarraga.syncsqlitemysql.Constants.TABLE_NAME

class DatabaseHelper(context: Context?) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        val sql = ("CREATE TABLE " + TABLE_NAME
                + "(" + COLUMN_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAME +
                " VARCHAR, " + COLUMN_STATUS +
                " TINYINT);")
        db.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        val sql = "DROP TABLE IF EXISTS Persons"
        db.execSQL(sql)
        onCreate(db)
    }

    fun addName(name: String?, status: Int): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COLUMN_NAME, name)
        contentValues.put(COLUMN_STATUS, status)
        db.insert(TABLE_NAME, null, contentValues)
        db.close()
        return true
    }

    fun updateNameStatus(id: Int, status: Int): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COLUMN_STATUS, status)
        db.update(TABLE_NAME, contentValues, "$COLUMN_ID=$id", null)
        db.close()
        return true
    }

    val names: Cursor
        get() {
            val db = this.readableDatabase
            val sql =
                "SELECT * FROM $TABLE_NAME ORDER BY $COLUMN_ID ASC;"
            return db.rawQuery(sql, null)
        }

    val unsyncedNames: Cursor
        get() {
            val db = this.readableDatabase
            val sql = "SELECT * FROM $TABLE_NAME WHERE $COLUMN_STATUS = 0;"
            return db.rawQuery(sql, null)
        }

}
