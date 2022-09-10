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

        binding.continuousSeekbar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekbar: SeekBar?) {
                Toast.makeText(applicationContext, "${seekbar?.progress}", Toast.LENGTH_LONG).show()
            }
        })

        binding.ratingBar.setOnRatingBarChangeListener { ratingBar, rating, b ->
            Toast.makeText(this, "Valor: $rating / ${ratingBar.numStars}", Toast.LENGTH_SHORT).show()
        }

    }

}