package com.sadegh.snake.presentation.game_screen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class GameScreenViewModel : ViewModel() {

    private val _snakePixelPositions = MutableStateFlow(listOf(0, 1, 2, 3))
    val snakePixelPositions = _snakePixelPositions.asStateFlow()

}