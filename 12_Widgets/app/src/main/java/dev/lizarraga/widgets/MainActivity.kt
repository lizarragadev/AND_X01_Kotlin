package dev.lizarraga.widgets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.lizarraga.widgets.databinding.ActivityMainBinding
import dev.lizarraga.widgets.ui.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnWidgets.setOnClickListener {
            startActivity(Intent(this, WidgetsActivity::class.java))
        }
        binding.btnPickers.setOnClickListener {
            startActivity(Intent(this, PickersActivity::class.java))
        }
        binding.btnWebView.setOnClickListener {
            startActivity(Intent(this, WebViewActivity::class.java))
        }
        binding.btnVideoView.setOnClickListener {
            startActivity(Intent(this, VideoViewActivity::class.java))
        }
    }
}