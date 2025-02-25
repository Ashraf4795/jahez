package com.jahez.product_details.route

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.jahez.navigation.routes.AppRoute
import com.jahez.product_details.screen.ProductDetailScreen


fun NavGraphBuilder.productDetailsScreen(navController: NavController) {
    composable<AppRoute.ProductDetailsRoute> {
        ProductDetailScreen {
            navController.popBackStack()
        }
    }
}