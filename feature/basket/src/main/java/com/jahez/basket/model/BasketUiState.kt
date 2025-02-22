package com.jahez.basket.model

sealed interface BasketUiState {
    data object Loading: BasketUiState
    data object LoadingFailed: BasketUiState
    data class Success(
        val basketItems: List<BasketOrderItem>,
        val orderPriceSection: OrderPriceSummaryUiModel
    ): BasketUiState
}