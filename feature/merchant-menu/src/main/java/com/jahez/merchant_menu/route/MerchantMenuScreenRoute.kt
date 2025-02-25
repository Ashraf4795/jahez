package com.jahez.merchant_menu.route

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.jahez.merchant_menu.screen.MerchantMenuScreen
import com.jahez.navigation.routes.AppRoute

fun NavGraphBuilder.merchantMenuScreen(navController: NavController) {
    composable<AppRoute.MerchantMenuScreenRoute> {
        MerchantMenuScreen (navController = navController)
    }
}