package com.jahez.address

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jahez.ui.theme.JahezTheme
import com.jahez.ui.theme.neutral_200
import com.jahez.ui.theme.neutral_50
import com.jahez.ui.theme.neutral_700
import com.jahez.ui.theme.primary_100
import com.jahez.ui.theme.primary_200
import com.jahez.ui.theme.primary_300
import com.jahez.ui.theme.primary_500


@Composable
fun AddAddressButton(modifier: Modifier = Modifier, enabled: Boolean = true, onClick: () -> Unit) {
    val isDark = isSystemInDarkTheme()

    Card(
        modifier = modifier.clickable {
            onClick()
        }.padding(vertical = 12.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isDark) MaterialTheme.colorScheme.surface else primary_100,
            contentColor = MaterialTheme.colorScheme.onPrimary
        ),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 1.dp, pressedElevation = 3.dp)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp, start = 24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {


            IconButton(
                modifier = Modifier,
                enabled = enabled,
                onClick = onClick
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "",
                    tint = if(isDark) Color.White else primary_500
                )
            }

            Text(
                text = stringResource(R.string.add_address_label),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 22.sp,
                    color = if (isDark) MaterialTheme.colorScheme.onPrimary else primary_500,
                    baselineShift = BaselineShift.None
                )
            )

        }
    }
}

@Preview
@Composable
private fun PreviewAddressListItem() {
    JahezTheme {
        Column {
            AddAddressButton { }

            Spacer(Modifier.height(8.dp))

            AddAddressButton { }
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL)
@Composable
private fun DarkPreviewAddressListItem() {
    JahezTheme {
        Column {
            AddAddressButton { }

            Spacer(Modifier.height(8.dp))

            AddAddressButton { }
        }
    }
}