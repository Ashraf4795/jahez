package com.jahez.actions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Start
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jahez.ui.R
import com.jahez.ui.theme.JahezTheme


@Composable
fun JIcon(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    enabled: Boolean = true,
    contentDescription: String,
    tint: Color,
    onClick: () -> Unit
) {
    IconButton(
        onClick = onClick,
        enabled = enabled,
    ) {
        Icon(
            modifier = modifier,
            imageVector = imageVector,
            contentDescription = contentDescription,
            tint = tint
        )
    }
}

@Preview
@Composable
private fun PreviewJIcon() {
    JahezTheme {
        JIcon(
            modifier = Modifier.clip(CircleShape).background(Color.Red).padding(8.dp),
            imageVector = Icons.Default.Start,
            contentDescription = "",
            tint = Color.Blue
        ) { }
    }
}