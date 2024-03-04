package com.example.movieApp.data.mappers

import com.example.movieApp.data.models.movie_model.MovieModel
import com.example.movieApp.data.utils.Constants.POSTER_PATH_URL
import com.example.movieApp.domain.models.movie_domain_model.MovieDomainModel
import com.example.movieApp.presantation.models.MovieUiModel


fun MovieModel.toDomain() = MovieDomainModel(
    movieAbult = movieAbult,
    movieBackdrop = movieBackdrop,
    movieId = movieId,
    movieLanguage = movieLanguage,
    movieOriginalTitle = movieOriginalTitle,
    movieOverview = movieOverview,
    moviePopularity = moviePopularity,
    moviePoster = moviePoster + POSTER_PATH_URL,
    movieRelease = movieRelease,
    movieTitle = movieTitle,
    movieVideo = movieVideo,
    movieVoteAverage = movieVoteAverage,
    movieVoteCount = movieVoteCount,
    genreIds = genreIds
)


fun MovieDomainModel.toDomain() = MovieUiModel(
    movieAbult = movieAbult,
    movieBackdrop = movieBackdrop,
    movieId = movieId,
    movieLanguage = movieLanguage,
    movieOriginalTitle = movieOriginalTitle,
    movieOverview = movieOverview,
    moviePopularity = moviePopularity,
    moviePoster = moviePoster + POSTER_PATH_URL,
    movieRelease = movieRelease,
    movieTitle = movieTitle,
    movieVideo = movieVideo,
    movieVoteAverage = movieVoteAverage,
    movieVoteCount = movieVoteCount,
    genreIds = genreIds
)