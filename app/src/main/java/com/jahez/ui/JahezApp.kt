package com.jahez.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.jahez.basket.route.basketScreen
import com.jahez.home.route.homeScreen
import com.jahez.merchant_menu.route.merchantMenuScreen
import com.jahez.navigation.routes.AppRoute
import com.jahez.product_details.route.productDetailsScreen


@Composable
fun JahezApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController,
        startDestination = AppRoute.HomeScreenRoute,
        modifier
    ) {
        homeScreen(navController)
        merchantMenuScreen(navController)
        basketScreen(navController)
        productDetailsScreen(navController)
    }
}