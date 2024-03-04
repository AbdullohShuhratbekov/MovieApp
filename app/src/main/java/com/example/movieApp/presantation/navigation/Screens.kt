package com.example.movieApp.presantation.navigation

sealed class Screens(val route: String) {

    data object HomeScreen : Screens("home")

    data object SplashScreen : Screens("splash")

    data object BottomScreen : Screens("BottomScreen")
}