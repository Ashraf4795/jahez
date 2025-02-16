package com.jahez.product_details

data class ProductDetailsUiModel(
    val productId: String,
    val productName: String,
    val productDesc: String,
    val productPrice: Float,
    val productOldPrice: Float? = null,
    val productCurrency: String,
    val productPhoto: List<String> = emptyList(),
    val rate: String? = null,
    val rateCount: Int? = null,
    val isFavorite: Boolean = false
) {
    companion object {
        fun getMock() = ProductDetailsUiModel(
            productId = "102",
            productName = "Garlic Bread",
            productDesc = "Toasted bread with garlic",
            productPrice = 3.99f,
            productOldPrice = 4.99f,
            productCurrency = "USD",
            productPhoto = listOf("garlic_bread.jpg"),
            rate = "4.7",
            rateCount = 85,
            isFavorite = true
        )
    }
}