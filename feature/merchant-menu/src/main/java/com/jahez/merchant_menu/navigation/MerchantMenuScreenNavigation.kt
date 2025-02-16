package com.jahez.merchant_menu.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import com.jahez.core.AppRoute
import com.jahez.merchant_menu.MerchantMenuScreen

fun NavController.navigateToMerchantMenuScreen(merchantId: String, merchantName: String,navOptions: NavOptionsBuilder.() -> Unit = {}) {
    navigate(AppRoute.MerchantMenuScreenRoute(merchantId, merchantName)) {
        navOptions()
    }
}

fun NavGraphBuilder.merchantMenuScreen(navController: NavController) {
    composable<AppRoute.MerchantMenuScreenRoute> {
        MerchantMenuScreen {
            navController.popBackStack()
        }
    }
}