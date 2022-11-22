package com.example.wordguesser.Navigation

sealed class Screen(val route: String) {
    object StartScreen : Screen(route = "startscreen")
    object gameScreen : Screen(route = "gamescreen")
    object againLostScreen : Screen(route = "againlostscreen")
    object againWoneScreen : Screen(route = "againwonescreen")
}
