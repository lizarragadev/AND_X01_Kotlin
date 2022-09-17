package dev.lizarraga.firebase.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import dev.lizarraga.firebase.Constants
import dev.lizarraga.firebase.R
import dev.lizarraga.firebase.adapter.RVAdapterReal
import dev.lizarraga.firebase.databinding.ActivityRealtimeBinding
import dev.lizarraga.firebase.model.Contact
import dev.lizarraga.firebase.model.Note

class RealtimeActivity : AppCompatActivity() {
    lateinit var binding: ActivityRealtimeBinding

    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var adaptador: RecyclerView.Adapter<*>
    lateinit var datos: ArrayList<Note>

    lateinit var db: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRealtimeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = FirebaseDatabase.getInstance().getReference(Constants.REAL_NOTES)

        layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvNotes.layoutManager = layoutManager
    }

    override fun onResume() {
        super.onResume()
        getNotes()
    }

    fun getNotes() {
        datos = ArrayList()
        binding.pbRealtime.visibility = View.VISIBLE

        db.addChildEventListener(object: ChildEventListener {
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                snapshot.getValue(Note::class.java)?.let { datos.add(it) }
                adaptador = RVAdapterReal(applicationContext, datos)
                binding.rvNotes.adapter = adaptador
                binding.pbRealtime.visibility = View.GONE
            }

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
            }

            override fun onChildRemoved(snapshot: DataSnapshot) {
            }

            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })
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