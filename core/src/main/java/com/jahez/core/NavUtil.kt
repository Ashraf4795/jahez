package com.jahez.core

import androidx.navigation.NavController
import androidx.navigation.NavOptionsBuilder


fun NavController.navigateTo(route: AppRoute, navOptions: NavOptionsBuilder.() -> Unit = {}): Boolean {
    return try {
        navigate(route, navOptions)
        true
    } catch (ex: Exception) {
        false
    }
}