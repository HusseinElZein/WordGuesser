package com.example.wordguesser.MVVM.Model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class GameUiState(
    var chosenWord: Word = Word(),
    var lives: Int = 5,
    var lastSpin: String = "",
    var lastSpinInt: Int = 0,
    var points: Int = 0,
    var guessedLetters: Int = 0,
    var hasToSpin: Boolean = true,
    var lostGame: Boolean = false,
    var wonGame: Boolean = false
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
            Word("Religion", "thespaghettimonster"),
            Word("Religion", "hinduism"),

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
            Word("Country", "ecuador"),
            Word("Country", "algeria"),

            Word("Animal", "cat"),
            Word("Animal", "dog"),
            Word("Animal", "snake"),
            Word("Animal", "bird"),
            Word("Animal", "lion"),
            Word("Animal", "tiger"),
            Word("Animal", "panda"),
            Word("Animal", "fish"),

            Word("Rapper", "tupac"),
            Word("Rapper", "gilli"),
            Word("Rapper", "popsmoke"),
            Word("Long real word", "dilinoleoylphosphatidylcholinec"),
            Word("Long real word", "dimyristoylphosphatidylcholine"),
            Word("Long real word", "hexakosioihexekontahexaphobics"),
            Word("Long real word", "pharyngolaryngoesophagectomies"),
            Word("Long real word", "pseudopseudohypoparathyroidism"),
            Word("Long real word", "quinquagintaquadringentilliard")
        )
    }
}