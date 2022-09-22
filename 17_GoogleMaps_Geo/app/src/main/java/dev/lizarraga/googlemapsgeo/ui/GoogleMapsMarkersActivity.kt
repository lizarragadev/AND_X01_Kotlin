package dev.lizarraga.googlemapsgeo.ui

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
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

        gMap.uiSettings.isZoomControlsEnabled = true
        gMap.uiSettings.isZoomGesturesEnabled = false
        gMap.uiSettings.isScrollGesturesEnabled = false
        gMap.uiSettings.isRotateGesturesEnabled = false

        activarUbicacion()
    }

    fun activarUbicacion() {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            gMap.isMyLocationEnabled = true
            gMap.uiSettings.isMyLocationButtonEnabled = true
        } else {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1)
        }
    }

    override fun onRequestPermissionsResult(requestCode: kotlin.Int, permissions: kotlin.Array<out kotlin.String>, grantResults: kotlin.IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == 1) {
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                activarUbicacion()
            }
        }
    }

}










