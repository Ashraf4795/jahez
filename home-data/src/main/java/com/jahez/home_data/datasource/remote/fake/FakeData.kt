package com.jahez.home_data.datasource.remote.fake

import com.jahez.common.Category
import com.jahez.common.DeliveryMetadata
import com.jahez.common.LocalizedContent
import com.jahez.common.Offer
import com.jahez.common.Rate
import com.jahez.data_model.RemoteMerchant
import com.jahez.home.CategoriesWidget
import com.jahez.home.HomePageContent
import com.jahez.home.MerchantsWidget
import com.jahez.home.OffersWidget


val fakeHomePageContent = HomePageContent(
    id = "home_001",
    categoriesWidget = CategoriesWidget(
        id = "categories_widget_001",
        categories = listOf(
            Category(
                id = "1",
                categoryTitle = LocalizedContent("برجر", "Burger"),
                categoryImage = "https://example.com/images/burger.jpg",
                deeplink = "app://category/burger"
            ),
            Category(
                id = "2",
                categoryTitle = LocalizedContent("بيتزا", "Pizza"),
                categoryImage = "https://example.com/images/pizza.jpg",
                deeplink = "app://category/pizza"
            ),
            Category(
                id = "3",
                categoryTitle = LocalizedContent("سوشي", "Sushi"),
                categoryImage = "https://example.com/images/sushi.jpg",
                deeplink = "app://category/sushi"
            ),
            Category(
                id = "4",
                categoryTitle = LocalizedContent("مشاوي", "Grill"),
                categoryImage = "https://example.com/images/grill.jpg",
                deeplink = "app://category/grill"
            ),
            Category(
                id = "5",
                categoryTitle = LocalizedContent("حلويات", "Desserts"),
                categoryImage = "https://example.com/images/desserts.jpg",
                deeplink = "app://category/desserts"
            ),
            Category(
                id = "6",
                categoryTitle = LocalizedContent("مشروبات", "Beverages"),
                categoryImage = "https://example.com/images/beverages.jpg",
                deeplink = "app://category/beverages"
            ),
            Category(
                id = "7",
                categoryTitle = LocalizedContent("فطور", "Breakfast"),
                categoryImage = "https://example.com/images/breakfast.jpg",
                deeplink = "app://category/breakfast"
            ),
            Category(
                id = "8",
                categoryTitle = LocalizedContent("سلطات", "Salads"),
                categoryImage = "https://example.com/images/salads.jpg",
                deeplink = "app://category/salads"
            ),
            Category(
                id = "9",
                categoryTitle = LocalizedContent("وجبات سريعة", "Fast Food"),
                categoryImage = "https://example.com/images/fastfood.jpg",
                deeplink = "app://category/fastfood"
            ),
            Category(
                id = "10",
                categoryTitle = LocalizedContent("مأكولات بحرية", "Seafood"),
                categoryImage = "https://example.com/images/seafood.jpg",
                deeplink = "app://category/seafood"
            )
        )
    ),
    offersWidget = OffersWidget(
        id = "offers_widget_001",
        title = LocalizedContent(
            arabic = "عروض الطعام الشهية",
            english = "Delicious Food Offers"
        ),
        items = listOf(
            Offer(
                id = "offer_001",
                title = LocalizedContent(
                    arabic = "وجبة برغر مزدوجة مع مشروب",
                    english = "Double Burger Meal with a Drink"
                ),
                provider = RemoteMerchant(
                    merchantId = "merchant_001",
                    merchantName = LocalizedContent(
                        arabic = "برغر هت",
                        english = "Burger Hut"
                    ),
                    merchantThumbnail = "https://example.com/images/burger_hut.png",
                    merchantRate = Rate(
                        rate = "4.8",
                        rateCount = 1345
                    ),
                    deliveryMetadata = DeliveryMetadata(
                        estimatedDeliveryTime = 30,
                        estimatedDeliveryFee = 3.5f,
                        currency = LocalizedContent(
                            arabic = "ريال سعودي",
                            english = "SAR"
                        )
                    )
                )
            ),
            Offer(
                id = "offer_002",
                title = LocalizedContent(
                    arabic = "بيتزا عائلية بسعر خاص",
                    english = "Family-Sized Pizza at a Special Price"
                ),
                provider = RemoteMerchant(
                    merchantId = "merchant_002",
                    merchantName = LocalizedContent(
                        arabic = "بيتزا بارتي",
                        english = "Pizza Party"
                    ),
                    merchantThumbnail = "https://example.com/images/pizza_party.png",
                    merchantRate = Rate(
                        rate = "4.5",
                        rateCount = 890
                    ),
                    deliveryMetadata = DeliveryMetadata(
                        estimatedDeliveryTime = 40,
                        estimatedDeliveryFee = 4.0f,
                        currency = LocalizedContent(
                            arabic = "ريال سعودي",
                            english = "SAR"
                        )
                    )
                )
            ),
            Offer(
                id = "offer_003",
                title = LocalizedContent(
                    arabic = "بيتزا عائلية بسعر خاص",
                    english = "Family-Sized Pizza at a Special Price"
                ),
                provider = RemoteMerchant(
                    merchantId = "merchant_002",
                    merchantName = LocalizedContent(
                        arabic = "بيتزا بارتي",
                        english = "Pizza Party"
                    ),
                    merchantThumbnail = "https://example.com/images/pizza_party.png",
                    merchantRate = Rate(
                        rate = "4.5",
                        rateCount = 890
                    ),
                    deliveryMetadata = DeliveryMetadata(
                        estimatedDeliveryTime = 40,
                        estimatedDeliveryFee = 4.0f,
                        currency = LocalizedContent(
                            arabic = "ريال سعودي",
                            english = "SAR"
                        )
                    )
                )
            ),
            Offer(
                id = "offer_004",
                title = LocalizedContent(
                    arabic = "بيتزا عائلية بسعر خاص",
                    english = "Family-Sized Pizza at a Special Price"
                ),
                provider = RemoteMerchant(
                    merchantId = "merchant_002",
                    merchantName = LocalizedContent(
                        arabic = "بيتزا بارتي",
                        english = "Pizza Party"
                    ),
                    merchantThumbnail = "https://example.com/images/pizza_party.png",
                    merchantRate = Rate(
                        rate = "4.5",
                        rateCount = 890
                    ),
                    deliveryMetadata = DeliveryMetadata(
                        estimatedDeliveryTime = 40,
                        estimatedDeliveryFee = 4.0f,
                        currency = LocalizedContent(
                            arabic = "ريال سعودي",
                            english = "SAR"
                        )
                    )
                )
            ),
            Offer(
                id = "offer_004",
                title = LocalizedContent(
                    arabic = "بيتزا عائلية بسعر خاص",
                    english = "Family-Sized Pizza at a Special Price"
                ),
                provider = RemoteMerchant(
                    merchantId = "merchant_002",
                    merchantName = LocalizedContent(
                        arabic = "بيتزا بارتي",
                        english = "Pizza Party"
                    ),
                    merchantThumbnail = "https://example.com/images/pizza_party.png",
                    merchantRate = Rate(
                        rate = "4.5",
                        rateCount = 890
                    ),
                    deliveryMetadata = DeliveryMetadata(
                        estimatedDeliveryTime = 40,
                        estimatedDeliveryFee = 4.0f,
                        currency = LocalizedContent(
                            arabic = "ريال سعودي",
                            english = "SAR"
                        )
                    )
                )
            ),
            Offer(
                id = "offer_004",
                title = LocalizedContent(
                    arabic = "بيتزا عائلية بسعر خاص",
                    english = "Family-Sized Pizza at a Special Price"
                ),
                provider = RemoteMerchant(
                    merchantId = "merchant_002",
                    merchantName = LocalizedContent(
                        arabic = "بيتزا بارتي",
                        english = "Pizza Party"
                    ),
                    merchantThumbnail = "https://example.com/images/pizza_party.png",
                    merchantRate = Rate(
                        rate = "4.5",
                        rateCount = 890
                    ),
                    deliveryMetadata = DeliveryMetadata(
                        estimatedDeliveryTime = 40,
                        estimatedDeliveryFee = 4.0f,
                        currency = LocalizedContent(
                            arabic = "ريال سعودي",
                            english = "SAR"
                        )
                    )
                )
            ),
            Offer(
                id = "offer_004",
                title = LocalizedContent(
                    arabic = "بيتزا عائلية بسعر خاص",
                    english = "Family-Sized Pizza at a Special Price"
                ),
                provider = RemoteMerchant(
                    merchantId = "merchant_002",
                    merchantName = LocalizedContent(
                        arabic = "بيتزا بارتي",
                        english = "Pizza Party"
                    ),
                    merchantThumbnail = "https://example.com/images/pizza_party.png",
                    merchantRate = Rate(
                        rate = "4.5",
                        rateCount = 890
                    ),
                    deliveryMetadata = DeliveryMetadata(
                        estimatedDeliveryTime = 40,
                        estimatedDeliveryFee = 4.0f,
                        currency = LocalizedContent(
                            arabic = "ريال سعودي",
                            english = "SAR"
                        )
                    )
                )
            ),
            Offer(
                id = "offer_004",
                title = LocalizedContent(
                    arabic = "بيتزا عائلية بسعر خاص",
                    english = "Family-Sized Pizza at a Special Price"
                ),
                provider = RemoteMerchant(
                    merchantId = "merchant_002",
                    merchantName = LocalizedContent(
                        arabic = "بيتزا بارتي",
                        english = "Pizza Party"
                    ),
                    merchantThumbnail = "https://example.com/images/pizza_party.png",
                    merchantRate = Rate(
                        rate = "4.5",
                        rateCount = 890
                    ),
                    deliveryMetadata = DeliveryMetadata(
                        estimatedDeliveryTime = 40,
                        estimatedDeliveryFee = 4.0f,
                        currency = LocalizedContent(
                            arabic = "ريال سعودي",
                            english = "SAR"
                        )
                    )
                )
            )
        )
    ),
    merchantsWidget = MerchantsWidget(
        id = "merchants_widget_001",
        title = LocalizedContent(
            arabic = "أفضل المطاعم",
            english = "Top Restaurants"
        ),
        items = listOf(
            RemoteMerchant(
                merchantId = "merchant_001",
                merchantName = LocalizedContent(
                    arabic = "شاورما الريم",
                    english = "Al-Reem Shawarma"
                ),
                merchantThumbnail = "https://example.com/images/al_reem_shawarma.png",
                merchantRate = Rate(
                    rate = "4.9",
                    rateCount = 2300
                ),
                deliveryMetadata = DeliveryMetadata(
                    estimatedDeliveryTime = 25,
                    estimatedDeliveryFee = 3.0f,
                    currency = LocalizedContent(
                        arabic = "ريال سعودي",
                        english = "SAR"
                    )
                )
            ),
            RemoteMerchant(
                merchantId = "merchant_002",
                merchantName = LocalizedContent(
                    arabic = "مطعم المذاق الإيطالي",
                    english = "The Italian Taste"
                ),
                merchantThumbnail = "https://example.com/images/the_italian_taste.png",
                merchantRate = Rate(
                    rate = "4.7",
                    rateCount = 1500
                ),
                deliveryMetadata = DeliveryMetadata(
                    estimatedDeliveryTime = 35,
                    estimatedDeliveryFee = 4.5f,
                    currency = LocalizedContent(
                        arabic = "ريال سعودي",
                        english = "SAR"
                    )
                )
            ),
            RemoteMerchant(
                merchantId = "merchant_003",
                merchantName = LocalizedContent(
                    arabic = "السوشي الياباني",
                    english = "Japanese Sushi"
                ),
                merchantThumbnail = "https://example.com/images/japanese_sushi.png",
                merchantRate = Rate(
                    rate = "4.6",
                    rateCount = 1120
                ),
                deliveryMetadata = DeliveryMetadata(
                    estimatedDeliveryTime = 40,
                    estimatedDeliveryFee = 5.0f,
                    currency = LocalizedContent(
                        arabic = "ريال سعودي",
                        english = "SAR"
                    )
                )
            ),
            RemoteMerchant(
                merchantId = "merchant_004",
                merchantName = LocalizedContent(
                    arabic = "السوشي الياباني",
                    english = "Japanese Sushi"
                ),
                merchantThumbnail = "https://example.com/images/japanese_sushi.png",
                merchantRate = Rate(
                    rate = "4.6",
                    rateCount = 1120
                ),
                deliveryMetadata = DeliveryMetadata(
                    estimatedDeliveryTime = 40,
                    estimatedDeliveryFee = 5.0f,
                    currency = LocalizedContent(
                        arabic = "ريال سعودي",
                        english = "SAR"
                    )
                )
            ),
            RemoteMerchant(
                merchantId = "merchant_005",
                merchantName = LocalizedContent(
                    arabic = "السوشي الياباني",
                    english = "Japanese Sushi"
                ),
                merchantThumbnail = "https://example.com/images/japanese_sushi.png",
                merchantRate = Rate(
                    rate = "4.6",
                    rateCount = 1120
                ),
                deliveryMetadata = DeliveryMetadata(
                    estimatedDeliveryTime = 40,
                    estimatedDeliveryFee = 5.0f,
                    currency = LocalizedContent(
                        arabic = "ريال سعودي",
                        english = "SAR"
                    )
                )
            ),
            RemoteMerchant(
                merchantId = "merchant_006",
                merchantName = LocalizedContent(
                    arabic = "شاورما الريم",
                    english = "Al-Reem Shawarma"
                ),
                merchantThumbnail = "https://example.com/images/al_reem_shawarma.png",
                merchantRate = Rate(
                    rate = "4.9",
                    rateCount = 2300
                ),
                deliveryMetadata = DeliveryMetadata(
                    estimatedDeliveryTime = 25,
                    estimatedDeliveryFee = 3.0f,
                    currency = LocalizedContent(
                        arabic = "ريال سعودي",
                        english = "SAR"
                    )
                )
            ),
            RemoteMerchant(
                merchantId = "merchant_007",
                merchantName = LocalizedContent(
                    arabic = "مطعم المذاق الإيطالي",
                    english = "The Italian Taste"
                ),
                merchantThumbnail = "https://example.com/images/the_italian_taste.png",
                merchantRate = Rate(
                    rate = "4.7",
                    rateCount = 1500
                ),
                deliveryMetadata = DeliveryMetadata(
                    estimatedDeliveryTime = 35,
                    estimatedDeliveryFee = 4.5f,
                    currency = LocalizedContent(
                        arabic = "ريال سعودي",
                        english = "SAR"
                    )
                )
            ),
            RemoteMerchant(
                merchantId = "merchant_008",
                merchantName = LocalizedContent(
                    arabic = "السوشي الياباني",
                    english = "Japanese Sushi"
                ),
                merchantThumbnail = "https://example.com/images/japanese_sushi.png",
                merchantRate = Rate(
                    rate = "4.6",
                    rateCount = 1120
                ),
                deliveryMetadata = DeliveryMetadata(
                    estimatedDeliveryTime = 40,
                    estimatedDeliveryFee = 5.0f,
                    currency = LocalizedContent(
                        arabic = "ريال سعودي",
                        english = "SAR"
                    )
                )
            ),
            RemoteMerchant(
                merchantId = "merchant_009",
                merchantName = LocalizedContent(
                    arabic = "السوشي الياباني",
                    english = "Japanese Sushi"
                ),
                merchantThumbnail = "https://example.com/images/japanese_sushi.png",
                merchantRate = Rate(
                    rate = "4.6",
                    rateCount = 1120
                ),
                deliveryMetadata = DeliveryMetadata(
                    estimatedDeliveryTime = 40,
                    estimatedDeliveryFee = 5.0f,
                    currency = LocalizedContent(
                        arabic = "ريال سعودي",
                        english = "SAR"
                    )
                )
            ),
            RemoteMerchant(
                merchantId = "merchant_0010",
                merchantName = LocalizedContent(
                    arabic = "السوشي الياباني",
                    english = "Japanese Sushi"
                ),
                merchantThumbnail = "https://example.com/images/japanese_sushi.png",
                merchantRate = Rate(
                    rate = "4.6",
                    rateCount = 1120
                ),
                deliveryMetadata = DeliveryMetadata(
                    estimatedDeliveryTime = 40,
                    estimatedDeliveryFee = 5.0f,
                    currency = LocalizedContent(
                        arabic = "ريال سعودي",
                        english = "SAR"
                    )
                )
            ), RemoteMerchant(
                merchantId = "merchant_0011",
                merchantName = LocalizedContent(
                    arabic = "شاورما الريم",
                    english = "Al-Reem Shawarma"
                ),
                merchantThumbnail = "https://example.com/images/al_reem_shawarma.png",
                merchantRate = Rate(
                    rate = "4.9",
                    rateCount = 2300
                ),
                deliveryMetadata = DeliveryMetadata(
                    estimatedDeliveryTime = 25,
                    estimatedDeliveryFee = 3.0f,
                    currency = LocalizedContent(
                        arabic = "ريال سعودي",
                        english = "SAR"
                    )
                )
            ),
            RemoteMerchant(
                merchantId = "merchant_0012",
                merchantName = LocalizedContent(
                    arabic = "مطعم المذاق الإيطالي",
                    english = "The Italian Taste"
                ),
                merchantThumbnail = "https://example.com/images/the_italian_taste.png",
                merchantRate = Rate(
                    rate = "4.7",
                    rateCount = 1500
                ),
                deliveryMetadata = DeliveryMetadata(
                    estimatedDeliveryTime = 35,
                    estimatedDeliveryFee = 4.5f,
                    currency = LocalizedContent(
                        arabic = "ريال سعودي",
                        english = "SAR"
                    )
                )
            ),
            RemoteMerchant(
                merchantId = "merchant_0013",
                merchantName = LocalizedContent(
                    arabic = "السوشي الياباني",
                    english = "Japanese Sushi"
                ),
                merchantThumbnail = "https://example.com/images/japanese_sushi.png",
                merchantRate = Rate(
                    rate = "4.6",
                    rateCount = 1120
                ),
                deliveryMetadata = DeliveryMetadata(
                    estimatedDeliveryTime = 40,
                    estimatedDeliveryFee = 5.0f,
                    currency = LocalizedContent(
                        arabic = "ريال سعودي",
                        english = "SAR"
                    )
                )
            ),
            RemoteMerchant(
                merchantId = "merchant_0014",
                merchantName = LocalizedContent(
                    arabic = "السوشي الياباني",
                    english = "Japanese Sushi"
                ),
                merchantThumbnail = "https://example.com/images/japanese_sushi.png",
                merchantRate = Rate(
                    rate = "4.6",
                    rateCount = 1120
                ),
                deliveryMetadata = DeliveryMetadata(
                    estimatedDeliveryTime = 40,
                    estimatedDeliveryFee = 5.0f,
                    currency = LocalizedContent(
                        arabic = "ريال سعودي",
                        english = "SAR"
                    )
                )
            ),
            RemoteMerchant(
                merchantId = "merchant_0015",
                merchantName = LocalizedContent(
                    arabic = "السوشي الياباني",
                    english = "Japanese Sushi"
                ),
                merchantThumbnail = "https://example.com/images/japanese_sushi.png",
                merchantRate = Rate(
                    rate = "4.6",
                    rateCount = 1120
                ),
                deliveryMetadata = DeliveryMetadata(
                    estimatedDeliveryTime = 40,
                    estimatedDeliveryFee = 5.0f,
                    currency = LocalizedContent(
                        arabic = "ريال سعودي",
                        english = "SAR"
                    )
                )
            )
        )
    )
)