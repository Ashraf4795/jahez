package com.jahez.common

import com.jahez.data_model.RemoteMerchant

data class Offer(
    val id: String,
    val title: LocalizedContent,
    val provider: RemoteMerchant
)