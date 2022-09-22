package dev.lizarraga.googlemapsgeo.ui

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.LocationManager
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dev.lizarraga.googlemapsgeo.databinding.ActivityGeolocalizacionBinding
import java.util.*

@SuppressLint("MissingPermission")
class GeolocalizacionActivity : AppCompatActivity() {
    lateinit var binding: ActivityGeolocalizacionBinding
    private val permissionId = 2
    lateinit var mFusedLocationClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGeolocalizacionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        binding.btnLocalizacion.setOnClickListener {
            getLocation()
        }
    }

    private fun getLocation() {
        if(checkPermissions()) {
            if(isLocationEnabled()) {
                mFusedLocationClient.lastLocation.addOnCompleteListener(this) { task -> 
                    val location = task.result
                    Toast.makeText(this, "Lat: ${location.latitude} - Lon: ${location.longitude}", Toast.LENGTH_SHORT).show()    
                    if(location != null) {
                        val geoCoder = Geocoder(this, Locale.getDefault())
                        val list: List<Address> = geoCoder.getFromLocation(location.latitude, location.longitude, 1)
                        binding.apply { 
                            tvLatitud.text = "Latitud\n${list[0].latitude}"
                            tvLongitud.text = "Longitud\n${list[0].longitude}"
                            tvNomrbePais.text = "País\n${list[0].countryName}"
                            tvLocalidad.text = "Localidad\n${list[0].locality}"
                            tvDireccion.text = "Dirección\n${list[0].getAddressLine(0)}"
                        }
                    }
                }
            } else {
                Toast.makeText(this, "Active la localizacion", Toast.LENGTH_SHORT).show()
                startActivity(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS))
            }
        } else {
            requestPermissions()
        }
    }

    private fun checkPermissions(): Boolean {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            return true
        }
        return false
    }

    private fun isLocationEnabled(): Boolean {
        val locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
    }

    private fun requestPermissions() {
        ActivityCompat.requestPermissions(this,
            arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION),
            permissionId
        )
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == permissionId) {
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                getLocation()
            }
        }
    }
}










