package dev.lizarraga.recyclerview.ui

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.lizarraga.recyclerview.databinding.ActivityDetalleBinding
import dev.lizarraga.recyclerview.model.Pokemon

class DetalleActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetalleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pokemon = intent.getSerializableExtra("poke") as Pokemon

        val myFont = Typeface.createFromAsset(assets, "fonts/product_sans_bold.ttf")

        binding.tvDetalleNombre.typeface = myFont
        binding.tvDetalleNombre.text = pokemon.name
        binding.ivDetalleImagen.setImageResource(pokemon.image)
    }
}