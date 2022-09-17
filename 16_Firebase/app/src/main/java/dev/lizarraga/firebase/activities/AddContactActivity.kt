package dev.lizarraga.firebase.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.lizarraga.firebase.databinding.ActivityAddContactBinding


class AddContactActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddContactBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddContactBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnFireCancelar.setOnClickListener {
            finish()
        }

        binding.btnFireGuardar.setOnClickListener {
            agregarNuevoContacto()
        }
    }

    private fun agregarNuevoContacto() {


    }
}