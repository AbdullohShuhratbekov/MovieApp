package com.example.movieApp.domain.use_case.use_case_up_caming

import com.example.movieApp.data.base.model.ResultStatus
import com.example.movieApp.data.reposetory.MovieReposetoryImpl
import com.example.movieApp.domain.models.movie_domain_model.MovieDomainModel

class GetMovieUpCamingUseCaseImple(
    private val response: MovieReposetoryImpl,
) : GetMovieUpCamingUseCase {
    override suspend fun invoke(): ResultStatus<List<MovieDomainModel>> =
        response.getMovieUpcoming()
}