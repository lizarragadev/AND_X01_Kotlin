package dev.lizarraga.restfulpoke.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Pokemon: Serializable {
    @SerializedName("name")
    lateinit var name: String
    @SerializedName("url")
    lateinit var url: String

    var number = 0
        get() {
            val urlParse = url.split("/".toRegex())
                .dropLastWhile {
                    it.isEmpty()
                }.toTypedArray()
            return Integer.parseInt(urlParse[urlParse.size - 1])
        }
}

