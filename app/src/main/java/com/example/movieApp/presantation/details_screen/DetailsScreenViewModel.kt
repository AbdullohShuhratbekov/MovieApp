package com.example.movieApp.presantation.details_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieApp.data.base.model.ResponseStatus
import com.example.movieApp.domain.use_case.use_case_details.GetMovieDetails
import com.example.movieApp.presantation.home_screen.CONNECTION_ERROR_MESSAGE
import com.example.movieApp.presantation.home_screen.MainScreenUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import okhttp3.internal.toImmutableList
import javax.inject.Inject

@HiltViewModel
class DetailsScreenViewModel @Inject constructor(
    private val getMovieDetails: GetMovieDetails
) : ViewModel() {

    private val _uiState: MutableStateFlow<DetailsScreenUiState> =
        MutableStateFlow(DetailsScreenUiState.Loading)
    val uiState: StateFlow<DetailsScreenUiState> = _uiState.asStateFlow()

    private val handle = CoroutineExceptionHandler { _, _ -> }


    fun getDetails(movie: Int) {
        viewModelScope.launch(handle + Dispatchers.IO) {
            _uiState.tryEmit(DetailsScreenUiState.Loading)
            val response = async {
                getMovieDetails(movie)
            }
            val movieDetails = response.await()
            if (
                movieDetails.status == ResponseStatus.SUCCESS
            ) {
                movieDetails.data?.let { details ->
                    _uiState.update {
                        DetailsScreenUiState.Success(
                            movieDetaile = details
                        )
                    }
                }
            } else if (movieDetails.errorThrowable.toString() == CONNECTION_ERROR_MESSAGE) {
                _uiState.update {
                    DetailsScreenUiState.Error(
                        movieDetails.errorThrowable?.message.orEmpty(),
                    )
                }
            }
        }
    }
}