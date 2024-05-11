package com.example.temp.data

import androidx.compose.runtime.MutableState

data class Question(
    val questionText: String,
    val options: List<String>,
    var chosenAnswerIndex: MutableState<Int>
)
