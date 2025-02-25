package com.jahez.home.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.jahez.home.HomeViewModel
import com.jahez.home.state.HomeUiState
import com.jahez.navigation.MerchantMenuNavArgs
import com.jahez.navigation.navigateToBasketScreen
import com.jahez.navigation.navigateToMerchantMenuScreen

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    homeViewModel: HomeViewModel = hiltViewModel(),
) {
    val homeUiState: HomeUiState by homeViewModel.homeUiState.collectAsStateWithLifecycle()
    HomeScreenImpl(
        modifier = modifier,
        homeUiState = homeUiState,
        navigateToBasket = { navController.navigateToBasketScreen() },
        navigateToAddress = { /* navigate to address listing */},
        navigateToMenu = { navController.navigateToMerchantMenuScreen(it) }
    )
}

@Composable
internal fun HomeScreenImpl(
    modifier: Modifier = Modifier,
    homeUiState: HomeUiState,
    navigateToBasket: () -> Unit,
    navigateToAddress: () -> Unit,
    navigateToMenu: (MerchantMenuNavArgs) -> Unit
) {
    Column(modifier) {
        HomeHeader(
            modifier = Modifier,
            onAddressClick = navigateToAddress,
            onBasketClick = navigateToBasket
        )

        when (homeUiState) {
            HomeUiState.Loading, HomeUiState.LoadingFailed -> Unit
            is HomeUiState.Success -> {
                HomeScreenContent(Modifier, homeUiState.homePageContent, navigateToMenu)
            }
        }
    }
}