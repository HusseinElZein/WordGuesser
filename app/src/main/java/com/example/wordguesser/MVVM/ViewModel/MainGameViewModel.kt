package com.example.wordguesser.MVVM.ViewModel

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import com.example.wordguesser.MVVM.Model.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class MainGameViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    /**Whenever player/user starts a new game*/
    fun onStartGame() {
        uiState.value.chosenWord = BuildWordList().getWordList().random()
    }

    /**Whenever player/user presses a letter on the keyboard*/
    fun onPressedKeyboardLetter(letterClicked: String, existsInWord: MutableState<Boolean>) {
        if (_uiState.value.chosenWord.word.contains(letterClicked.lowercase())) {
            var foundCounter = 0
            for (letter in _uiState.value.chosenWord.letters) {
                if (!letter.isFound.value && letter.letter == letterClicked.lowercase()) {
                    foundCounter++
                    letter.isFound.value = true
                    existsInWord.value = true
                }
            }
        }
    }

    /**Whenever player/user on spin wheel to get a random number*/
    fun onSpinWheel() {

        //Log.d("you", "have just spun the wheel, before changing: ${lastSpin.value}")

        val rnds = (0..10).random()

        var lastSpin = ""

        when (rnds) {
            0 -> lastSpin = "Bankrupt"
            1 -> lastSpin = "1000"
            2 -> lastSpin = "500"
            3 -> lastSpin = "600"
            4 -> lastSpin = "700"
            5 -> lastSpin = "800"
            6 -> lastSpin = "900"
            7 -> lastSpin = "100"
            8 -> lastSpin = "200"
            9 -> lastSpin = "300"
            10 -> lastSpin = "400"
            else -> lastSpin = "exception"
        }

        _uiState.update { currentState ->
            currentState.copy(
                lastSpin = lastSpin
            )

            //Log.d("you", "spun ${lastSpin")
        }
    }
}
