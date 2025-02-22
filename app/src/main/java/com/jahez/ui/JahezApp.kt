package com.jahez.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.jahez.basket.navigation.basketScreen
import com.jahez.core.AppRoute
import com.jahez.home.navigation.homeScreen
import com.jahez.merchant_menu.navigation.merchantMenuScreen


@Composable
fun JahezApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController, AppRoute.BasketScreenRoute, modifier) {
        homeScreen(navController)
        merchantMenuScreen(navController)
        basketScreen(navController)
    }
}