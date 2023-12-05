package com.sadegh.snake.presentation.game_screen

sealed interface UserEvent {

    data object OnMoveRightButtonClick : UserEvent
    data object OnMoveLeftButtonClick : UserEvent
    data object OnMoveUpButtonClick : UserEvent
    data object OnMoveDownButtonClick : UserEvent
}