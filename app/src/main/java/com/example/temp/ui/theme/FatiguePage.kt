package com.example.temp.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.temp.ui.theme.TempTheme

@Composable
fun FatiguePage() {
    var fatigueLevel by remember { mutableStateOf(80) }

    TempTheme(darkTheme = true) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.Black  // Use a black background for the whole page
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                FatigueIndicator(fatigueLevel)
                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    text = "You should take rest",
                    style = MaterialTheme.typography.displayLarge,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = "Fatigue % = $fatigueLevel",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Gray,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(100.dp))
                Button(
                    onClick = { /* Navigate to home or handle error */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6200EE))  // Vibrant button color
                ) {
                    Text(text = "Home", style = MaterialTheme.typography.displayMedium, color = Color.White)
                }
                Spacer(modifier = Modifier.height(20.dp))
                TextButton(
                    onClick = { /* Handle incorrect information */ },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.textButtonColors(contentColor = Color.Red)
                ) {
                    Text(text = "Incorrect Information? Click Here", style = MaterialTheme.typography.bodyLarge)
                }
            }
        }
    }
}

@Composable
fun FatigueIndicator(fatigueLevel: Int) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth()
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(Color.DarkGray, Color.Black)
                )
            )
    ) {
        CircularProgressIndicator(
            progress = fatigueLevel / 100f,
            color = if (fatigueLevel > 50) Color.Red else Color.Green,
            strokeWidth = 12.dp
        )
        Text(
            text = "$fatigueLevel%",
            style = MaterialTheme.typography.displaySmall,
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFatiguePage() {
    FatiguePage()
}
