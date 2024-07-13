package com.example.animationquickguide

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp

@Composable
fun AnimateElevationDemo(){
    val mutableInteractionSource = remember {
        MutableInteractionSource()
    }
    val pressed = mutableInteractionSource.collectIsPressedAsState()
    val elevation = animateDpAsState(
        targetValue = if (pressed.value) 32.dp else 8.dp,
        label = "pressed"
    )
    Box(
        modifier = Modifier
            .size(100.dp)
            .graphicsLayer {
                this.shadowElevation = elevation.value.toPx()
            }
            .clickable(
                interactionSource = mutableInteractionSource,
                indication = null,
                onClick = {}
            )
            .background(Color.Green)
    )
}