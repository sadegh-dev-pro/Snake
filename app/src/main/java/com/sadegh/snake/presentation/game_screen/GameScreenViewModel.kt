package com.sadegh.snake.presentation.game_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class GameScreenViewModel : ViewModel() {

    private val _snakePixelPositions = MutableStateFlow(listOf(0 to 0, 0 to 1, 0 to 2, 0 to 3))
    val snakePixelPositions = _snakePixelPositions.asStateFlow()

    private val snakeHeadPosition
        get() = _snakePixelPositions.value.last()

    private val _numberOfSquaresInHeight = MutableStateFlow(21)
    val numberOfSquaresInHeight = _numberOfSquaresInHeight.asStateFlow()

    private val _numberOfSquaresInWidth = MutableStateFlow(12)
    val numberOfSquaresInWidth = _numberOfSquaresInWidth.asStateFlow()

    fun onEvent(event: UserEvent) {

        when (event) {
            UserEvent.OnMoveDownButtonClick -> onMoveDownButtonClick()
            UserEvent.OnMoveLeftButtonClick -> onMoveLeftButtonClick()
            UserEvent.OnMoveRightButtonClick -> onMoveRightButtonClick()
            UserEvent.OnMoveUpButtonClick -> onMoveUpButtonClick()
        }
    }

    private fun onMoveDownButtonClick() {
        changeSnakePixelsPositions(snakeHeadPosition.copy(first = snakeHeadPosition.first + 1))
    }

    private fun onMoveUpButtonClick() {
        changeSnakePixelsPositions(snakeHeadPosition.copy(first = snakeHeadPosition.first - 1))
    }

    private fun onMoveRightButtonClick() {
        changeSnakePixelsPositions(snakeHeadPosition.copy(second = snakeHeadPosition.first + 1))
    }

    private fun onMoveLeftButtonClick() {
        changeSnakePixelsPositions(snakeHeadPosition.copy(second = snakeHeadPosition.first - 1))
    }

    private fun changeSnakePixelsPositions(snakeHeadNewPosition: Pair<Int, Int>) {

        viewModelScope.launch {
            delay(300)
            val newSnakePixelPositions = mutableListOf<Pair<Int, Int>>()
            for (index in 1.._snakePixelPositions.value.lastIndex) {

                newSnakePixelPositions += _snakePixelPositions.value[index]
            }
            newSnakePixelPositions += snakeHeadNewPosition
        }
    }
}