package dev.lizarraga.widgets.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.webkit.WebViewClient
import dev.lizarraga.widgets.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {
    lateinit var binding: ActivityWebViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        setContentView(binding.root)

        binding.ibIr.setOnClickListener {
            irPaginaWeb(binding.etURL.text.toString())
            hideSoftKeyboard()
        }
        binding.etURL.setOnEditorActionListener { textView, i, keyEvent ->
            return@setOnEditorActionListener when(i) {
                EditorInfo.IME_ACTION_GO -> {
                    irPaginaWeb(binding.etURL.text.toString())
                    hideSoftKeyboard()
                    true
                }
                else -> false
            }
        }

    }

    fun irPaginaWeb(url: String) {
        binding.webView.webViewClient = WebViewClient()
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.settings.builtInZoomControls = true
        //binding.webView.setInitialScale(100)
        binding.webView.loadUrl("https://$url")
    }

    fun hideSoftKeyboard() {
        if(currentFocus != null) {
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        }
    }
}