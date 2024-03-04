package com.example.movieApp.presantation.details_screen

import androidx.compose.runtime.Immutable
import com.example.movieApp.domain.models.movie_domain_info.MovieInfoResponseDomain


@Immutable
sealed class DetailsScreenUiState {

    @Immutable
    data class Success(
        val movieDetaile: MovieInfoResponseDomain
    ) : DetailsScreenUiState()

    data object Loading : DetailsScreenUiState()

    @Immutable
    data class Error(
        val message: String,
    ) : DetailsScreenUiState()
}