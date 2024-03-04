package com.example.movieApp.data.models.movie_model

import com.example.movieApp.data.utils.Constants.EMPTY_STRING
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MovieModel(
    @SerializedName("adult")
    val movieAbult: Boolean,
    @SerializedName("backdrop_path")
    val movieBackdrop: String,
    @SerializedName("genre_ids")
    val genreIds: List<Int>,
    @SerializedName("id")
    val movieId: Int,
    @SerializedName("original_language")
    val movieLanguage: String,
    @SerializedName("original_title")
    val movieOriginalTitle: String,
    @SerializedName("overview")
    val movieOverview: String,
    @SerializedName("popularity")
    val moviePopularity: Double,
    @SerializedName("poster_path")
    val moviePoster: String,
    @SerializedName("release_date")
    val movieRelease: String,
    @SerializedName("title")
    val movieTitle: String,
    @SerializedName("video")
    val movieVideo: Boolean,
    @SerializedName("vote_average")
    val movieVoteAverage: Double,
    @SerializedName("vote_count")
    val movieVoteCount: Int,
) : Serializable {
    companion object {
        val unknown = MovieModel(
            movieAbult = true,
            movieBackdrop = EMPTY_STRING,
            movieId = 0,
            movieLanguage = EMPTY_STRING,
            movieOriginalTitle = EMPTY_STRING,
            movieOverview = EMPTY_STRING,
            moviePopularity = 0.0,
            moviePoster = EMPTY_STRING,
            movieRelease = EMPTY_STRING,
            movieTitle = EMPTY_STRING,
            movieVideo = true,
            movieVoteAverage = 0.0,
            movieVoteCount = 0,
            genreIds = listOf(0)

        )
    }
}