package com.example.jcsample.ui.screen.top

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import com.example.jcsample.ui.theme.JCSampleTheme
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

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(0.dp),
        verticalArrangement = Arrangement.spacedBy(1.dp)
    ) {
        items(50) { index ->
            NumberListItem(viewModel, index = index)
        }
    }
}

@Composable
private fun NumberListItem(
    viewModel: TopViewModel,
    index: Int,
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
            .clickable {
                viewModel.onItemClick(index)
            }
    ) {
        Text(
            text = "Number: $index",
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