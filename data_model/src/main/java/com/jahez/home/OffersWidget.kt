package com.jahez.home

import com.jahez.common.LocalizedContent
import com.jahez.common.Offer

data class OffersWidget(
    val id: String,
    val title: LocalizedContent,
    val items: List<Offer>
)