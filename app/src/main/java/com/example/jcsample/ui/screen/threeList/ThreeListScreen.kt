package com.example.jcsample.ui.screen.threeList

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jcsample.R
import com.example.jcsample.ui.component.CommonTopBar
import com.example.jcsample.ui.theme.JCSampleTheme

@Composable
fun ThreeListScreen(
    navController: NavController,
    viewModel: ThreeListViewModel = hiltViewModel()
) {

    Scaffold(
        topBar = {
            CommonTopBar(navController, R.string.three_list_title)
        },
    ) { innerPadding ->
        LazyColumn(Modifier.padding(innerPadding)) {
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GitRepoScreenPreview() {
    JCSampleTheme {
        ThreeListScreen(navController = rememberNavController())
    }
}