package com.example.androidanimationoverview

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
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
fun UpdateTransitionDemo(
    modifier: Modifier = Modifier
){
    var boxState by remember {
        mutableStateOf(0)
    }
    val transition = updateTransition(targetState = boxState)

    val color by transition.animateColor() {state->
        when (state) {
            0 -> Color.Blue
            else -> Color.Red
        }
    }

    val size by transition.animateDp(
        transitionSpec = {
            if (targetState == 0) {
                tween(
                    durationMillis = 500,
                    easing = FastOutSlowInEasing
                )
            } else {
                spring(

                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            }
        }
    ) {state->
        when (state) {
            0 -> 64.dp
            else -> 128.dp
        }
    }

    Column (
        modifier = modifier
    ){
        Button(onClick = {
            boxState = when(boxState){
                0 -> 1
                else -> 0
            }
        }) {
            Text(text = "Change Color And Size")

        }
        Spacer(modifier = Modifier.height(16.dp))
        Box(modifier = Modifier.size(size).background(color))
    }
}