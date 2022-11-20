package com.example.wordguesser.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.wordguesser.MVVM.View.MainGameUI


@Composable
fun NavigatorSetup() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "MainGameUI"){
        composable("MainGameUI"){
            MainGameUI(navController)
        }
    }

}