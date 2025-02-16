package com.jahez.home.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.jahez.core.AppRoute
import com.jahez.home.HomePageContent
import com.jahez.home.ui.sections.CategoriesSection
import com.jahez.home.ui.sections.MerchantSection
import com.jahez.home_data.datasource.remote.fake.fakeHomePageContent
import com.jahez.inputs.SearchField
import com.jahez.ui.theme.JahezTheme
import kotlinx.coroutines.flow.distinctUntilChanged

fun LazyListState.isScrolledToEnd(): Boolean {
    return layoutInfo.visibleItemsInfo.lastOrNull()?.index == layoutInfo.totalItemsCount - 1
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreenContent(
    modifier: Modifier = Modifier,
    homePageContent: HomePageContent,
    navigateTo: (AppRoute) -> Unit
) {

    val listState = rememberLazyListState()
    var searchFieldOffset by remember { mutableStateOf(0f) }

    // Observe scroll position and update search field offset
    LaunchedEffect(listState) {
        snapshotFlow { listState.firstVisibleItemScrollOffset }
            .distinctUntilChanged()
            .collect { offset ->
                // Adjust the search field offset based on scroll position
                searchFieldOffset = offset.toFloat()
            }
    }

    LazyColumn(
        state = listState,
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            // Search field with dynamic offset
            Box(
                modifier = Modifier
                    .offset {
                        IntOffset(
                            0,
                            -searchFieldOffset.toInt()
                        )
                    } // Move up/down based on scroll
            ) {
                SearchField() {}
            }
        }

        homePageContent.categoriesWidget?.let {
            CategoriesSection(categoriesWidget = it)
        }

        homePageContent.merchantsWidget?.let { merchantsWidget ->
            MerchantSection(
                modifier = Modifier.padding(top = 16.dp),
                merchantsWidget = merchantsWidget
            ) {
                // todo: change routing args
                navigateTo(
                    AppRoute.MerchantMenuScreenRoute(
                        merchantId = "M001",
                        merchantName = "merchant-name"
                    )
                )
            }
        }
    }
}

@Preview
@Composable
private fun PreviewHomeScreenContent() {
    JahezTheme {
        HomeScreenContent(homePageContent = fakeHomePageContent) { }
    }
}