package com.jahez.inputs

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jahez.common_resources.R
import com.jahez.ui.theme.JahezTheme


@Composable
fun SearchField(
    modifier: Modifier = Modifier,
    placeHolder: String = "",
    onValueChange: (String) -> Unit
) {
   var searchText by remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current

//    val hint = remember {
//        mutableStateOf(LocalizedContent("تااااكل ايه؟", "Wanna eat?"))
//    }
//    var hintPlaceHolder by remember { mutableStateOf("") }
//
//    LaunchedEffect(hint) {
//        delay(500)
//        for (ch in hint.value.localize("ar")) {
//            hintPlaceHolder += ch
//            delay(100)
//        }
//    }

    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = searchText,
        onValueChange = {
            searchText = it
            onValueChange(it)
        },
        placeholder = {
            Text(
                text = placeHolder,
                style = MaterialTheme.typography.titleMedium
            )
        },
        shape = RoundedCornerShape(8.dp),
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
                    modifier = Modifier.padding(end = 12.dp),
                    imageVector = ImageVector.vectorResource(R.drawable.search),
                    contentDescription = "Clear text"
                )
            }
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.outlineVariant,
            unfocusedContainerColor = MaterialTheme.colorScheme.outlineVariant,
            cursorColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
            focusedBorderColor = MaterialTheme.colorScheme.outline,
            unfocusedBorderColor = MaterialTheme.colorScheme.primary
        ),
        textStyle = MaterialTheme.typography.titleMedium
    )
}

@Preview(
    apiLevel = 34,
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL, locale = "ar"
)
@Composable
fun DarkSearchFieldPreview() {
    JahezTheme {
        SearchField(placeHolder = stringResource(R.string.search_field_placeholder)) { }

    }
}

@Preview(
    apiLevel = 34,
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL, locale = "ar"
)
@Composable
fun SearchFieldPreview() {

    JahezTheme {
        SearchField(placeHolder = stringResource(R.string.search_field_placeholder)) { }
    }
}