package dev.lizarraga.firebase.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.lizarraga.firebase.R
import dev.lizarraga.firebase.databinding.ActivityRealtimeBinding
import dev.lizarraga.firebase.model.Note

class RealtimeActivity : AppCompatActivity() {
    lateinit var binding: ActivityRealtimeBinding

    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var adaptador: RecyclerView.Adapter<*>
    lateinit var datos: ArrayList<Note>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRealtimeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvNotes.layoutManager = layoutManager
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.itemAdd -> startActivity(Intent(this, AddNoteActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }

}