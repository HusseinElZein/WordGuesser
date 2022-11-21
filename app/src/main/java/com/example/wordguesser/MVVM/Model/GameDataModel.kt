package com.example.wordguesser.MVVM.Model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

class GameDataModel {
    //writing categories and each word into each category
    var word = Word("Religion", "abcdefghijklmnopqrstuvwxyzaeoeaa")

    //Getting a random Word:
    fun getRandomWord(): Word {
        return word
    }
}

class Word(
    val category: String,
    val word: String,
    var letters: MutableList<Letter> = emptyList<Letter>().toMutableList()
) {
    init {
        for (i in 0..word.length - 1){
            letters.add(Letter(word.get(i).toString()))
        }
    }
}

class Letter(
    var letter: String,
    var isFound: MutableState<Boolean> = mutableStateOf(false)
)


/**A test*/
fun main() {
    var game = GameDataModel()
}

