package com.example.temp.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.temp.data.Question
import com.example.temp.data.QuestionnaireViewModel

@Composable
fun QuestionProgressIndicator(currentQuestionIndex: Int, totalQuestions: Int) {
    val progress = (currentQuestionIndex + 1) / totalQuestions.toFloat()

    LinearProgressIndicator(
        progress = progress,
        color = MaterialTheme.colorScheme.secondary,
        modifier = Modifier
            .fillMaxWidth()
            .height(20.dp)
            .clip(RoundedCornerShape(10.dp))
    )
}

@Composable
fun Present(Q: Question, onOptionSelected: (Int) -> Unit) {
    Column {
        Text(
            text = Q.questionText,
            style = MaterialTheme.typography.headlineMedium,
            color = Color.White,
            modifier = Modifier.padding(all = 16.dp)
        )
        Q.options.forEachIndexed { index, option ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onOptionSelected(index) }
                    .background(Brush.horizontalGradient(listOf(Color.DarkGray, Color.Black)))
                    .padding(8.dp)
            ) {
                RadioButton(
                    selected = (index == Q.chosenAnswerIndex.value),
                    onClick = { onOptionSelected(index) },
                    colors = RadioButtonDefaults.colors(selectedColor = MaterialTheme.colorScheme.primary)
                )
                Text(
                    text = option,
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
    }
}

@Composable
fun Screen(
    questionViewModel: QuestionnaireViewModel = QuestionnaireViewModel()
) {
    TempTheme(darkTheme = true) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.Black
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                QuestionProgressIndicator(
                    currentQuestionIndex = questionViewModel.currentQuestionIndex.collectAsState().value,
                    totalQuestions = questionViewModel.questions.size
                )
                Present(
                    Q = questionViewModel.currentQuestion.collectAsState().value,
                    onOptionSelected = questionViewModel::selectAnswer
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(
                        onClick = { questionViewModel.previousQuestion() },
                        enabled = questionViewModel.currentQuestionIndex.collectAsState().value > 0
                    ) {
                        Text("Back", color = Color.White)
                    }
                    Button(
                        onClick = { questionViewModel.nextQuestion() },
                        enabled = questionViewModel.currentQuestionIndex.collectAsState().value < questionViewModel.questions.size - 1
                    ) {
                        Text("Next", color = Color.White)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewScreen() {
    Screen(QuestionnaireViewModel())
}
