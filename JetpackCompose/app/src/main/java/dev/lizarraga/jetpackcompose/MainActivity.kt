package dev.lizarraga.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import dev.lizarraga.jetpackcompose.ui.theme.JetpackComposeTheme
import dev.lizarraga.jetpackcompose.viewmodel.SpeakerViewModel

class MainActivity : ComponentActivity() {
    private val speakerView: SpeakerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {

            }
        }
    }



    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {

    }
}