package com.example.myjetpack

sealed class Screens(val route: String) {
    object MainScreens : Screens("main_screen")
    object FavoritesScreens : Screens("favorites_screen")
    object ProfileScreen : Screens("profile_screen")
}
