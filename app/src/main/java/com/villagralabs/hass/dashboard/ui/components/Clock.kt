package com.villagralabs.hass.dashboard.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.villagralabs.hass.dashboard.ui.theme.HomeDashboardTheme
import com.villagralabs.hass.dashboard.ui.theme.White100
import kotlinx.coroutines.delay
import java.text.SimpleDateFormat
import java.util.Calendar
import kotlin.time.Duration.Companion.seconds

@Composable
fun Clock() {

    val timeFormat = SimpleDateFormat("hh:mm aa")
    val dateFormat = SimpleDateFormat.getDateInstance()

    var now by remember {
        mutableStateOf(Calendar.getInstance().time)
    }

    LaunchedEffect(Unit) {
        while(true) {
            delay(1.seconds)
            now = Calendar.getInstance().time
        }
    }

    Column(
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = timeFormat.format(now),
            fontSize = 30.sp,
            color = White100,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(0.dp, 2.dp)
        )
        Text(
            text = dateFormat.format(now),
            fontSize = 14.sp,
            color = White100,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HomeDashboardTheme {
        Clock()
    }
}

