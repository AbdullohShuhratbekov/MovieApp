package com.example.movieApp.domain.repository

import com.example.movieApp.data.base.model.ResultStatus
import com.example.movieApp.domain.models.movie_domain_info.MovieInfoResponseDomain
import com.example.movieApp.domain.models.movie_domain_model.MovieDomainModel

interface MovieRepository {

    suspend fun getMovieTopRated(): ResultStatus<List<MovieDomainModel>>

    suspend fun getMoviePopular(): ResultStatus<List<MovieDomainModel>>

    suspend fun getMovieNowPlaying(): ResultStatus<List<MovieDomainModel>>

    suspend fun getMovieUpcoming(): ResultStatus<List<MovieDomainModel>>

    suspend fun getMovieDetails(movieId: Int): ResultStatus<MovieInfoResponseDomain>

}