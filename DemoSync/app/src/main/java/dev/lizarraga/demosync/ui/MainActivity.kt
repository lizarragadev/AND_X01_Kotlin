package dev.lizarraga.demosync.ui

import android.annotation.SuppressLint
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
import dev.lizarraga.demosync.*
import dev.lizarraga.demosync.Constants.COLUMN_NAME
import dev.lizarraga.demosync.Constants.COLUMN_STATUS
import dev.lizarraga.demosync.Constants.DATA_SAVED_BROADCAST
import dev.lizarraga.demosync.Constants.NAME_NOT_SYNCED_WITH_SERVER
import dev.lizarraga.demosync.Constants.NAME_SYNCED_WITH_SERVER
import dev.lizarraga.demosync.Constants.URL_SAVE_NAME
import dev.lizarraga.demosync.databinding.ActivityMainBinding
import dev.lizarraga.demosync.db.DatabaseHelper
import dev.lizarraga.demosync.model.Name
import dev.lizarraga.demosync.receiver.NetworkStateChecker
import dev.lizarraga.demosync.service.VolleySingleton
import dev.lizarraga.demosync.ui.adapter.RVNameAdapter
import org.json.JSONException
import org.json.JSONObject

@Suppress("DEPRECATION", "Range")
open class MainActivity : AppCompatActivity(), View.OnClickListener {
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
            override fun onReceive(context: Context?, intent: Intent?) {
                loadNames()
            }
        }
        registerReceiver(broadcastReceiver, IntentFilter(DATA_SAVED_BROADCAST))
    }

    private fun loadNames() {
        names.clear()
        val cursor: Cursor = db.names
        if (cursor.moveToFirst()) {
            do {
                val name = Name(
                    cursor.getString(cursor.getColumnIndex(COLUMN_NAME)),
                    cursor.getInt(cursor.getColumnIndex(COLUMN_STATUS))
                )
                names.add(name)
            } while (cursor.moveToNext())
        }
        adaptador.adicionarListaNames(names)
    }

    private fun saveNameToServer() {
        displayLoading(this)
        val name = binding.editTextName.text.toString().trim { it <= ' ' }
        val stringRequest: StringRequest =
            object : StringRequest(
                Method.POST,
                URL_SAVE_NAME,
                Response.Listener { response ->
                    hideLoading()
                    try {
                        val obj = JSONObject(response)
                        if (!obj.getBoolean("error")) {
                            saveNameToLocalStorage(name, NAME_SYNCED_WITH_SERVER)
                        } else {
                            saveNameToLocalStorage(name, NAME_NOT_SYNCED_WITH_SERVER)
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                },
                Response.ErrorListener {
                    hideLoading()
                    saveNameToLocalStorage(name, NAME_NOT_SYNCED_WITH_SERVER)
                }) {
                override fun getParams(): MutableMap<String, String>? {
                    val params: MutableMap<String, String> = HashMap()
                    params["name"] = name
                    return params
                }
            }
        VolleySingleton.getInstance(this)!!.addToRequestQueue(stringRequest)
    }

    private fun saveNameToLocalStorage(name: String, status: Int) {
        binding.editTextName.setText("")
        db.addName(name, status)
        val n = Name(name, status)
        names.add(n)
        adaptador.adicionaName(n)
    }

    override fun onClick(view: View) {
        saveNameToServer()
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
