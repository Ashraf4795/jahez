package com.jahez.product_details.composable

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jahez.TwoLabelView
import com.jahez.ui.theme.JahezTheme

@Composable
fun ProductOptions(
    modifier: Modifier = Modifier,
    optionLabelSize: TextUnit = 16.sp,
    optionTitle: String,
    optionSubtitle: String,
    trailing: @Composable () -> Unit = {}
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TwoLabelView(
            modifier = Modifier.fillMaxWidth(),
            labelSize = optionLabelSize,
            label1 = optionTitle,
            label2 = optionSubtitle
        )
        Box(
            modifier = Modifier.align(Alignment.CenterVertically)
        ) {
            trailing()
        }

    }
}


@Preview(showBackground = true)
@Composable
private fun PreviewPriceView() {
    JahezTheme {
        Card(
            Modifier
                .height(50.dp)
                .wrapContentWidth()
        ) {
            ProductOptions(
                Modifier
                    .fillMaxSize()
                    .padding(horizontal = 8.dp),
                optionTitle = "Add Bacon",
                optionSubtitle = "+2.00 L.E"
            )
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
private fun DarkPreviewPriceView() {
    JahezTheme {
        Card(
            Modifier
                .height(50.dp)
                .wrapContentWidth()
        ) {
            ProductOptions(
                Modifier
                    .fillMaxSize()
                    .padding(horizontal = 8.dp),
                optionTitle = "Add Bacon",
                optionSubtitle = "+2.00 L.E"
            )
        }
    }
}