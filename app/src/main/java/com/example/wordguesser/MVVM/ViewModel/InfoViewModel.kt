package com.example.wordguesser.MVVM.ViewModel

import androidx.lifecycle.ViewModel
import com.example.wordguesser.MVVM.Model.GameUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class InfoViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    fun updateInfo(gameUiState: GameUiState) {
        _uiState.value = GameUiState(
            chosenWord = gameUiState.chosenWord,
            lives = gameUiState.lives,
            points = gameUiState.points
        )


        /*{ currentState ->
            currentState.copy(
                chosenWord = gameUiState.chosenWord,
                lives = gameUiState.lives,
                points = gameUiState.points
            )
        }

         */
    }

}