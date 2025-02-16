package com.jahez.merchant_menu.model

import com.jahez.product_details.ProductDetailsUiModel

data class MenuSectionUiModel(
    val title: String,
    val items: List<ProductDetailsUiModel>
)