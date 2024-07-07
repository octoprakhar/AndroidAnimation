package com.example.androidanimationoverview

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AnimateAsState(){
    var blue by remember {
        mutableStateOf(true)
    }
    val color by animateColorAsState(targetValue = if(blue) Color.Blue else Color.Red)
    val color2 = if(blue) Color.Blue else Color.Red

    Column (modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)){
        Button(onClick = { blue = !blue }) {
            Text(text = "Change Color")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Box(modifier = Modifier.size(128.dp).background(color))
    }
}