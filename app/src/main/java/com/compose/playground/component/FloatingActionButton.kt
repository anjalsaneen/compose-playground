package com.compose.playground.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import com.compose.playground.theme.green_primary
import com.compose.playground.theme.textLineSpacing6
import com.compose.playground.theme.white


@Composable
fun OkcFloatingActionButton(
    onClick: () -> Unit,
    drawableId: Int,
    modifier: Modifier = Modifier,
    drawableTint: Color = white,
    shape: Shape = CircleShape,
    backgroundColor: Color = green_primary,
    elevation: FloatingActionButtonElevation = FloatingActionButtonDefaults.elevation(),
    contentColor: Color = white,
) {
    FloatingActionButton(
        onClick = onClick,
        modifier = modifier,
        shape = shape,
        backgroundColor = backgroundColor,
        elevation = elevation,
        contentColor = contentColor
    ) {
        Icon(
            painter = painterResource(id = drawableId),
            contentDescription = null,
            tint = drawableTint
        )
    }
}

@OptIn(ExperimentalUnitApi::class)
@Composable
fun OkcExtendedFloatingActionButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    textColor: Color = white,
    textSize: Float = 16.0f,
    drawableId: Int? = null,
    drawablePadding: Dp = 4.dp,
    drawableTint: Color = white,
    shape: Shape = CircleShape,
    backgroundColor: Color = green_primary,
    elevation: FloatingActionButtonElevation = FloatingActionButtonDefaults.elevation(),
    contentColor: Color = white,
) {
    ExtendedFloatingActionButton(
        modifier = modifier,
        shape = shape,
        backgroundColor = backgroundColor,
        elevation = elevation,
        contentColor = contentColor,
        text = {
            Text(
                text = text,
                fontSize = TextUnit(textSize, TextUnitType.Sp),
                color = textColor,
                letterSpacing = TextUnit(textLineSpacing6.value, TextUnitType.Sp),
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold
            )
        },
        onClick = onClick,
        icon = {
            if (drawableId != null) {
                Icon(
                    painter = painterResource(id = drawableId),
                    contentDescription = null,
                    tint = drawableTint,
                    modifier = Modifier.padding(drawablePadding)
                )
            }
        }
    )
}


