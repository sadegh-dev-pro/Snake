package com.sadegh.snake.presentation.game_screen

sealed interface UiEvent {

    data object MoveRight : UiEvent
    data object MoveLeft : UiEvent
    data object MoveUp : UiEvent
    data object MoveDown : UiEvent
}