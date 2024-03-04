package com.example.movieApp.presantation.component.bottom_bar

import android.annotation.SuppressLint
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun BottomBar(
    navController: NavController
) {
    val listItems = listOf(
        BottomItem.HomeScreen,
        BottomItem.SeatherScreen,
        BottomItem.SaveScreen
    )
    BottomNavigation(
        backgroundColor = MaterialTheme.colorScheme.background
    ) {
        val backStateEmpty by navController.currentBackStackEntryAsState()
        val currentRoute = backStateEmpty?.destination?.route
        listItems.forEach { items ->
            BottomNavigationItem(
                selected = currentRoute == items.route,
                onClick = {
                    navController.navigate(items.route)
                },
                icon = {
                    Icon(
                        painter = painterResource(id = items.selectedItem),
                        contentDescription = null,
                    )
                },
                label = {
                    Text(
                        text = items.title,
                        fontSize = 12.sp,
                    )
                },
                selectedContentColor = MaterialTheme.colorScheme.onBackground,
                unselectedContentColor = Color.Gray,
            )
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ScafoltBottom() {
    val navController = rememberNavController()
    Scaffold (
        bottomBar = { BottomBar(navController = navController) }
    ){
        NavGraph(navHostController = navController)
    }

}