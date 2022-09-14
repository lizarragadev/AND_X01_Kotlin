package dev.lizarraga.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import dev.lizarraga.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        binding.btnGuardarUno.setOnClickListener(this)
        binding.btnGuardarDos.setOnClickListener(this)
        binding.btnLeerUno.setOnClickListener(this)
        binding.btnLeerDos.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {

        }
    }

}