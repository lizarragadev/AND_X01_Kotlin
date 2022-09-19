package dev.lizarraga.googlemapsgeo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.lizarraga.googlemapsgeo.databinding.ActivityMainBinding
import dev.lizarraga.googlemapsgeo.ui.GeolocalizacionActivity
import dev.lizarraga.googlemapsgeo.ui.GoogleMapsMarkersActivity
import dev.lizarraga.googlemapsgeo.ui.GoogleMapsPolyActivity

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMapsMarkers.setOnClickListener {
            startActivity(Intent(this, GoogleMapsMarkersActivity::class.java))
        }

        binding.btnPolys.setOnClickListener {
            startActivity(Intent(this, GoogleMapsPolyActivity::class.java))
        }

        binding.btnGeolocalizacion.setOnClickListener {
            startActivity(Intent(this, GeolocalizacionActivity::class.java))
        }
    }
}