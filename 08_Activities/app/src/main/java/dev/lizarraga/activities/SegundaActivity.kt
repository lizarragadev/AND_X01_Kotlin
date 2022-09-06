package dev.lizarraga.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.lizarraga.activities.databinding.ActivitySegundaBinding

class SegundaActivity : AppCompatActivity() {
    lateinit var binding: ActivitySegundaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySegundaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSegundaVolver.setOnClickListener {
            finish()
        }
    }
}