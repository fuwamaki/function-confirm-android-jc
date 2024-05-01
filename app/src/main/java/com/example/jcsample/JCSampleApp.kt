package com.example.jcsample

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jcsample.ui.screen.Screen
import com.example.jcsample.ui.screen.gitRepo.GitRepoScreen
import com.example.jcsample.ui.screen.top.TopScreen

@Composable
fun JCSampleApp(
    appState: JCSampleAppState = rememberJCSampleAppState()
) {
    NavHost(
        navController = appState.navController,
        startDestination = Screen.TopScreen.name,
    ) {
        composable(route = Screen.TopScreen.name) {
            TopScreen(navController = appState.navController)
        }
        composable(route = Screen.GitRepoScreen.name) {
            GitRepoScreen(navController = appState.navController)
        }
    }
}