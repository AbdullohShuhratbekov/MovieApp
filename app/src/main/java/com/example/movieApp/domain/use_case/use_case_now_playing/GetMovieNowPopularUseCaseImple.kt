package com.example.movieApp.domain.use_case.use_case_now_playing

import com.example.movieApp.data.base.model.ResultStatus
import com.example.movieApp.domain.models.movie_domain_model.MovieDomainModel
import com.example.movieApp.domain.repository.MovieRepository

class GetMovieNowPopularUseCaseImple(
    private val response: MovieRepository
) : GetMovieNowPopularUseCase {
    override suspend fun invoke(): ResultStatus<List<MovieDomainModel>> =
        response.getMovieNowPlaying()
}