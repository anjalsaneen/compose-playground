package com.compose.playground.account_statement.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import com.compose.playground.R
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.playground.theme.*
import com.compose.playground.theme.caption2
import com.compose.playground.theme.headline5

@Composable
fun AccountStatementSummery() {
    Card(
        border = BorderStroke(color = grey300, width = 1.dp),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp, horizontal = 8.dp),
        backgroundColor = white,
    ) {
        Column {

            Row(
                modifier = Modifier.padding(12.dp, 28.dp, 0.dp, 0.dp)
            ) {
                OutlinedButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .width(40.dp)
                        .height(40.dp)
                        .align(Alignment.CenterVertically),
                    shape = CircleShape,
                    border = BorderStroke(color = grey300, width = 1.dp),
                    contentPadding = PaddingValues(0.dp),  //avoid the little icon
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = grey300)
                ) {
                    Icon(
                        modifier = Modifier.then(
                            Modifier
                                .size(24.dp)
                                .height(24.dp)
                                .width(24.dp)
                        ),
                        painter = painterResource(id = R.drawable.ic_account_balance),
                        contentDescription = null,
                        tint = grey700
                    )
                }

                Column(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(8.dp),
                ) {
                    Text(
                        text = "Net Balance",
                        style = caption2
                    )
                    Text(
                        text = "$234",
                        style = headline5.copy(
                            color = red_primary
                        )
                    )
                }
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(0.dp, 28.dp, 0.dp, 0.dp)
                    .fillMaxWidth()
            ) {
                Row(
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.padding(12.dp, 0.dp, 0.dp, 0.dp)
                ) {
                    OutlinedButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .width(40.dp)
                            .height(40.dp)
                            .align(Alignment.CenterVertically),
                        shape = CircleShape,
                        border = BorderStroke(color = grey300, width = 1.dp),
                        contentPadding = PaddingValues(0.dp),  //avoid the little icon
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = grey300)
                    ) {
                        Icon(
                            modifier = Modifier.then(
                                Modifier
                                    .size(20.dp)
                                    .height(20.dp)
                                    .width(20.dp)
                            ),
                            painter = painterResource(id = R.drawable.ic_down_arrow),
                            contentDescription = null,
                            tint = tx_payment
                        )
                    }

                    Column(
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(8.dp),
                    ) {
                        Text(
                            text = "Net Balance",
                            style = caption2
                        )
                        Text(
                            text = "$234",
                            style = headline5.copy(
                                color = red_primary,
                            )
                        )
                    }
                }

                Card(
                    modifier = Modifier
                        .height(40.dp)
                        .width(0.5.dp)
                        .align(Alignment.CenterVertically),
                    backgroundColor = divider,
                ) {}

                Row(
                    modifier = Modifier.padding(0.dp, 0.dp, 12.dp, 0.dp)
                ) {
                    OutlinedButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .width(40.dp)
                            .height(40.dp)
                            .align(Alignment.CenterVertically),
                        shape = CircleShape,
                        border = BorderStroke(color = grey300, width = 1.dp),
                        contentPadding = PaddingValues(0.dp),  //avoid the little icon
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = grey300)
                    ) {
                        Icon(
                            modifier = Modifier.then(
                                Modifier
                                    .size(20.dp)
                                    .height(20.dp)
                                    .width(20.dp)
                            ),
                            painter = painterResource(id = R.drawable.ic_up_arrow),
                            contentDescription = null,
                            tint = tx_credit
                        )
                    }

                    Column(
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(8.dp),
                    ) {
                        Text(
                            text = "Net Balance",
                            style = caption2
                        )
                        Text(
                            text = "$234",
                            style = headline5.copy(
                                color = red_primary
                            )
                        )
                    }
                }
            }

            Spacer(
                Modifier
                    .height(1.dp)
                    .fillMaxWidth()
                    .background(divider)
            )

            Row(
                modifier = Modifier.padding(12.dp)
            ) {
                Icon(
                    modifier = Modifier.then(
                        Modifier
                            .size(16.dp)
                            .height(16.dp)
                            .width(16.dp)
                    ),
                    imageVector = Icons.Default.DateRange,
                    contentDescription = null,
                    tint = grey800
                )

                Text(
                    text = "Discounts offered",
                    style = caption2,
                    modifier = Modifier.padding(6.dp, 0.dp, 0.dp, 0.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun MenuItemPreview() {
    OkcTheme {
        AccountStatementSummery()
    }
}