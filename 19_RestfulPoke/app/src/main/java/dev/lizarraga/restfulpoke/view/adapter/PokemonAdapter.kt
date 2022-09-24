package dev.lizarraga.restfulpoke.view.adapter

import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import dev.lizarraga.restfulpoke.R
import dev.lizarraga.restfulpoke.databinding.ItemPokeBinding
import dev.lizarraga.restfulpoke.model.Pokemon
import dev.lizarraga.restfulpoke.view.DetalleActivity

class PokemonAdapter(private val context: Context) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    private val dataset: ArrayList<Pokemon> = ArrayList()

    inner class ViewHolder(val binding: ItemPokeBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPokeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val poke = dataset[position]

        val fontBold = Typeface.createFromAsset(context.assets, "product_sans_bold.ttf")
        val requestOption = RequestOptions().placeholder(R.drawable.pokeball).centerCrop()

        with(holder) {
            this.binding.tvNombre.typeface = fontBold
            this.binding.tvNombre.text = poke.name
            Glide.with(context)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${poke.number}.png")
                .apply(requestOption)
                .into(this.binding.ivImagen)
            this.itemView.setOnClickListener {
                val intent = Intent(context, DetalleActivity::class.java)
                intent.putExtra("poke", poke)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    fun adicionarListaPokemon(listaPokemon: ArrayList<Pokemon>) {
        dataset.addAll(listaPokemon)
        notifyDataSetChanged()
    }
}