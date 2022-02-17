package com.compose.playground.account_statement.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.compose.playground.R
import com.compose.playground.theme.OkcTheme
import com.compose.playground.theme.black
import com.compose.playground.theme.green_primary
import com.compose.playground.theme.toolbar_background
import com.compose.playground.theme.subtitle2

@Composable
fun Toolbar(
    onBackClick: () -> Unit,
    onClickAllTransactionFromMenu: () -> Unit,
    onClickAllCollectionsFromMenu: () -> Unit,
) {
    val expanded = remember { mutableStateOf(false) }

    TopAppBar(
        title = {
            Text(text = "Account Statement")
        },
        backgroundColor = toolbar_background,
        contentColor = MaterialTheme.colors.onSurface,
        navigationIcon = {
            IconButton(onClick = {

            }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back"
                )
            }
        },
        actions = {
            IconButton(onClick = {
                expanded.value = true
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_menu_overflow),
                    contentDescription = null
                )
            }
            DropMenu(expanded)
        }
    )
}

@Composable
private fun DropMenu(expanded: MutableState<Boolean>) {
    DropdownMenu(
        expanded = expanded.value,
        offset = DpOffset((0).dp, (0).dp),
        modifier = Modifier
            .width(IntrinsicSize.Max)
            .padding(0.dp)
            .width(200.dp),
        onDismissRequest = { expanded.value = false }
    ) {
        MenuItem(
            isSelected = true,
            title = "All Transactions",
            onClick = {},
            drawable = R.drawable.ic_collection_icon
        )

        MenuItem(
            isSelected = false,
            title = "Online Transactions",
            onClick = {},
            drawable = R.drawable.ic_collection_icon
        )
    }
}

@Composable
private fun MenuItem(
    isSelected: Boolean = false,
    title: String = "",
    onClick: () -> Unit,
    @DrawableRes drawable: Int,
) {
    DropdownMenuItem(
        onClick = onClick
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(0.dp)
        ) {
            Icon(
                tint = if (isSelected) green_primary else black,
                painter = painterResource(id = drawable),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .align(Alignment.CenterVertically)
            )
            Text(
                text = title,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                style = subtitle2.copy(
                    color = if (isSelected) green_primary else black
                )
            )
        }
    }
}

@Preview
@Composable
fun ToolbarPreview() {
    OkcTheme {
        Toolbar(onBackClick = {}, onClickAllTransactionFromMenu = {}) {

        }
    }
}

@Preview
@Composable
fun AccountStatementSummeryPreview() {
    OkcTheme {
        MenuItem(
            true,
            "All Transactions",
            {},
            R.drawable.ic_collection_icon
        )
    }
}