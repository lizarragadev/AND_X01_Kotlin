package dev.lizarraga.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import dev.lizarraga.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityMainBinding

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("mis_preferencias", Context.MODE_PRIVATE)

        if(!sharedPreferences.getBoolean("primeraVez", false)) {
            val editor = sharedPreferences.edit()
            editor.putBoolean("primeraVez", true)
            editor.apply()
            binding.etLabelInit.text = "Es primera vez que ingresas"
        } else {
            binding.etLabelInit.text = "Ya ingresaste mas de una vez"
        }

        binding.btnGuardarUno.setOnClickListener(this)
        binding.btnGuardarDos.setOnClickListener(this)
        binding.btnLeerUno.setOnClickListener(this)
        binding.btnLeerDos.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btnGuardarUno -> guardarValor("valor1", binding.etTextoUno.text.toString(), binding.etTextoUno)
            R.id.btnLeerUno -> binding.etTextoUno.setText(leerValor("valor1"))
            R.id.btnGuardarDos -> guardarValor("valor2", binding.etTextoDos.text.toString(), binding.etTextoDos)
            R.id.btnLeerDos -> binding.etTextoDos.setText(leerValor("valor2"))
        }
    }

    fun guardarValor(nombre: String, contenido: String, et: EditText) {
        val editor = sharedPreferences.edit()
        editor.putString(nombre, contenido)
        editor.apply()
        et.setText("")
        Toast.makeText(this, "Se guardo exitosamente", Toast.LENGTH_SHORT).show()
    }

    fun leerValor(nombre: String) = sharedPreferences.getString(nombre, "").toString()


}









