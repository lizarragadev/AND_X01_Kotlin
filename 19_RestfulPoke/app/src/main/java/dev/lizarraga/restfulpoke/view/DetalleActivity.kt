package dev.lizarraga.restfulpoke.view

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import dev.lizarraga.restfulpoke.databinding.ActivityDetalleBinding
import dev.lizarraga.restfulpoke.model.Pokemon

class DetalleActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetalleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pokemon = intent.getSerializableExtra("poke") as Pokemon

        val font = Typeface.createFromAsset(assets, "product_sans_bold.ttf")
        binding.tvDetalleNombre.typeface = font

        Glide.with(this)
            .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${pokemon.number}.png")
            .into(binding.ivDetalleImagen)
        binding.tvDetalleNombre.text = pokemon.name

    }
}