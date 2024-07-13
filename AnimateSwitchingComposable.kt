package com.example.animationquickguide.switchcomposable

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

enum class UiState{
    Loading,Loaded,Error
}

@Composable
fun AnimateSwitchingComposable(){
    var state by remember {
        mutableStateOf(UiState.Loading)
    }
    AnimatedContent(
        targetState = state,
        transitionSpec = {
            fadeIn(
                animationSpec = tween(1000)
            ) togetherWith fadeOut(animationSpec = tween(1000))
        },
        modifier = Modifier.clickable(
            interactionSource = remember {
                MutableInteractionSource()
            },
            indication = null,
            onClick = {
                state = when(state){
                    UiState.Loading -> UiState.Loaded
                    UiState.Loaded -> UiState.Error
                    UiState.Error -> UiState.Loading
                }
            }
        ),
        label = "Animated Content"
    ) { targetState ->
        when(targetState){
            UiState.Loading -> {
                LoadingPage()
            }
            UiState.Loaded -> {
                LoadedPage()
            }
            UiState.Error -> {
                ErrorPage()
            }
        }
        
    }

}