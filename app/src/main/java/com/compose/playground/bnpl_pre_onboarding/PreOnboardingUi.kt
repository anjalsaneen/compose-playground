package com.compose.playground.bnpl_pre_onboarding

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.compose.playground.R
import com.compose.playground.component.*
import com.compose.playground.theme.*

@Composable
fun PreOnboardingUi() {
    Column {
        Column(
            Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
        ) {
            EducationCards()
            DarkSolidButton(
                onClick = { /*TODO*/ }, text = "Abc", modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            DarkOutlineButton(
                onClick = { /*TODO*/ }, text = "Abc", modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            LightSolidButton(
                onClick = { /*TODO*/ }, text = "Abc", modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            OkcFloatingActionButton(
                onClick = {},
                drawableId = R.drawable.ic_account_balance,
                drawableTint = red_primary
            )
            OkcExtendedFloatingActionButton(
                onClick = { },
                text = "abc",
                drawableId = R.drawable.ic_account_balance,
                modifier = Modifier.offset(x = 50.dp)
            )
            OkcMaterialCard(
                modifier = Modifier
                    .padding(32.dp)
                    .fillMaxWidth(),
                backgroundColor = green_lite_1
            ) {
                Text(text = "Some random text", modifier = Modifier.padding(16.dp))
            }
        }
        Button(
            onClick = { /*TODO*/ }, modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Text(text = "Get Credit Line")
        }
    }
}

@Composable
fun EducationCards() {
    GetInstantCreditLineCard()
}

@Composable
fun GetInstantCreditLineCard() {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .height(100.dp)
            .fillMaxWidth(),
        border = BorderStroke(1.dp, Color.Black)
    ) {

        Text(text = "Some Random text")
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "PreOnboardingUi"
)
@Composable
fun MainPreview() {
    OkcTheme {
        PreOnboardingUi()
    }
}