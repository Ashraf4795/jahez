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
import com.jahez.home.MerchantsWidget
import com.jahez.home.R
import com.jahez.home.state.MerchantUiModel
import com.jahez.home.ui.MerchantListItem
import com.jahez.home_data.datasource.remote.fake.fakeHomePageContent

fun LazyListScope.MerchantSection(
    modifier: Modifier = Modifier,
    merchantsWidget: MerchantsWidget,
    onMerchantClick: (String) -> Unit,
    onMoreClick: () -> Unit,
) {

    item {
        Section(
            modifier.padding(bottom = 8.dp),
            sectionTitle = stringResource(R.string.merchant_section_label),
            onMoreClick = onMoreClick,
        )
    }

    merchantsWidget.let { merchantsWidget ->
        items(
            merchantsWidget.items.size,
            key = { merchantsWidget.items[it].merchantId }) { index ->
            val merchantItem = merchantsWidget.items[index]
            MerchantListItem(
                modifier = Modifier.padding(bottom = 8.dp),
                merchantUiModel = MerchantUiModel.getMock(),
                onFavoritClick = {},
                onMerchantClick = onMerchantClick
            )
        }
    }
}


@Preview
@Composable
private fun PreviewMerchantSection() {
    LazyColumn {
        MerchantSection(
            merchantsWidget = fakeHomePageContent.merchantsWidget!!,
            onMerchantClick = {},
        ) {}
    }
}