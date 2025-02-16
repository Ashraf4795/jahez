package com.jahez.merchant_menu

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jahez.common.DeliveryMetadata
import com.jahez.common.LocalizedContent
import com.jahez.core.IoDispatcher
import com.jahez.core.language
import com.jahez.merchant_menu.model.MenuSectionUiModel
import com.jahez.merchant_menu.model.MerchantUiModel
import com.jahez.merchant_menu.state.MerchantMenuUiState
import com.jahez.product_details.ProductDetailsUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MerchantMenuViewModel @Inject constructor(
    @IoDispatcher private val io: CoroutineDispatcher,
    @ApplicationContext context: Context
) : ViewModel() {

    val merchantMenuUiState: StateFlow<MerchantMenuUiState> = MutableStateFlow(
        MerchantMenuUiState.Success(
            merchant = merchantUiModel,
            menuSections = getSampleMenuSections(context.language())
        )
    ).stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5_000),
        MerchantMenuUiState.Loading
    )
}

// Sample Data Models
fun getSampleMenuSections(lang: String = "en"): List<MenuSectionUiModel> {
    return if (lang == "en") {
        listOf(
            MenuSectionUiModel(
                title = "Appetizers",
                items = listOf(
                    ProductDetailsUiModel(
                        productId = "101",
                        productName = "Spring Rolls",
                        productDesc = "Crispy spring rolls filled with vegetables and served with sweet chili sauce.",
                        productPrice = 5.99f,
                        productOldPrice = 6.99f,
                        productCurrency = "USD",
                        productPhoto = listOf("spring_rolls.jpg"),
                        rate = "4.5",
                        rateCount = 120,
                        isFavorite = false
                    ),
                    ProductDetailsUiModel(
                        productId = "102",
                        productName = "Garlic Bread",
                        productDesc = "Toasted bread with garlic butter and herbs.",
                        productPrice = 3.99f,
                        productCurrency = "USD",
                        productPhoto = listOf("garlic_bread.jpg"),
                        rate = "4.7",
                        rateCount = 85,
                        isFavorite = true
                    )
                )
            ),
            MenuSectionUiModel(
                title = "Salads",
                items = listOf(
                    ProductDetailsUiModel(
                        productId = "201",
                        productName = "Caesar Salad",
                        productDesc = "Crisp romaine lettuce, parmesan cheese, croutons, and Caesar dressing.",
                        productPrice = 7.99f,
                        productCurrency = "USD",
                        productPhoto = listOf("caesar_salad.jpg"),
                        rate = "4.6",
                        rateCount = 95,
                        isFavorite = true
                    ),
                    ProductDetailsUiModel(
                        productId = "202",
                        productName = "Greek Salad",
                        productDesc = "Fresh cucumbers, tomatoes, olives, feta cheese, and Greek dressing.",
                        productPrice = 8.49f,
                        productCurrency = "USD",
                        productPhoto = listOf("greek_salad.jpg"),
                        rate = "4.8",
                        rateCount = 110,
                        isFavorite = false
                    )
                )
            ),
            MenuSectionUiModel(
                title = "Soups",
                items = listOf(
                    ProductDetailsUiModel(
                        productId = "301",
                        productName = "Tomato Soup",
                        productDesc = "Creamy tomato soup served with fresh basil and croutons.",
                        productPrice = 6.49f,
                        productCurrency = "USD",
                        productPhoto = listOf("tomato_soup.jpg"),
                        rate = "4.5",
                        rateCount = 90,
                        isFavorite = true
                    ),
                    ProductDetailsUiModel(
                        productId = "302",
                        productName = "Chicken Noodle Soup",
                        productDesc = "Homemade chicken broth with fresh vegetables and noodles.",
                        productPrice = 7.99f,
                        productCurrency = "USD",
                        productPhoto = listOf("chicken_noodle_soup.jpg"),
                        rate = "4.7",
                        rateCount = 130,
                        isFavorite = false
                    )
                )
            ),
            MenuSectionUiModel(
                title = "Main Course",
                items = listOf(
                    ProductDetailsUiModel(
                        productId = "401",
                        productName = "Grilled Salmon",
                        productDesc = "Freshly grilled salmon with lemon butter sauce and vegetables.",
                        productPrice = 15.99f,
                        productCurrency = "USD",
                        productPhoto = listOf("grilled_salmon.jpg"),
                        rate = "4.9",
                        rateCount = 150,
                        isFavorite = true
                    ),
                    ProductDetailsUiModel(
                        productId = "402",
                        productName = "Steak with Mashed Potatoes",
                        productDesc = "Juicy beef steak served with creamy mashed potatoes.",
                        productPrice = 18.99f,
                        productCurrency = "USD",
                        productPhoto = listOf("steak_mashed_potatoes.jpg"),
                        rate = "4.8",
                        rateCount = 170,
                        isFavorite = false
                    )
                )
            ),
            MenuSectionUiModel(
                title = "Pasta",
                items = listOf(
                    ProductDetailsUiModel(
                        productId = "501",
                        productName = "Spaghetti Carbonara",
                        productDesc = "Classic Italian pasta with creamy sauce, bacon, and parmesan cheese.",
                        productPrice = 12.99f,
                        productCurrency = "USD",
                        productPhoto = listOf("spaghetti_carbonara.jpg"),
                        rate = "4.7",
                        rateCount = 115,
                        isFavorite = true
                    ),
                    ProductDetailsUiModel(
                        productId = "502",
                        productName = "Penne Arrabbiata",
                        productDesc = "Spicy tomato sauce with garlic and chili flakes over penne pasta.",
                        productPrice = 11.99f,
                        productCurrency = "USD",
                        productPhoto = listOf("penne_arrabbiata.jpg"),
                        rate = "4.6",
                        rateCount = 98,
                        isFavorite = false
                    )
                )
            ),
            MenuSectionUiModel(
                title = "Burgers",
                items = listOf(
                    ProductDetailsUiModel(
                        productId = "601",
                        productName = "Classic Cheeseburger",
                        productDesc = "Beef patty with cheddar cheese, lettuce, tomato, and special sauce.",
                        productPrice = 9.99f,
                        productCurrency = "USD",
                        productPhoto = listOf("cheeseburger.jpg"),
                        rate = "4.8",
                        rateCount = 180,
                        isFavorite = true
                    ),
                    ProductDetailsUiModel(
                        productId = "602",
                        productName = "BBQ Bacon Burger",
                        productDesc = "Juicy beef patty topped with bacon, BBQ sauce, and crispy onions.",
                        productPrice = 10.99f,
                        productCurrency = "USD",
                        productPhoto = listOf("bbq_bacon_burger.jpg"),
                        rate = "4.9",
                        rateCount = 200,
                        isFavorite = false
                    )
                )
            ),
            MenuSectionUiModel(
                title = "Desserts",
                items = listOf(
                    ProductDetailsUiModel(
                        productId = "701",
                        productName = "Chocolate Lava Cake",
                        productDesc = "Rich chocolate cake with a gooey molten center, served with ice cream.",
                        productPrice = 6.99f,
                        productCurrency = "USD",
                        productPhoto = listOf("chocolate_lava_cake.jpg"),
                        rate = "4.9",
                        rateCount = 160,
                        isFavorite = true
                    ),
                    ProductDetailsUiModel(
                        productId = "702",
                        productName = "Tiramisu",
                        productDesc = "Classic Italian dessert with coffee-soaked ladyfingers and mascarpone cream.",
                        productPrice = 7.49f,
                        productCurrency = "USD",
                        productPhoto = listOf("tiramisu.jpg"),
                        rate = "4.8",
                        rateCount = 140,
                        isFavorite = false
                    )
                )
            ),
            MenuSectionUiModel(
                title = "Beverages",
                items = listOf(
                    ProductDetailsUiModel(
                        productId = "801",
                        productName = "Fresh Orange Juice",
                        productDesc = "Freshly squeezed orange juice with no added sugar.",
                        productPrice = 4.99f,
                        productCurrency = "USD",
                        productPhoto = listOf("orange_juice.jpg"),
                        rate = "4.6",
                        rateCount = 110,
                        isFavorite = true
                    ),
                    ProductDetailsUiModel(
                        productId = "802",
                        productName = "Iced Coffee",
                        productDesc = "Chilled coffee served with milk and ice.",
                        productPrice = 3.99f,
                        productCurrency = "USD",
                        productPhoto = listOf("iced_coffee.jpg"),
                        rate = "4.7",
                        rateCount = 90,
                        isFavorite = false
                    )
                )
            )
        )
    } else {
        listOf(
            MenuSectionUiModel(
                title = "المقبلات",
                items = listOf(
                    ProductDetailsUiModel(
                        productId = "101",
                        productName = "سبرينج رول",
                        productDesc = "لفائف سبرينج مقرمشة محشوة بالخضروات وتُقدم مع صلصة الفلفل الحلو.",
                        productPrice = 180.0f,
                        productOldPrice = 210.0f,
                        productCurrency = "EGP",
                        productPhoto = listOf("spring_rolls.jpg"),
                        rate = "4.5",
                        rateCount = 120,
                        isFavorite = false
                    ),
                    ProductDetailsUiModel(
                        productId = "102",
                        productName = "خبز بالثوم",
                        productDesc = "خبز محمص بالزبدة والثوم والأعشاب.",
                        productPrice = 120.0f,
                        productCurrency = "EGP",
                        productPhoto = listOf("garlic_bread.jpg"),
                        rate = "4.7",
                        rateCount = 85,
                        isFavorite = true
                    )
                )
            ),
            MenuSectionUiModel(
                title = "السلطات",
                items = listOf(
                    ProductDetailsUiModel(
                        productId = "201",
                        productName = "سلطة سيزر",
                        productDesc = "خس روماني مقرمش مع جبن البارميزان والخبز المحمص وصلصة السيزر.",
                        productPrice = 240.0f,
                        productCurrency = "EGP",
                        productPhoto = listOf("caesar_salad.jpg"),
                        rate = "4.6",
                        rateCount = 95,
                        isFavorite = true
                    ),
                    ProductDetailsUiModel(
                        productId = "202",
                        productName = "سلطة يونانية",
                        productDesc = "خيار طازج، طماطم، زيتون، جبن الفيتا، وصلصة يونانية.",
                        productPrice = 260.0f,
                        productCurrency = "EGP",
                        productPhoto = listOf("greek_salad.jpg"),
                        rate = "4.8",
                        rateCount = 110,
                        isFavorite = false
                    )
                )
            ),
            MenuSectionUiModel(
                title = "الشوربات",
                items = listOf(
                    ProductDetailsUiModel(
                        productId = "301",
                        productName = "شوربة الطماطم",
                        productDesc = "شوربة طماطم كريمية تقدم مع الريحان الطازج والخبز المحمص.",
                        productPrice = 195.0f,
                        productCurrency = "EGP",
                        productPhoto = listOf("tomato_soup.jpg"),
                        rate = "4.5",
                        rateCount = 90,
                        isFavorite = true
                    ),
                    ProductDetailsUiModel(
                        productId = "302",
                        productName = "شوربة الدجاج بالنودلز",
                        productDesc = "مرق دجاج محضر منزليًا مع خضروات طازجة ونودلز.",
                        productPrice = 240.0f,
                        productCurrency = "EGP",
                        productPhoto = listOf("chicken_noodle_soup.jpg"),
                        rate = "4.7",
                        rateCount = 130,
                        isFavorite = false
                    )
                )
            ),
            MenuSectionUiModel(
                title = "الأطباق الرئيسية",
                items = listOf(
                    ProductDetailsUiModel(
                        productId = "401",
                        productName = "سمك السلمون المشوي",
                        productDesc = "سمك سلمون مشوي طازج مع صلصة الزبدة والليمون والخضروات.",
                        productPrice = 480.0f,
                        productCurrency = "EGP",
                        productPhoto = listOf("grilled_salmon.jpg"),
                        rate = "4.9",
                        rateCount = 150,
                        isFavorite = true
                    ),
                    ProductDetailsUiModel(
                        productId = "402",
                        productName = "ستيك مع البطاطس المهروسة",
                        productDesc = "شريحة لحم بقري طرية تقدم مع بطاطس مهروسة كريمية.",
                        productPrice = 570.0f,
                        productCurrency = "EGP",
                        productPhoto = listOf("steak_mashed_potatoes.jpg"),
                        rate = "4.8",
                        rateCount = 170,
                        isFavorite = false
                    )
                )
            ),
            MenuSectionUiModel(
                title = "المعكرونة",
                items = listOf(
                    ProductDetailsUiModel(
                        productId = "501",
                        productName = "سباجيتي كاربونارا",
                        productDesc = "باستا إيطالية كلاسيكية مع صلصة كريمية ولحم مقدد وجبن البارميزان.",
                        productPrice = 390.0f,
                        productCurrency = "EGP",
                        productPhoto = listOf("spaghetti_carbonara.jpg"),
                        rate = "4.7",
                        rateCount = 115,
                        isFavorite = true
                    ),
                    ProductDetailsUiModel(
                        productId = "502",
                        productName = "بيني أربياتا",
                        productDesc = "صلصة الطماطم الحارة مع الثوم والفلفل الحار فوق معكرونة بيني.",
                        productPrice = 360.0f,
                        productCurrency = "EGP",
                        productPhoto = listOf("penne_arrabbiata.jpg"),
                        rate = "4.6",
                        rateCount = 98,
                        isFavorite = false
                    )
                )
            ),
            MenuSectionUiModel(
                title = "البرجر",
                items = listOf(
                    ProductDetailsUiModel(
                        productId = "601",
                        productName = "برجر بالجبن الكلاسيكي",
                        productDesc = "شريحة لحم بقري مع جبن الشيدر والخس والطماطم وصوص خاص.",
                        productPrice = 300.0f,
                        productCurrency = "EGP",
                        productPhoto = listOf("cheeseburger.jpg"),
                        rate = "4.8",
                        rateCount = 180,
                        isFavorite = true
                    ),
                    ProductDetailsUiModel(
                        productId = "602",
                        productName = "برجر بيكون باربكيو",
                        productDesc = "شريحة لحم بقري مع لحم مقدد، صوص باربكيو، وبصل مقرمش.",
                        productPrice = 330.0f,
                        productCurrency = "EGP",
                        productPhoto = listOf("bbq_bacon_burger.jpg"),
                        rate = "4.9",
                        rateCount = 200,
                        isFavorite = false
                    )
                )
            ),
            MenuSectionUiModel(
                title = "الحلويات",
                items = listOf(
                    ProductDetailsUiModel(
                        productId = "701",
                        productName = "كيك الشوكولاتة البركاني",
                        productDesc = "كيك شوكولاتة غني مع مركز سائل، يقدم مع آيس كريم.",
                        productPrice = 210.0f,
                        productCurrency = "EGP",
                        productPhoto = listOf("chocolate_lava_cake.jpg"),
                        rate = "4.9",
                        rateCount = 160,
                        isFavorite = true
                    ),
                    ProductDetailsUiModel(
                        productId = "702",
                        productName = "تيراميسو",
                        productDesc = "تحلية إيطالية كلاسيكية بطبقات من البسكويت المنقوع بالقهوة وكريمة الماسكربوني.",
                        productPrice = 225.0f,
                        productCurrency = "EGP",
                        productPhoto = listOf("tiramisu.jpg"),
                        rate = "4.8",
                        rateCount = 140,
                        isFavorite = false
                    )
                )
            ),
            MenuSectionUiModel(
                title = "المشروبات",
                items = listOf(
                    ProductDetailsUiModel(
                        productId = "801",
                        productName = "عصير برتقال طازج",
                        productDesc = "عصير برتقال طازج بدون سكر مضاف.",
                        productPrice = 150.0f,
                        productCurrency = "EGP",
                        productPhoto = listOf("orange_juice.jpg"),
                        rate = "4.6",
                        rateCount = 110,
                        isFavorite = true
                    ),
                    ProductDetailsUiModel(
                        productId = "802",
                        productName = "قهوة مثلجة",
                        productDesc = "قهوة باردة تقدم مع الحليب والثلج.",
                        productPrice = 120.0f,
                        productCurrency = "EGP",
                        productPhoto = listOf("iced_coffee.jpg"),
                        rate = "4.7",
                        rateCount = 90,
                        isFavorite = false
                    )
                )
            )
        )

    }

}

val merchantUiModel = MerchantUiModel(
    merchantId = "M001",
    merchantName = "Gourmet Bistro",
    merchantThumbnail = "https://example.com/images/gourmet_bistro.jpg",
    merchantRate = "4.8", // Rating as a string
    merchantRateCount = 320, // Number of reviews
    merchantDeliveryMetadata = DeliveryMetadata(
        estimatedDeliveryTime = 100000L,
        estimatedDeliveryFee = 3.99f,
        currency = LocalizedContent(
            english = "USD",
            arabic = "د.إ"
        )
    )
)