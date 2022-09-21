package dev.lizarraga.restfulpoke.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.lizarraga.restfulpoke.databinding.ActivityMainBinding
import dev.lizarraga.restfulpoke.view.adapter.PokemonAdapter
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var retrofit: Retrofit
    lateinit var listaPokemonAdapter: PokemonAdapter
    var desdePosicion = 0
    var cantidadAObtener = 20
    var sePuedeCargar: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listaPokemonAdapter = PokemonAdapter(this)
        binding.recyclerView.adapter = listaPokemonAdapter
        binding.recyclerView.setHasFixedSize(true)

    }

}