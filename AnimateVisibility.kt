package com.example.androidanimationoverview

import androidx.compose.animation.AnimatedVisibility
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
fun AnimatedVisibilityDemo(modifier: Modifier = Modifier){
    var visible by remember {
        mutableStateOf(true)
    }
    Column(
        modifier = modifier
    ) {
        Button(onClick = { visible = !visible }) {
            Text(text = if (visible) "HIDE" else "SHOW")
        }
        Spacer(modifier = Modifier.height(16.dp))
        AnimatedVisibility (visible){
            Box(modifier = Modifier.size(128.dp).background(Color.Blue))
        }
    }
}