package dev.lizarraga.googlemapsgeo.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.lizarraga.googlemapsgeo.databinding.ActivityGoogleMapsMarkersBinding

@SuppressLint("MissingPermission")
class GoogleMapsMarkersActivity : AppCompatActivity() {
    lateinit var binding: ActivityGoogleMapsMarkersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGoogleMapsMarkersBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }


}