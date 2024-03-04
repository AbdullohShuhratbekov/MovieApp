package com.example.movieApp.presantation.home_screen


import androidx.compose.runtime.Immutable
import com.example.movieApp.domain.models.movie_domain_model.MovieDomainModel

@Immutable
sealed class MainScreenUiState {

    @Immutable
    data class Success(
        val moviePopularModel: List<MovieDomainModel>,
        val movieNowPopularModel: List<MovieDomainModel>,
        val movieTopRatedModel: List<MovieDomainModel>,
        val movieUpCamingModel: List<MovieDomainModel>
    ) : MainScreenUiState()

    data object Loading : MainScreenUiState()

    @Immutable
    data class Error(
        val message: String,
    ) : MainScreenUiState()
}