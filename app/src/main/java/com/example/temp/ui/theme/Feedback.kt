package com.example.temp.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.temp.ui.theme.TempTheme

@Composable
fun FeedbackPage() {
    TempTheme(darkTheme = true) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.Black  // Enhanced dark background
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "What went wrong?",
                    style = MaterialTheme.typography.headlineMedium,  // Updated for better visibility
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(24.dp))
                DropDownQuestion()
                Spacer(modifier = Modifier.height(24.dp))
                SingleQuestion("Felt Normal and not intense.")
                Spacer(modifier = Modifier.height(12.dp))
                SingleQuestion("Body was mostly stable and there was no movement.")
                Spacer(modifier = Modifier.height(12.dp))
                SingleQuestion("Head was mostly stable and there was no movement.")
                Spacer(modifier = Modifier.height(32.dp))
                Button(
                    onClick = { /* Submit feedback */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6200EE)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "SUBMIT", style = MaterialTheme.typography.displayMedium)
                }
            }
        }
    }
}

@Composable
fun DropDownQuestion() {
    var expanded by remember { mutableStateOf(false) }
    var selectedIndex by remember { mutableStateOf(0) }
    val options = listOf("Not an intense activity?", "Another reason?")

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.DarkGray, shape = RoundedCornerShape(8.dp)),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .clickable { expanded = !expanded },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = options[selectedIndex], color = Color.White, style = MaterialTheme.typography.bodyLarge)
            Icon(
                imageVector = Icons.Filled.ArrowDropDown,
                contentDescription = "Dropdown",
                tint = Color.White
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.background(Color.DarkGray)
        ) {
            options.forEachIndexed { index, label ->
                DropdownMenuItem(
                    text = { Text(text = label, color = Color.White) },
                    onClick = {
                        selectedIndex = index
                        expanded = false
                    }
                )
            }
        }
    }
}

@Composable
fun SingleQuestion(text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Brush.horizontalGradient(listOf(Color.DarkGray, Color.Black))),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = false,
            onCheckedChange = {},
            colors = CheckboxDefaults.colors(checkedColor = Color.Cyan)
        )
        Spacer(modifier = Modifier.width(8.dp))
        ClickableText(
            text = AnnotatedString(text),
            onClick = {},
            style = MaterialTheme.typography.bodyLarge.copy(color = Color.White)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFeedbackPage() {
    FeedbackPage()
}
