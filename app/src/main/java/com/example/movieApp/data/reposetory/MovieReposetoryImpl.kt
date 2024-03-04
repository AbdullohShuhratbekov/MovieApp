package com.example.movieApp.data.reposetory

import com.example.movieApp.data.base.BaseDataSource
import com.example.movieApp.data.base.model.ResultStatus
import com.example.movieApp.data.mappers.toDomain
import com.example.movieApp.data.remote.MovieService
import com.example.movieApp.domain.models.movie_domain_info.MovieInfoResponseDomain
import com.example.movieApp.domain.models.movie_domain_model.MovieDomainModel
import com.example.movieApp.domain.repository.MovieRepository
import javax.inject.Inject

class MovieReposetoryImpl @Inject constructor(
    private val service: MovieService
) : MovieRepository, BaseDataSource() {

    override suspend fun getMovieTopRated(): ResultStatus<List<MovieDomainModel>> {
        val response = invokeResponseRequest {
            service.getMovieTopRated()
        }
        return ResultStatus(
            status = response.status,
            errorThrowable = response.errorThrowable,
            data = response.data?.movieResults?.map { it.toDomain() })

    }

    override suspend fun getMoviePopular(): ResultStatus<List<MovieDomainModel>> {
        val response = invokeResponseRequest {
            service.getMoviePopular()
        }
        return ResultStatus(status = response.status,
            errorThrowable = response.errorThrowable,
            data = response.data?.movieResults?.map { it.toDomain() })

    }

    override suspend fun getMovieNowPlaying(): ResultStatus<List<MovieDomainModel>> {
        val response = invokeResponseRequest {
            service.getMovieNowPlaying()
        }
        return ResultStatus(status = response.status,
            errorThrowable = response.errorThrowable,
            data = response.data?.movieResults?.map { it.toDomain() })

    }

    override suspend fun getMovieUpcoming(): ResultStatus<List<MovieDomainModel>> {
        val response = invokeResponseRequest {
            service.getMovieUpcoming()
        }
        return ResultStatus(status = response.status,
            errorThrowable = response.errorThrowable,
            data = response.data?.movieResults?.map { it.toDomain() })

    }

    override suspend fun getMovieDetails(
        movieId :Int
    ): ResultStatus<MovieInfoResponseDomain> {
        val response = invokeResponseRequest {
            service.getMovieInfo(movieId)
        }
        return ResultStatus(status = response.status,
            errorThrowable = response.errorThrowable,
            data = response.data?.toDomain()
        )
    }
}