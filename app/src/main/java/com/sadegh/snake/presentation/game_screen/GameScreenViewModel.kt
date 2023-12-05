package com.sadegh.snake.presentation.game_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class GameScreenViewModel : ViewModel() {

    private val _snakePixelPositions = MutableStateFlow(listOf(0 to 0, 0 to 1, 0 to 2, 0 to 3))
    val snakePixelPositions = _snakePixelPositions.asStateFlow()

    fun onEvent(event: UserEvent) {

        when (event) {
            UserEvent.OnMoveDownButtonClick -> onMoveDownButtonClick()
            UserEvent.OnMoveLeftButtonClick -> onMoveLeftButtonClick()
            UserEvent.OnMoveRightButtonClick -> onMoveRightButtonClick()
            UserEvent.OnMoveUpButtonClick -> onMoveUpButtonClick()
        }
    }

    private fun onMoveDownButtonClick() {
    }

    private fun onMoveUpButtonClick() {

    }

    private fun onMoveRightButtonClick() {


    }

    private fun onMoveLeftButtonClick() {

    }
}