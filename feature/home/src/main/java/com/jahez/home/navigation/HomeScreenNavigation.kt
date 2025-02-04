package com.jahez.home.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import com.jahez.core.AppRoute
import com.jahez.core.navigateTo
import com.jahez.home.ui.HomeScreen

fun NavController.navigateToHome(navOptions: NavOptionsBuilder.() -> Unit = {}) {
    navigate(AppRoute.HomeScreenRoute) {
        navOptions()
    }
}

fun NavGraphBuilder.homeScreen(navController: NavController) {
    composable<AppRoute.HomeScreenRoute> {
        HomeScreen(
            modifier = Modifier,
            navigateTo = { route ->
                val navigated = navController.navigateTo(route)
                if (navigated) {
                    println("navigation done")
                } else {
                    println("failed")
                }
            }
        )
    }
}