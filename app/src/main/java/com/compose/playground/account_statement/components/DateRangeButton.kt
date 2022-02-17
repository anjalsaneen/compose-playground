package com.compose.playground.account_statement.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.compose.playground.theme.OkcTheme
import com.compose.playground.theme.grey300
import com.compose.playground.theme.grey800
import com.compose.playground.theme.subtitle2
import kotlin.math.roundToInt

@Composable
fun DateRangePicker(
    fabOffsetHeightPx: MutableState<Float>,
    onClick: () -> Unit
) {
    Box {
        Box(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .align(Alignment.Center)
                    .offset {
                        IntOffset(x = 0, y = fabOffsetHeightPx.value.roundToInt())
                    }
                    .padding(0.dp, 8.dp, 0.dp, 0.dp),
            ) {
                Card(
                    border = BorderStroke(color = grey300, width = 1.dp),
                    shape = RoundedCornerShape(16.dp),
                    elevation = 5.dp,
                ) {
                    Surface(modifier = Modifier
                        .clickable(
                            onClick = { onClick.invoke() }
                        )) {
                        Row(
                            modifier = Modifier
                                .padding(start = 8.dp, top = 4.dp, end = 8.dp, bottom = 4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(Icons.Default.DateRange, contentDescription = null, tint = grey800)
                            Spacer(Modifier.width(4.dp))
                            Text(
                                text = "10 Jul, 2018 - 10 Jul, 2018",
                                style = subtitle2.copy(color = grey800)
                            )
                            Spacer(Modifier.width(4.dp))
                            Icon(
                                Icons.Default.ArrowDropDown,
                                contentDescription = null,
                                tint = grey800
                            )
                        }
                    }

                }
            }
        }
    }
}

@Preview
@Composable
fun ChipPreview() {
    OkcTheme {
        DateRangePicker(remember { mutableStateOf(0f) }, {})
    }
}