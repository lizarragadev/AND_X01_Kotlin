package dev.lizarraga.firebase.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import dev.lizarraga.firebase.Constants
import dev.lizarraga.firebase.R
import dev.lizarraga.firebase.adapter.RVAdapterFirestore
import dev.lizarraga.firebase.databinding.ActivityFirestoreBinding
import dev.lizarraga.firebase.model.Contact

class FirestoreActivity : AppCompatActivity() {
    lateinit var binding: ActivityFirestoreBinding

    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var adaptador: RecyclerView.Adapter<*>
    lateinit var datos: ArrayList<Contact>

    lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirestoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = FirebaseFirestore.getInstance()

        layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvContacts.layoutManager = layoutManager
    }

    fun getContacts() {
        datos = ArrayList()
        binding.pbFirestore.visibility = View.VISIBLE
        db.collection(Constants.FIRE_COLLECTION_CONTACTOS)
            .get()
            .addOnSuccessListener { result ->
                result.forEach {
                    val cont: Contact = it.toObject(Contact::class.java)
                    cont.contactosId = it.id
                    datos.add(cont)
                }
                adaptador = RVAdapterFirestore(this, datos)
                binding.rvContacts.adapter = adaptador
                binding.pbFirestore.visibility = View.GONE
            }
            .addOnFailureListener { exc ->
                Toast.makeText(this, "${exc.message}", Toast.LENGTH_SHORT).show()
                binding.pbFirestore.visibility = View.GONE
            }
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

    override fun onResume() {
        super.onResume()
        getContacts()
    }

}