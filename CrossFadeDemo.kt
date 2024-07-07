package com.example.androidanimationoverview

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CrossFadeDemo(modifier: Modifier = Modifier){
    var scene by remember {
        mutableStateOf(0)
    }

    Column(
        modifier = modifier
    ) {
        Button(onClick = {
            scene = when(scene){
                0 -> 1
                else -> 0
            }
        }) {
            Text(text = "TOGGLE")

        }
        Spacer(modifier = Modifier.height(16.dp))
        Crossfade(targetState = scene){scene ->
            when (scene) {
                0 -> Text(
                    text = "PHONE",
                    fontSize = 32.sp
                )

                else ->
                    Icon(
                        imageVector = Icons.Default.Phone,
                        contentDescription = "Phone",
                        modifier = Modifier.size(48.dp)
                    )
            }
        }
    }
}