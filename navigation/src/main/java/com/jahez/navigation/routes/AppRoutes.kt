package com.jahez.navigation.routes

import kotlinx.serialization.Serializable

sealed class AppRoute {
    @Serializable
    data object HomeScreenRoute : AppRoute()

    @Serializable
    data object AddressScreenRoute : AppRoute()

    @Serializable
    data object BasketScreenRoute : AppRoute()

    @Serializable
    data object OffersScreenRoute : AppRoute()

    @Serializable
    data class ProductDetailsRoute(
        val productId: String
    ) : AppRoute()

    @Serializable
    data class MerchantMenuScreenRoute(
        val merchantId: String
    ) : AppRoute()

    @Serializable
    data object SearchScreenRoute : AppRoute()
}