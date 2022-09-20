package dev.lizarraga.firebase.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import dev.lizarraga.firebase.Constants
import dev.lizarraga.firebase.databinding.ActivityAddContactBinding
import dev.lizarraga.firebase.model.Contact
import java.util.*

class AddContactActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddContactBinding
    lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = FirebaseFirestore.getInstance()

        binding.btnFireCancelar.setOnClickListener {
            finish()
        }

        binding.btnFireGuardar.setOnClickListener {
            agregarNuevoContacto()
        }
    }

    private fun agregarNuevoContacto() {
        val contact = Contact()
        contact.nombre = binding.etNombre.text.toString()
        contact.correo = binding.etEmail.text.toString()
        contact.telefono = binding.etTelefono.text.toString()

        binding.pbAddFirestore.visibility = View.VISIBLE
        db.collection(Constants.FIRE_COLLECTION_CONTACTOS).document(UUID.randomUUID().toString()).set(contact)
            .addOnSuccessListener {
                binding.pbAddFirestore.visibility = View.GONE
                Toast.makeText(this, "Contacto agregago exitosamente", Toast.LENGTH_SHORT).show()
                finish()
            }
            .addOnFailureListener {
                binding.pbAddFirestore.visibility = View.GONE
                Toast.makeText(this, "${it.toString()}", Toast.LENGTH_SHORT).show()
            }
    }
}








