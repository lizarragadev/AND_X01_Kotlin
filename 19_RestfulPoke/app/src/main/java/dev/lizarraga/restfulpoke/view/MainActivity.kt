package dev.lizarraga.restfulpoke.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.lizarraga.restfulpoke.databinding.ActivityMainBinding
import dev.lizarraga.restfulpoke.model.PokemonResponse
import dev.lizarraga.restfulpoke.service.PokeInterface
import dev.lizarraga.restfulpoke.view.adapter.PokemonAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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

        val layoutManager = GridLayoutManager(this, 3)
        binding.recyclerView.layoutManager = layoutManager

        retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        sePuedeCargar = true
        desdePosicion = 0
        obtenerDatos(desdePosicion)

        binding.recyclerView.addOnScrollListener(object: RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if(dy > 0) {
                    val visibleCount = layoutManager.childCount
                    val totalItemCount = layoutManager.itemCount
                    val pastVisibleItems = layoutManager.findFirstVisibleItemPosition()
                    if(sePuedeCargar) {
                        if(visibleCount + pastVisibleItems >= totalItemCount) {
                            sePuedeCargar = false
                            desdePosicion+=20
                            obtenerDatos(desdePosicion)
                        }
                    }
                }
            }
        })

    }

    fun obtenerDatos(offset: Int) {
        val service = retrofit.create(PokeInterface::class.java)
        val pokemonResponseCall = service.obtenerListaPokemon(offset, 20)

        binding.llCarga.visibility = View.VISIBLE

        pokemonResponseCall.enqueue(object: Callback<PokemonResponse> {
            override fun onResponse(call: Call<PokemonResponse>, response: Response<PokemonResponse>) {
                binding.llCarga.visibility = View.GONE
                if(response.isSuccessful) {
                    sePuedeCargar = true
                    val pokemonResponse = response.body()
                    val listaPokemon = pokemonResponse?.results
                    listaPokemon?.let { listaPokemonAdapter.adicionarListaPokemon(it) }
                }
            }

            override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {
                binding.llCarga.visibility = View.GONE
            }
        })
    }

}