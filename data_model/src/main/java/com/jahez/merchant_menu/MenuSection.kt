package com.jahez.merchant_menu

import com.jahez.common.LocalizedContent
import com.jahez.product_details.RemoteProductDetails

data class MenuSection(val title: LocalizedContent, val items: List<RemoteProductDetails>)