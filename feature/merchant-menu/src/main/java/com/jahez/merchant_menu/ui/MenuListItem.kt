package com.jahez.merchant_menu.ui


import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jahez.PriceView
import com.jahez.product_details.ProductDetailsUiModel
import com.jahez.ui.theme.JahezTheme


@Composable
fun MenuListItem(
    modifier: Modifier = Modifier,
    product: ProductDetailsUiModel,
    onItemClick: (ProductDetailsUiModel) -> Unit
) {
    Card(modifier = modifier
        .clickable { onItemClick(product) }
        .fillMaxWidth()
        .wrapContentHeight(),
        colors = CardDefaults.cardColors().copy(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Row(
            horizontalArrangement = Arrangement.Absolute.Left
        ) {
            product.productPhoto.firstOrNull()?.let {
                Image(
                    modifier = Modifier.clip(RoundedCornerShape(12.dp)),
                    painter = painterResource(
                        com.jahez.common_resources.R.drawable.place_holder_food_image,
                    ),
                    contentDescription = "",
                    contentScale = ContentScale.Fit
                )
            } ?: run {
                Image(
                    modifier = Modifier.clip(RoundedCornerShape(12.dp)),
                    painter = painterResource(
                        com.jahez.common_resources.R.drawable.place_holder_food_image,
                    ),
                    contentDescription = "",
                    contentScale = ContentScale.Fit
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(Alignment.CenterVertically)
                    .padding(16.dp)
            ) {

                Text(
                    text = product.productName,
                    style = MaterialTheme.typography.titleLarge
                )

                Text(
                    text = product.productDesc,
                    style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Normal),
                    maxLines = 2,
                    letterSpacing = 0.15.sp,
                    overflow = TextOverflow.Ellipsis
                )

                PriceView(
                    modifier = Modifier,
                    actualPrice = product.productPrice,
                    originalPrice = product.productOldPrice,
                    currency = product.productCurrency
                )

            }
        }
    }
}

@Preview
@Composable
private fun PreviewMerchantListItem() {

    JahezTheme {
        MenuListItem(product = ProductDetailsUiModel.getMock().copy(productOldPrice = null)) {}
    }

}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,
    showBackground = true
)
@Composable
private fun DarkPreviewMerchantListItem() {

    JahezTheme {
        MenuListItem(product = ProductDetailsUiModel.getMock()) {}
    }

}