package com.notesappcompose.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost

import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.notesappcompose.AddNewNote
import com.notesappcompose.MainScreen

@Composable
fun NavGraph(navHostController: NavHostController, context: Context) {
    NavHost(navController = navHostController, startDestination = NavCases.MAIN_SCREEN) {
        composable(route = NavCases.MAIN_SCREEN) {
            MainScreen(navHostController,context)
        }
        composable(route = NavCases.ADD_NEW_NOTE) {
            AddNewNote(navHostController,context)
        }
    }
}