package com.jahez.product_details

import com.jahez.common.LocalizedContent
import com.jahez.common.Rate

data class RemoteProductDetails(
    val productId: String,
    val productName: LocalizedContent,
    val productDesc: LocalizedContent,
    val productPrice: Float,
    val productOldPrice: Float? = null,
    val productCurrency: LocalizedContent,
    val productPhoto: List<String> = emptyList(),
    val rate: Rate? = null,
    val isFavorite: Boolean = false
)