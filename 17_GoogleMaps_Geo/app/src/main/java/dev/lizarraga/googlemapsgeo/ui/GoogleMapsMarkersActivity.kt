package dev.lizarraga.googlemapsgeo.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.MarkerOptions
import dev.lizarraga.googlemapsgeo.R
import dev.lizarraga.googlemapsgeo.databinding.ActivityGoogleMapsMarkersBinding

@SuppressLint("MissingPermission")
class GoogleMapsMarkersActivity : AppCompatActivity(), OnMapReadyCallback {
    lateinit var binding: ActivityGoogleMapsMarkersBinding
    lateinit var gMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGoogleMapsMarkersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.gMapMark) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }

    override fun onMapReady(googleMap: GoogleMap) {
        gMap = googleMap

        val latLngCentro = LatLng(-17.043021, -63.865743)
        val centroBolivia = CameraUpdateFactory.newLatLng(latLngCentro)
        val zoom = CameraUpdateFactory.zoomTo(5.3f)

        gMap.moveCamera(centroBolivia)
        gMap.animateCamera(zoom)

        //gMap.mapType = GoogleMap.MAP_TYPE_TERRAIN
        gMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(this, R.raw.map_style))

        gMap.addMarker(
            MarkerOptions()
                .position(latLngCentro)
                .title("Bolivia")
        )

        val coord = resources.getStringArray(R.array.coord_around_bol)
        val listaCoord = ArrayList<LatLng>()
        for (i in coord.indices) {
            val convertVect = coord[i].split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            listaCoord.add(LatLng(convertVect[0].toDouble(), convertVect[1].toDouble()))
        }
        for (i in listaCoord.indices) {
            gMap.addMarker(
                MarkerOptions()
                    .position(listaCoord[i])
                    .title("Marcador en posicion ${i+1}")
            )
        }

        gMap.setOnMarkerClickListener { mar ->
            when(mar.id) {
                "m1" -> Toast.makeText(this, "Click en marcador 1", Toast.LENGTH_SHORT).show()
            }
            return@setOnMarkerClickListener true
        }


    }


}










