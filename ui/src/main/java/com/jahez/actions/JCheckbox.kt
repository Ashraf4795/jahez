package com.jahez.actions

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jahez.ui.theme.JahezTheme

@Composable
fun JCheckbox(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    var isChecked by remember(checked, onCheckedChange) {
        mutableStateOf(checked)
    }
    Checkbox(
        modifier = modifier,
        checked = isChecked,
        onCheckedChange = { checkState ->
            isChecked = checkState
            onCheckedChange(isChecked)
        },
        enabled = enabled,
        colors = CheckboxDefaults.colors().copy(
            checkedBorderColor = if(isChecked) {
                MaterialTheme.colorScheme.secondary
            } else MaterialTheme.colorScheme.tertiary,
            disabledBorderColor = MaterialTheme.colorScheme.tertiary,
            checkedBoxColor =  MaterialTheme.colorScheme.secondary,
            checkedCheckmarkColor = MaterialTheme.colorScheme.onSecondary,
            disabledCheckedBoxColor = MaterialTheme.colorScheme.tertiary,
            uncheckedCheckmarkColor = MaterialTheme.colorScheme.onSecondary,
        ),
    )
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
private fun DarkCounterPreview() {
    JahezTheme {
        Column {
            Card(
                colors = CardDefaults.cardColors()
                    .copy(containerColor = MaterialTheme.colorScheme.primary)
            ) {
                JCheckbox(enabled = true, checked = true) { }
            }

            Card(
                colors = CardDefaults.cardColors()
                    .copy(containerColor = MaterialTheme.colorScheme.primary)
            ) {
                JCheckbox(enabled = false, checked = true) { }
            }

            Card(
                colors = CardDefaults.cardColors()
                    .copy(containerColor = MaterialTheme.colorScheme.primary)
            ) {
                JCheckbox(enabled = false, checked = false) { }
            }
        }
    }
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
private fun CounterPreview() {
    JahezTheme {
        Column {
            Column {
                Card(
                    colors = CardDefaults.cardColors()
                        .copy(containerColor = MaterialTheme.colorScheme.primary)
                ) {
                    JCheckbox(enabled = true, checked = true) { }
                }

                Card(
                    colors = CardDefaults.cardColors()
                        .copy(containerColor = MaterialTheme.colorScheme.primary)
                ) {
                    JCheckbox(enabled = false, checked = true) { }
                }
                Card(
                    colors = CardDefaults.cardColors()
                        .copy(containerColor = MaterialTheme.colorScheme.primary)
                ) {
                    JCheckbox(enabled = false, checked = false) { }
                }
            }

        }
    }
}