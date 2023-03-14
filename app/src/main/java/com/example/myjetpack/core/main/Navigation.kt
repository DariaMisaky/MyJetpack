package com.example.myjetpack.core.main

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myjetpack.R
import com.example.myjetpack.Screens
import com.example.myjetpack.core.data.BottomNavItem
import com.example.myjetpack.core.main.favorites.FavoritesScreen
import com.example.myjetpack.core.main.home.HomeScreen
import com.example.myjetpack.core.main.profile.ProfileScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screens.MainScreens.route) {
        composable(route = Screens.MainScreens.route) {
            HomeScreen(navController = navController)
        }
        composable(route = Screens.FavoritesScreens.route) {
            FavoritesScreen(navController = navController)
        }
        composable(route = Screens.ProfileScreen.route) {
            ProfileScreen(navController = navController)
        }
    }
}

@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClicked: (BottomNavItem) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(modifier = modifier, backgroundColor = Color.White) {
        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = { onItemClicked(item) },
                selectedContentColor = Color.Red,
                unselectedContentColor = Color.Gray,
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = null
                    )
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNavBar() {
    BottomNavigationBar(
        items = listOf(
            BottomNavItem(
                "Home",
                Screens.MainScreens.route,
                icon = Icons.Default.Home
            ),
            BottomNavItem(
                "Favorites",
                Screens.FavoritesScreens.route,
                icon = ImageVector.vectorResource(id = R.drawable.nav_favorites)
            ),
            BottomNavItem(
                "Profile",
                Screens.ProfileScreen.route,
                icon = ImageVector.vectorResource(id = R.drawable.nav_profile)
            )
        ),
        navController = rememberNavController(),
        onItemClicked = { }
    )
}
