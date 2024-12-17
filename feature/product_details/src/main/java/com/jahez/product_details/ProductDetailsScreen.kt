package com.jahez.product_details

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jahez.PriceView
import com.jahez.RatingView
import com.jahez.common_resources.R
import com.jahez.composable.AddToBasketView
import com.jahez.composable.ProductOptions
import com.jahez.ui.theme.JahezTheme

@Composable
fun ProductDetailScreen(modifier: Modifier = Modifier, onBackClick: () -> Unit) {
    Box(contentAlignment = Alignment.BottomCenter) {
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
        ) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                ) {
                    // replace with AsynImage
                    Image(
                        painter = painterResource(R.drawable.place_holder_food_image),
                        contentDescription = "Product Image",
                        modifier = Modifier
                            .fillMaxSize(),
                        contentScale = ContentScale.FillBounds
                    )
                }
            }
            item {
                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Product Title",
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
            item {
                PriceView(
                    modifier = Modifier.padding(vertical = 16.dp),
                    labelSize = 22.sp,
                    originalPrice = 10f,
                    actualPrice = 6f,
                    currency = "$"
                )
            }

            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    RatingView(
                        rate = 4.9f,
                        rateCount = 1234
                    )

                    Text(
                        text = stringResource(R.string.see_all_review_label),
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontWeight = FontWeight.Medium,
                            textDecoration = TextDecoration.Underline
                        ),
                    )
                }
            }
            item {
                ExpandableText(
                    text = """
            This is a detailed description of the product, This is a detailed description of the product,
            This is a detailed description of the product, This is a detailed description of the product
            This is a detailed description of the product
        """.trimIndent()
                )
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                Text(
                    text = stringResource(R.string.additional_options_label),
                    style = MaterialTheme.typography.titleLarge
                )
            }
            repeat(10) {
                item {
                    ProductOptions(
                        modifier = Modifier.padding(vertical = 16.dp),
                        optionTitle = "option ${it + 1}",
                        optionSubtitle = "option subtitle"
                    )
                }
            }
            item {
                Spacer(Modifier.height(100.dp))
            }
        }
        AddToBasketView(modifier = Modifier.padding(8.dp))
    }
}

@Composable
fun ExpandableText(text: String) {
    var expanded by remember { mutableStateOf(false) }
    val maxLines = if (expanded) Int.MAX_VALUE else 2

    Column {
        Text(
            text = text,
            maxLines = maxLines,
            overflow = TextOverflow.Ellipsis
        )
        if (!expanded) {
            Text(
                text = stringResource(R.string.show_more_label),
                modifier = Modifier.clickable { expanded = true }
            )
        } else {
            Text(
                text = stringResource(R.string.show_less_label),
                modifier = Modifier.clickable { expanded = false }
            )
        }
    }
}

@Preview
@Composable
private fun PreviewProductDetailsScreen() {
    JahezTheme {
        ProductDetailScreen {}
    }
}