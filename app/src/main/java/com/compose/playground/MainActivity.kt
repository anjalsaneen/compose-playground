package com.compose.playground

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.compose.playground.account_statement.RenderAccountStatement
import com.compose.playground.legacy.dialogues.DateRangePickerDialog
import com.compose.playground.theme.OkcTheme
import org.joda.time.DateTime

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OkcTheme {
                RenderAccountStatement(
                    onShowDateRangePicker = ::openDateRangeDialog
                )
            }
        }
    }

    private fun openDateRangeDialog(startDate: DateTime, endDate: DateTime) {
        DateRangePickerDialog.show(
            this,
            startDate,
            endDate,
            object : DateRangePickerDialog.Listener {
                override fun onDone(startDate: DateTime, endDate: DateTime) {
                }
            }
        ).show()
    }
}
