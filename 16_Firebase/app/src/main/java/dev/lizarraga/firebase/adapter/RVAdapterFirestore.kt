package dev.lizarraga.firebase.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import dev.lizarraga.firebase.databinding.ItemContactBinding
import dev.lizarraga.firebase.model.Contact

class RVAdapterFirestore(val context: Context, private val items: ArrayList<Contact>) : RecyclerView.Adapter<RVAdapterFirestore.ViewHolder>() {

    inner class ViewHolder(val binding: ItemContactBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemContactBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(items[position]) {
                binding.tvTitulo.text = this.nombre
                binding.tvSubtitulo.text = this.correo
                binding.tvSubtituloSegundo.text = this.telefono
                holder.itemView.setOnClickListener {
                    Toast.makeText(context, "${this.contactosId}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}