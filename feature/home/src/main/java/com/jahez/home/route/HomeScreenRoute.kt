package com.jahez.home.route

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.jahez.navigation.navigateTo
import com.jahez.home.ui.HomeScreen
import com.jahez.navigation.routes.AppRoute


fun NavGraphBuilder.homeScreen(navController: NavController) {
    composable<AppRoute.HomeScreenRoute> {
        HomeScreen(
            modifier = Modifier,
            navController = navController
        )
    }
}