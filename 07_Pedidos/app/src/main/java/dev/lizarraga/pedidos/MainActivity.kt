package dev.lizarraga.pedidos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import dev.lizarraga.pedidos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var cantidad = 1
    val precio = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvCantidad.text = cantidad.toString()
    }
    fun menos(view: View) {
        if(cantidad > 1)
            cantidad--

        binding.tvCantidad.text = cantidad.toString()
    }
    fun mas(view: View) {
        cantidad++
        binding.tvCantidad.text = cantidad.toString()
    }
    fun calcular(view: View) {
        if (binding.etNombre.text.toString() != "") {
            binding.tvResumenCantidad.text = cantidad.toString()
            binding.tvResumenPrecioUnitario.text = "Bs. $precio"
            binding.tvResumenCostoTotal.text = "Bs. ${cantidad * precio}"
            binding.tvResumenNombre.text = binding.etNombre.text.toString()
        } else {
            Toast.makeText(this,
                "Escriba un nombre",
                Toast.LENGTH_LONG).show()
        }
    }
}
