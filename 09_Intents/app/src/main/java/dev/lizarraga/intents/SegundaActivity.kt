package dev.lizarraga.intents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.lizarraga.intents.databinding.ActivitySegundaBinding

class SegundaActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySegundaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySegundaBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}