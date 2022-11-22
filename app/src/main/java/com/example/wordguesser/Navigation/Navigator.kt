package com.example.wordguesser.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.wordguesser.MVVM.View.*


@Composable
fun NavigatorSetup() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.StartScreen.route){
        composable(Screen.gameScreen.route){
            MainGameUI(navController)
        }
        composable(Screen.StartScreen.route){
            StartGameUI(navController)
        }
        composable(Screen.againLostScreen.route){
            AgainLostGameUI(navController = navController)
        }
        composable(Screen.againWoneScreen.route){
            AgainWoneGameUI(navController = navController)
        }
    }

}