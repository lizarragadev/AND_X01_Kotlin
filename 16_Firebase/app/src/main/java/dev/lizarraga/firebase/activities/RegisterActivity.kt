package dev.lizarraga.firebase.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dev.lizarraga.firebase.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding

    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth

        binding.btnRegister.setOnClickListener {
            val correo = binding.etRegisterCorreo.text.toString()
            val pass = binding.etRegisterPassword.text.toString()
            auth.createUserWithEmailAndPassword(correo, pass)
                .addOnCompleteListener { task ->
                    if(task.isSuccessful) {
                        startActivity(Intent(this, LoginActivity::class.java))
                        finish()
                    } else {
                        Toast.makeText(this, "${task.exception}", Toast.LENGTH_SHORT).show()
                    }
                }
        }

    }
}