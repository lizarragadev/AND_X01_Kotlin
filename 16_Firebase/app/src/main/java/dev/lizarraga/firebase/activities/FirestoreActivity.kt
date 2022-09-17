package dev.lizarraga.firebase.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.lizarraga.firebase.R
import dev.lizarraga.firebase.databinding.ActivityFirestoreBinding
import dev.lizarraga.firebase.model.Contact

class FirestoreActivity : AppCompatActivity() {
    lateinit var binding: ActivityFirestoreBinding

    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var adaptador: RecyclerView.Adapter<*>
    lateinit var datos: ArrayList<Contact>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirestoreBinding.inflate(layoutInflater)
        setContentView(binding.root)


        layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvContacts.layoutManager = layoutManager
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.itemAdd -> startActivity(Intent(this, AddContactActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }



}