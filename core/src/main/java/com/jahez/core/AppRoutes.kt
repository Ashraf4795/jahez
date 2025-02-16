package com.jahez.core
import kotlinx.serialization.Serializable


sealed class AppRoute {
    @Serializable data object HomeScreenRoute : AppRoute()
    @Serializable data object AddressScreenRoute : AppRoute()
    @Serializable data object CartScreenRoute : AppRoute()
    @Serializable data object OffersScreenRoute : AppRoute()
    @Serializable data class MerchantMenuScreenRoute(
        val merchantId: String,
        val merchantName: String
    ) : AppRoute()
}