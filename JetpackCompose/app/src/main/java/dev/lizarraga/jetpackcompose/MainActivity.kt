package dev.lizarraga.jetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.lizarraga.jetpackcompose.model.Speaker
import dev.lizarraga.jetpackcompose.ui.theme.JetpackComposeTheme
import dev.lizarraga.jetpackcompose.uibase.SpeakerCard
import dev.lizarraga.jetpackcompose.viewmodel.SpeakerViewModel

class MainActivity : ComponentActivity() {
    private val speakerView: SpeakerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                MainScreen()
            }
        }
    }

    @Composable
    fun MainScreen() {
        Column(modifier = Modifier.fillMaxSize()) {
            TopAppBar(title = {
                Text(text = "Jetpack Compose")
            })
            ShowList()
        }
    }

    @Composable
    fun ShowList() {
        val speakerData = speakerView.speakerList.value
        speakerData?.let {
            SetSpeakerList(speakerList = it)
        }
    }

    @Composable
    fun SetSpeakerList(speakerList: List<Speaker>) {
        LazyColumn {
            itemsIndexed(items = speakerList) { index, itemSpeaker ->
                SpeakerCard(speaker = itemSpeaker, onClick = {
                    Toast.makeText(applicationContext, "Hizo click en ${itemSpeaker.name}", Toast.LENGTH_LONG).show()
                })
            }
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {

    }
}