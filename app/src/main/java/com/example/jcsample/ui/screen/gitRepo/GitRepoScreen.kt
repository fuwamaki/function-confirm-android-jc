package com.example.jcsample.ui.screen.gitRepo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jcsample.R
import com.example.jcsample.ui.component.CommonTopBar
import com.example.jcsample.ui.screen.Screen
import com.example.jcsample.ui.theme.JCSampleTheme

@Composable
fun GitRepoScreen(navController: NavController) {
    Scaffold(
        topBar = { CommonTopBar(navController, R.string.git_repo_title) },
    ) { innerPadding ->
        Column(Modifier.padding(innerPadding)) {
            Text(text = "Screen 2")
            Button(onClick = { navController.navigate(Screen.TopScreen.name) }) {
                Text(text = "Back to Screen 1")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GitRepoScreenPreview() {
    JCSampleTheme {
        GitRepoScreen(navController = rememberNavController())
    }
}