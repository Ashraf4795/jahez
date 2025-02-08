package com.jahez.home.ui.sections

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jahez.actions.Section
import com.jahez.home.OffersWidget
import com.jahez.home.R
import com.jahez.home.ui.OfferGridContent
import com.jahez.home_data.datasource.remote.fake.fakeHomePageContent
import com.jahez.ui.theme.JahezTheme


fun LazyListScope.OfferSection(
    modifier: Modifier = Modifier,
    offersWidget: OffersWidget,
    onMoreClick: () -> Unit
) {

    if (offersWidget.items.isNotEmpty()) {
        item {
            Section(
                modifier.padding(vertical = 4.dp, horizontal = 8.dp),
                sectionTitle = stringResource(R.string.offer_secion_label),
                onMoreClick = onMoreClick,
            )
        }

        OfferGridContent(offersWidget)
    }
}

@Preview
@Composable
private fun PreviewOfferSection() {
    JahezTheme {
        LazyColumn {
            fakeHomePageContent.offersWidget?.let {
                OfferSection(
                    offersWidget = it
                ) {}
            }
        }
    }
}