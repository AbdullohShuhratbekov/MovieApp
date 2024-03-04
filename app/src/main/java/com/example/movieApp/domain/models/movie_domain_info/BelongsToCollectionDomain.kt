package com.example.movieApp.domain.models.movie_domain_info

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class BelongsToCollectionDomain(
    val backdropPath: String,
    val id: Int,
    val name: String,
    val posterPath: String
):Serializable{
    companion object{
        val unknown = BelongsToCollectionDomain(
            backdropPath = "",
            id = 0,
            name = "",
            posterPath = ""

        )
    }
}