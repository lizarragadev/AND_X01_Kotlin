package dev.lizarraga.recyclerview.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.lizarraga.recyclerview.databinding.ActivityDetalleBinding

class DetalleActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetalleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}