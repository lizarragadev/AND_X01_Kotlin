package dev.lizarraga.firebase.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import dev.lizarraga.firebase.Constants
import dev.lizarraga.firebase.databinding.ActivityAddContactBinding
import dev.lizarraga.firebase.model.Contact
import java.util.*
import kotlin.collections.HashMap

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