package dev.lizarraga.room.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.lizarraga.room.databinding.ItemNoteBinding
import dev.lizarraga.room.model.Note

class RVAdapter : ListAdapter<Note, RVAdapter.ViewHolder>(DiffCallback()) {

    inner class ViewHolder(val binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root)

    private lateinit var listener: RecyclerClickListener
    fun setItemListener(listener: RecyclerClickListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val noteHolder = ViewHolder(binding)

        binding.ivNoteDelete.setOnClickListener {
            listener.onItemRemoveClick(noteHolder.adapterPosition)
        }
        binding.cardNote.setOnClickListener {
            listener.onItemClick(noteHolder.adapterPosition)
        }
        return noteHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.binding.tvNoteTitle.text = currentItem.noteTitle
        holder.binding.tvNoteText.text = currentItem.noteText
    }

    class DiffCallback : DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(oldItem: Note, newItem: Note) =
            oldItem.dateAdded == newItem.dateAdded

        override fun areContentsTheSame(oldItem: Note, newItem: Note) =
            oldItem == newItem
    }
}