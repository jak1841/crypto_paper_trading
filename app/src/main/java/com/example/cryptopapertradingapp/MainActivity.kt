package com.example.cryptopapertradingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
    val viewModel = HomeScreenViewModel()
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        MyButton(viewModel)
        TextFieldWithSuggestions(viewModel)
    }
}

@Composable
fun MyButton(viewModel: HomeScreenViewModel) {
    Button(onClick = { viewModel.printToScreen() }) {
        Text("Click Me!")
    }
}

@Composable
fun TextFieldWithSuggestions(viewModel: HomeScreenViewModel) {
    var text by remember { mutableStateOf("") }
    viewModel.updateSearchSuggestion(text)
    val filteredSuggestions by viewModel.cryptoSearchSuggestions.observeAsState(emptyList())

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = text,
            onValueChange = { newText -> text = newText },
            placeholder = { Text("Type to filter suggestions...") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn {
            items(filteredSuggestions) { suggestion ->
                Text(
                    text = suggestion,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { text = suggestion }
                        .padding(8.dp)
                )
            }
        }
    }
}
