package com.example.animationquickguide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.animationquickguide.switchcomposable.AnimateSwitchingComposable
import com.example.animationquickguide.switchcomposable.SequentialAnimation
import com.example.animationquickguide.ui.theme.AnimationQuickGuideTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnimationQuickGuideTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    AnimatedVisibilityDemo(modifier = Modifier.padding(innerPadding))
//                    AnimatedColorDemo(paddingValues = innerPadding)
//                    AnimateContentSizeDemo(paddingValues = innerPadding)
//                    AnimatePositionDemo(paddingValues = innerPadding)
//                    TestingPurpose(paddingValues = innerPadding)
                    Column(
                        modifier = Modifier.padding(innerPadding)
                    ) {
//                        AnimatePaddingDemo()
//                        AnimateElevationDemo()
//                        AnimateTextSizeDemo()
//                        AnimateContentColor()
//                        AnimateSwitchingComposable()
//                        NavigationDemoApp()
//                        RepeatAnimation()
//                        AnimationWhileLaunch()
//                        SequentialAnimation()
                        ConcurrentAnimation()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AnimationQuickGuideTheme {
        Greeting("Android")
    }
}