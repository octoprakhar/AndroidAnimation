package com.example.animationquickguide

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp

@Composable
fun AnimationWhileLaunch(){

    val alphaAnimation = remember {
        androidx.compose.animation.core.Animatable(0f)
    }
    
    LaunchedEffect(Unit) {
        alphaAnimation.animateTo(1f)
    }
    Box (
        modifier = Modifier
            .fillMaxSize()
            .graphicsLayer {
                alpha = alphaAnimation.value
            }
    ){
        Text(text = "Hello Prakhar....")

    }
}