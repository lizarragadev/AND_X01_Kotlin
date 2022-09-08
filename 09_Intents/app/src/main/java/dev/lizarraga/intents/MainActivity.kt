package dev.lizarraga.intents

import android.Manifest
import android.app.Activity
import android.app.SearchManager
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import dev.lizarraga.intents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ibAbrirActivity.setOnClickListener {
            abrirActivity()
        }
        binding.ibEnviarDatos.setOnClickListener {
            enviarDatos()
        }
        binding.ibDevolverDatos.setOnClickListener {
            devolverDatos()
        }
        binding.ibAbrirMarcado.setOnClickListener(this)
        binding.ibLlamar.setOnClickListener(this)
        binding.ibAbrirGoogleMaps.setOnClickListener(this)
        binding.ibAbrirStreetView.setOnClickListener(this)
        binding.ibAbrirPaginaWeb.setOnClickListener(this)
        binding.ibAbrirBuscador.setOnClickListener(this)
        binding.ibCompartirTexto.setOnClickListener(this)
        binding.ibCapturaImagen.setOnClickListener(this)
        binding.ibEnviarEmail.setOnClickListener(this)
        binding.ibAbrirApp.setOnClickListener(this)
    }
    override fun onClick(view: View?) {
        when(view?.id) {
            binding.ibAbrirMarcado.id -> abrirMarcado()
            binding.ibLlamar.id -> llamar()
            binding.ibAbrirGoogleMaps.id -> abrirGoogleMaps()
            binding.ibAbrirStreetView.id -> abrirStreetView()
            binding.ibAbrirPaginaWeb.id -> abrirPaginaWeb()
            binding.ibAbrirBuscador.id -> abrirBuscador()
            binding.ibCompartirTexto.id -> compartirTexto()
            binding.ibCapturaImagen.id -> capturarImagen()
            binding.ibEnviarEmail.id -> enviarEmail()
            binding.ibAbrirApp.id -> abrirApp()
        }
    }

    private fun abrirApp() {
        val intent = Intent(Intent.ACTION_MAIN)
        //intent.setClassName("com.facebook.katana","com.facebook.katana.LoginActivity")
        intent.setClassName("dev.lizarraga.activities","dev.lizarraga.activities.MainActivity")
        startActivity(intent)
    }

    private fun enviarEmail() {
        val to = arrayOf("lizarraga.dev@gmail.com", "kotlinlapaz@gmail.com")
        val cc = arrayOf("juliana32@gmail.com", "juanito111@gmail.com")
        val asunto = "Postulacion para Beca"
        val contenido = "Estimados amigops ..... "

        val intent = Intent(Intent.ACTION_SENDTO)
        intent.type = "text/plain"
        intent.data = Uri.parse("mailto:")
        intent.putExtra(Intent.EXTRA_EMAIL, to)
        intent.putExtra(Intent.EXTRA_CC, cc)
        intent.putExtra(Intent.EXTRA_SUBJECT, asunto)
        intent.putExtra(Intent.EXTRA_TEXT, contenido)

        startActivity(intent)
    }

    private fun capturarImagen() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        resultCamera.launch(intent)
    }
    val resultCamera = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if(result.resultCode == Activity.RESULT_OK) {
            val bitmap = result.data?.extras?.get("data") as Bitmap
            binding.ibCapturaImagen.setImageBitmap(bitmap)
        } else {
            Toast.makeText(this, "Se cancelo la captura de imagen", Toast.LENGTH_SHORT).show()
        }
    }

    private fun compartirTexto() {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, "Descarga esta aplicacion de: https://play.google.com")
        startActivity(intent)
    }

    private fun abrirBuscador() {
        val intent = Intent(Intent.ACTION_WEB_SEARCH)
        intent.putExtra(SearchManager.QUERY, "Android")
        startActivity(intent)
    }

    private fun abrirPaginaWeb() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("https://www.google.com")
        startActivity(intent)
    }

    private fun abrirStreetView() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("google.streetview:cbll=-16.529996,-68.100931")
        startActivity(intent)
    }

    private fun abrirGoogleMaps() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("geo:-16.529996, -68.100931")
        startActivity(intent)
    }

    private fun llamar() {
        val permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
        if(permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), 5000)
        } else {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:77752810")
            startActivity(intent)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode) {
            5000 -> {
                if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    llamar()
                } else {
                    Toast.makeText(this, "Permiso Denegado", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun abrirMarcado() {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:77752810")
        startActivity(intent)
    }

    fun abrirActivity() {
        startActivity(Intent(this, SegundaActivity::class.java))
    }
    fun enviarDatos() {
        val intent = Intent(this, SegundaActivity::class.java)
        intent.putExtra("valor1", "Gustavo")
        intent.putExtra("valor2", 77752810)
        startActivity(intent)
    }
    fun devolverDatos() {
        val intent = Intent(this, SegundaActivity::class.java)
        intent.putExtra("valor3", "Mi apellido es ")
        resultDevolverDatos.launch(intent)
    }
    val resultDevolverDatos = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if(result.resultCode == Activity.RESULT_OK) {
            val resultado = result.data?.getStringExtra("respuesta")
            Toast.makeText(this, "Resultado: $resultado",
                Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Se cancelo la respuesta",
                Toast.LENGTH_LONG).show()
        }
    }

}