package com.jahez.actions

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jahez.ui.theme.JahezTheme
import com.jahez.ui.theme.neutral_50
import com.jahez.ui.theme.primary_100
import com.jahez.ui.theme.primary_500


@Composable
fun SecondaryButton(
    modifier: Modifier = Modifier,
    title: String,
    leading: @Composable () -> Unit = {},
    trailing: @Composable () -> Unit = {},
    onClick: () -> Unit
) {

    Button(
        modifier = modifier,
        onClick = onClick,
        shape = RoundedCornerShape(28.dp),
        colors = ButtonColors(
            containerColor = neutral_50,
            contentColor = primary_500,
            disabledContainerColor = Color.White,
            disabledContentColor = primary_100,
        ),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        leading()
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = title)
        Spacer(modifier = Modifier.width(8.dp))
        trailing()
    }
}

@Preview(
    apiLevel = 34, showSystemUi = true,
    showBackground = true,
)
@Composable
fun SecondaryButtonPreview() {
    JahezTheme {
        Card(
            colors = CardDefaults.cardColors()
                .copy(containerColor = MaterialTheme.colorScheme.primary)
        ) {

            Column {
                SecondaryButton(
                    modifier = Modifier.fillMaxWidth(),
                    title = "Next", leading = {
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
                SecondaryButton(
                    modifier = Modifier,
                    title = "Next", leading = {
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
fun DarkSecondaryButtonPreview() {
    JahezTheme {
        Card(
            colors = CardDefaults.cardColors()
                .copy(containerColor = MaterialTheme.colorScheme.primary)
        ) {

            Column {
                SecondaryButton(
                    modifier = Modifier.fillMaxWidth(),
                    title = "Next", leading = {
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
                SecondaryButton(
                    modifier = Modifier,
                    title = "Next", leading = {
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