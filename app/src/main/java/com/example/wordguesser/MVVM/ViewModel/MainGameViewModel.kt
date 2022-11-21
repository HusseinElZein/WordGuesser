package com.example.wordguesser.MVVM.ViewModel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.wordguesser.MVVM.Model.GameDataModel
import com.example.wordguesser.MVVM.Model.Letter
import com.example.wordguesser.MVVM.Model.Word


class MainGameViewModel : ViewModel() {
    private val _chosenWord = mutableStateOf("")
    private val _chosenCategory = mutableStateOf("")
    private var _listOfLetters = emptyList<Letter>().toMutableList()
    private val _lives = mutableStateOf(5)
    private val _lastSpin = mutableStateOf("")
    val lastSpin: State<String> = _lastSpin
    private val _gameDataModel = mutableStateOf(GameDataModel())

    val chosenWord: Word = _gameDataModel.value.word

    /**Whenever player/user starts a new game*/
    fun onStartGame() {
        _lives.value = 5
        val chosenWord = _gameDataModel.value.getRandomWord()
        _chosenCategory.value = chosenWord.category
        _chosenWord.value = chosenWord.word
        _listOfLetters = chosenWord.letters
    }

    /**Whenever player/user presses a letter on the keyboard*/
    fun onPressedKeyboardLetter(letterClicked: String, existsInWord: MutableState<Boolean>) {
        if (_chosenWord.value.contains(letterClicked.lowercase())) {
            var foundCounter = 0
            for (letter in _gameDataModel.value.word.letters) {
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

        Log.d("you" ,"have just spun the wheel")

        val rnds = (0..10).random()

        when (rnds) {
            0 -> _lastSpin.value = "Bankrupt"
            1 -> _lastSpin.value = "1000"
            2 -> _lastSpin.value = "500"
            3 -> _lastSpin.value = "600"
            4 -> _lastSpin.value = "700"
            5 -> _lastSpin.value = "800"
            6 -> _lastSpin.value = "900"
            7 -> _lastSpin.value = "100"
            8 -> _lastSpin.value = "200"
            9 -> _lastSpin.value = "300"
            10 -> _lastSpin.value = "400"
            else -> _lastSpin.value = "exception"
        }

        Log.d("you", "spun ${lastSpin.value}")
    }
}
