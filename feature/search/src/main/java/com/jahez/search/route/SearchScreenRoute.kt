package com.jahez.search.route

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.jahez.navigation.routes.AppRoute
import com.jahez.search.SearchScreen


fun NavGraphBuilder.searchScreen(navController: NavController) {
    composable<AppRoute.SearchScreenRoute> {
        SearchScreen(
            modifier = Modifier,
            navController = navController
        )
    }
}