package com.jahez.common

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DeliveryMetadata(
    @Json(name = "estimated_time") val estimatedDeliveryTime: Long,
    @Json(name = "estimated_fee") val estimatedDeliveryFee: Float,
    @Json(name = "currency") val currency: LocalizedContent
)