package com.jahez.composable

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jahez.actions.PrimaryButton
import com.jahez.inputs.Counter
import com.jahez.common_resources.R
import com.jahez.ui.theme.JahezTheme


@Composable
fun AddToBasketView(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp), shape = RoundedCornerShape(12.dp),

    ) {
        Row(
            Modifier
                .fillMaxSize()
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Counter { }
            PrimaryButton(
                leading = {
                    Icon(
                        modifier = Modifier.padding(horizontal = 14.dp),
                        imageVector = ImageVector.vectorResource(R.drawable.filled_cart_icon),
                        tint = Color.White,
                        contentDescription = "",

                        )
                },
                content = {
                    Text("Add to basket")
                }
            ) { }
        }
    }
}

@Preview
@Composable
private fun PreviewAddToBasketView() {
    JahezTheme {
        AddToBasketView()
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL)
@Composable
private fun DarkPreviewAddToBasketView() {
    JahezTheme {
        AddToBasketView()
    }
}