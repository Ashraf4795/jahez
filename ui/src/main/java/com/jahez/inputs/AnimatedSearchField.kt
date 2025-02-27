package com.jahez.inputs

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jahez.common_resources.R
import com.jahez.ui.theme.JahezTheme
import kotlinx.coroutines.delay
import com.jahez.ui.R as uiR


@Composable
fun AnimatedSearchBar(
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit
) {
    var searchText by remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current
    val focusRequester = remember { FocusRequester() }
    var isFocused by remember { mutableStateOf(false) } // Track focus state

    val hints = listOf(
        // this migh be a localized remote content
        stringResource(id = uiR.string.hint_1),
        stringResource(id = uiR.string.hint_2),
        stringResource(id = uiR.string.hint_3),
        stringResource(id = uiR.string.hint_4),
        stringResource(id = uiR.string.hint_5)
    )

    var animatedText by rememberSaveable { mutableStateOf("") }
    var hintIndex by remember { mutableStateOf(0) }
    val textIndex = remember { mutableStateOf(0) }

    LaunchedEffect(searchText) {
        delay(500) // Adjust debounce time (milliseconds)
        onValueChange(searchText) // Trigger search after delay
    }

    LaunchedEffect(hintIndex, searchText, isFocused) {
        if (searchText.isEmpty() && !isFocused) { // Animate only when not focused
            animatedText = ""
            textIndex.value = 0

            hints[hintIndex].forEachIndexed { index, _ ->
                delay(100) // Typing speed
                textIndex.value = index + 1
                animatedText = hints[hintIndex].substring(0, textIndex.value)
            }

            delay(2000) // Wait before switching hints

            hintIndex = (hintIndex + 1) % hints.size // Loop through hints
        }
    }

    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .focusRequester(focusRequester)
            .onFocusChanged {
                isFocused = it.isFocused
                if (isFocused) {
                    animatedText = ""
                }
            }, // Track focus changes
        value = searchText,
        onValueChange = {
            searchText = it
        },
        placeholder = {
            Text(
                text = if (searchText.isEmpty()) animatedText else "", // Show animated text only when empty
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
            )
        },
        shape = RoundedCornerShape(50),
        trailingIcon = {
            if (searchText.isNotEmpty()) {
                IconButton(onClick = {
                    searchText = ""
                    focusManager.clearFocus()
                }) {
                    Icon(Icons.Default.Clear, contentDescription = "Clear text")
                }
            }
        },
        singleLine = true,
        prefix = {
            if (searchText.isEmpty()) {
                Icon(
                    modifier = Modifier
                        .size(24.dp)
                        .padding(end = 8.dp),
                    imageVector = ImageVector.vectorResource(R.drawable.search),
                    contentDescription = "Search icon"
                )
            }
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.primary,
            unfocusedContainerColor = MaterialTheme.colorScheme.onPrimary.copy(0.1f),
            cursorColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.7f),
            focusedBorderColor = MaterialTheme.colorScheme.outline,
            unfocusedBorderColor = MaterialTheme.colorScheme.outline
        ),
        textStyle = MaterialTheme.typography.bodyMedium
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewAnimatedSearchBar() {
    JahezTheme {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            AnimatedSearchBar(
                onValueChange = {}
            )
        }
    }
}