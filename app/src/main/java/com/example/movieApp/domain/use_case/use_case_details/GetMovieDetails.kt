package com.example.movieApp.domain.use_case.use_case_details

import com.example.movieApp.data.base.model.ResultStatus
import com.example.movieApp.domain.models.movie_domain_info.MovieInfoResponseDomain
import com.example.movieApp.domain.models.movie_domain_model.MovieDomainModel

interface GetMovieDetails {

    suspend operator fun invoke(movieId: Int): ResultStatus<MovieInfoResponseDomain>

}