package dev.lizarraga.googlemapsgeo.ui

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.PolygonOptions
import com.google.android.gms.maps.model.PolylineOptions
import dev.lizarraga.googlemapsgeo.R
import dev.lizarraga.googlemapsgeo.databinding.ActivityGoogleMapsPolyBinding

class GoogleMapsPolyActivity : AppCompatActivity(), OnMapReadyCallback {
    lateinit var binding: ActivityGoogleMapsPolyBinding
    lateinit var gMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGoogleMapsPolyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.gMapPoly) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        gMap = googleMap

        //drawPolygon()
        drawPolyline()

        val latLngCentro = LatLng(-17.043021, -63.865743)
        val centroBolivia = CameraUpdateFactory.newLatLng(latLngCentro)
        val zoom = CameraUpdateFactory.zoomTo(5.3f)

        gMap.moveCamera(centroBolivia)
        gMap.animateCamera(zoom)
    }

    fun drawPolygon() {
        val coord = resources.getStringArray(R.array.coord_around_bol)
        val listaCoord = ArrayList<LatLng>()
        for(i in coord.indices) {
            val convertVect = (coord[i].split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray())
            listaCoord.add(LatLng(convertVect[0].toDouble(), convertVect[1].toDouble()))
        }
        val polygon = PolygonOptions()
        polygon.addAll(listaCoord)
            .strokeColor(Color.BLUE)
            .fillColor(Color.CYAN)

        gMap.addPolygon(polygon)
    }
    
    fun drawPolyline() {
        val coord = resources.getStringArray(R.array.coord_bol)
        val listaCoord = ArrayList<LatLng>()
        for(i in coord.indices) {
            val convertVect = (coord[i].split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray())
            listaCoord.add(LatLng(convertVect[0].toDouble(), convertVect[1].toDouble()))
        }
        val polilinea = PolylineOptions()
        polilinea.addAll(listaCoord)
            .color(Color.RED)

        gMap.addPolyline(polilinea)
    }
}