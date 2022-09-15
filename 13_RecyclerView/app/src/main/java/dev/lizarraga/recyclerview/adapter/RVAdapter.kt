package dev.lizarraga.recyclerview.adapter

import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.lizarraga.recyclerview.databinding.ItemPokemonBinding
import dev.lizarraga.recyclerview.model.Pokemon
import dev.lizarraga.recyclerview.ui.DetalleActivity

class RVAdapter(val context: Context, private val items: ArrayList<Pokemon>) : RecyclerView.Adapter<RVAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemPokemonBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val myFont = Typeface.createFromAsset(context.assets, "fonts/product_sans_bold.ttf")

        with(holder) {
            with(items[position]) {
                binding.tvNombre.typeface = myFont
                binding.tvNombre.text = this.name
                binding.ivImagen.setImageResource(this.image)

                holder.itemView.setOnClickListener {
                    val intent = Intent(context, DetalleActivity::class.java)
                    intent.putExtra("poke", this)
                    context.startActivity(intent)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}