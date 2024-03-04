package com.example.movieApp.presantation.component.bottom_bar

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.movieApp.presantation.details_screen.DetailScreen
import com.example.movieApp.presantation.details_screen.DetailsDescreption
import com.example.movieApp.presantation.home_screen.MainScreen
import com.example.movieApp.presantation.home_screen.MainScreenViewModel
import com.example.movieApp.presantation.home_screen.SaveScreen
import com.example.movieApp.presantation.home_screen.SearchScreen
import com.example.movieApp.presantation.navigation.Screens

@Composable
fun NavGraph(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = Screens.HomeScreen.route,
    ) {
        composable(BottomItem.HomeScreen.route) {
            val viewModel: MainScreenViewModel = hiltViewModel()
            MainScreen(uiStateFlow = viewModel.uiState) {
            }
        }
        composable(BottomItem.SeatherScreen.route) {
           SearchScreen ()
        }
        composable(BottomItem.SaveScreen.route) {
            SaveScreen()
        }
    }
}