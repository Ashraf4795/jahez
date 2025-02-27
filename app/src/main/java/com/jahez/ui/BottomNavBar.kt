package com.jahez.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.jahez.navigation.routes.AppRoute

sealed class BottomNavItem(val route: AppRoute, val icon: ImageVector, val label: String) {
    object Home : BottomNavItem(AppRoute.HomeScreenRoute, Icons.Default.Home, "Home")
    object Offers : BottomNavItem(AppRoute.OffersScreenRoute, Icons.Default.Star, "Offers")
    object Profile : BottomNavItem(AppRoute.AddressScreenRoute, Icons.Default.Person, "Profile")


    companion object {
        fun getNavItems() = listOf(Home, Offers, Profile)
    }

}


@Composable
fun BottomNavigationBar(onNavItemChange: (AppRoute) -> Unit) {

    var navigationSelectedItem by remember { mutableStateOf(0) }
    val navItems = rememberSaveable {
        listOf(
            BottomNavItem.Home,
            BottomNavItem.Offers,
            BottomNavItem.Profile
        )
    }
    NavigationBar {
        navItems.forEachIndexed {index,navigationItem ->
            NavigationBarItem(
                selected = index == navigationSelectedItem,
                label = {
                    Text(navigationItem.label)
                },
                icon = {
                    Icon(
                        navigationItem.icon,
                        contentDescription = navigationItem.label
                    )
                },
                onClick = {
                    navigationSelectedItem = index
                    onNavItemChange(navigationItem.route)
                }
            )
        }
    }
}