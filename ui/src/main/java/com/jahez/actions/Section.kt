package com.jahez.actions

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun Section(
    modifier: Modifier = Modifier,
    sectionTitle: String,
    onMoreClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        SectionHeader(modifier = Modifier.clickable { onMoreClick.invoke() }, title = sectionTitle)
        content()
    }
}

@Composable
fun Section(
    modifier: Modifier = Modifier,
    sectionTitle: String,
    onMoreClick: () -> Unit
) {
    SectionHeader(modifier = modifier.clickable { onMoreClick.invoke() }, title = sectionTitle)
}