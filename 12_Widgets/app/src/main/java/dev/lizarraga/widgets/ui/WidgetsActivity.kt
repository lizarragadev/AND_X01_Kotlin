package dev.lizarraga.widgets.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import dev.lizarraga.widgets.databinding.ActivityWidgetsBinding

class WidgetsActivity : AppCompatActivity() {
    lateinit var binding: ActivityWidgetsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWidgetsBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }

}