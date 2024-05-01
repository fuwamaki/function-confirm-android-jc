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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jcsample.ui.screen.Screen
import com.example.jcsample.ui.theme.JCSampleTheme

@Composable
fun TopScreen(navController: NavController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(0.dp),
        verticalArrangement = Arrangement.spacedBy(1.dp)
    ) {
        items(50) { index ->
            NumberListItem(navController, number = index)
        }
    }
}

@Composable
private fun NumberListItem(navController: NavController, number: Int) {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
            .clickable {
                if (number == 0) {
                    navController.navigate(Screen.GitRepoScreen.name)
                }
                Toast
                    .makeText(context, "click test $number", Toast.LENGTH_SHORT)
                    .show()
            }
    ) {
        Text(
            text = "Number: $number",
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