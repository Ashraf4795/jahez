package com.jahez.inputs

import android.content.res.Configuration
import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jahez.actions.JIcon
import com.jahez.ui.theme.JahezTheme

@Composable
fun Counter(
    modifier: Modifier = Modifier,
    min: Int = 1,
    max: Int = 100,
    counterLabelStyle: TextStyle = MaterialTheme.typography.headlineLarge,
    onCounterChange: (Int) -> Unit
) {
    var count by remember(min) {
        mutableIntStateOf(min)
    }

    Box(Modifier.width(IntrinsicSize.Max)) {
        Row(
            modifier = modifier
                .wrapContentSize()
                .semantics { contentDescription = "change item quantity" },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            JIcon(
                modifier = Modifier
                    .border(
                        BorderStroke(
                            1.dp,
                            MaterialTheme.colorScheme.onPrimary
                        ),
                        shape = CircleShape
                    )
                    .padding(8.dp),
                imageVector = Icons.Filled.Remove,
                enabled = count > min,
                contentDescription = "decrement",
                tint = MaterialTheme.colorScheme.onPrimary
            ) {
                if (count > min) {
                    count--
                    onCounterChange(count)
                }
            }

            AnimatedContent(targetState = count) { targetCount ->
                Text(
                    text = targetCount.toString(),
                    style = counterLabelStyle,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .weight(1f),
                    color = MaterialTheme.colorScheme.onPrimary,
                )
            }

            JIcon(
                modifier = Modifier
                    .border(
                        BorderStroke(
                            1.dp,
                            MaterialTheme.colorScheme.onPrimary
                        ),
                        shape = CircleShape
                    )
                    .padding(8.dp),
                imageVector = Icons.Filled.Add,
                enabled = count < max,
                contentDescription = "increment",
                tint = MaterialTheme.colorScheme.onPrimary
            ) {
                if (count < max) {
                    count++
                    onCounterChange(count)
                }
            }
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL)
@Composable
private fun CounterPreview() {
    JahezTheme {
        Card(
            colors = CardDefaults.cardColors()
                .copy(containerColor = MaterialTheme.colorScheme.primary)
        ) {
            Counter() {}
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL)
@Composable
private fun DarkCounterPreview() {
    JahezTheme {
        Card(
            colors = CardDefaults.cardColors()
                .copy(containerColor = MaterialTheme.colorScheme.primary)
        ) {
            Counter() {}
        }
    }
}