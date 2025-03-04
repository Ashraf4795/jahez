package com.jahez.home.ui

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.jahez.RatingView
import com.jahez.home.state.MerchantUiModel
import com.jahez.ui.theme.JahezTheme
import com.jahez.ui.theme.primary_500


@Composable
fun MerchantListItem(
    modifier: Modifier = Modifier,
    merchantUiModel: MerchantUiModel,
    onMerchantClick: (String) -> Unit,
    onFavoritClick: (Boolean) -> Unit,
) {
    var favoritIconState by remember(merchantUiModel) {
        mutableStateOf(merchantUiModel.isFavorite)
    }

    Card(modifier = modifier
        .clickable { onMerchantClick(merchantUiModel.merchantId) }
        .heightIn(70.dp, 80.dp)
        .fillMaxWidth(),
        colors = CardDefaults.cardColors().copy(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        ConstraintLayout(
            modifier = Modifier.fillMaxWidth()
        ) {
            val (mImage, merchantInfo, mIsFavorite) = createRefs()
            val margin = 18.dp
            Image(
                modifier = Modifier
                    .constrainAs(mImage) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
                    .clip(RoundedCornerShape(12.dp)),
                painter = painterResource(
                    com.jahez.common_resources.R.drawable.place_holder_food_image,
                ),
                contentDescription = "",
                contentScale = ContentScale.Fit
            )

            Column(
                modifier = Modifier.constrainAs(merchantInfo) {
                        start.linkTo(mImage.end, margin)
                        top.linkTo(parent.top, 12.dp)
                    }
                    .fillMaxHeight()
            ) {
                Text(
                    text = merchantUiModel.merchantName.localize("en"),
                    style = MaterialTheme.typography.titleLarge
                )

                RatingView(
                    rate = merchantUiModel.rating,
                    rateCount = merchantUiModel.rateCount
                )

                merchantUiModel.getDeliveryMetadata()?.let { deliveryMetadata ->
                    Text(text = deliveryMetadata)
                }

            }

            IconButton(
                modifier = Modifier
                    .constrainAs(mIsFavorite) {
                        top.linkTo(merchantInfo.top)
                        bottom.linkTo(merchantInfo.bottom)
                        end.linkTo(parent.end, margin)
                    },
                onClick = {
                    favoritIconState = !favoritIconState
                }
            ) {
                Icon(
                    imageVector = if (favoritIconState) {
                        Icons.Filled.Favorite
                    } else Icons.Outlined.FavoriteBorder,
                    contentDescription = "",
                    tint = if (favoritIconState) {
                        primary_500
                    } else MaterialTheme.colorScheme.onSurface
                )
            }

        }
    }
}

@Preview
@Composable
private fun PreviewMerchantListItem() {

    JahezTheme {
        MerchantListItem(
            merchantUiModel = MerchantUiModel.getMock(),
            onFavoritClick = { isFavorit -> },
            onMerchantClick = {}
        )
    }

}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL

)
@Composable
private fun DarkPreviewMerchantListItem() {

    JahezTheme {
        MerchantListItem(
            merchantUiModel = MerchantUiModel.getMock(),
            onFavoritClick = { isFavorit -> },
            onMerchantClick = {}
        )
    }

}