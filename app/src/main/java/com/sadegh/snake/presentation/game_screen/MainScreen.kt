package com.sadegh.snake.presentation.game_screen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sadegh.snake.presentation.game_screen.components.GameBoard

@Composable
fun MainScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {

        val viewModel = viewModel<GameScreenViewModel>()

        val snakePixelsPosition by viewModel.snakePixelPositions.collectAsState()

        GameBoard(
            modifier = Modifier
                .padding(start = 25.dp, end = 25.dp, top = 25.dp),
            numberOfSquaresInHeight =21,
            numberOfSquaresInWidth =12,
            snakePixelPositions =snakePixelsPosition
        )
    }
}