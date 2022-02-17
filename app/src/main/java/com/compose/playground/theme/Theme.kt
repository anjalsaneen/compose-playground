package com.compose.playground.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun OkcTheme(
    content: @Composable () -> Unit
) {

    MaterialTheme(
        colors = OkcColors,
        typography = OkcTypography,
        shapes = OkcShapes,
        content = content
    )
}
