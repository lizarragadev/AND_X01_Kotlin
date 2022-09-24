package dev.lizarraga.room

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.lizarraga.room.databinding.ActivityAddNoteBinding

class AddNoteActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddNoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val noteDateAdded = intent.getSerializableExtra("note_date_added")
        val noteTitleToEdit = intent.getStringExtra("note_title")
        val noteTextToEdit = intent.getStringExtra("note_text")

        binding.etTitulo.setText(noteTitleToEdit ?: "")
        binding.etTexto.setText(noteTextToEdit ?: "")

        binding.btnAddButton.setOnClickListener {
            val intent = Intent()
            intent.putExtra("note_date_added", noteDateAdded)
            intent.putExtra("note_title", binding.etTitulo.text.toString())
            intent.putExtra("note_text", binding.etTexto.text.toString())
            setResult(Activity.RESULT_OK, intent)
            onBackPressed()
        }

    }

}