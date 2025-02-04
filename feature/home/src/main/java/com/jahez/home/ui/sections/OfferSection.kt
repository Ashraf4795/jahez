package com.jahez.home.ui.sections

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.jahez.actions.Section
import com.jahez.home.OffersWidget
import com.jahez.home.R
import com.jahez.home.ui.OfferGridContent


fun LazyListScope.OfferSection(
    modifier: Modifier = Modifier,
    offersWidget: OffersWidget,
    onMoreClick: () -> Unit
) {

    if (offersWidget.items.isNotEmpty()) {
        item {
            Section(
                modifier.padding(vertical = 8.dp, horizontal = 8.dp),
                sectionTitle = stringResource(R.string.offer_secion_label),
                onMoreClick = onMoreClick,
            )
        }

        OfferGridContent(offersWidget)
    }
}