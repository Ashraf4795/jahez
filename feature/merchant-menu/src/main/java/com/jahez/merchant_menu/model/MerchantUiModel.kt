package com.jahez.merchant_menu.model

import com.jahez.common.DeliveryMetadata

data class MerchantUiModel(
    val merchantId: String,
    val merchantName: String,
    val merchantThumbnail: String,
    val merchantRate: String,
    val merchantRateCount: Int,
    val merchantDeliveryMetadata: DeliveryMetadata
)