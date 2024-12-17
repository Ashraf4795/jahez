package com.jahez

import android.content.res.Configuration
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jahez.ui.theme.JahezTheme
import com.jahez.ui.theme.secondary_500

@Composable
fun RatingView(modifier: Modifier = Modifier, rate: Float? = null, rateCount: Int = 0) {

    if (rateCount > 0) {
        Row(modifier, verticalAlignment = Alignment.CenterVertically) {
            // star
            Icon(
                modifier = modifier,
                imageVector = Icons.Default.Star,
                contentDescription = "Rating start icon",
                tint = secondary_500
            )

            // rating e.g. 4.9
            Text(
                modifier = Modifier.padding(horizontal = 8.dp),
                text = rate.toString(),
                style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Normal)
            )

            // rate count e.g (1102)
            Text(
                text = "($rateCount)",
                style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Normal)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewRatingView() {
    JahezTheme {
        RatingView(
            rate = 4.9f,
            rateCount = 1243
        )
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
private fun DarkPreviewRatingView() {
    JahezTheme {
        Card {
            RatingView(
                rate = 4.9f,
                rateCount = 1234
            )
        }
    }
}