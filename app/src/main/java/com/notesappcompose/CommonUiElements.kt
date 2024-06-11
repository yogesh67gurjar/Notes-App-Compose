package com.notesappcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.notesappcompose.ui.theme.darkGray

@Composable
fun SquareButton(painterResourceId: Int, modifier: Modifier, onClick: () -> Unit) {
    Box(
        modifier = modifier
            .clickable(enabled = true, onClick = onClick)
            .background(color = darkGray, RoundedCornerShape(size = 10.dp))
            .padding(horizontal = 10.dp, vertical = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = painterResourceId),
            contentDescription = null,
            modifier = Modifier.size(21.dp),
            contentScale = ContentScale.Fit
        )
    }
}

//@Preview
//@Composable
//fun CommonPreview() {
//    SquareButton(
//        painterResourceId = R.drawable.ic_info, Modifier
//    )
//}