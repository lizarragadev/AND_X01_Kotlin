package dev.lizarraga.room

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.lizarraga.room.adapter.RVAdapter
import dev.lizarraga.room.adapter.RecyclerClickListener
import dev.lizarraga.room.databinding.ActivityMainBinding
import dev.lizarraga.room.db.NoteDatabase
import dev.lizarraga.room.model.Note
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var adaptador: RVAdapter

    lateinit var binding: ActivityMainBinding

    val noteDatabase by lazy { NoteDatabase.getDatabase(this)!!.noteDao() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setRecyclerView()
        observeNotes()
    }

    private fun setRecyclerView() {
        layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvNotes.layoutManager = layoutManager
        binding.rvNotes.setHasFixedSize(true)


    }

    private fun observeNotes() {

    }

    private val newNoteResultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->

        }

    val editNoteResultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->

        }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.itemAddNote) {
            val intent = Intent(this, AddNoteActivity::class.java)
            newNoteResultLauncher.launch(intent)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_notes, menu)
        return true
    }
}