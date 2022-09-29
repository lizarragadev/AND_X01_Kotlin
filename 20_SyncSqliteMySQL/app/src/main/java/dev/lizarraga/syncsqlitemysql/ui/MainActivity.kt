package dev.lizarraga.syncsqlitemysql.ui

import android.app.Dialog
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.database.Cursor
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import dev.lizarraga.syncsqlitemysql.*
import dev.lizarraga.syncsqlitemysql.Constants.COLUMN_NAME
import dev.lizarraga.syncsqlitemysql.Constants.COLUMN_STATUS
import dev.lizarraga.syncsqlitemysql.Constants.DATA_SAVED_BROADCAST
import dev.lizarraga.syncsqlitemysql.Constants.NAME_NOT_SYNCED_WITH_SERVER
import dev.lizarraga.syncsqlitemysql.Constants.NAME_SYNCED_WITH_SERVER
import dev.lizarraga.syncsqlitemysql.Constants.URL_SAVE_NAME
import dev.lizarraga.syncsqlitemysql.databinding.ActivityMainBinding
import dev.lizarraga.syncsqlitemysql.db.DatabaseHelper
import dev.lizarraga.syncsqlitemysql.model.Name
import dev.lizarraga.syncsqlitemysql.receiver.NetworkStateChecker
import dev.lizarraga.syncsqlitemysql.service.VolleySingleton
import dev.lizarraga.syncsqlitemysql.ui.adapter.RVNameAdapter
import org.json.JSONException
import org.json.JSONObject

@Suppress("DEPRECATION", "Range")
class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    private lateinit var db: DatabaseHelper
    private lateinit var names: ArrayList<Name>
    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var adaptador: RVNameAdapter

    private lateinit var broadcastReceiver: BroadcastReceiver
    lateinit var dialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adaptador = RVNameAdapter()
        binding.rvNames.adapter = adaptador
        binding.rvNames.setHasFixedSize(true)

        layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvNames.layoutManager = layoutManager

        registerReceiver(
            NetworkStateChecker(),
            IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        )

        db = DatabaseHelper(this)
        names = ArrayList()

        binding.buttonSave.setOnClickListener(this)

        loadNames()

        broadcastReceiver = object : BroadcastReceiver() {
            override fun onReceive(p0: Context?, p1: Intent?) {
                loadNames()
            }
        }

        registerReceiver(
            broadcastReceiver,
            IntentFilter(DATA_SAVED_BROADCAST)
        )
    }

    override fun onClick(p0: View?) {
        saveNameToServer()
    }

    fun saveNameToServer() {
        displayLoading(this)
        val name = binding.editTextName.text.toString().trim()
        val stringRequest: StringRequest =
            object : StringRequest(
                Method.POST,
                URL_SAVE_NAME,
                Response.Listener { response ->
                    hideLoading()
                    try {
                        val obj = JSONObject(response)
                        if(!obj.getBoolean("error")) {
                            saveNameToLocalStorage(name, NAME_SYNCED_WITH_SERVER)
                        }else {
                            saveNameToLocalStorage(name, NAME_NOT_SYNCED_WITH_SERVER)
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                },
                Response.ErrorListener {
                    hideLoading()
                    saveNameToLocalStorage(name, NAME_NOT_SYNCED_WITH_SERVER)
                }
            ) {
                override fun getParams(): MutableMap<String, String>? {
                    val params: MutableMap<String, String> = HashMap()
                    params["name"] = name
                    return params
                }
            }
        VolleySingleton.getInstance(this)?.addToRequestQueue(stringRequest)
    }

    fun saveNameToLocalStorage(name: String, status: Int) {
        binding.editTextName.setText("")
        db.addName(name, status)
        val n = Name(name, status)
        names.add(n)
        adaptador.adicionaName(n)
    }

    fun loadNames() {
        names.clear()
        val cursor: Cursor = db.names
        if(cursor.moveToFirst()) {
            do {
                val name = Name(
                    cursor.getString(cursor.getColumnIndex(COLUMN_NAME)),
                    cursor.getInt(cursor.getColumnIndex(COLUMN_STATUS))
                )
                names.add(name)
            } while(cursor.moveToNext())
        }
        adaptador.adicionarListaNames(names)
    }

    private fun displayLoading(context: Context) {
        dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_layout)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCancelable(false)
        try {
            dialog.show()
        } catch (e: Exception) {
        }
    }

    fun hideLoading() {
        try {
            dialog.dismiss()
        } catch (e: Exception) {
        }
    }

}
