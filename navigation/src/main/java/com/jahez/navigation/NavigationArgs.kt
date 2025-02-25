package com.jahez.navigation

import kotlinx.serialization.Serializable


@Serializable
data class MerchantMenuNavArgs(
    val merchantId: String,
    val merchantName: String
)

@Serializable
data class ProductDetailsNavArgs(
    val productId: String
)