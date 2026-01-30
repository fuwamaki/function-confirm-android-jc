package com.example.jcsample.ui.screen.threeList

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
        val list = remember {
            listOf(
                ListItem("タイトル1", List(7) { "${it}" }),
                ListItem("タイトル2", List(8) { "${it + 7}" }),
                ListItem("タイトル3", List(8) { "${it + 15}" }),
                ListItem("タイトル4", List(14) { "${it + 23}" }),
            )
        }

        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
        ) {
            list.forEach {
                item {
                    Text(
                        text = it.title,
                        style = MaterialTheme.typography.headlineSmall,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                    CustomGrid(items = it.items)
                }
            }
        }
    }
}

@Composable
fun CustomGrid(items: List<String>) {
    BoxWithConstraints {
        val columns = 3
        val totalWidth = maxWidth
        val itemWidth = 60.dp
        val itemPadding = (totalWidth - itemWidth * columns) / (columns - 1)
        val rows = (items.size + columns - 1) / columns

        Column {
            for (row in 0 until rows) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(itemPadding)
                ) {
                    for (column in 0 until columns) {
                        val index = row * columns + column
                        if (index < items.size) {
                            val item = items[index]
                            Box(
                                modifier = Modifier
                                    .width(itemWidth)
                                    .padding(vertical = 8.dp)
                                    .background(
                                        color = MaterialTheme.colorScheme.primary,
                                        shape = MaterialTheme.shapes.extraLarge
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = item,
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    style = MaterialTheme.typography.bodyMedium,
                                    modifier = Modifier.padding(18.dp)
                                )
                            }
                        } else {
                            Spacer(modifier = Modifier.width(itemWidth))
                        }
                    }
                }
            }
        }
    }
}

private data class ListItem(val title: String, val items: List<String>)

@Preview(showBackground = true)
@Composable
fun GitRepoScreenPreview() {
    JCSampleTheme {
        ThreeListScreen(navController = rememberNavController())
    }
}