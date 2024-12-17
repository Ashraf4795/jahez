package com.jahez.home.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jahez.home.HomeScreenHandler
import com.jahez.home.model.HomeUiState

@Composable
fun HomeScreen(modifier: Modifier = Modifier, homeUiState: HomeUiState, homeScreenHandler: HomeScreenHandler) {
    LazyColumn {
        // Home header ( address and cart )
        item {
            HomeHeader(
                modifier = Modifier,
                onAddressClick = homeScreenHandler::onAddressClick,
                onCartClick = homeScreenHandler::onCartClick
            )
        }

        when (homeUiState) {
            HomeUiState.Loading, HomeUiState.LoadingFailed -> Unit
            is HomeUiState.Success -> {
                // home page content (offers, merchants, etc)
                HomeScreenContent(homeUiState.homePageContent)
            }
        }
    }
}