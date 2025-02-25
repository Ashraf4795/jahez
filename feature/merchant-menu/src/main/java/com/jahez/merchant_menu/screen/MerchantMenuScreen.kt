package com.jahez.merchant_menu.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.ahmadhamwi.tabsync_compose.lazyListTabSync
import com.jahez.TopBar
import com.jahez.merchant_menu.MerchantMenuViewModel
import com.jahez.merchant_menu.model.MenuSectionUiModel
import com.jahez.merchant_menu.state.MerchantMenuUiState
import com.jahez.merchant_menu.ui.MenuListItem
import com.jahez.navigation.ProductDetailsNavArgs
import com.jahez.navigation.navigateToProductDetailsScreen
import com.jahez.product_details.ProductDetailsUiModel
import com.jahez.ui.theme.JahezTheme

@Composable
internal fun MerchantMenuScreen(
    viewModel: MerchantMenuViewModel = hiltViewModel(),
    navController: NavController
) {
    MerchantMenuScreenImpl(
        viewModel = viewModel,
        onProductClicked = {
            navController.navigateToProductDetailsScreen(
                ProductDetailsNavArgs(it.productId)
            )
        },
        onBackCList = { navController.popBackStack() }
    )
}

@Composable
private fun MerchantMenuScreenImpl(
    viewModel: MerchantMenuViewModel = hiltViewModel(),
    onProductClicked: (ProductDetailsUiModel) -> Unit,
    onBackCList: () -> Unit
) {

    val merchantMenuUiState = viewModel.merchantMenuUiState.collectAsStateWithLifecycle().value

    Column {
        TopBar(
            leading = {
                IconButton(onClick = onBackCList) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back Arrow",
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            },
            content = {
                Text(
                    text = "Merchant Name",
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Start
                )
            },
            trailing = { },
        )

        when (merchantMenuUiState) {
            is MerchantMenuUiState.Loading -> {
                CircularProgressIndicator(modifier = Modifier.size(48.dp))
            }

            is MerchantMenuUiState.LoadingFailed -> {
                Text(
                    text = "Failed to load merchant menu",
                    modifier = Modifier.fillMaxSize(),
                    textAlign = TextAlign.Center
                )
            }

            is MerchantMenuUiState.Success -> {
                MerchantMenuContent(
                    menuSections = merchantMenuUiState.menuSections,
                    onProductClicked = onProductClicked
                )
            }
        }

    }


}

@Composable
private fun MerchantMenuContent(
    menuSections: List<MenuSectionUiModel>,
    onProductClicked: (ProductDetailsUiModel) -> Unit
) {
    val (selectedTabIndex, setSelectedTabIndex, lazyListState) = lazyListTabSync(
        syncedIndices = menuSections.flatMap { it.items }.indices.toList()
    )

    Column {
        if (menuSections.isNotEmpty()) {
            SectionTabs(menuSections, selectedTabIndex) { index, section ->
                setSelectedTabIndex(index)
            }
        }

        LazyColumn(state = lazyListState, modifier = Modifier.fillMaxSize()) {
            itemsIndexed(menuSections) { _, section ->
                MenuSection(section, onProductClicked)
            }
        }
    }
}

@Composable
private fun SectionTabs(
    menuSections: List<MenuSectionUiModel>,
    selectedTabIndex: Int = 0,
    onSectionSelected: (Int, MenuSectionUiModel) -> Unit
) {

    ScrollableTabRow(
        selectedTabIndex = selectedTabIndex,
        edgePadding = 0.dp
    ) {
        menuSections.forEachIndexed { index, section ->
            Tab(
                selected = index == selectedTabIndex,
                onClick = { onSectionSelected(index, section) },
                text = {
                    Text(
                        text = section.title,
                        color = Color.Black,
                        fontSize = 16.sp
                    )
                }
            )

        }
    }
}

@Composable
private fun MenuSection(
    section: MenuSectionUiModel,
    onProductClicked: (ProductDetailsUiModel) -> Unit
) {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
        Text(
            text = section.title,
            fontSize = 18.sp,
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(Modifier.height(8.dp))
        section.items.forEach { item ->
            MenuListItem(
                modifier = Modifier.padding(bottom = 8.dp),
                product = item,
                onProductClicked
            )
        }
    }
}

@Preview
@Composable
private fun PreviewMerchantMenuScreen() {
    JahezTheme {
        MerchantMenuScreenImpl(onProductClicked = {}, onBackCList = {})
    }
}