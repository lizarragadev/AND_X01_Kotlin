package dev.lizarraga.jetpackcompose.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.lizarraga.jetpackcompose.R
import dev.lizarraga.jetpackcompose.model.Speaker

class SpeakerViewModel : ViewModel() {
    val speakerList: MutableLiveData<List<Speaker>> by lazy {
        MutableLiveData<List<Speaker>>()
    }
    private  var spList :ArrayList<Speaker> = ArrayList()

    init {
        getSpeakerList()
    }
    fun getSpeakerList(){
        fechList()
        speakerList.value = spList
    }
    private fun fechList(){
        spList.add(Speaker(R.drawable.speaker01,"Uriel Pacheco","Aplicacion iOS escalables con Clean Architecture"))
        spList.add(Speaker(R.drawable.speaker02,"Mauricio Hernandez","SRE para aplicaciones móviles"))
        spList.add(Speaker(R.drawable.speaker03,"Juan Guillermo Gomez","GRPC para Android - Un eficiente framework de comunicación RPC"))
        spList.add(Speaker(R.drawable.speaker04,"Carlo Huaman","Shortcuts & Capabilities API for Android"))
        spList.add(Speaker(R.drawable.speaker05,"Jose Dimas Lujan","Conoce Flutter Flow"))
        spList.add(Speaker(R.drawable.speaker06,"Adrian Catalan","Deep Learning para Desarrolladores Mobile"))
        spList.add(Speaker(R.drawable.speaker07,"Antonio Leiva","Jetpack Compose: (casi) todo lo que habias soñado para crear interfaces Android"))
        spList.add(Speaker(R.drawable.speaker08,"Frank Moreno","Introducción a la gestión de estados con Riverpod"))
        spList.add(Speaker(R.drawable.speaker09,"Facundo Rodriguez","Kotlin Multiplatform Mobile en la Universidad"))
        spList.add(Speaker(R.drawable.speaker10,"Brais Moure","¡Hola SwiftUI!"))
        spList.add(Speaker(R.drawable.speaker11,"Brian Castillo","Flutter Multiplatform"))
        spList.add(Speaker(R.drawable.speaker12,"Hansy Schmitt","Hardware & Flutter"))
        spList.add(Speaker(R.drawable.speaker13,"KotlinersKT","KSP: Khe Sta Pasandah!"))
        spList.add(Speaker(R.drawable.speaker14,"Anahí Salgado","State Hoisting with Jetpack Compose"))
        spList.add(Speaker(R.drawable.speaker15,"Cecilia Castillo","Haciendo el mundo más accesible: Como implementar accesibilidad en tus aplicaciones nativas"))
        spList.add(Speaker(R.drawable.speaker16,"Dinorah Tovar","Dinorah Tovar"))
        spList.add(Speaker(R.drawable.speaker17,"Bruno Aybar","React Native + Kotlin Multiplatform @Shopify"))
        spList.add(Speaker(R.drawable.speaker18,"Diego Velasquez","Nativo o Multiplataforma?"))
        spList.add(Speaker(R.drawable.speaker19,"Yury Camacho","Construyendo Android Apps nativas en el 2021"))
        spList.add(Speaker(R.drawable.speaker20,"Cristian Gomez","Hola Compose, Soy React"))
        spList.add(Speaker(R.drawable.speaker21,"Argel Bejarano","De Junior a Senior con Flutter"))
        spList.add(Speaker(R.drawable.speaker22,"Marco Erlwein","Blazor The Big Picture"))
        spList.add(Speaker(R.drawable.speaker23,"Santiago Carrillo","Inyección de Dependencias con Hilt"))
        spList.add(Speaker(R.drawable.speaker24,"Juan Villalvazo","Pasos para NO tener éxito como programador"))
    }
}