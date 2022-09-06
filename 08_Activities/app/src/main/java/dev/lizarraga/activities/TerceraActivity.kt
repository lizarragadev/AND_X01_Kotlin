package dev.lizarraga.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.lizarraga.activities.databinding.ActivityTerceraBinding

class TerceraActivity : AppCompatActivity() {
    lateinit var binding: ActivityTerceraBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTerceraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnTerceraVolver.setOnClickListener {
            //startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}