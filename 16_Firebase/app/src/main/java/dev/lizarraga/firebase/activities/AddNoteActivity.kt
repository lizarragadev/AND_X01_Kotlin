package dev.lizarraga.firebase.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.database.*
import dev.lizarraga.firebase.Constants
import dev.lizarraga.firebase.databinding.ActivityAddNoteBinding
import dev.lizarraga.firebase.model.Note
import java.util.*

class AddNoteActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddNoteBinding

    lateinit var db: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = FirebaseDatabase.getInstance().getReference(Constants.REAL_NOTES)

        binding.btnRealCancelar.setOnClickListener {
            finish()
        }

        binding.btnRealGuardar.setOnClickListener {
            agregarNuevaNota()
        }
    }

    private fun agregarNuevaNota() {
        val note = Note()
        note.titulo = binding.etTitulo.text.toString()
        note.contenido = binding.etContenido.text.toString()

        binding.pbAddReal.visibility = View.VISIBLE

        db.addListenerForSingleValueEvent(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                //db.push().setValue(note)
                db.child(UUID.randomUUID().toString()).setValue(note)
                binding.pbAddReal.visibility = View.GONE
                finish()
            }

            override fun onCancelled(error: DatabaseError) {
                binding.pbAddReal.visibility = View.GONE
            }
        })
    }
}




