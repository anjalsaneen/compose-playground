package com.compose.playground.account_statement.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.playground.theme.*
import com.compose.playground.theme.caption2
import com.compose.playground.theme.headline5
import com.compose.playground.theme.subtitle4

@Composable
fun TransactionItem(txn: Int, onClickTransaction: () -> Unit) {
    Surface(
        modifier = Modifier
            .clickable(
                onClick = onClickTransaction
            )
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Card(
                border = BorderStroke(color = grey300, width = 1.dp),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .padding(vertical = 4.dp, horizontal = 8.dp)
                    .width(180.dp)
                    .align(if (txn % 2 == 0) Alignment.End else Alignment.Start),
                backgroundColor = white,
            ) {
                Column() {
                    Box(
                        Modifier
                            .background(grey100)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "Discounts offered",
                            style = subtitle4.copy(color = grey700),
                            modifier = Modifier.padding(10.dp, 2.dp, 10.dp, 2.dp)
                        )
                    }
                    Text(
                        text = "Customer Name",
                        style = subtitle4.copy(color = grey700),
                        modifier = Modifier.padding(10.dp, 2.dp, 10.dp, 2.dp)
                    )

                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "300",
                            style = headline5,
                            modifier = Modifier.padding(10.dp, 2.dp, 10.dp, 2.dp)
                        )
                        Text(
                            text = "21-10-1993",
                            style = caption2.copy(color = grey600),
                            modifier = Modifier.padding(24.dp, 2.dp, 10.dp, 2.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun TransactionItemPreview() {
    OkcTheme {
        TransactionItem(2, {})
    }
}