package com.jahez.home.model

import com.jahez.common.LocalizedContent
import com.jahez.home.HomePageContent

sealed interface HomeUiState {
    data object Loading: HomeUiState
    data object LoadingFailed: HomeUiState
    data class Success(
        val homePageContent: HomePageContent,
    ): HomeUiState

}

data class MerchantUiModel (
    val merchantId: String,
    val merchantName: LocalizedContent,
    val merchantImageUrl: String,
    val isFavorite: Boolean,
    val estimatedDeliveryTime: String,
    val estimatedDeliveryFees: String,
    val currency: String,
    val rating: Float,
    val rateCount: Int,
) {
    fun getDeliveryMetadata(): String? {
        return if (estimatedDeliveryFees.isBlank())  null
        else "$estimatedDeliveryTime . $estimatedDeliveryFees $currency"
    }
    companion object {
        fun getMock() = MerchantUiModel(
            merchantId = "12345",
            merchantName = LocalizedContent("عبده كفته", "Abdo kufta"),
            merchantImageUrl = "https://example.com/image.jpg",
            isFavorite = false,
            estimatedDeliveryTime = "30 mins",
            estimatedDeliveryFees = "50.00",
            currency = "L.E",
            rating = 4.5f,
            rateCount = 150
        )
    }
}