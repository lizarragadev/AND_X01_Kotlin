package dev.lizarraga.firebase.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.lizarraga.firebase.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
}