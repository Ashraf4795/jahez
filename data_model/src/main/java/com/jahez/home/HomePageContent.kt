package com.jahez.home


data class HomePageContent(
    val id: String,
    val categoriesWidget: CategoriesWidget? = null,
    val offersWidget: OffersWidget? = null,
    val merchantsWidget: MerchantsWidget? = null,
)