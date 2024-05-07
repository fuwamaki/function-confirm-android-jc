package com.example.jcsample.ui.screen.gitRepo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jcsample.R
import com.example.jcsample.ui.component.CommonTopBar
import com.example.jcsample.ui.theme.JCSampleTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GitRepoScreen(
    navController: NavController,
    viewModel: GitRepoViewModel = hiltViewModel()
) {
    val searchText by viewModel.searchText.collectAsState()
    val isSearching by viewModel.isSearching.collectAsState()
    val repositories = viewModel.repositories.collectAsState().value

    Scaffold(
        topBar = {
            Column {
                CommonTopBar(navController, R.string.git_repo_title)
                SearchBar(
                    query = searchText,
                    onQueryChange = viewModel::onSearchTextChange,
                    onSearch = viewModel::onSearch,
                    active = isSearching,
                    onActiveChange = viewModel::onToggleSearch,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp, 0.dp)
                ) {

                }
            }
        },
    ) { innerPadding ->
        LazyColumn(Modifier.padding(innerPadding)) {
            repositories.forEach { repository ->
                item { Text(text = repository.fullName) }
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