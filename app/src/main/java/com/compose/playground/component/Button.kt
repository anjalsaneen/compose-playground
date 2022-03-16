package com.compose.playground.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.*
import com.compose.playground.theme.*

@OptIn(ExperimentalUnitApi::class)
@Composable
fun DarkSolidButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    color: Color = green_primary,
    elevation: ButtonElevation? = ButtonDefaults.elevation(),
    horizontalContentPadding: Dp = 16.dp,
    verticalContentPadding: Dp = 12.dp,
    cornerRadius: Dp = 24.dp,
    textColor: Color = white,
    textSize: Float = 16.0f
) {
    Button(
        onClick = onClick,
        contentPadding = PaddingValues(
            horizontal = horizontalContentPadding,
            vertical = verticalContentPadding
        ),
        shape = RoundedCornerShape(cornerRadius),
        colors = ButtonDefaults.buttonColors(backgroundColor = color, contentColor = textColor),
        elevation = elevation,
        enabled = enabled,
        modifier = modifier
    ) {
        Text(
            text = text,
            fontSize = TextUnit(textSize, TextUnitType.Sp),
            color = textColor,
            letterSpacing = TextUnit(textLineSpacing6.value, TextUnitType.Sp),
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold,
        )
    }
}

@OptIn(ExperimentalUnitApi::class)
@Composable
fun LightSolidButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    color: Color = white,
    elevation: ButtonElevation? = ButtonDefaults.elevation(),
    horizontalContentPadding: Dp = 16.dp,
    verticalContentPadding: Dp = 12.dp,
    cornerRadius: Dp = 24.dp,
    textColor: Color = green_primary,
    textSize: Float = 16.0f
) {
    Button(
        onClick = onClick,
        contentPadding = PaddingValues(
            horizontal = horizontalContentPadding,
            vertical = verticalContentPadding
        ),
        shape = RoundedCornerShape(cornerRadius),
        colors = ButtonDefaults.buttonColors(backgroundColor = color, contentColor = textColor),
        elevation = elevation,
        enabled = enabled,
        modifier = modifier
    ) {
        Text(
            text = text,
            fontSize = TextUnit(textSize, TextUnitType.Sp),
            color = textColor,
            letterSpacing = TextUnit(textLineSpacing6.value, TextUnitType.Sp),
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold,
        )
    }
}


@OptIn(ExperimentalUnitApi::class)
@Composable
fun DarkOutlineButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    elevation: ButtonElevation? = null,
    horizontalContentPadding: Dp = 16.dp,
    verticalContentPadding: Dp = 12.dp,
    strokeWidth: Dp = 1.dp,
    strokeColor: Color = green_primary,
    cornerRadius: Dp = 24.dp,
    textColor: Color = green_primary,
    textSize: Float = 16.0f
) {

    OutlinedButton(
        onClick = onClick,
        contentPadding = PaddingValues(
            horizontal = horizontalContentPadding,
            vertical = verticalContentPadding
        ),
        shape = RoundedCornerShape(cornerRadius),
        border = BorderStroke(
            width = strokeWidth,
            color = strokeColor
        ),
        elevation = elevation,
        enabled = enabled,
        modifier = modifier
    ) {
        Text(
            text = text,
            fontSize = TextUnit(textSize, TextUnitType.Sp),
            color = textColor,
            letterSpacing = TextUnit(textLineSpacing6.value, TextUnitType.Sp),
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold,
        )
    }
}
