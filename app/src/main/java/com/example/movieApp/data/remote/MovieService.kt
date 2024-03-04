package com.example.movieApp.data.remote

import com.example.movieApp.data.models.movie_model.MovieModelResults
import com.example.movieApp.data.models.movie_info.MovieInfoResponse
import com.example.movieApp.data.utils.Constants.API_KAY
import com.example.movieApp.data.utils.Constants.FETCH_MOVIE_INFO
import com.example.movieApp.data.utils.Constants.GET_NOW_PLAYING
import com.example.movieApp.data.utils.Constants.GET_POPULAR
import com.example.movieApp.data.utils.Constants.GET_TOP_RATED
import com.example.movieApp.data.utils.Constants.GET_UPCOMING
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {

    @GET(GET_TOP_RATED)
    suspend fun getMovieTopRated(
        @Query("api_key") apiKey: String = API_KAY,
        @Query("language") language: String = "ru",
    ): Response<MovieModelResults>

    @GET(FETCH_MOVIE_INFO)
    suspend fun getMovieInfo(
        @Path("Movie_id") movieId: Int,
    ):Response<MovieInfoResponse>

    @GET(GET_POPULAR)
    suspend fun getMoviePopular(
        @Query("api_key") apiKey: String = API_KAY,
        @Query("language") language: String = "ru",
    ): Response<MovieModelResults>


    @GET(GET_NOW_PLAYING)
    suspend fun getMovieNowPlaying(
        @Query("api_key") apiKey: String = API_KAY,
        @Query("language") language: String = "ru",
    ): Response<MovieModelResults>

    @GET(GET_UPCOMING)
    suspend fun getMovieUpcoming(
        @Query("api_key") apiKey: String = API_KAY,
        @Query("language") language: String = "ru",
    ): Response<MovieModelResults>
}