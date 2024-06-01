package com.notesappcompose

import android.os.Bundle
import android.util.Log
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.notesappcompose.model.Note
import com.notesappcompose.ui.theme.darkCharcoal
import com.notesappcompose.ui.theme.darkGray
import com.notesappcompose.ui.theme.green
import com.notesappcompose.ui.theme.lightRed
import com.notesappcompose.ui.theme.pink
import com.notesappcompose.ui.theme.purple
import com.notesappcompose.ui.theme.skyBlue
import com.notesappcompose.ui.theme.yellow
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
            .padding(top = 20.dp, start = 16.dp, end = 16.dp)
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

        if (getNotes().isEmpty()) {
            PlaceHolder()
        } else {
            SavedNotes(getNotes())

        }

        AddNoteFloatingButton(
            Modifier
                .padding(end = 20.dp, bottom = 20.dp)
                .background(color = Color.Black, shape = CircleShape)
                .padding(16.dp)
                .align(Alignment.BottomEnd)
        )
    }
}

@Composable
fun SavedNotes(notes: MutableList<Note>) {
    val colors = listOf(lightRed, green, yellow, skyBlue, purple, pink)
    LazyColumn(modifier = Modifier
        .padding(start = 16.dp, end = 16.dp), content = {
        items(notes) {
            val colorIndex = notes.indexOf(it) % colors.size
            val color = colors[colorIndex]
            SingleNote(it, color)
        }
    })
}

@Composable
fun SingleNote(note: Note, color: Color) {
    Text(
        text = note.title,

        modifier = Modifier
            .padding(vertical = 8.dp)
            .background(color = color, shape = RoundedCornerShape(size = 8.dp))
            .padding(20.dp)
            .fillMaxWidth(),
        color = Color.Black,
        fontSize = 18.sp,
        textAlign = TextAlign.Center,
        fontFamily = FontFamily(Font(resId = R.font.nunito_regular))
    )
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
fun AddNoteFloatingButton(modifier: Modifier) {
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

fun getNotes(): MutableList<Note> {
    val notes: MutableList<Note> = mutableListOf()
    notes.add(Note("Importance of education", "android developer"))
    notes.add(Note("Kirana list", "Company secretary"))
    notes.add(Note("Kotlin coroutines", "hotel manager"))
    notes.add(Note("Null handling in kotlin", "tech lead"))
    notes.add(Note("How to win friends and influence people", "react developer"))
    notes.add(Note("Rich dad poor dad", "android senior developer"))
    notes.add(Note("The Rudest book ever", "android jr developer"))
    notes.add(Note("My dreams by dr.yogesh", "android developer"))
    notes.add(Note("Tere jaisa yaar kaha", "hotel manager"))
    notes.add(Note("Love the way you lie", "react developer"))
    return notes
}