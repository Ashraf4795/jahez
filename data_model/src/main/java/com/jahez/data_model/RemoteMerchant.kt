package com.jahez.data_model

import com.jahez.common.DeliveryMetadata
import com.jahez.common.LocalizedContent
import com.jahez.common.Rate
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RemoteMerchant(
    @Json(name = "id")
    val merchantId: String,

    @Json(name = "name")
    val merchantName: LocalizedContent,

    @Json(name = "thumbnail")
    val merchantThumbnail: String,

    @Json(name = "rate_metadata")
    val merchantRate: Rate,

    @Json(name = "delivery_metadata")
    val deliveryMetadata: DeliveryMetadata
)