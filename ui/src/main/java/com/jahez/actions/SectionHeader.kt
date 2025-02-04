package com.jahez.actions

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jahez.ui.theme.Typography
import com.jahez.ui.theme.primary_500


@Composable
fun SectionHeader(
    title: String,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = Typography.titleMedium.copy(fontWeight = FontWeight.SemiBold),
            maxLines = 1
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = stringResource(com.jahez.common_resources.R.string.view_more_label),
                style = Typography.titleMedium.copy(fontWeight = FontWeight.SemiBold),
                color = primary_500,
                maxLines = 1
            )
            Spacer(modifier = Modifier.width(4.dp))
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                contentDescription = "More",
                tint = primary_500
            )
        }
    }
}

@Preview
@Composable
fun PreviewDualLabelRow() {
    SectionHeader(title = "Special offers")
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,
    showBackground = true, showSystemUi = true
)
@Composable
fun DarkPreviewDualLabelRow() {
    SectionHeader(title = "Restaurants")
}