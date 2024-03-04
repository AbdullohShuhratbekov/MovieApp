package com.example.movieApp.data.models.movie_model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MovieModelResults(
    @SerializedName("results")
    val movieResults: List<MovieModel>,
) : Serializable {
    companion object{
        val unknown = MovieModelResults(
            movieResults = listOf()
        )
    }
}