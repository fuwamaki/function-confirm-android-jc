package com.example.jcsample

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.jcsample.ui.screen.Screen
import com.example.jcsample.ui.screen.gitRepo.GitRepoScreen
import com.example.jcsample.ui.screen.threeList.ThreeListScreen
import com.example.jcsample.ui.screen.top.TopScreen
import com.example.jcsample.ui.screen.webview.WebViewScreen

@Composable
fun JCSampleApp(
    appState: JCSampleAppState = rememberJCSampleAppState()
) {
    NavHost(
        navController = appState.navController,
        startDestination = Screen.Top.route,
    ) {
        composable(route = Screen.Top.route) {
            TopScreen(navController = appState.navController)
        }
        composable(route = Screen.GitRepo.route) {
            GitRepoScreen(navController = appState.navController)
        }
        composable(route = Screen.ThreeList.route) {
            ThreeListScreen(navController = appState.navController)
        }
        composable(
            route = Screen.WebView.route,
            arguments = listOf(navArgument("url") { type = NavType.StringType }),
        ) {
            WebViewScreen(
                url = it.arguments?.getString("url") ?: "",
                navController = appState.navController
            )
        }
    }
}