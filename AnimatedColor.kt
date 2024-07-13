package com.example.animationquickguide

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color

@Composable
fun AnimatedColorDemo(paddingValues: PaddingValues){
    var animatedColorBackground by remember {
        mutableStateOf(false)
    }
    val animatedColor by animateColorAsState(
        targetValue = if (animatedColorBackground) Color.Blue else Color.Green,
        label = "color"
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .drawBehind {
                drawRect(animatedColor)
            }
            .clickable(onClick = {animatedColorBackground = !animatedColorBackground})
    ) {
        Text(text = "Hello")
    }
}