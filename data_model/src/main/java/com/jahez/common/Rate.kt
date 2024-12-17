package com.jahez.common

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Rate(
    @Json(name = "rate") val rate: String,
    @Json(name = "rate_count") val rateCount: Int
)