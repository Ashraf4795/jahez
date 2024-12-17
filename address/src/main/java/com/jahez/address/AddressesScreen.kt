package com.jahez.address

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import com.jahez.AppBar
import com.jahez.actions.PrimaryButton
import com.jahez.ui.theme.JahezTheme

@Composable
fun AddressesScreen(modifier: Modifier = Modifier, addresses: List<Pair<String, String>>) {
    var selectedAddressState by remember(addresses) {
        mutableStateOf<Any?>(null)
    }

    Scaffold(
        modifier = modifier,
        topBar = {
            AppBar(title = stringResource(R.string.my_locations_label)) {}
        },
    ) { innerPadding ->
        ConstraintLayout(
            modifier = Modifier.padding(innerPadding)
        ) {
            val (addressList, applyBtn) = createRefs()

            LazyColumn(
                modifier = Modifier.constrainAs(addressList) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            ) {
                items(addresses.size) { index ->
                    val address = addresses[index]
                    AddressListItem(
                        addressName = address.first,
                        addressDetails = address.second
                    ) {  selected, selectedAddress ->
                        // update list of address selected flag and enable apply btn
                        // if at least one address selected=true
                        selectedAddressState = selectedAddress
                    }
                }

                item {
                    AddAddressButton { }
                }
            }

            PrimaryButton(
                modifier = Modifier.constrainAs(applyBtn){
                    top.linkTo(addressList.bottom)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }.fillMaxWidth(),
                enabled = selectedAddressState != null,
                content = {
                    Text(
                        text = stringResource(com.jahez.common_resources.R.string.apply_label)
                    )
                }
            ) { }
        }

    }
}


@Preview
@Composable
private fun PreviewAddressScreen() {
    JahezTheme {
        AddressesScreen(addresses = emptyList())
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL)
@Composable
private fun DarkPreviewAddressScreen() {
    JahezTheme {
        AddressesScreen(
            addresses = listOf(
                Pair("Home", "1A Baker Street, London, United Kingdom")
            )
        )
    }
}