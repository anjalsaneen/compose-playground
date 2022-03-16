package com.compose.playground.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import com.compose.playground.theme.extendedFabTextStyle
import com.compose.playground.theme.green_primary
import com.compose.playground.theme.textLineSpacing6
import com.compose.playground.theme.white


@Composable
fun OkcFloatingActionButton(
    onClick: () -> Unit,
    drawableId: Int,
    modifier: Modifier = Modifier,
    drawableTint: Color = MaterialTheme.colors.onPrimary,
    shape: Shape = CircleShape,
    backgroundColor: Color = MaterialTheme.colors.primary,
    elevation: FloatingActionButtonElevation = FloatingActionButtonDefaults.elevation(),
    contentColor: Color = MaterialTheme.colors.onPrimary,
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
    textStyle: TextStyle = extendedFabTextStyle,
    drawableId: Int? = null,
    drawablePadding: Dp = 4.dp,
    drawableTint: Color = MaterialTheme.colors.onPrimary,
    shape: Shape = CircleShape,
    backgroundColor: Color = MaterialTheme.colors.primary,
    elevation: FloatingActionButtonElevation = FloatingActionButtonDefaults.elevation(),
    contentColor: Color = MaterialTheme.colors.onPrimary,
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
                fontSize = TextUnit(textStyle.fontSize.value, TextUnitType.Sp),
                color = textStyle.color,
                letterSpacing = TextUnit(textStyle.letterSpacing.value, TextUnitType.Sp),
                fontWeight = textStyle.fontWeight,
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


