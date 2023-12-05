package com.sadegh.snake.presentation.game_screen.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.sadegh.snake.presentation.game_screen.components.util.GameBoardColors
import com.sadegh.snake.presentation.game_screen.components.util.GameBoardDefaults

@Composable
fun GameBoard(
    modifier: Modifier,
    colors: GameBoardColors = GameBoardDefaults.colors(),
    numberOfSquaresInHeight: Int,
    numberOfSquaresInWidth: Int,
    snakePixelPositions: List<Pair<Int, Int>>
) {

    val colorList = remember(colors) { listOf(colors.secondColor, colors.firstColor) }

    val snakePixelRowIndices = remember(snakePixelPositions) {
        snakePixelPositions.map { it.first }
    }

    val snakePixelColumnIndices = remember(snakePixelPositions) {
        snakePixelPositions.map { it.second }
    }

    Column(modifier = modifier) {

        repeat(numberOfSquaresInHeight) { rowIndex ->

            Row(modifier = Modifier.fillMaxWidth()) {

                repeat(numberOfSquaresInWidth) { columnIndex ->

                    val squareColor = remember(
                        snakePixelRowIndices,
                        snakePixelColumnIndices,
                        colorList
                    ) {
                        if (
                            rowIndex in snakePixelRowIndices &&
                            columnIndex in snakePixelColumnIndices
                        ) {
                            Color.Blue
                        } else {
                            colorList[(rowIndex + columnIndex) % 2]
                        }
                    }

                    val boxModifier = remember(squareColor) {
                        Modifier
                            .weight(1f)
                            .aspectRatio(1f)
                            .background(squareColor)
                    }

                    Box(
                        modifier =boxModifier
                    )
                }
            }
        }
    }
}