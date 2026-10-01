package com.example.latihan2_pam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                onNavigateToScreen2 = { navController.navigate("screen2") },
                onNavigateToLazyList = { navController.navigate("lazyList") }
            )
        }
        composable("screen2") {
            Screen2()
        }
        composable("lazyList") {
            LazyListScreen()
        }
    }
}

@Composable
fun Screen1(
    onNavigateToScreen2: () -> Unit,
    onNavigateToLazyList: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("NIM: 245150400111068")
        Text("Nama: Aryanti Puspita Sari")

        Spacer(modifier = Modifier.height(16.dp))
        Text("Screen 1")
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = onNavigateToScreen2) {
            Text("Halaman 2")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Tombol baru untuk menuju tugas LazyList
        Button(onClick = onNavigateToLazyList) {
            Text("Tugas Lazy List")
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

// --- TUGAS BARU: LAZY LIST ---
@Composable
fun LazyListScreen() {
    val dataList = listOf("Materi Mobile", "Materi Web", "Materi UI/UX", "Materi Basis Data", "Materi RPL")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // NIM dan Nama di atas LazyList
        Text(text = "Nama: Aryanti Puspita Sari", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Text(text = "NIM: 245150400111068", fontSize = 16.sp, modifier = Modifier.padding(bottom = 16.dp))

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(dataList) { item ->
                Card(modifier = Modifier.fillMaxWidth()) {
                    Row(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // GANTI 'gambar_tugas' DENGAN NAMA FILE GAMBAR DI FOLDER DRAWABLE KAMU
                        Image(
                            painter = painterResource(id = R.drawable.fotoacu),
                            contentDescription = "Ikon List",
                            modifier = Modifier
                                .size(50.dp)
                                .padding(end = 16.dp)
                        )
                        Text(text = item, fontSize = 18.sp)
                    }
                }
            }
        }
    }
}