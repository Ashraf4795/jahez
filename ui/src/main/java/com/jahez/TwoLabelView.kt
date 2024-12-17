package com.jahez

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jahez.ui.theme.JahezTheme


@Composable
fun TwoLabelView(
    modifier: Modifier = Modifier,
    label1: String,
    label2: String,
    labelSize: TextUnit
) {

    Row(
        modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label1,
            style = MaterialTheme.typography.labelLarge.copy(
                fontWeight = FontWeight.Normal,
                fontSize = labelSize,
                color = MaterialTheme.colorScheme.onPrimary
            )
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = label2,
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.labelLarge.copy(
                fontWeight = FontWeight.Normal,
                fontSize = labelSize,
                color = MaterialTheme.colorScheme.onPrimary
            )
        )
    }
}

@Preview
@Composable
private fun PreviewTwoLabelView() {
    JahezTheme {
        Card(Modifier.height(50.dp)) {
            Column(
                modifier = Modifier.fillMaxSize().padding(horizontal = 8.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TwoLabelView(
                    modifier = Modifier,
                    labelSize = 24.sp,
                    label1 = "Add Bacon",
                    label2 = "+2.00 L.E"
                )
            }
        }
    }
}


@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,
    showBackground = true
)
@Composable
private fun DarkPreviewTwoLabelView() {
    JahezTheme {
        Card {
            TwoLabelView(
                modifier = Modifier.fillMaxWidth(),
                labelSize = 24.sp,
                label1 = "Add Bacon",
                label2 = "+2.00 L.E"
            )
        }
    }
}