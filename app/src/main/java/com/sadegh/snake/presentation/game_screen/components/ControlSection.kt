package com.sadegh.snake.presentation.game_screen.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.sadegh.snake.presentation.game_screen.UserEvent

@Composable
fun ControlSection(
    modifier: Modifier,
    onEvent: (UserEvent) -> Unit
) {

    Box(modifier = modifier) {

        Button(
            onClick = { onEvent(UserEvent.OnMoveDownButtonClick) },
            colors = ButtonDefaults.buttonColors(Color.LightGray.copy(0.5f)),
            modifier=Modifier
                .fillMaxWidth(1/3f)
                .align(Alignment.BottomCenter)
        ) {}

        Button(
            onClick = { onEvent(UserEvent.OnMoveUpButtonClick) },
            colors = ButtonDefaults.buttonColors(Color.LightGray.copy(0.5f)),
            modifier=Modifier
                .fillMaxWidth(1/3f)
                .align(Alignment.TopCenter)
        ) {}

        Button(
            onClick = { onEvent(UserEvent.OnMoveRightButtonClick) },
            colors = ButtonDefaults.buttonColors(Color.LightGray.copy(0.5f)),
            modifier=Modifier
                .fillMaxWidth(1/3f)
                .align(Alignment.CenterEnd)
        ) {}

        Button(
            onClick = { onEvent(UserEvent.OnMoveLeftButtonClick) },
            colors = ButtonDefaults.buttonColors(Color.LightGray.copy(0.5f)),
            modifier=Modifier
                .fillMaxWidth(1/3f)
                .align(Alignment.CenterStart)
        ) {}
    }

}