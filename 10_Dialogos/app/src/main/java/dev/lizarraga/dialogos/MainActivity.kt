package dev.lizarraga.dialogos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import dev.lizarraga.dialogos.databinding.ActivityMainBinding
import dev.lizarraga.dialogos.databinding.CustomDialogBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDialogoSimple.setOnClickListener{
            crearDialogoSimple().show()
        }
        binding.btnDialogoConLista.setOnClickListener {
            crearDialogoConLista().show()
        }
        binding.btnDialogoConListaRadio.setOnClickListener {
            crearDialogoConListaRadio().show()
        }
        binding.btnDialogoConListaCheckbox.setOnClickListener {
            crearDialogoConListaCheckbox().show()
        }
        binding.btnDialogoPersonalizado.setOnClickListener {
            crearDialogoPersonalizado()
        }
    }

    fun crearDialogoSimple() : AlertDialog {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog
            .setTitle("Mi Dialogo")
            .setMessage("Este es un contenido de mi dialogo")
            .setCancelable(false)
            .setPositiveButton("Aceptar") { a, b ->
                Toast.makeText(this, "Click en Aceptar", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Rechazar") { a, b ->
                Toast.makeText(this, "Click en Rechazar", Toast.LENGTH_SHORT).show()
            }
            .setNeutralButton("Salir") { a, b ->
                Toast.makeText(this, "Click en Salir", Toast.LENGTH_SHORT).show()
            }
        return alertDialog.create()
    }

    fun crearDialogoConLista(): AlertDialog {
        val alertDialog = AlertDialog.Builder(this)
        val opciones = arrayOf("Opcion 1", "Opcion 2", "Opcion 3", "Opcion 4", "Opcion 5", "Opcion 6")
        alertDialog
            .setTitle("Dialogo Lista")
            .setCancelable(false)
            .setItems(opciones) { a, i ->
                Toast.makeText(this, "Hizo click en ${opciones[i]}", Toast.LENGTH_LONG).show()
            }
            .setNeutralButton("Cancelar") { a, b ->
                Toast.makeText(this, "Click en Cancelar", Toast.LENGTH_SHORT).show()
            }
        return alertDialog.create()
    }

    fun crearDialogoConListaRadio(): AlertDialog {
        val alertDialog = AlertDialog.Builder(this)
        val opciones = arrayOf("Femenino", "Masculino", "Sin especificar")
        var posicion = 0
        alertDialog
            .setTitle("Dialogo Lista Radio")
            .setCancelable(false)
            .setSingleChoiceItems(opciones, 0) { a, i ->
                posicion = i
            }
            .setPositiveButton("Aceptar") { a, b ->
                Toast.makeText(this, "Selecciono: ${opciones[posicion]}", Toast.LENGTH_SHORT).show()
            }
        return alertDialog.create()
    }

    fun crearDialogoConListaCheckbox(): AlertDialog {
        val alertDialog = AlertDialog.Builder(this)
        val opciones = arrayOf("Android", "iOS", "Java", "Kotlin")
        var itemSeleccionados = ArrayList<Int>()
        alertDialog
            .setTitle("Dialogo Lista CheckBox")
            .setCancelable(false)
            .setMultiChoiceItems(opciones, null) { a, i, b ->
                if(b) {
                    itemSeleccionados.add(i)
                } else {
                    if(itemSeleccionados.contains(i)) {
                        itemSeleccionados.remove(i)
                    }
                }
            }
            .setPositiveButton("Aceptar") { a, b ->
                var res = ""
                itemSeleccionados.forEach {
                    res += "\n ${opciones[it]}"
                }
                Toast.makeText(this,
                    "Selecciono: $res",
                    Toast.LENGTH_SHORT).show()
            }
        return alertDialog.create()
    }

    fun crearDialogoPersonalizado() {
        val bind = CustomDialogBinding.inflate(layoutInflater)

        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setCancelable(false)
        alertDialog.setView(bind.root)

        val dialog = alertDialog.show()

        bind.btnCrear.setOnClickListener {
            Toast.makeText(this, "Nombre: ${bind.etNombre.text}", Toast.LENGTH_LONG).show()
            dialog.dismiss()
        }
        bind.btnEntrar.setOnClickListener {
            Toast.makeText(this, "Nombre: ${bind.etNombre.text}", Toast.LENGTH_LONG).show()
            dialog.dismiss()
        }
    }
}




