package com.sadegh.snake.presentation.game_screen.components.util

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

object GameBoardDefaults {

    @Composable
    fun colors(
        firstColor: Color=MaterialTheme.colorScheme.primary,
        secondColor: Color=MaterialTheme.colorScheme.secondary
    ): GameBoardColors {

        return GameBoardColors(firstColor,secondColor)
    }
}