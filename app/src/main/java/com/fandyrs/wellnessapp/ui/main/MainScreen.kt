package com.fandyrs.wellnessapp.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MainScreen(navController: NavController) {
    var waterCount by rememberSaveable { mutableIntStateOf(0) }
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        WaterCounter(waterCount = waterCount, waterCountOnChange = {
            waterCount += 1
        })
    }
}

@Composable
fun WaterCounter(
    modifier: Modifier = Modifier,
    waterCount: Int,
    waterCountOnChange: () -> Unit
) {
    Column(modifier = modifier) {
        Text("You've had $waterCount glasses")
        Button(
            onClick = {
                waterCountOnChange()
            }
        ) {
            Text("Add One")
        }
    }
}