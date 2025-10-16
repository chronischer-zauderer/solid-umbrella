package com.example.heltexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.heltexample.ui.theme.HeltExampleTheme
import dagger.hilt.android.AndroidEntryPoint
import androidx.hilt.navigation.compose.hiltViewModel

// @AndroidEntryPoint habilita la inyección en esta Activity y
// permite que hiltViewModel() resuelva el ViewModel con sus dependencias.
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HeltExampleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    UsersScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

// Pantalla Compose que obtiene el ViewModel inyectado por Hilt
@Composable
fun UsersScreen(modifier: Modifier = Modifier, vm: UserViewModel = hiltViewModel()) {
    val users = vm.users.collectAsState()
    Column(modifier = modifier) {
        Text("Users (Hilt + ViewModel)")
        if (users.value.isEmpty()) {
            Text("Loading…")
        } else {
            users.value.forEach { user ->
                Text("• ${user.name}")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UsersPreview() {
    HeltExampleTheme {
        Column { Text("Users (Preview)") }
    }
}