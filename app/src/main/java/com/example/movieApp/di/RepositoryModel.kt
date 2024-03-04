package com.example.movieApp.di

import com.example.movieApp.data.remote.MovieService
import com.example.movieApp.data.reposetory.MovieReposetoryImpl
import com.example.movieApp.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModel {
    @Provides
    fun providesGetPopulerMovieRepository(
        service: MovieService
    ): MovieRepository = MovieReposetoryImpl(
        service = service
    )
}