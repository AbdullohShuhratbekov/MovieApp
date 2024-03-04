package com.example.movieApp.domain.use_case.use_case_populare

import com.example.movieApp.data.base.model.ResultStatus
import com.example.movieApp.data.reposetory.MovieReposetoryImpl
import com.example.movieApp.domain.models.movie_domain_model.MovieDomainModel

class GetPopularMovieUseCaseImpl(
    private val response: MovieReposetoryImpl,
) : GetPopularMovieUseCase {
    override suspend fun invoke(): ResultStatus<List<MovieDomainModel>> =
        response.getMoviePopular()
}