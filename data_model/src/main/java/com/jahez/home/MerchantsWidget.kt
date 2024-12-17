package com.jahez.home

import com.jahez.common.LocalizedContent
import com.jahez.common.Offer
import com.jahez.data_model.RemoteMerchant

data class MerchantsWidget(
    val id: String,
    val title: LocalizedContent,
    val items: List<RemoteMerchant>
)