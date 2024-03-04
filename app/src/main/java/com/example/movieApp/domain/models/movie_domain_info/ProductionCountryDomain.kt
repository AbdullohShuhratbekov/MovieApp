package com.example.movieApp.domain.models.movie_domain_info

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ProductionCountryDomain(
    val iso31661: String,
    val name: String
):Serializable{
    companion object{
        val unknown = ProductionCountryDomain(
            iso31661 = "",
            name = ""
        )
    }
}