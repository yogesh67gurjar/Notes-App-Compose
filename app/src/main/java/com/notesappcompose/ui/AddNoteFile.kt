package com.notesappcompose.ui

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.notesappcompose.R
import com.notesappcompose.ui.theme.darkCharcoal
import com.notesappcompose.ui.theme.darkGray
import com.notesappcompose.ui.theme.transparent
import com.notesappcompose.ui.theme.white

@Composable
fun AddNewNote(navHostController: NavHostController, context: Context) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(darkCharcoal)
    ) {
        Header(navHostController, context)

        val titleState = remember {
            mutableStateOf("")
        }
        TextField(
            value = titleState.value,
            onValueChange = {
                titleState.value = it
            },

            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 30.dp, bottom = 10.dp)
                .fillMaxWidth(),
            maxLines = 2,
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = transparent,
                cursorColor = Color.White,
                focusedContainerColor = transparent,
                unfocusedContainerColor = transparent,
                disabledContainerColor = transparent,
                unfocusedIndicatorColor = transparent
            ),
            textStyle = TextStyle(
                color = white,
                fontSize = 34.sp,
                fontFamily = FontFamily(Font(resId = R.font.nunito_regular))
            ),
            placeholder = {
                Text(
                    text = "Title", color = darkGray, fontSize = 34.sp,
                    fontFamily = FontFamily(Font(resId = R.font.nunito_regular))
                )
            }
        )

        val descriptionState = remember {
            mutableStateOf("")
        }
        TextField(
            value = descriptionState.value, onValueChange = {
                descriptionState.value = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = transparent,
                cursorColor = Color.White,
                focusedContainerColor = transparent,
                unfocusedContainerColor = transparent,
                disabledContainerColor = transparent,
                unfocusedIndicatorColor = transparent
            ),
            textStyle = TextStyle(
                color = white,
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(resId = R.font.nunito_regular))
            ),
            placeholder = {
                Text(
                    text = "Type something...", color = darkGray, fontSize = 20.sp,
                    fontFamily = FontFamily(Font(resId = R.font.nunito_regular))
                )
            }
        )
    }
}


@Composable
private fun Header(navHostController: NavHostController, context: Context) {
    Box(
        modifier = Modifier
            .padding(top = 20.dp, start = 16.dp, end = 16.dp)
            .fillMaxWidth()
    ) {

        SquareButton(
            painterResourceId = R.drawable.ic_back,
            modifier = Modifier,onClick = {
                navHostController.popBackStack()
            }
        )

        Row(
            modifier = Modifier.align(Alignment.CenterEnd)
        ) {

//            SquareButton(
//                painterResourceId = R.drawable.ic_eye,
//                modifier = Modifier.padding(end = 15.dp), onClick = {
//                }
//            )

            SquareButton(
                painterResourceId = R.drawable.ic_save,
                modifier = Modifier, onClick = {
                    Toast.makeText(context, "saved", Toast.LENGTH_SHORT).show()
                    navHostController.popBackStack()
                })
        }
    }
}