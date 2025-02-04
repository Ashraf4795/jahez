package com.jahez.home.ui.sections

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.jahez.actions.Section
import com.jahez.home.MerchantsWidget
import com.jahez.home.R
import com.jahez.home.model.MerchantUiModel
import com.jahez.home.ui.MerchantListItem

fun LazyListScope.MerchantSection(
    modifier: Modifier = Modifier,
    merchantsWidget: MerchantsWidget?,
    onMoreClick: () -> Unit
) {

    item {
        Section(
            modifier,
            sectionTitle = stringResource(R.string.merchant_section_label),
            onMoreClick = onMoreClick,
        )
    }

    merchantsWidget?.let { merchantsWidget ->
        items(
            merchantsWidget.items.size,
            key = { merchantsWidget.items[it].merchantId }) { index ->
            val merchantItem = merchantsWidget.items[index]
            MerchantListItem(
                modifier = Modifier.padding(vertical = 16.dp, horizontal = 8.dp),
                merchantUiModel = MerchantUiModel.getMock(),
                onFavoritClick = {},
            ) { }
        }
    }
}