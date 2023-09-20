package com.example.co_opt1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.co_opt1.ui.theme.CoOpt1Theme

/* Test Commit */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoOpt1Theme {
                Greeting("Android")
            }
        }
    }
}

@Composable
fun NumberedTextBoxes(numTextboxes: Int) {
    Column {
        for (i in 1..numTextboxes) {
            Text(text = "Text Box $i")
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        NumberedTextBoxes(numTextboxes = 5) // Adjust the number of text boxes here
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoOpt1Theme {
        Greeting("Android")
    }
}