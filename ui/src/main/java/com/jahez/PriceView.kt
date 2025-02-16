package com.jahez

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jahez.ui.theme.JahezTheme
import com.jahez.ui.theme.neutral_200
import com.jahez.ui.theme.primary_500

@Composable
fun PriceView(
    modifier: Modifier = Modifier,
    labelSize: TextUnit = 16.sp,
    originalPrice: Float? = null,
    actualPrice: Float? = null,
    currency: String = "",
) {

    Row(modifier, verticalAlignment = Alignment.CenterVertically) {
        if (originalPrice != null && originalPrice > 0f) {
            Text(
                modifier = Modifier.padding(end = 12.dp),
                text = "$currency $originalPrice",
                style = MaterialTheme.typography.labelLarge.copy(
                    fontWeight = FontWeight.Normal,
                    fontSize = labelSize,
                    color = neutral_200,
                    textDecoration = TextDecoration.LineThrough
                )
            )
        }
        if (actualPrice != null && actualPrice > 0f) {
            Text(
                modifier = Modifier,
                text = "$currency $actualPrice",
                style = MaterialTheme.typography.labelLarge.copy(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = labelSize,
                    color = primary_500
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewPriceView() {
    JahezTheme {
        Card(
            Modifier
                .fillMaxWidth()
                .padding(32.dp)
        ) {
            Column {
                PriceView(
                    labelSize = 16.sp,
                    originalPrice = null,
                    actualPrice = 6.0f,
                    currency = "$"
                )
                PriceView(
                    labelSize = 24.sp,
                    originalPrice = 10f,
                    actualPrice = 6.0f,
                    currency = "£"
                )
            }
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
            colors = CardDefaults.cardColors()
                .copy(containerColor = MaterialTheme.colorScheme.primary),
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp)
        ) {
            Column {
                PriceView(
                    labelSize = 16.sp,
                    originalPrice = null,
                    actualPrice = 6.0f,
                    currency = "L.E"
                )
                PriceView(
                    labelSize = 24.sp,
                    originalPrice = 10f,
                    actualPrice = 6.0f,
                    currency = "£"
                )
            }
        }
    }
}