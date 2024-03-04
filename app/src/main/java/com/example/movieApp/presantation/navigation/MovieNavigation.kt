package com.example.movieApp.presantation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movieApp.presantation.component.bottom_bar.ScafoltBottom
import com.example.movieApp.presantation.home_screen.MainScreen
import com.example.movieApp.presantation.home_screen.MainScreenViewModel
import com.example.movieApp.presantation.searth_screen.SplashScreen


@Composable
fun AppNavGraph(
    onBackPressedCallback: () -> Unit,
) {
    val navController = rememberNavController()
    val viewModel: MainScreenViewModel = hiltViewModel()

    NavHost(
        navController = navController,
        startDestination = Screens.SplashScreen.route,
    ) {
        composable(Screens.BottomScreen.route) {
            ScafoltBottom()
        }

        composable(Screens.SplashScreen.route) {
            SplashScreen(
                onNavigateNext = {
                    navController.navigate(Screens.BottomScreen.route)
                }
            )
        }
    }
}
