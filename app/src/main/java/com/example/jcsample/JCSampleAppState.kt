package com.example.jcsample

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

class JCSampleAppState(
    val navController: NavHostController,
    private val context: Context,
) {
}

@Composable
fun rememberJCSampleAppState(
    navController: NavHostController = rememberNavController(),
    context: Context = LocalContext.current,
) = remember(navController, context) { // TODO: このrememberって何？
    JCSampleAppState(navController, context)
}