package com.example.movieApp.presantation.searth_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieApp.presantation.component.WeatherLottieAnimation
import com.example.weatherapptest.R
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private const val SPLASH_SCREENTIME_MILLTS = 1000L

@Composable
fun SplashScreen(
    onNavigateNext: () -> Unit
) {
    val systemUiController = rememberSystemUiController()
    val coroutineScope = rememberCoroutineScope()
    val colorBackground = MaterialTheme.colorScheme.background

    LaunchedEffect(key1 = true) {
        coroutineScope.launch {
            delay(SPLASH_SCREENTIME_MILLTS)
            onNavigateNext()
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        WeatherLottieAnimation(
            modifier = Modifier.size(220.dp),
            rawFile = R.raw.movie_lottie
        )
    }
    SideEffect {
        systemUiController.setNavigationBarColor(colorBackground)
        systemUiController.setNavigationBarColor(colorBackground)
    }
    val color  = MaterialTheme.colorScheme.background
    SideEffect {
        systemUiController.setSystemBarsColor(color)
        systemUiController.setNavigationBarColor(color)
    }
}


@Preview
@Composable
fun SplashScreenPreview() {
    MaterialTheme {
        SplashScreen(
            onNavigateNext = {
            }
        )
    }
}
