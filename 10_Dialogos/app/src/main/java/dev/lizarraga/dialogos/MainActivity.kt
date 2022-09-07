package dev.lizarraga.dialogos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.lizarraga.dialogos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDialogoSimple.setOnClickListener{

        }
        binding.btnDialogoConLista.setOnClickListener {

        }
        binding.btnDialogoConListaRadio.setOnClickListener {

        }
        binding.btnDialogoConListaCheckbox.setOnClickListener {

        }
        binding.btnDialogoPersonalizado.setOnClickListener {

        }
    }

}