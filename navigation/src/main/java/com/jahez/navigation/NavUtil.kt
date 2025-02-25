package com.jahez.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptionsBuilder
import com.jahez.navigation.routes.AppRoute


fun NavController.navigateTo(route: AppRoute, navOptions: NavOptionsBuilder.() -> Unit = {}): Boolean {
    return try {
        navigate(route, navOptions)
        true
    } catch (ex: Exception) {
        false
    }
}