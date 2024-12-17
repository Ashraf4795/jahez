package com.jahez.home.model

import com.jahez.home.HomePageContent

sealed interface HomeUiState {
    data object Loading: HomeUiState
    data object LoadingFailed: HomeUiState
    data class Success(
        val homePageContent: HomePageContent,
    ): HomeUiState

}

data class MerchantListItemUiState (
    val merchantId: String,
    val merchantName: String,
    val merchantImageUrl: String,
    val isFavorite: Boolean,
    val estimatedDeliveryTime: String,
    val estimatedDeliveryFees: String,
    val currency: String,
    val rating: Float,
    val rateCount: Int,
) {
    fun getDeliveryMetadata() = "$estimatedDeliveryTime . $estimatedDeliveryFees $currency"
    companion object {
        fun getMock() = MerchantListItemUiState(
            merchantId = "12345",
            merchantName = "Test Merchant",
            merchantImageUrl = "https://example.com/image.jpg",
            isFavorite = false,
            estimatedDeliveryTime = "30 mins",
            estimatedDeliveryFees = "5.00",
            currency = "L.E",
            rating = 4.5f,
            rateCount = 150
        )
    }
}