package com.example.wordguesser.MVVM.ViewModel

import android.util.Log
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
    private val lastSpin = mutableStateOf("0")
    private val _gameDataModel = mutableStateOf(GameDataModel())

    val chosenWord: Word = _gameDataModel.value.word


    /**Whenever player/user starts a new game*/
    fun onStartGame(){
        var chosenWord = _gameDataModel.value.getRandomWord()
        _chosenCategory.value = chosenWord.category
        _chosenWord.value = chosenWord.word
        _listOfLetters = chosenWord.letters
    }

    /**Whenever player/user presses a letter on the keyboard*/
    fun onPressedKeyboardLetter(letterClicked: String){
        if(_chosenWord.value.contains(letterClicked.lowercase())){

            var foundCounter = 0
            for (letter in _gameDataModel.value.word.letters){
                if(!letter.isFound.value && letter.letter == letterClicked.lowercase()){
                    Log.d("found", "found one!")
                    foundCounter++
                    letter.isFound.value = true
                }
            }

        }
    }

    fun onSpinWheel(){

    }
}