package dev.lizarraga.firebase.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import dev.lizarraga.firebase.databinding.ItemNoteBinding
import dev.lizarraga.firebase.model.Note

class RVAdapterReal(val context: Context, private val items: ArrayList<Note>) : RecyclerView.Adapter<RVAdapterReal.ViewHolder>() {

    inner class ViewHolder(val binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(items[position]) {
                binding.tvTitulo.text = this.titulo
                binding.tvSubtitulo.text = this.contenido
                holder.itemView.setOnClickListener {
                    Toast.makeText(context, "${this.titulo}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}