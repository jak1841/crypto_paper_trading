package com.example.cryptopapertradingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.cryptopapertradingapp.ui.theme.CryptoPaperTradingAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CryptoPaperTradingAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Jaskarn Dhillon bri",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
    MyButton()
}

@Composable
fun MyButton() {
    val myViewModel: HomeScreenViewModel = HomeScreenViewModel()
    Button(onClick = { myViewModel.printToScreen() }) {
        Text("Click Me!")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CryptoPaperTradingAppTheme {
        Greeting("Android")
    }
}