package com.example.jcsample.ui.screen.gitRepo

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.jcsample.ui.screen.Screen

@Composable
fun GitRepoScreen(navController: NavController) {
    Column {
        Text(text = "Screen 2")
        Button(onClick = { navController.navigate(Screen.TopScreen.name) }) {
            Text(text = "Back to Screen 1")
        }
    }
}
