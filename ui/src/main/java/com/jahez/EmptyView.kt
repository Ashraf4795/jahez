package com.jahez

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun EmptyView(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Column {
            Text("Empty View")
        }
    }
}