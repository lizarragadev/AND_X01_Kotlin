package dev.lizarraga.intents

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import dev.lizarraga.intents.databinding.ActivityMainBinding

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val FORM_RESULT = 7000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ibAbrirActivity.setOnClickListener {
            abrirActivity()
        }
        binding.ibEnviarDatos.setOnClickListener {
            enviarDatos()
        }
        binding.ibDevolverDatos.setOnClickListener {
            devolverDatos()
        }
    }

    fun abrirActivity() {
        startActivity(Intent(this, SegundaActivity::class.java))
    }
    fun enviarDatos() {
        val intent = Intent(this, SegundaActivity::class.java)
        intent.putExtra("valor1", "Gustavo")
        intent.putExtra("valor2", 77752810)
        startActivity(intent)
    }
    fun devolverDatos() {
        val intent = Intent(this, SegundaActivity::class.java)
        intent.putExtra("valor3", "Mi apellido es ")
        startActivityForResult(intent, FORM_RESULT)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == FORM_RESULT) {
            if(resultCode == Activity.RESULT_OK) {
                val resultado = data?.getStringExtra("respuesta")
                Toast.makeText(this, "Resultado: $resultado",
                    Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Se cancelo la respuesta",
                    Toast.LENGTH_LONG).show()
            }
        }
    }


}