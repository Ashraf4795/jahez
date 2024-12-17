package com.jahez.common

data class Category(
    val id: String,
    val categoryTitle: LocalizedContent,
    val categoryImage: String,
    val deeplink: String
)