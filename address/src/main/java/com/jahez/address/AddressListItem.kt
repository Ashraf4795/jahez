package com.jahez.address

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jahez.ui.theme.JahezTheme
import com.jahez.ui.theme.primary_200
import com.jahez.ui.theme.primary_500

@Composable
fun AddressListItem(
    modifier: Modifier = Modifier,
    addressName: String,
    addressDetails: String,
    enabled: Boolean = true,
    isSelected: Boolean = false,
    onItemRadioButtonClick: (Boolean, Any) -> Unit
) {
    var addressSelectState by remember(isSelected) {
        mutableStateOf(isSelected)
    }

    Card(
        border = if (addressSelectState && enabled) {
            BorderStroke(2.dp, primary_500)
        } else {
            BorderStroke(2.dp, MaterialTheme.colorScheme.surface)
        },
        modifier = modifier.clickable {
            if (enabled) {
                addressSelectState = !addressSelectState
                onItemRadioButtonClick(addressSelectState, 1) // change 1 to address obj
            }
        }.padding(vertical = 12.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onPrimary
        )
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp, start = 24.dp)
        ) {
            Column(Modifier.weight(1f)) {
                Text(
                    text = addressName,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold)
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    text = addressDetails,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold)
                )
            }
            RadioButton(modifier = Modifier,
                selected = addressSelectState,
                enabled = enabled,
                colors = RadioButtonColors(
                    selectedColor = primary_500,
                    unselectedColor = MaterialTheme.colorScheme.onPrimary,
                    disabledSelectedColor = primary_200,
                    disabledUnselectedColor = MaterialTheme.colorScheme.onPrimary
                ),
                onClick = {
                    if (enabled) {
                        addressSelectState = !addressSelectState
                        onItemRadioButtonClick(addressSelectState, 1)
                    }
                })
        }
    }
}


@Preview
@Composable
private fun PreviewAddressListItem() {
    JahezTheme {
        Column {
            AddressListItem(
                addressName = "Home",
                addressDetails = "1A Baker Street, London, United  Kingdom Kingdom Kingdom Kingdom"
            ) { selected, address -> }

            Spacer(Modifier.height(8.dp))

            AddressListItem(
                enabled = false,
                isSelected = true,
                addressName = "Home",
                addressDetails = "2A Baker Street, London, United  Kingdom Kingdom Kingdom Kingdom"
            ) { selected, address -> }
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL)
@Composable
private fun DarkPreviewAddressListItem() {
    JahezTheme {
        Column {
            AddressListItem(
                addressName = "Home",
                addressDetails = "1A Baker Street, London, United  Kingdom Kingdom Kingdom Kingdom"
            ) { selected, address ->}

            Spacer(Modifier.height(8.dp))

            AddressListItem(
                enabled = false,
                isSelected = true,
                addressName = "Home",
                addressDetails = "2A Baker Street, London, United  Kingdom Kingdom Kingdom Kingdom"
            ) { selected, address -> }
        }
    }
}