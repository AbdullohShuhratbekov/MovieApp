package com.example.movieApp.domain.use_case.use_case_populare

import com.example.movieApp.data.base.model.ResultStatus
import com.example.movieApp.domain.models.movie_domain_model.MovieDomainModel

interface GetPopularMovieUseCase {
    suspend operator fun invoke(): ResultStatus<List<MovieDomainModel>>
}