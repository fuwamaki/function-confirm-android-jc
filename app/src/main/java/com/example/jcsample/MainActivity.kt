package com.example.jcsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jcsample.ui.theme.JCSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JCSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FunctionList()
                }
            }
        }
    }
}

@Composable
fun FunctionList() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(0.dp),
        verticalArrangement = Arrangement.spacedBy(1.dp)
    ) {
        items(50) { index ->
            NumberListItem(number = index + 1)
        }
    }
}

@Composable
fun NumberListItem(number: Int) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
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
        FunctionList()
    }
}