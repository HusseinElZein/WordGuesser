package com.example.wordguesser.MVVM.ViewModel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import com.example.wordguesser.MVVM.Model.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.random.Random


class MainGameViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    /**Whenever player/user starts a new game*/
    fun onStartGame() {
        _uiState.update { currentState ->
            currentState.copy(
                chosenWord = BuildWordList().getWordList().shuffled().random(),
            )
        }
    }

    init {
        onStartGame()
    }

    /**Whenever player/user presses a letter on the keyboard*/
    fun onPressedKeyboardLetter(letterClicked: String, existsInWord: MutableState<Boolean>) {
        _uiState.update { currentState ->
            currentState.copy(
                hasToSpin = true
            )
        }

        if (_uiState.value.chosenWord.word.contains(letterClicked.lowercase())) {
            var foundCounter = 0
            for (letter in _uiState.value.chosenWord.letters) {
                if (!letter.isFound.value && letter.letter == letterClicked.lowercase()) {
                    foundCounter++
                    letter.isFound.value = true
                    existsInWord.value = true
                }
            }
            _uiState.update { currentState ->
                currentState.copy(
                    points = uiState.value.points + (foundCounter * uiState.value.lastSpinInt),
                    guessedLetters = uiState.value.guessedLetters + foundCounter
                )
            }
        } else {
            _uiState.update { currentState ->
                currentState.copy(
                    lives = currentState.lives - 1
                )
            }
        }

        if (uiState.value.chosenWord.letters.size == uiState.value.guessedLetters) {
            _uiState.update { currentState ->
                currentState.copy(
                    wonGame = true
                )
            }
        }

        if (uiState.value.lives == 0) {
            _uiState.update { currentState ->
                currentState.copy(
                    lostGame = true
                )
            }
        }
    }

    /**Whenever player/user on spin wheel to get a random number*/
    fun onSpinWheel() {

        _uiState.update { currentState ->
            currentState.copy(
                hasToSpin = false
            )
        }

        val rndm = (0..10).random()

        var lastSpin = ""

        when (rndm) {
            0 -> lastSpin = "Bankrupt"
            1 -> lastSpin = "100"
            2 -> lastSpin = "200"
            3 -> lastSpin = "300"
            4 -> lastSpin = "400"
            5 -> lastSpin = "500"
            6 -> lastSpin = "600"
            7 -> lastSpin = "700"
            8 -> lastSpin = "800"
            9 -> lastSpin = "900"
            10 -> lastSpin = "1000"
            else -> lastSpin = "exception"
        }

        _uiState.update { currentState ->
            currentState.copy(
                lastSpin = lastSpin
            )
        }


        _uiState.update { currentState ->
            currentState.copy(
                lastSpinInt = 100 * rndm
            )
        }


        if (rndm == 0) {
            _uiState.update { currentState ->
                currentState.copy(
                    points = 0,
                )
            }
        }
    }

    fun setFalse() {
        _uiState.update { currentState ->
            currentState.copy(
                wonGame = false,
                lostGame = false
            )
        }
    }
}


