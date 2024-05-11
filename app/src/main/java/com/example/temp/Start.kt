package com.example.temp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.temp.ui.theme.TempTheme

@Composable
fun StartPage(){
    TempTheme(darkTheme = true) { // Ensures we're using a dark theme across the app
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.Black // Dark background for the page
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                HomeIcon()
                StartButton()
                BottomButtons()
            }
        }
    }
}

@Composable
fun HomeIcon(){
    Row (horizontalArrangement = Arrangement.Start){
        Icon(
            imageVector = Icons.Default.Home,
            modifier = Modifier.size(40.dp),
            contentDescription = null,
            tint = Color.LightGray
        )
    }
}

@Composable
fun BottomButtons(){
    Row (){
        Spacer(modifier = Modifier.padding(1.dp))
        Button(onClick = { /*TODO*/ }, modifier = Modifier
            .weight(1f) , colors = ButtonDefaults.buttonColors(Color(0xFF1E0060))
            ) {
            Icon(imageVector = Icons.Default.Person, contentDescription = null)
            Text(text = "Chat with moderator",style = MaterialTheme.typography.bodyLarge , modifier = Modifier.padding(3.dp) , textAlign = TextAlign.Center)
        }
        Spacer(modifier = Modifier.padding(1.dp))
        Button(onClick = { /*TODO*/ }, modifier = Modifier
            .weight(1f) ,  colors = ButtonDefaults.buttonColors(Color(0xFF1E0060)
            )) {
            Icon(imageVector = Icons.Default.Person, contentDescription = null)
            Text(text = "Chat with group",style = MaterialTheme.typography.bodyLarge, modifier = Modifier.padding(3.dp) , textAlign = TextAlign.Center)
        }
        Spacer(modifier = Modifier.padding(1.dp))
    }
}

@Composable
fun StartButton(modifier: Modifier = Modifier){
    Column (horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()){
        Text(text = "FATIGUE", style = MaterialTheme.typography.displayLarge, modifier = Modifier.padding(4.dp) , color = Color.White)
        Text(text = "TEST", style = MaterialTheme.typography.displayLarge, modifier = Modifier.padding(bottom = 16.dp) , color = Color.White)
        Spacer(modifier = Modifier.padding(5.dp))
        Button(
            onClick = { /*TODO*/ },
            shape = CircleShape,
            modifier = Modifier
                .size(120.dp),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 30.dp,
                pressedElevation = 35.dp,
                disabledElevation = 0.dp,
                hoveredElevation = 35.dp,
                focusedElevation = 30.dp
            )
        ) {
            Text(text = "START", style = MaterialTheme.typography.displayMedium)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StartPagePreview(){
    TempTheme(darkTheme = true){
        StartPage()
    }
}