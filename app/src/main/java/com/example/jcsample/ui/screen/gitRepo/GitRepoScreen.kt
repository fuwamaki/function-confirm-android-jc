package com.example.jcsample.ui.screen.gitRepo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.jcsample.R
import com.example.jcsample.model.GitRepo
import com.example.jcsample.ui.component.CommonTopBar
import com.example.jcsample.ui.theme.JCSampleTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GitRepoScreen(
    navController: NavController,
    viewModel: GitRepoViewModel = hiltViewModel()
) {
    val searchText by viewModel.searchText.collectAsState()
    val repositories = viewModel.repositories.collectAsState().value
    val keyboardController = LocalSoftwareKeyboardController.current

    Scaffold(
        topBar = {
            Column {
                CommonTopBar(navController, R.string.git_repo_title)
                SearchBar(
                    query = searchText,
                    onQueryChange = viewModel::onSearchTextChange,
                    onSearch = {
                        keyboardController?.hide()
                        viewModel.onSearch(searchText)
                    },
                    active = false,
                    onActiveChange = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp, 4.dp)
                ) {

                }
            }
        },
    ) { innerPadding ->
        LazyColumn(Modifier.padding(innerPadding)) {
            repositories.forEach { data ->
                item { Item(navController, data) }
            }
        }
    }
}

@Composable
private fun Item(
    navController: NavController,
    data: GitRepo,
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onPrimary)
            .padding(4.dp)
            .clickable {
                navController.navigate("web-view/?url=${data.htmlUrl}")
            }
    ) {
        Image(
            modifier = Modifier
                .width(48.dp)
                .height(48.dp),
            painter = rememberAsyncImagePainter(data.owner.avatarUrl),
            contentDescription = data.fullName
        )
        Text(
            text = data.fullName,
            modifier = Modifier
                .padding(12.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GitRepoScreenPreview() {
    JCSampleTheme {
        GitRepoScreen(navController = rememberNavController())
    }
}