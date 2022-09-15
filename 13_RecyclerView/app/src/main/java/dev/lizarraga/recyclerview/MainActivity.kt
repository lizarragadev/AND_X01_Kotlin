package dev.lizarraga.recyclerview

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.lizarraga.recyclerview.adapter.RVAdapter
import dev.lizarraga.recyclerview.databinding.ActivityMainBinding
import dev.lizarraga.recyclerview.model.Pokemon

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var datos: ArrayList<Pokemon>
    lateinit var adaptador: RecyclerView.Adapter<*>
    lateinit var layoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        //layoutManager = GridLayoutManager(this, 2)
        binding.rvContenido.layoutManager = layoutManager

        llenarPokemones()

        adaptador = RVAdapter(this, datos)
        binding.rvContenido.adapter = adaptador
    }

    fun llenarPokemones() {
        datos = ArrayList()
        val arrayNombres = resources.getStringArray(R.array.nombres)
        val arrayImagenes = resources.obtainTypedArray(R.array.imagenes)
        for(i in arrayNombres.indices) {
            val poke = Pokemon()
            poke.name = arrayNombres[i]
            poke.image = arrayImagenes.getResourceId(i, -1)
            datos.add(poke)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_opciones, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.menuUno -> Toast.makeText(this, "Opcion 1", Toast.LENGTH_SHORT).show()
            R.id.menuDos -> Toast.makeText(this, "Opcion 2", Toast.LENGTH_SHORT).show()
            R.id.menuTres -> Toast.makeText(this, "Opcion 3", Toast.LENGTH_SHORT).show()
            R.id.menuCuatro -> Toast.makeText(this, "Opcion 4", Toast.LENGTH_SHORT).show()
            R.id.menuCinco -> Toast.makeText(this, "Opcion 5", Toast.LENGTH_SHORT).show()
            R.id.subMenuUno -> Toast.makeText(this, "Sub menu 1", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

}