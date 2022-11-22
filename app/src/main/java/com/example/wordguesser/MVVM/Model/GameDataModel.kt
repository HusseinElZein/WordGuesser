package com.example.wordguesser.MVVM.Model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class GameUiState(
    var chosenWord: Word = Word(),
    var lives: Int = 5,
    var lastSpin: String = "",
)

class Word(
    val category: String = "",
    val word: String = "",
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

class BuildWordList(){

    fun getWordList(): List<Word>{
        return listOf(
            Word("Religion", "islam"),
            Word("Religion", "christianity"),
            Word("Religion", "sikhism"),
            Word("Religion", "judaism"),

            Word("Car", "lamborghini"),
            Word("Car", "ferrari"),
            Word("Car", "toyota"),
            Word("Car", "skoda"),
            Word("Car", "citroen"),
            Word("Car", "cadillac"),
            Word("Car", "lamborghini"),

            Word("Country", "spain"),
            Word("Country", "denmark"),
            Word("Country", "ecuador"),
            Word("Country", "sweden"),
            Word("Country", "theunitedstatesofamerica"),
        )
    }

    fun getRandomWord(int: Int): Word{
        val rnds = (0..int - 1).random()
        return getWordList()[rnds]
    }
}