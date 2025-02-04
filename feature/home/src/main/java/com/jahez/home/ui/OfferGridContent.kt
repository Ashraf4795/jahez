package com.jahez.home.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jahez.ProductMedaDataCard
import com.jahez.home.OffersWidget

fun LazyListScope.OfferGridContent(
    offersWidget: OffersWidget,
) {
    val rows = offersWidget.items.chunked(2)
    items(rows.size) { index ->
        val offersRow = rows[index]
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            for (offer in offersRow) {
                ProductMedaDataCard(
                    modifier = Modifier
                        .padding(bottom = 16.dp, end = 16.dp)
                        .weight(1f)
                )
            }

            // If the row has only 1 item (odd number of items), add an empty spacer
            if (offersRow.size == 1) {
                Spacer(modifier = Modifier.weight(1f))
            }
        }
    }
}