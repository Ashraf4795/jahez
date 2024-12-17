package com.jahez.common

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LocalizedContent(
    @Json(name = "ar") val arabic: String,
    @Json(name = "en") val english: String
)