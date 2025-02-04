package com.jahez.home


data class HomePageContent(
    val id: String,
    val offersWidget: OffersWidget? = null,
    val merchantsWidget: MerchantsWidget? = null,
)