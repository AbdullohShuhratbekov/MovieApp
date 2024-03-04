package com.example.movieApp.di

import com.example.movieApp.data.remote.MovieService
import com.example.movieApp.data.reposetory.MovieReposetoryImpl
import com.example.movieApp.data.utils.Constants.API_KAY
import com.example.movieApp.data.utils.Constants.USE_LOGIN
import com.example.movieApp.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
class DataModel {

    @Provides
    fun provideGetCurrentWeatherRipository(
        service: MovieService
    ): MovieRepository {
        return MovieReposetoryImpl(
            service  = service
        )
    }

    @Provides
    fun provisedWeatherServise(
        retrofit: Retrofit
    ): MovieService {
        return retrofit.create(MovieService::class.java)
    }

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(USE_LOGIN)
            .addConverterFactory(GsonConverterFactory.create()).client(
                OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .addInterceptor(
                        Interceptor { chain ->
                            val request = chain.request().newBuilder()
                                .addHeader("Authorization", "Bearer $API_KAY").build()
                            return@Interceptor chain.proceed(request = request)
                        },
                    ).build()
            ).build()
    }
}