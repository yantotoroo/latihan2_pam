package com.example.latihan2_pam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppNavigation()
        }
    }
}

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "screen1"
    ) {

        composable("screen1") {
            Screen1(
                onNavigateToScreen2 = {
                    navController.navigate("screen2")
                }
            )
        }

        composable("screen2") {
            Screen2()
        }
    }
}

@Composable
fun Screen1(
    onNavigateToScreen2: () -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text("NIM: 245150400111068")
        Text("Nama: Aryanti Puspita Sari")

        Text("Screen 1")

        Button(
            onClick = onNavigateToScreen2
        ) {
            Text("Halaman 2")
        }
    }
}

@Composable
fun Screen2() {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text("NIM: 245150400111068")
        Text("Nama: Aryanti Puspita Sari")

        Text("Screen 2")
    }
}
