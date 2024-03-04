package com.example.movieApp.di

import com.example.movieApp.data.reposetory.MovieReposetoryImpl
import com.example.movieApp.domain.use_case.use_case_details.GetMovieDetails
import com.example.movieApp.domain.use_case.use_case_details.GetMovieDetailsImple
import com.example.movieApp.domain.use_case.use_case_now_playing.GetMovieNowPopularUseCase
import com.example.movieApp.domain.use_case.use_case_now_playing.GetMovieNowPopularUseCaseImple
import com.example.movieApp.domain.use_case.use_case_populare.GetPopularMovieUseCase
import com.example.movieApp.domain.use_case.use_case_populare.GetPopularMovieUseCaseImpl
import com.example.movieApp.domain.use_case.use_case_top_rated.GetMovieTopRatedUseCase
import com.example.movieApp.domain.use_case.use_case_top_rated.GetMovieTopRatedUseCaseImple
import com.example.movieApp.domain.use_case.use_case_up_caming.GetMovieUpCamingUseCase
import com.example.movieApp.domain.use_case.use_case_up_caming.GetMovieUpCamingUseCaseImple
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainModel {
    @Provides
    fun providesGetMovieUseCase(
        repositorys: MovieReposetoryImpl
    ): GetPopularMovieUseCase = GetPopularMovieUseCaseImpl(response = repositorys)

    @Provides
    fun providesGetMovieNowPlayingUseCase(
        repositorys: MovieReposetoryImpl
    ): GetMovieNowPopularUseCase = GetMovieNowPopularUseCaseImple(response = repositorys)

    @Provides
    fun providesGetMovieTopRadedUseCase(
        repositorys: MovieReposetoryImpl
    ): GetMovieTopRatedUseCase = GetMovieTopRatedUseCaseImple(response = repositorys)

    @Provides
    fun providesGetMovieUpCamingUseCase(
        repositorys: MovieReposetoryImpl
    ): GetMovieUpCamingUseCase = GetMovieUpCamingUseCaseImple(response = repositorys)

    @Provides
    fun provideGetMovieDitails(
        repositorys: MovieReposetoryImpl
    ): GetMovieDetails = GetMovieDetailsImple(response = repositorys)
}