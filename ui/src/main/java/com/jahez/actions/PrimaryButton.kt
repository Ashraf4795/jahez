package com.jahez.actions

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jahez.ui.theme.JahezTheme
import com.jahez.ui.theme.primary_200
import com.jahez.ui.theme.primary_500


@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentPaddingValues: PaddingValues = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
    leading: @Composable () -> Unit = {},
    content: @Composable () -> Unit,
    trailing: @Composable () -> Unit = {},
    onClick: () -> Unit
) {

    Button(
        modifier = modifier,
        onClick = onClick,
        enabled = enabled,
        shape = RoundedCornerShape(28.dp),
        colors = ButtonColors(
            containerColor = primary_500,
            contentColor = Color.White,
            disabledContainerColor = primary_200,
            disabledContentColor = Color.White
        ),
        contentPadding = contentPaddingValues
    ) {
        leading()
        content()
        trailing()
    }
}

@Composable
fun OutlinePrimaryButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentPaddingValues: PaddingValues = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
    leading: @Composable () -> Unit = {},
    content: @Composable () -> Unit,
    trailing: @Composable () -> Unit = {},
    onClick: () -> Unit
) {

    OutlinedButton(
        modifier = modifier,
        onClick = onClick,
        enabled = enabled,
        shape = RoundedCornerShape(28.dp),
        colors = ButtonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = primary_500,
            disabledContainerColor = primary_200,
            disabledContentColor = Color.White
        ),
        contentPadding = contentPaddingValues ,
        border = BorderStroke(2.dp, primary_500)
    ) {
        leading()
        content()
        trailing()
    }
}

@Preview(
    apiLevel = 34,
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun PrimaryButtonPreview() {
    JahezTheme {
        Card(
            colors = CardDefaults.cardColors()
                .copy(containerColor = MaterialTheme.colorScheme.primary)
        ) {
            Column {
                PrimaryButton(
                    modifier = Modifier.fillMaxWidth(),
                    content = {
                        Text("Next")
                    }, leading = {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Leading Icon",
                            modifier = Modifier.size(24.dp)
                        )
                    }, trailing = {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Leading Icon",
                            modifier = Modifier.size(24.dp)
                        )
                    }) {}
                PrimaryButton(
                    modifier = Modifier,
                    content = {
                        Text("Next")
                    }, leading = {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Leading Icon",
                            modifier = Modifier.size(24.dp)
                        )
                    }) {}
                PrimaryButton(
                    modifier = Modifier,
                    content = {
                        Text("Place order")
                    }
                ) {}

                PrimaryButton(
                    modifier = Modifier,
                    content = {
                        Text("Next")
                    }, enabled = false, leading = {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Leading Icon",
                            modifier = Modifier.size(24.dp)
                        )
                    }) {}

                OutlinePrimaryButton (
                    modifier = Modifier.fillMaxWidth(),
                    content = {
                        Text("Next")
                    }, leading = {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Leading Icon",
                            modifier = Modifier.size(24.dp)
                        )
                    }, trailing = {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Leading Icon",
                            modifier = Modifier.size(24.dp)
                        )
                    }) {}
            }
        }
    }
}

@Preview(
    apiLevel = 34, showSystemUi = true,
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun DarkPrimaryButtonPreview() {
    JahezTheme {
        Card(
            colors = CardDefaults.cardColors()
                .copy(containerColor = MaterialTheme.colorScheme.primary)
        ) {
            Column {
                PrimaryButton(
                    modifier = Modifier.fillMaxWidth(),
                    content = {
                        Text("Next")
                    }, leading = {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Leading Icon",
                            modifier = Modifier.size(24.dp)
                        )
                    }, trailing = {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Leading Icon",
                            modifier = Modifier.size(24.dp)
                        )
                    }) {}
                PrimaryButton(
                    modifier = Modifier,
                    content = {
                        Text("Next")
                    }, leading = {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Leading Icon",
                            modifier = Modifier.size(24.dp)
                        )
                    }) {}
                PrimaryButton(
                    modifier = Modifier,
                    content = {
                        Text("Place order")
                    }
                ) {}

                PrimaryButton(
                    modifier = Modifier,
                    content = {
                        Text("Next")
                    }, enabled = false, leading = {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Leading Icon",
                            modifier = Modifier.size(24.dp)
                        )
                    }) {}

                PrimaryButton(
                    modifier = Modifier.wrapContentWidth(),
                    content = {
                        Box(
                            modifier = Modifier
                                .padding(horizontal = 8.dp)
                                .size(18.dp)
                                .background(MaterialTheme.colorScheme.onSecondary, CircleShape),
                            contentAlignment = Alignment.Center,

                            ) {
                            Text("1", fontSize = 14.sp, color = MaterialTheme.colorScheme.secondary)
                        }

                    }, enabled = true, leading = {
                        Icon(
                            imageVector = Icons.Default.ShoppingCart,
                            contentDescription = "Leading Icon",
                            modifier = Modifier.size(24.dp)
                        )
                    }) {}

            }
        }
    }
}