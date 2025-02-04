package com.jahez.home.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.jahez.core.AppRoute
import com.jahez.home.HomeViewModel
import com.jahez.home.model.HomeUiState

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = hiltViewModel(),
    navigateTo: (AppRoute) -> Unit,
) {
    val homeUiState: HomeUiState by homeViewModel.homeUiState.collectAsStateWithLifecycle()
    HomeScreenImpl(
        modifier = modifier,
        homeUiState = homeUiState,
        navigateTo
    )
}

@Composable
internal fun HomeScreenImpl(
    modifier: Modifier = Modifier,
    homeUiState: HomeUiState,
    navigateTo: (AppRoute) -> Unit
) {
    Column(modifier) {
        HomeHeader(
            modifier = Modifier,
            onAddressClick = { navigateTo(AppRoute.AddressScreenRoute) },
            onCartClick = { navigateTo(AppRoute.CartScreenRoute) }
        )

        when (homeUiState) {
            HomeUiState.Loading, HomeUiState.LoadingFailed -> Unit
            is HomeUiState.Success -> {
                HomeScreenContent(Modifier, homeUiState.homePageContent, navigateTo)
            }
        }
    }
}