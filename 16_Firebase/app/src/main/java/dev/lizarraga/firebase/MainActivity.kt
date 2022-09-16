package dev.lizarraga.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.firebase.auth.ktx.auth
import dev.lizarraga.firebase.activities.FirestoreActivity
import dev.lizarraga.firebase.activities.LoginActivity
import dev.lizarraga.firebase.activities.RealtimeActivity
import dev.lizarraga.firebase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnRealtime.setOnClickListener {
            startActivity(Intent(this, RealtimeActivity::class.java))
        }
        binding.btnFirestore.setOnClickListener {
            startActivity(Intent(this, FirestoreActivity::class.java))
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_user, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.itemLogout -> logOut()
        }
        return super.onOptionsItemSelected(item)
    }

    fun logOut() {

    }
}