package com.compose.playground.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.compose.playground.theme.grey900
import com.compose.playground.theme.white

@Composable
fun OkcMaterialCard(
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 8.dp,
    backgroundColor: Color = white,
    contentColor: Color = grey900,
    strokeWidth: Dp? = null,
    strokeColor: Color? = null,
    elevation: Dp = 0.dp,
    content: @Composable () -> Unit
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(cornerRadius),
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        border = BorderStroke(strokeWidth ?: 0.dp, strokeColor ?: backgroundColor),
        elevation = elevation,
        content = content
    )
}