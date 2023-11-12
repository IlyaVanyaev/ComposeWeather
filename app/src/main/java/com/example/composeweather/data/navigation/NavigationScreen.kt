package com.example.composeweather.data.navigation

sealed class NavigationScreen(val route: String){
    object Home: NavigationScreen("home_screen")
    object Info: NavigationScreen("info_screen")
    object Settings: NavigationScreen("settings_screen")
}
