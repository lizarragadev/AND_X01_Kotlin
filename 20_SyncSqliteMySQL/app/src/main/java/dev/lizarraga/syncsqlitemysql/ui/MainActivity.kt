package dev.lizarraga.syncsqlitemysql.ui

import android.app.Dialog
import android.content.BroadcastReceiver
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.lizarraga.syncsqlitemysql.*
import dev.lizarraga.syncsqlitemysql.databinding.ActivityMainBinding
import dev.lizarraga.syncsqlitemysql.db.DatabaseHelper
import dev.lizarraga.syncsqlitemysql.model.Name
import dev.lizarraga.syncsqlitemysql.ui.adapter.RVNameAdapter

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


    }

    override fun onClick(p0: View?) {

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
