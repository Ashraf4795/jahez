package com.jahez.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.jahez.basket.route.basketScreen
import com.jahez.home.route.homeScreen
import com.jahez.merchant_menu.route.merchantMenuScreen
import com.jahez.navigation.routes.AppRoute
import com.jahez.product_details.route.productDetailsScreen
import com.jahez.search.route.searchScreen
import com.jahez.ui.theme.JahezTheme


@Composable
fun JahezApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    Scaffold (
        bottomBar = {
            BottomNavigationBar { route ->
                // should navigate safely
            }
        }
    ){ innerPadding ->
        NavHost(
            navController,
            startDestination = AppRoute.HomeScreenRoute,
            modifier.padding(innerPadding)
        ) {
            homeScreen(navController)
            merchantMenuScreen(navController)
            basketScreen(navController)
            productDetailsScreen(navController)
            searchScreen(navController)
        }
    }
}


@Preview
@Composable
private fun JahezAppPreview() {
    JahezTheme {
        JahezApp()
    }
}