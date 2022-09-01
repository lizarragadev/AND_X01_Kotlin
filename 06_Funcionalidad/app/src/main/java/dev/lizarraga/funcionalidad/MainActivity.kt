package dev.lizarraga.funcionalidad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

// Llamar o referenciar a un recurso dentro el directorio "res"
// @tipoRecurso/nombreRecurso
// Ej. @drawable/imagen ,  @string/cadena  ,  @color/colorAzul
// Llamar o referencia a un recurso desde Kotlin o el directorio Java.
// R.tipoRecurso.nombreRecurso
// Ej. R.layout.activity_main , R.drawable.imagen , R.string.cadena

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSuma.setOnClickListener {
            if(valida())
                opera(1)
            else
                printMensaje(1)
        }

        btnResta.setOnClickListener {
            if(valida())
                opera(2)
            else
                printMensaje(1)
        }
        btnMultiplica.setOnClickListener {
            if(valida())
                opera(3)
            else
                printMensaje(1)
        }
        btnDivide.setOnClickListener {
            if(valida()) {
                if(etNumber2.text.toString().toInt() != 0)
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
        val n1 = etNumber1.text.toString().toInt()
        val n2 = etNumber2.text.toString().toInt()
        when(tipo) {
            1 -> tvResultado.text = "La suma es: \n${n1 + n2}"
            2 -> tvResultado.text = "La resta es: \n${n1 - n2}"
            3 -> tvResultado.text = "La multiplicacion es: \n${n1 * n2}"
            4 -> tvResultado.text = "La division es: \n${n1 / n2}"
        }
    }

    fun valida() = etNumber1.text.toString() != "" && etNumber2.text.toString() != ""

}