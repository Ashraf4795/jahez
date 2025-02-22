package com.jahez.basket.model

data class OrderPriceSummaryUiModel(
    val subTotal: Float,
    private val discount: Int,
    val deliveryFee: Float,
    val currency: String
) {
    fun total(): String {
        return "${(subTotal - discount()) + deliveryFee} $currency"
    }

    fun discount(): Float {
        return (subTotal / 100) * discount
    }
}