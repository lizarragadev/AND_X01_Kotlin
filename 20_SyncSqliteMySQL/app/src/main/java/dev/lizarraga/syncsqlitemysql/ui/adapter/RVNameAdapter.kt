package dev.lizarraga.syncsqlitemysql.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.lizarraga.syncsqlitemysql.R
import dev.lizarraga.syncsqlitemysql.databinding.ItemNamesBinding
import dev.lizarraga.syncsqlitemysql.model.Name

class RVNameAdapter: RecyclerView.Adapter<RVNameAdapter.ViewHolder>() {

    private val dataset: ArrayList<Name> = ArrayList()

    inner class ViewHolder(val binding: ItemNamesBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemNamesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val name = dataset[position] as Name
        with(holder) {
            binding.textViewName.text = name.name
            if(name.status == 0) {
                binding.imageViewStatus.setBackgroundResource(R.drawable.ic_warning)
            } else {
                binding.imageViewStatus.setBackgroundResource(R.drawable.ic_done)
            }
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    fun adicionarListaNames(listaNames: ArrayList<Name>) {
        dataset.clear()
        dataset.addAll(listaNames)
        notifyDataSetChanged()
    }

    fun adicionaName(name: Name) {
        dataset.add(name)
        notifyDataSetChanged()
    }
}