package com.example.movieApp.presantation.details_screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.example.movieApp.presantation.component.LoadingScreeen
import kotlinx.coroutines.flow.StateFlow

@Composable
fun DetailScreen(
    uiStateFlow: StateFlow<DetailsScreenUiState>,
    onBackPressedCallback: () -> Unit
) {
    when (val mainUiStateFlow = uiStateFlow.collectAsState().value) {
        is DetailsScreenUiState.Loading -> { LoadingScreeen() }
        is DetailsScreenUiState.Success -> {}
        is DetailsScreenUiState.Error -> {}
    }
}