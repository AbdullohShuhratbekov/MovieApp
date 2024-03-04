package com.example.movieApp.presantation.home_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieApp.data.base.model.ResponseStatus
import com.example.movieApp.domain.use_case.use_case_now_playing.GetMovieNowPopularUseCase
import com.example.movieApp.domain.use_case.use_case_populare.GetPopularMovieUseCase
import com.example.movieApp.domain.use_case.use_case_top_rated.GetMovieTopRatedUseCase
import com.example.movieApp.domain.use_case.use_case_up_caming.GetMovieUpCamingUseCase
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

const val CONNECTION_ERROR_MESSAGE = "CONNECTION_ERROR_MESSAGE"


@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val getPopularMovieUseCase: GetPopularMovieUseCase,
    private val getMovieNowPopularUseCase: GetMovieNowPopularUseCase,
    private val getMovieTopRatedUseCase: GetMovieTopRatedUseCase,
    private val getMovieUpCamingUseCase: GetMovieUpCamingUseCase
) : ViewModel() {

    private val _uiState: MutableStateFlow<MainScreenUiState> =
        MutableStateFlow(MainScreenUiState.Loading)
    val uiState: StateFlow<MainScreenUiState> = _uiState.asStateFlow()

    private val handle = CoroutineExceptionHandler { _, _ -> }

    init {
        getMovieList()
    }

    private fun getMovieList() {
        viewModelScope.launch(handle + Dispatchers.IO) {
            _uiState.tryEmit(MainScreenUiState.Loading)

            val responsePopularMovieDefirred = async {
                getPopularMovieUseCase()
            }
            val responseNowPopularMovieDefirred = async {
                getMovieNowPopularUseCase()
            }
            val responseTopRatedMovieDefirred = async {
                getMovieTopRatedUseCase()
            }
            val responseUpCamingMovieDefirred = async {
                getMovieUpCamingUseCase()
            }

            val popularMovie = responsePopularMovieDefirred.await()
            val nowPopularMovie = responseNowPopularMovieDefirred.await()
            val topRatedMovie = responseTopRatedMovieDefirred.await()
            val upCamingMovie = responseUpCamingMovieDefirred.await()

            if (
                popularMovie.status == ResponseStatus.SUCCESS &&
                nowPopularMovie.status == ResponseStatus.SUCCESS &&
                topRatedMovie.status == ResponseStatus.SUCCESS &&
                upCamingMovie.status == ResponseStatus.SUCCESS
            ) {
                popularMovie.data?.let { popularMovies ->
                    nowPopularMovie.data?.let { nowPopularMovies ->
                        topRatedMovie.data?.let { topRatedMovies ->
                            upCamingMovie.data?.let { upCamingMovies ->
                                _uiState.update {
                                    MainScreenUiState.Success(
                                        moviePopularModel = popularMovies.toImmutableList(),
                                        movieNowPopularModel = nowPopularMovies.toImmutableList(),
                                        movieTopRatedModel = topRatedMovies.toImmutableList(),
                                        movieUpCamingModel = upCamingMovies.toImmutableList()
                                    )
                                }
                            }
                        }
                    }
                }
            } else if (popularMovie.errorThrowable.toString() == CONNECTION_ERROR_MESSAGE) {
                _uiState.update {
                    MainScreenUiState.Error(
                        popularMovie.errorThrowable?.message.orEmpty(),
                    )
                }
            }
        }
    }
}



