package com.compose.playground.account_statement

import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.compose.playground.R
import com.compose.playground.account_statement.components.AccountStatementSummery
import com.compose.playground.account_statement.components.DateRangePicker
import com.compose.playground.account_statement.components.Toolbar
import com.compose.playground.account_statement.components.TransactionItem
import com.compose.playground.theme.*
import org.joda.time.DateTime
import kotlin.math.roundToInt

@Composable
fun RenderAccountStatement(
    onShowDateRangePicker: (startDate: DateTime, endTime: DateTime) -> Unit
) {
    val fabHeightPx = with(LocalDensity.current) { 72.dp.roundToPx().toFloat() }
    val fabOffsetHeightPx = remember { mutableStateOf(0f) }
    val nestedScrollConnection = remember { ScrollHandler(fabOffsetHeightPx, fabHeightPx) }

    Scaffold(
        modifier = Modifier
            .nestedScroll(nestedScrollConnection),
        topBar = {
            Toolbar(
                onBackClick = {

                },
                onClickAllTransactionFromMenu = {

                },
                onClickAllCollectionsFromMenu = {

                })
        },
        floatingActionButton = {
            DownloadButton(fabOffsetHeightPx = fabOffsetHeightPx, onClick = {

            })
        },
        floatingActionButtonPosition = FabPosition.Center,
    ) {
        AccountStatementList(
            fabOffsetHeightPx = fabOffsetHeightPx,
            onClickTransaction = {},
            onShowDateRangePicker = {
                onShowDateRangePicker.invoke(DateTime.now().minusDays(7), DateTime.now())
            }
        )
    }
}

class ScrollHandler(
    private val fabOffsetHeightPx: MutableState<Float>,
    private val fabHeightPx: Float
) : NestedScrollConnection {
    override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
        fabOffsetHeightPx.value =
            (fabOffsetHeightPx.value + available.y).coerceIn(-fabHeightPx, 0f)

        return Offset.Zero
    }
}

@Composable
private fun AccountStatementList(
    fabOffsetHeightPx: MutableState<Float>,
    onClickTransaction: () -> Unit,
    names: List<Int> = List(10) { it },
    onShowDateRangePicker: () -> Unit,
) {
    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
        item {
            Spacer(Modifier.height(16.dp))
        }

        if (false ) {
            item {
                EmptyPlaceHolder()
            }
        }

        item {
            AccountStatementSummery()
        }
        items(items = names) { txn ->
            TransactionItem(txn, onClickTransaction)
        }


        item {
            LoadMoreButton(onClickTransaction)
        }

        item {
            Spacer(modifier = Modifier.height(72.dp))
        }
    }
    DateRangePicker(fabOffsetHeightPx, onShowDateRangePicker)
    if (false) {
        DownloadInfoBanner()
    }
}

@Composable
private fun EmptyPlaceHolder() {
    Box(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.align(Alignment.Center)) {
            Image(
                modifier = Modifier.height(136.dp).width(200.dp).padding(0.dp, 50.dp, 0.dp, 0.dp),
                painter = painterResource(id = R.drawable.customer_page_placeholder),
                contentDescription = ""
            )
            Text(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp),
                text = "No txns"
            )
        }
    }
}

@Composable
private fun LoadMoreButton(onClickLoadMore: () -> Unit) {
    Column(Modifier.fillMaxWidth()) {
        OutlinedButton(
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = green_primary,
            ),
            onClick = onClickLoadMore,
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Show Old")
        }
    }
}

@Composable
private fun DownloadButton(fabOffsetHeightPx: MutableState<Float>, onClick: () -> Unit) {
    FloatingActionButton(
        onClick = onClick,
        modifier = Modifier
            .offset {
                IntOffset(x = 0, y = -fabOffsetHeightPx.value.roundToInt())
            }
            .fillMaxWidth()
            .height(48.dp)
            .padding(16.dp, 0.dp, 16.dp, 0.dp),
        shape = CircleShape,
        backgroundColor = MaterialTheme.colors.secondary
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "Back"
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(text = "Download", style = button.copy(color = white))
        }
    }
}

@Composable
fun DownloadInfoBanner() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(align = Alignment.BottomStart)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(72.dp)
                .align(Alignment.BottomCenter)
                .background(green_lite_1),
        ) {
            Text(
                text = "Download Complete",
                style = body2.copy(color = grey700, fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 420,
    name = "AccountStatementUI"
)
@Composable
fun DefaultPreview() {
    OkcTheme {
        RenderAccountStatement { _, _ -> }
    }
}