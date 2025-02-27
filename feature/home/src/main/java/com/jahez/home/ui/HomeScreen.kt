package com.jahez.home.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.jahez.home.HomeViewModel
import com.jahez.home.state.HomeUiState
import com.jahez.home_data.datasource.remote.fake.fakeHomePageContent
import com.jahez.inputs.AnimatedSearchBar
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
            modifier = Modifier.padding(bottom = 8.dp),
            onAddressClick = navigateToAddress,
            onBasketClick = navigateToBasket
        )

        AnimatedSearchBar(
            modifier = Modifier
        ) {  }

        when (homeUiState) {
            HomeUiState.Loading, HomeUiState.LoadingFailed -> Unit
            is HomeUiState.Success -> {
                HomeScreenContent(Modifier, homeUiState.homePageContent, navigateToMenu)
            }
        }
    }
}


@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreenImpl(
        homeUiState = HomeUiState.Success(
            homePageContent = fakeHomePageContent,
        ),
        navigateToBasket = { },
        navigateToAddress = { },
        navigateToMenu = { }
    )
}