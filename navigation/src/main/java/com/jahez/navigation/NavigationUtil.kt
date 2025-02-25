package com.jahez.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptionsBuilder
import com.jahez.navigation.routes.AppRoute

fun NavController.navigateToHome(navOptions: NavOptionsBuilder.() -> Unit = {}): Boolean {
    return navigateTo(AppRoute.HomeScreenRoute) {
        navOptions()
    }
}

fun NavController.navigateToBasketScreen(navOptions: NavOptionsBuilder.() -> Unit = {}): Boolean {
    return navigateTo(AppRoute.BasketScreenRoute) {
        navOptions()
    }
}

fun NavController.navigateToMerchantMenuScreen(
    args: MerchantMenuNavArgs,
    navOptions: NavOptionsBuilder.() -> Unit = {}
): Boolean {
    return navigateTo(AppRoute.MerchantMenuScreenRoute(args.merchantId)) {
        navOptions()
    }
}

fun NavController.navigateToOffersScreen(navOptions: NavOptionsBuilder.() -> Unit = {}): Boolean {
    return navigateTo(AppRoute.OffersScreenRoute) {
        navOptions()
    }
}

fun NavController.navigateToProductDetailsScreen(
    args: ProductDetailsNavArgs,
    navOptions: NavOptionsBuilder.() -> Unit = {}
): Boolean {
    return navigateTo(AppRoute.ProductDetailsRoute(args.productId)) {
        navOptions()
    }
}