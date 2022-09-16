package dev.lizarraga.firebase.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.lizarraga.firebase.databinding.ActivityAddNoteBinding

class AddNoteActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddNoteBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnRealCancelar.setOnClickListener {
            finish()
        }

        binding.btnRealGuardar.setOnClickListener {
            agregarNuevaNota()
        }
    }

    private fun agregarNuevaNota() {

    }
}