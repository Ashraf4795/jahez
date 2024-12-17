package com.jahez.home.ui

import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jahez.home.HomePageContent

fun LazyListScope.HomeScreenContent(
    homePageContent: HomePageContent
) {
    homePageContent.offersWidget?.let { offerWidget ->
        items(offerWidget.items.size, key = { offerWidget.items[it].id }) { index ->
            val offerItem = offerWidget.items[index]
            Text("offer: ${offerItem.title.english}")
        }
    }

    homePageContent.merchantsWidget?.let { merchantsWidget ->
        items(merchantsWidget.items.size, key = { merchantsWidget.items[it].merchantId }) { index ->
            val offerItem = merchantsWidget.items[index]
            Text("offer: ${offerItem.merchantName.english}")
        }
    }
}