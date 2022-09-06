package dev.lizarraga.funcionalidad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import dev.lizarraga.funcionalidad.databinding.ActivityMainBinding

// Llamar o referenciar a un recurso dentro el directorio "res"
// @tipoRecurso/nombreRecurso
// Ej. @drawable/imagen ,  @string/cadena  ,  @color/colorAzul
// Llamar o referencia a un recurso desde Kotlin o el directorio Java.
// R.tipoRecurso.nombreRecurso
// Ej. R.layout.activity_main , R.drawable.imagen , R.string.cadena

// La clase generada gracias a ViewBinding se llama:
// ActivityMainBinding.kt

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSuma.setOnClickListener {
            if(valida())
                opera(1)
            else
                printMensaje(1)
        }

        binding.btnResta.setOnClickListener {
            if(valida())
                opera(2)
            else
                printMensaje(1)
        }
        binding.btnMultiplica.setOnClickListener {
            if(valida())
                opera(3)
            else
                printMensaje(1)
        }
        binding.btnDivide.setOnClickListener {
            if(valida()) {
                if(binding.etNumber2.text.toString().toInt() != 0)
                    opera(4)
                else
                    printMensaje(2)
            } else
                printMensaje(1)
        }
    }

    fun printMensaje(tipo: Int) {
        if(tipo == 1)
            Toast.makeText(this, "Existen Campos Vacios", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(this, "No se puede realizar la división entre cero", Toast.LENGTH_LONG).show()
    }

    fun opera(tipo: Int) {
        val n1 = binding.etNumber1.text.toString().toInt()
        val n2 = binding.etNumber2.text.toString().toInt()
        when(tipo) {
            1 -> binding.tvResultado.text = "La suma es: \n${n1 + n2}"
            2 -> binding.tvResultado.text = "La resta es: \n${n1 - n2}"
            3 -> binding.tvResultado.text = "La multiplicacion es: \n${n1 * n2}"
            4 -> binding.tvResultado.text = "La division es: \n${n1 / n2}"
        }
    }

    fun valida() = binding.etNumber1.text.toString() != "" && binding.etNumber2.text.toString() != ""

}