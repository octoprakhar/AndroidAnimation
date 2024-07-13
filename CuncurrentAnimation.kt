package com.example.animationquickguide

import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun ConcurrentAnimation(){
    val alphaAnimation = remember {
        Animatable(0f)
    }

    val yAnimation = remember {
        Animatable(0f)
    }
    
    LaunchedEffect("animationKey") {
        launch {
            alphaAnimation.animateTo(1f)
        }
        launch {
            yAnimation.animateTo(100f)
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .offset(y = yAnimation.value.dp)
                .background(Color.Blue.copy(alpha = alphaAnimation.value))
                .fillMaxSize(0.5f)
        )
    }
}