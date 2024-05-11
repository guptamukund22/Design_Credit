package com.example.temp.data

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class QuestionnaireViewModel : ViewModel() {
    val questions = mutableListOf(
        Question(
            questionText = "What is your favorite color?",
            options = listOf("Red", "Blue", "Green"),
            chosenAnswerIndex = mutableStateOf(-1)
        ),
        Question(
            questionText = "What is your favorite city?",
            options = listOf("Delhi", "Mumbai", "Lucknow"),
            chosenAnswerIndex = mutableStateOf(-1)
        ),
        Question(
            questionText = "What is your favorite flavour?",
            options = listOf("Chocolate", "Straberry"),
            chosenAnswerIndex = mutableStateOf(-1)
        )
    )

    private val _currentQuestionIndex = MutableStateFlow(0)
    val currentQuestionIndex: StateFlow<Int> = _currentQuestionIndex.asStateFlow()

    private val _currentQuestion = MutableStateFlow(questions.first())
    val currentQuestion: StateFlow<Question> = _currentQuestion.asStateFlow()

    // Function to handle answer selection
    fun selectAnswer(index: Int) {
        _currentQuestion.value.chosenAnswerIndex.value = index
        questions[_currentQuestionIndex.value].chosenAnswerIndex.value = index
    }

    // Function to move to the next question
    fun nextQuestion() {
        if (_currentQuestionIndex.value < questions.size - 1) {
            _currentQuestionIndex.value += 1
            _currentQuestion.value = questions[_currentQuestionIndex.value]
        } else {
            // Reached the end of the questions, maybe show a summary or finish the questionnaire
        }
    }

    fun previousQuestion() {
        if (_currentQuestionIndex.value > 0) {
            _currentQuestionIndex.value -= 1
            _currentQuestion.value = questions[_currentQuestionIndex.value]
        }
    }
}