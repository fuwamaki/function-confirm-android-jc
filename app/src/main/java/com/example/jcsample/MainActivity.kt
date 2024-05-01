package com.example.jcsample

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jcsample.ui.theme.JCSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JCSampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DisplayNav()
                }
            }
        }
    }
}

enum class Nav {
    TopScreen,
    GitRepoScreen,
}

@Composable
fun DisplayNav() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Nav.TopScreen.name) {
        composable(route = Nav.TopScreen.name) {
            TopScreen(navController)
        }
        composable(route = Nav.GitRepoScreen.name) {
            GitRepoScreen(navController)
        }
    }
}

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
fun GitRepoScreen(navController: NavController) {
    Column {
        Text(text = "Screen 2")
        Button(onClick = { navController.navigate(Nav.TopScreen.name) }) {
            Text(text = "Back to Screen 1")
        }
    }
}

@Composable
fun NumberListItem(navController: NavController, number: Int) {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
            .clickable {
                if (number == 0) {
                    navController.navigate(Nav.GitRepoScreen.name)
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
fun FunctionListPreview() {
    JCSampleTheme {
        DisplayNav()
    }
}