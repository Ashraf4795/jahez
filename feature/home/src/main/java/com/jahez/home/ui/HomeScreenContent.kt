package com.jahez.home.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jahez.home.HomePageContent
import com.jahez.home.ui.sections.CategoriesSection
import com.jahez.home.ui.sections.MerchantSection
import com.jahez.home_data.datasource.remote.fake.fakeHomePageContent
import com.jahez.navigation.MerchantMenuNavArgs
import com.jahez.ui.theme.JahezTheme

fun LazyListState.isScrolledToEnd(): Boolean {
    return layoutInfo.visibleItemsInfo.lastOrNull()?.index == layoutInfo.totalItemsCount - 1
}

@Composable
fun HomeScreenContent(
    modifier: Modifier = Modifier,
    homePageContent: HomePageContent,
    navigateToMenu: (MerchantMenuNavArgs) -> Unit
) {

    val listState = rememberLazyListState()

    LazyColumn(
        state = listState,
        modifier = modifier.fillMaxWidth(),
    ) {
        homePageContent.categoriesWidget?.let {
            CategoriesSection(categoriesWidget = it)
        }

        homePageContent.merchantsWidget?.let { merchantsWidget ->
            MerchantSection(
                modifier = Modifier.padding(top = 16.dp),
                merchantsWidget = merchantsWidget,
                onMerchantClick = {
                    navigateToMenu(
                        MerchantMenuNavArgs(
                            merchantId = "M001",
                            merchantName = "merchant-name"
                        )
                    )
                },
                onMoreClick = {}
            )
        }
    }
}

@Preview(fontScale = 2.0f)
@Composable
private fun PreviewHomeScreenContent() {
    JahezTheme {
        HomeScreenContent(homePageContent = fakeHomePageContent) { }
    }
}