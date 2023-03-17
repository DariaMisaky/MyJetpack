package com.example.myjetpack.core.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.compose.rememberNavController
import com.example.myjetpack.R
import com.example.myjetpack.core.theme.MyJetpackTheme
import com.example.myjetpack.data.models.BottomNavModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyJetpackTheme {
                val navController = rememberNavController()
                Navigation(navController)
                Scaffold(
                    bottomBar =
                    {
                        BottomNavigationBar(
                            items = listOf(
                                BottomNavModel(
                                    "Home",
                                    Screens.MainScreens.route,
                                    icon = Icons.Default.Home
                                ),
                                BottomNavModel(
                                    "Favorites",
                                    Screens.FavoritesScreens.route,
                                    icon = ImageVector.vectorResource(id = R.drawable.nav_favorites)
                                ),
                                BottomNavModel(
                                    "Profile",
                                    Screens.ProfileScreen.route,
                                    icon = ImageVector.vectorResource(id = R.drawable.nav_profile)
                                )
                            ),
                            navController = navController,
                            onItemClicked = { navController.navigate(it.route) }
                        )
                    }
                ) { innerPadding ->
                    Box(modifier = Modifier.padding(bottom = innerPadding.calculateBottomPadding())) {
                        Navigation(navController = navController)
                    }
                }
            }
        }
    }
}
