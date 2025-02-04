package com.jahez.common

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LocalizedContent(
    @Json(name = "ar") val arabic: String?,
    @Json(name = "en") val english: String?
) {
    fun localize(lang: String, default: String = "N/A"): String {
        val primary = if (lang == "ar") arabic else english
        val secondary = if (lang == "ar") english else arabic

        return primary?.takeIf { it.isNotBlank() }
            ?: secondary?.takeIf { it.isNotBlank() }
            ?: default
    }
}