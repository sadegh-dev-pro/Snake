package com.sadegh.snake.presentation.game_screen.components

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.dp
import com.sadegh.snake.presentation.game_screen.components.util.GameBoardColors
import com.sadegh.snake.presentation.game_screen.components.util.GameBoardDefaults

@Composable
fun GameBoard(
    modifier: Modifier,
    colors: GameBoardColors=GameBoardDefaults.colors(),
    numberOfSquaresInHeight: Int,
    numberOfSquaresInWidth: Int,
) {

    val colorList = remember { listOf(colors.secondColor, colors.firstColor) }

    Canvas(modifier = modifier) {

        val squareSide = this.size.width / numberOfSquaresInWidth

        repeat(numberOfSquaresInHeight) { rowIndex ->

            repeat(numberOfSquaresInWidth) { columnIndex ->

                val squareColor = colorList[(rowIndex + columnIndex) % 2]

                val squareTopLeftOffset = Offset(
                    x = columnIndex * squareSide,
                    y = rowIndex * squareSide
                )

                drawRect(
                    color = squareColor,
                    topLeft = squareTopLeftOffset,
                    size = Size(width = squareSide, height = squareSide)
                )
            }
        }
    }
}