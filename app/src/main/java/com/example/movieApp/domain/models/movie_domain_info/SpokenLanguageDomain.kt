package com.example.movieApp.domain.models.movie_domain_info

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SpokenLanguageDomain(
    val englishName: String,
    val iso6391: String,
    val name: String
):Serializable{
    companion object{
        val unknown = SpokenLanguageDomain(
            englishName = "",
            iso6391 = "",
            name = ""
        )
    }
}