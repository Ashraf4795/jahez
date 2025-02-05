package com.jahez.common

data class Category(
    val id: String,
    val categoryTitle: LocalizedContent,
    val categoryImage: String,
    val deeplink: String
) {
    companion object {
        fun mock() = Category(
            "id",
            LocalizedContent("برجر", "Burger"),
            "image_url",
            "deep_link"
        )
    }
}