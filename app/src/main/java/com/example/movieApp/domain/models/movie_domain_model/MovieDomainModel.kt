package com.example.movieApp.domain.models.movie_domain_model

import com.example.movieApp.data.models.movie_model.MovieModel
import com.example.movieApp.data.utils.Constants
import java.io.Serializable
import javax.annotation.concurrent.Immutable

@Immutable
data class MovieDomainModel(
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
        val unknown = MovieModel(
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