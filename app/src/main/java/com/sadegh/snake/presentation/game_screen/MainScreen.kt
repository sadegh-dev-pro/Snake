package com.sadegh.snake.presentation.game_screen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sadegh.snake.presentation.game_screen.components.ControlSection
import com.sadegh.snake.presentation.game_screen.components.GameBoard

@Composable
fun MainScreen() {
    Surface(modifier = remember{ Modifier.fillMaxSize() }) {

        val viewModel = viewModel<GameScreenViewModel>()

        val snakePixelsPosition by viewModel.snakePixelPositions.collectAsState()

        Column(
            modifier = remember{ Modifier.fillMaxSize() },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            val gameBoardModifier = remember {
                Modifier
                    .padding(start = 25.dp, end = 25.dp, top = 25.dp)
                    .fillMaxWidth()
            }

            GameBoard(
                modifier = gameBoardModifier,
                numberOfSquaresInHeight = 21,
                numberOfSquaresInWidth = 12,
                snakePixelPositions = snakePixelsPosition
            )

            val controlSectionModifier = remember {
                Modifier
                    .padding(20.dp)
                    .fillMaxWidth(2 / 3f)
                    .weight(1f)
            }

            ControlSection(modifier = controlSectionModifier, onEvent = viewModel::onEvent)
        }
    }
}