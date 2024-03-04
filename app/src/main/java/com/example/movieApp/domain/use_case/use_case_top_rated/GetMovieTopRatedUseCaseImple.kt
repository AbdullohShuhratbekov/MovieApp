package com.example.movieApp.domain.use_case.use_case_top_rated

import com.example.movieApp.data.base.model.ResultStatus
import com.example.movieApp.data.reposetory.MovieReposetoryImpl
import com.example.movieApp.domain.models.movie_domain_model.MovieDomainModel

class GetMovieTopRatedUseCaseImple(
    private val response: MovieReposetoryImpl,
) : GetMovieTopRatedUseCase {
    override suspend fun invoke(): ResultStatus<List<MovieDomainModel>> =
        response.getMovieTopRated()
}
