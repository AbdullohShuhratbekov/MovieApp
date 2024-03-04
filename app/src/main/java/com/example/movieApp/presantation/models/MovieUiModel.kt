package com.example.movieApp.presantation.models

import com.example.movieApp.data.utils.Constants
import java.io.Serializable

data class MovieUiModel (
    val movieAbult: Boolean,
    val movieBackdrop: String,
    val genreIds: List<Int>,
    val movieId: Int,
    val movieLanguage: String,
    val movieOriginalTitle: String,
    val movieOverview: String,
    val moviePopularity: Double,
    val moviePoster: String,
    val movieRelease: String,
    val movieTitle: String,
    val movieVideo: Boolean,
    val movieVoteAverage: Double,
    val movieVoteCount: Int,
) : Serializable {
    companion object {
        val unknown = MovieUiModel(
            movieAbult = true,
            movieBackdrop = Constants.EMPTY_STRING,
            movieId = 0,
            movieLanguage = Constants.EMPTY_STRING,
            movieOriginalTitle = Constants.EMPTY_STRING,
            movieOverview = Constants.EMPTY_STRING,
            moviePopularity = 0.0,
            moviePoster = Constants.EMPTY_STRING,
            movieRelease = Constants.EMPTY_STRING,
            movieTitle = Constants.EMPTY_STRING,
            movieVideo = true,
            movieVoteAverage = 0.0,
            movieVoteCount = 0,
            genreIds = listOf(0)

        )
    }
}

