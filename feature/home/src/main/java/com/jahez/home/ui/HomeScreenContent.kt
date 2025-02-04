package com.jahez.home.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jahez.core.AppRoute
import com.jahez.home.HomePageContent
import com.jahez.home.ui.sections.OfferSection
import com.jahez.inputs.SearchField

@Composable
fun HomeScreenContent(
    modifier: Modifier,
    homePageContent: HomePageContent,
    navigateTo: (AppRoute) -> Unit
) {
    LazyColumn (
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        item {
            SearchField() {}
        }

        homePageContent.offersWidget?.let { offerWidget ->
            OfferSection(modifier = modifier, offersWidget = offerWidget) {
                navigateTo(AppRoute.OffersScreenRoute)
            }
        }
    }
}