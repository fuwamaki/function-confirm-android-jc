package com.example.jcsample.ui.screen.top

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jcsample.R
import com.example.jcsample.ui.component.CommonTopBar
import com.example.jcsample.ui.theme.JCSampleTheme
import com.example.jcsample.ui.type.TopItemType
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@Composable
fun TopScreen(
    navController: NavController,
    viewModel: TopViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(context) {
        viewModel.showToast
            .onEach { message ->
                Toast
                    .makeText(context, message, Toast.LENGTH_SHORT)
                    .show()
            }
            .launchIn(coroutineScope)
    }

    LaunchedEffect(Unit) {
        viewModel.navigateFlow
            .onEach { navController.navigate(it.name) }
            .launchIn(coroutineScope)
    }

    Scaffold(
        topBar = { CommonTopBar(navController, R.string.top_title) },
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(1.dp)
        ) {
            TopItemType.entries.forEach { type ->
                item {
                    NumberListItem(context, viewModel, type)
                }
            }
        }
    }
}

@Composable
private fun NumberListItem(
    context: Context,
    viewModel: TopViewModel,
    type: TopItemType,
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onPrimary)
            .clickable {
                viewModel.onItemClick(context, type)
            }
    ) {
        Text(
            text = type.title(context),
            modifier = Modifier
                .padding(12.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun TopScreenPreview() {
    JCSampleTheme {
        TopScreen(navController = rememberNavController())
    }
}