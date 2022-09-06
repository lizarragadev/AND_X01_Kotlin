package dev.lizarraga.intents

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.lizarraga.intents.databinding.ActivitySegundaBinding

class SegundaActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySegundaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySegundaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras

        if(bundle != null) {
            binding.tvTextoUno.text = bundle.getString("valor1", "")
            binding.tvTextoDos.text = bundle.getInt("valor2", 0).toString()
            binding.etCajaTexto.setText(bundle.getString("valor3", ""))
        }

        binding.btnRespuesta.setOnClickListener {
            val intent = Intent()
            intent.putExtra("respuesta", binding.etCajaTexto.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

    }
}