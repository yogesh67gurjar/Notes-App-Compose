package com.notesappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.notesappcompose.model.Note
import com.notesappcompose.ui.theme.darkCharcoal
import com.notesappcompose.ui.theme.darkGray
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(darkCharcoal)
            ) {
                Header()
                MainContent()
            }
        }
    }
}

@Composable
private fun Header() {
    Row(
        modifier = Modifier
            .padding(top = 20.dp, start = 13.dp, end = 13.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(id = R.string.notes),
            color = Color.White,
            fontSize = 34.sp,
            modifier = Modifier.weight(1f),
            fontFamily = FontFamily(Font(resId = R.font.nunito_semibold))
        )

        Box(
            modifier = Modifier
                .padding(end = 15.dp)
                .background(color = darkGray, shape = RoundedCornerShape(size = 10.dp))
                .padding(horizontal = 10.dp, vertical = 10.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = null,
                modifier = Modifier.size(21.dp),
                contentScale = ContentScale.Fit
            )
        }

        Box(
            modifier = Modifier
                .background(color = darkGray, shape = RoundedCornerShape(size = 10.dp))
                .padding(horizontal = 10.dp, vertical = 10.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_info),
                contentDescription = null,
                modifier = Modifier.size(21.dp),
                contentScale = ContentScale.Fit
            )
        }
    }
}

@Composable
fun MainContent() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        contentAlignment = Alignment.Center
    ) {

        PlaceHolder()
        SavedNotes()
        AddNoteIcon(
            Modifier
                .padding(end = 20.dp, bottom = 20.dp)
                .background(color = Color.Black, shape = CircleShape)
                .padding(16.dp)
                .align(Alignment.BottomEnd)
        )
    }
}

@Composable
fun SavedNotes() {

}

@Composable
fun PlaceHolder() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .width(210.dp)
                .height(210.dp),
            painter = painterResource(id = R.drawable.img_placeholder),
            contentDescription = null
        )

        Text(
            text = stringResource(id = R.string.create_your_first_note),
            color = Color.White,
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(resId = R.font.nunito_regular))
        )
    }

}

@Composable
fun AddNoteIcon(modifier: Modifier) {
    Box(
        modifier = modifier, contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_add),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun MyPreview() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(darkCharcoal)
    ) {
        Header()
        MainContent()
    }
}