package com.jahez.basket

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.jahez.PriceView
import com.jahez.TopBar
import com.jahez.TwoLabelView
import com.jahez.actions.OutlinePrimaryButton
import com.jahez.actions.PrimaryButton
import com.jahez.basket.model.BasketOrderItem
import com.jahez.basket.model.BasketUiState
import com.jahez.basket.model.OrderPriceSummaryUiModel
import com.jahez.inputs.Counter
import com.jahez.product_details.ProductDetailsUiModel
import com.jahez.ui.theme.JahezTheme


@Composable
fun BasketScreen(
    modifier: Modifier = Modifier,
    basketUiState: BasketUiState,
    onBackCList: () -> Unit
) {
    Column(modifier.padding(16.dp)) {
        TopBar(
            modifier = Modifier.padding(top = 16.dp),
            leading = {
                IconButton(onClick = onBackCList) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back Arrow",
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            },
            content = {
                Text(
                    text = stringResource(R.string.my_basket_screen_label),
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Start
                )
            },
            trailing = { },
        )

        BasketScreenContent(
            modifier = Modifier.weight(1f),
            basketUiState = basketUiState as BasketUiState.Success
        )

        Footer(
            modifier = Modifier,
            basketUiState.orderPriceSection
        )
    }
}

@Composable
internal fun Footer(
    modifier: Modifier = Modifier,
    orderPriceSummaryUiModel: OrderPriceSummaryUiModel
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TwoLabelView(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(vertical = 4.dp),
            label1 = stringResource(R.string.subtotal_label),
            label2 = "${orderPriceSummaryUiModel.subTotal} ${orderPriceSummaryUiModel.currency}",
            labelSize = 16.sp
        )

        TwoLabelView(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(vertical = 4.dp),
            label1 = stringResource(R.string.delivery_fee_label),
            label2 = "${orderPriceSummaryUiModel.deliveryFee} ${orderPriceSummaryUiModel.currency}",
            labelSize = 16.sp
        )

        if (orderPriceSummaryUiModel.discount() > 0.5f) {
            TwoLabelView(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(vertical = 4.dp),
                label1 = stringResource(R.string.discount_label),
                label2 = "${orderPriceSummaryUiModel.discount()} ${orderPriceSummaryUiModel.currency}",
                labelSize = 16.sp
            )
        }

        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            color = MaterialTheme.colorScheme.onPrimary
        )

        TwoLabelView(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(bottom = 16.dp),
            label1 = stringResource(R.string.total_label),
            label2 = orderPriceSummaryUiModel.total(),
            labelSize = 16.sp
        )

        // place order button
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = orderPriceSummaryUiModel.total(),
                style = MaterialTheme.typography.titleMedium.copy(fontSize = 32.sp),
                color = MaterialTheme.colorScheme.onPrimary
            )
            PrimaryButton(
                modifier = Modifier.weight(1f),
                content = {
                    Text(stringResource(R.string.place_order_label))
                }) {}
        }
    }
}

@Composable
internal fun BasketScreenContent(
    modifier: Modifier = Modifier,
    basketUiState: BasketUiState
) {
    Box(
        modifier = modifier
            .padding(top = 16.dp)
    ) {

        when (basketUiState) {
            BasketUiState.Loading -> {
                CircularProgressIndicator()
            }

            BasketUiState.LoadingFailed -> {
                Text("failed to load basket")
            }

            is BasketUiState.Success -> {
                LazyColumn {
                    item {
                        OrderSummary()
                    }

                    items(
                        basketUiState.basketItems.size,
                        key = { basketUiState.basketItems[it].productDetailsUiModel.productId }) { index ->
                        val basketItem = basketUiState.basketItems[index]
                        BasketItemRow(basketOrderItem = basketItem) {}
                    }
                }
            }
        }
    }

}

@Composable
fun OrderSummary(modifier: Modifier = Modifier) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        val (orderSummaryLabel, addItemButton) = createRefs()

        Text(
            modifier = Modifier
                .wrapContentWidth()
                .constrainAs(orderSummaryLabel) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                },
            text = stringResource(R.string.order_summary_label),
            style = MaterialTheme.typography.titleMedium.copy(fontSize = 24.sp),
            color = MaterialTheme.colorScheme.onPrimary
        )
        PrimaryButton(
            modifier = Modifier
                .wrapContentSize()
                .constrainAs(addItemButton) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                },
            content = {
                Text(
                    stringResource(R.string.add_item_button_label),
                    style = MaterialTheme.typography.labelMedium
                )
            },
            contentPaddingValues = PaddingValues(8.dp),
        ) {}
    }
}

@Composable
internal fun BasketItemRow(
    modifier: Modifier = Modifier,
    basketOrderItem: BasketOrderItem,
    onBasketOrderItem: () -> Unit = {}
) {
    Card(modifier = modifier
        .clickable { onBasketOrderItem() }
        .fillMaxWidth(),
        colors = CardDefaults.cardColors().copy(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Absolute.Left
        ) {
            Image(
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .padding(8.dp)
                    .size(100.dp),

                painter = painterResource(
                    com.jahez.common_resources.R.drawable.place_holder_food_image,
                ),
                contentDescription = "",
                contentScale = ContentScale.Fit
            )

            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f)
            ) {
                Text(
                    text = basketOrderItem.productDetailsUiModel.productName,
                    style = MaterialTheme.typography.titleLarge
                )

                Counter(
                    counterLabelStyle = MaterialTheme.typography.bodyLarge.copy(fontSize = 24.sp),
                ) { }
            }

            PriceView(
                originalPrice = basketOrderItem.productDetailsUiModel.productOldPrice,
                actualPrice = basketOrderItem.productDetailsUiModel.productPrice,
                modifier = Modifier.wrapContentHeight(),
                labelSize = 24.sp,
            )

        }
    }
}

@Preview
@Composable
private fun PreviewBasketScreen() {
    JahezTheme {
        BasketScreen(modifier = Modifier, BasketUiState.Success(
            basketItems = listOf(
                BasketOrderItem(
                    productDetailsUiModel = ProductDetailsUiModel.getMock().copy(productId = "1"),
                    quantity = 1
                ),
                BasketOrderItem(
                    productDetailsUiModel = ProductDetailsUiModel.getMock().copy(productId = "2"),
                    quantity = 2
                ),
                BasketOrderItem(
                    productDetailsUiModel = ProductDetailsUiModel.getMock().copy(productId = "3"),
                    quantity = 2
                ),
                BasketOrderItem(
                    productDetailsUiModel = ProductDetailsUiModel.getMock().copy(productId = "4"),
                    quantity = 2
                )
            ),
            orderPriceSection = OrderPriceSummaryUiModel(
                subTotal = 100f,
                discount = 0,
                deliveryFee = 10f,
                currency = "EGP"
            )
        ), onBackCList = { })
    }
}

@Preview
@Composable
private fun PreviewBasketOrderItem() {
    JahezTheme {
        BasketItemRow(
            modifier = Modifier, BasketOrderItem(
                productDetailsUiModel = ProductDetailsUiModel.getMock().copy(productId = "1"),
                quantity = 1
            )
        )
    }
}