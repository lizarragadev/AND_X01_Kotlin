package dev.lizarraga.restfulpoke.model

import com.google.gson.annotations.SerializedName

class PokemonResponse  {
    @SerializedName("results")
    val results: ArrayList<Pokemon>? = null
}