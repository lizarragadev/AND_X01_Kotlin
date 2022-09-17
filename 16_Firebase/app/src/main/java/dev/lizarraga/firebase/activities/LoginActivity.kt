package dev.lizarraga.firebase.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dev.lizarraga.firebase.MainActivity
import dev.lizarraga.firebase.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding

    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = Firebase.auth

        if(auth.currentUser != null) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvRegistrarse.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
            finish()
        }

        binding.btnLogIn.setOnClickListener {
            val correo = binding.etUsuario.text.toString()
            val pass = binding.etPassword.text.toString()
            auth.signInWithEmailAndPassword(correo, pass)
                .addOnCompleteListener { task ->
                    if(task.isSuccessful) {
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    } else {
                        Toast.makeText(this, "${task.exception}", Toast.LENGTH_SHORT).show()
                    }
                }
        }


    }
}