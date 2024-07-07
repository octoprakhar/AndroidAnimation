package com.example.androidanimationoverview

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AnimateContentSizeDemo(modifier: Modifier = Modifier){
    var expand by remember {
        mutableStateOf(true)
    }

    Column (
        modifier = modifier
    ){
        Button(onClick = { expand = !expand }) {
            Text(text = if (expand) "SHRINK" else "EXPAND")
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        Box(modifier = Modifier.background(Color.LightGray).animateContentSize() ){
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam non leo a erat tempor blandit a et metus. Mauris commodo sem mattis, posuere metus id, dictum ex. Aliquam sagittis augue et turpis efficitur elementum. Nullam arcu tortor, ultrices ac porta at, tincidunt nec eros. Nunc tempus dapibus nisl, in ultrices tellus congue ut. Duis sed lectus turpis. Morbi blandit elit et augue vestibulum, ac dapibus nulla accumsan. Phasellus tincidunt lacus nec est ultricies rhoncus ut a ligula.",
                fontSize = 16.sp,
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(16.dp),
                maxLines = if (expand) Int.MAX_VALUE else 2
            )
        }
    }
}