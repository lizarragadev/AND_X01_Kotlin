package dev.lizarraga.syncsqlitemysql.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.net.ConnectivityManager
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import dev.lizarraga.syncsqlitemysql.Constants.COLUMN_ID
import dev.lizarraga.syncsqlitemysql.Constants.COLUMN_NAME
import dev.lizarraga.syncsqlitemysql.Constants.DATA_SAVED_BROADCAST
import dev.lizarraga.syncsqlitemysql.Constants.NAME_SYNCED_WITH_SERVER
import dev.lizarraga.syncsqlitemysql.Constants.URL_SAVE_NAME
import dev.lizarraga.syncsqlitemysql.db.DatabaseHelper
import dev.lizarraga.syncsqlitemysql.service.VolleySingleton
import org.json.JSONException
import org.json.JSONObject

@Suppress("DEPRECATION", "Range")
class NetworkStateChecker : BroadcastReceiver() {
    lateinit var context: Context
    lateinit var db: DatabaseHelper

    override fun onReceive(context: Context, intent: Intent?) {
        this.context = context
        db = DatabaseHelper(context)
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo

        if (activeNetwork != null) {
            if (activeNetwork.type == ConnectivityManager.TYPE_WIFI || activeNetwork.type == ConnectivityManager.TYPE_MOBILE) {
                val cursor: Cursor = db.unsyncedNames
                if (cursor.moveToFirst()) {
                    do {
                        saveName(
                            cursor.getInt(cursor.getColumnIndex(COLUMN_ID)),
                            cursor.getString(cursor.getColumnIndex(COLUMN_NAME))
                        )
                    } while (cursor.moveToNext())
                }
            }
        }
    }

    private fun saveName(id: Int, name: String) {
        val stringRequest: StringRequest =
            object : StringRequest(
                Method.POST,
                URL_SAVE_NAME,
                Response.Listener{ response ->
                    try {
                        val obj = JSONObject(response)
                        if (!obj.getBoolean("error")) {
                            db.updateNameStatus(id, NAME_SYNCED_WITH_SERVER)
                            context.sendBroadcast(Intent(DATA_SAVED_BROADCAST))
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                },
                Response.ErrorListener { }) {
                override fun getParams(): MutableMap<String, String>? {
                    val params: MutableMap<String, String> = HashMap()
                    params["name"] = name
                    return params
                }
            }
        VolleySingleton.getInstance(context)?.addToRequestQueue(stringRequest)
    }
}