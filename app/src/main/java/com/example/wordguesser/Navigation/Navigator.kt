package com.example.wordguesser.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.wordguesser.MVVM.View.*
import com.example.wordguesser.MVVM.ViewModel.InfoViewModel


@Composable
fun NavigatorSetup() {

    val navController = rememberNavController()
    val infoViewModel = InfoViewModel()

    NavHost(navController = navController, startDestination = Screen.StartScreen.route){
        composable(Screen.gameScreen.route){
            MainGameUI(navController, infoViewModel = infoViewModel)
        }
        composable(Screen.StartScreen.route){
            StartGameUI(navController)
        }
        composable(Screen.againLostScreen.route){
            AgainLostGameUI(navController = navController, infoViewModel)
        }
        composable(Screen.againWoneScreen.route){
            AgainWoneGameUI(navController = navController, infoViewModel)
        }
    }

}