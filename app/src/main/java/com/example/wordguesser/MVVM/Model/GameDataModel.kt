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
    var wonGame: Boolean = false,
    var gameStarted: Boolean = false,
    var reached: Int = 0,
    var keyLetters: MutableList<KeyLetter> = emptyList<KeyLetter>().toMutableList()
)

class Word(
    val category: String = "",
    val word: String = "",
    var letters: MutableList<Letter> = emptyList<Letter>().toMutableList()
) {
    init {
        for (i in 0..word.length - 1) {
            letters.add(Letter(word.get(i).toString()))
        }
    }
}

class Letter(
    var letter: String,
    var isFound: MutableState<Boolean> = mutableStateOf(false)
)

class KeyLetter(
    var isFoundInWord: MutableState<Boolean> = mutableStateOf(false),
    var isClicked: MutableState<Boolean> = mutableStateOf(false)
)

class BuildWordList() {
    fun getWordList(): List<Word> {
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
            Word("Car", "mercedes"),
            Word("Car", "bmw"),
            Word("Car", "volvo"),
            Word("Car", "saab"),
            Word("Car", "mini"),
            Word("Car", "fiat"),
            Word("Car", "lotus"),
            Word("Car", "lexus"),
            Word("Car", "bentley"),
            Word("Car", "bughatti"),
            Word("Car", "alfaromeo"),
            Word("Car", "landrover"),
            Word("Car", "porsche"),
            Word("Car", "maserati"),
            Word("Car", "opel"),


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
            Word("Animal", "rhino"),
            Word("Animal", "elephant"),
            Word("Animal", "goat"),
            Word("Animal", "donkey"),

            Word("Rapper", "tupac"),
            Word("Rapper", "gilli"),
            Word("Rapper", "popsmoke"),

            Word("Actor", "jenniferlawrence"),
            Word("Actor/Singer", "selenagomez"),
            Word("Comedian", "davechapelle"),
            Word("Comedian", "kevinhart"),


            Word("Long real word", "pseudopseudohypoparathyroidism"),
            Word("Sport", "football"),
            Word("Sport", "soccer"),
            Word("Sport", "tennis"),
            Word("Sport", "swimming"),
            Word("Sport", "football"),
            Word("Sport", "basketball"),
            Word("Sport", "hockey"),
            Word("Sport", "badminton"),

            Word("Game", "supermariobros"),
            Word("Game", "fifa"),
            Word("Game", "valorant"),
            Word("Game", "counterstrikeglobaloffensive"),
            Word("Game", "grandtheftautosanandreas"),
            Word("Game", "callofdutymodernwarfarethree"),
            Word("Game", "leagueoflegends"),

            Word("Historical event", "worldwartwo"),
            Word("Historical event", "worldwarone"),
            Word("Historical event", "medievalperiod"),
            Word("Historical event", "roman"),
            Word("Historical event", "modernperiod"),

            Word("Super hero", "theflash"),
            Word("Super hero", "theamazingspiderman"),
            Word("Super hero", "superman"),
            Word("Super hero", "batman"),
            Word("Super hero", "wonderwoman"),
            Word("Super hero", "captainamerica"),
            Word("Super hero", "batman"),

            Word("Food", "lasagna"),
            Word("Food", "bread"),
            Word("Food", "shawarma"),
            Word("Food", "pizza"),
            Word("Food", "cheese"),
            Word("Food", "banana"),
            Word("Food", "rice"),

            Word("Food brand", "oreo"),
            Word("Food brand", "lays"),
            Word("Food brand", "pringles"),
            Word("Food brand", "nestle"),
            Word("Food brand", "snickers"),
            Word("Food brand", "galaxy"),
            Word("Food brand", "lipton"),
            Word("Food brand", "mcdonalds"),
            Word("Food brand", "dunkindonuts"),
            Word("Food brand", "wendys"),
            Word("Food brand", "target"),
            Word("Food brand", "subway"),
            Word("Food brand", "benandjerrys"),
            Word("Food brand", "dominos"),
            Word("Food brand", "burgerking"),
            Word("Food brand", "pizzahut"),
            Word("Food brand", "tacobell"),
            Word("Food brand", "droetker"),
        )
    }
}