package com.jahez.ui_model

data class ProductDetailsUiModel(
    val id: String,
    val title: String,
    val description: String,
    val pictures: List<String>,
    val originalPrice: Float,
    val actualPrice: Float,
    val currency: String,
    val rate: Float,
    val rateCount: Int,
    val isFavorit: Boolean,
    val requiredSelection: Any,
    val optionalSelection: Any,
    val quantity: Int,
)