package com.example.wordguesser.Navigation

sealed class Screen(val route: String) {
    object StartScreen : Screen(route = "startscreen")
    object gameScreen : Screen(route = "gamescreen")
    object againLostScreen : Screen(route = "againlostscreen")
    object againWonScreen : Screen(route = "againwonscreen")
    object PauseScreen : Screen(route = "pausescreen")
}
