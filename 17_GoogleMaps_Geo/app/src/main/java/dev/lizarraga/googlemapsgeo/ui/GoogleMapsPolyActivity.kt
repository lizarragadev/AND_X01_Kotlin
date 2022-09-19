package dev.lizarraga.googlemapsgeo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.lizarraga.googlemapsgeo.R
import dev.lizarraga.googlemapsgeo.databinding.ActivityGoogleMapsPolyBinding

class GoogleMapsPolyActivity : AppCompatActivity() {
    lateinit var binding: ActivityGoogleMapsPolyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGoogleMapsPolyBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }


    fun drawPolygon() {
        val coord = resources.getStringArray(R.array.coord_around_bol)
        val listaCoord = ArrayList<Any>()
        for(i in coord.indices) {
            val convertVect = (coord[i].split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray())

        }

    }
    
    fun drawPolyline() {
        val coord = resources.getStringArray(R.array.coord_bol)
        val listaCoord = ArrayList<Any>()
        for(i in coord.indices) {
            val convertVect = (coord[i].split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray())

        }

    }
}