package com.example.movieApp.presantation.component.bottom_bar

import com.example.weatherapptest.R

sealed class BottomItem(
    val title: String,
    val selectedItem: Int,
    val route: String,
) {

    data object HomeScreen : BottomItem(
        "Home",
        R.drawable.home__1_,
        "MainScreen"
    )

    data object SeatherScreen : BottomItem(
        "Search",
        R.drawable.search__1_,
        "SearchScreen"
    )

    data object SaveScreen : BottomItem(
        "Save",
        R.drawable.favorite,
        "SaveScreen"
    )
}
