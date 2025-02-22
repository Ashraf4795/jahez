package com.jahez.basket.model

import com.jahez.product_details.ProductDetailsUiModel

data class BasketOrderItem(
    val productDetailsUiModel: ProductDetailsUiModel,
    val quantity: Int = 1,
    val addOns: List<Pair<String, Float>>? = null,
)