package com.example.myjetpack.core.main

sealed class Screens(val route: String) {
    object MainScreens : Screens("main_screen")

    object SearchScreens : Screens("search_screen")
    object FavoritesScreens : Screens("favorites_screen")
    object ProfileScreen : Screens("profile_screen")

    object TipScreen : Screens("tip_screen")
}
