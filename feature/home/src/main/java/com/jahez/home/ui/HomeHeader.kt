package com.jahez.home.ui

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jahez.common_resources.R
import com.jahez.ui.theme.JahezTheme
import com.jahez.ui.theme.neutral_200
import com.jahez.ui.theme.primary_500

@Composable
fun HomeHeader(
    modifier: Modifier = Modifier,
    address: String = "",
    onCartClick: () -> Unit,
    onAddressClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // user location address
        Column(
            modifier = Modifier
                .clickable { onAddressClick() }
                .padding(24.dp)
        ) {
            Text(
                modifier = Modifier.padding(vertical = 4.dp),
                text = stringResource(com.jahez.home.R.string.deliver_to_label),
                style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Normal)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (address.isNotBlank()) {
                    Text(
                        modifier = Modifier.fillMaxWidth(0.4f),
                        text = address,
                        style = MaterialTheme.typography.titleMedium,
                        color = neutral_200,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                } else {
                    Text(
                        text = stringResource(com.jahez.home.R.string.select_location_label),
                        style = MaterialTheme.typography.titleMedium,
                        color = neutral_200
                    )
                }
                Icon(
                    modifier = Modifier.size(24.dp),
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "",
                    tint = primary_500
                )
            }
        }

        // order cart
        Icon(
            modifier = Modifier
                .clickable { onCartClick() }
                .padding(24.dp),
            imageVector = ImageVector.vectorResource(R.drawable.cart_icon),
            contentDescription = "Order cart",
            tint = MaterialTheme.colorScheme.onPrimary
        )
    }
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    showBackground = true, showSystemUi = true, apiLevel = 34
)
@Composable
private fun HomeHeaderPreview() {
    JahezTheme {
        Scaffold(topBar = {
            HomeHeader(
                modifier = Modifier,
                address = "",
                onCartClick = {},
                onAddressClick = {},
            )
        }) { innerPadding ->
            Text(modifier = Modifier.padding(innerPadding), text = "")
        }
    }
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,
    showBackground = true, showSystemUi = true, apiLevel = 34
)
@Composable
private fun DarkHomeHeaderPreview() {
    JahezTheme {
        Scaffold(topBar = {
            HomeHeader(
                modifier = Modifier,
                address = "",
                onCartClick = {},
                onAddressClick = {},
            )
        }) { innerPadding ->
            Text(modifier = Modifier.padding(innerPadding), text = "")
        }
    }
}