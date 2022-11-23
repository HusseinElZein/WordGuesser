package com.example.wordguesser.MVVM.View

import android.annotation.SuppressLint
import android.content.SharedPreferences
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.wordguesser.Components.*
import com.example.wordguesser.MVVM.ViewModel.InfoViewModel
import com.example.wordguesser.MVVM.ViewModel.MainGameViewModel
import com.example.wordguesser.Navigation.Screen

@Composable
fun MainGameUI(
    navController: NavHostController,
    viewModel: MainGameViewModel = viewModel(),
    infoViewModel: InfoViewModel
) {
    InitialStartBackground()

    val uiState by viewModel.uiState.collectAsState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.size(20.dp))
        Table(points = uiState.points, lives = uiState.lives)

        Spacer(modifier = Modifier.size(80.dp))
        BuildWord(word = uiState.chosenWord)
        ShowCategory(category = uiState.chosenWord.category)
        Spacer(modifier = Modifier.size(240.dp))
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 30.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            ShowSpin(spin = uiState.lastSpin)
            PressForSpin({ viewModel.onSpinWheel() }, uiState.hasToSpin)
        }
        Spacer(modifier = Modifier.height(18.dp))
        CreateKeyboard(viewModel, uiState.hasToSpin)
    }

    if (uiState.lostGame){
        viewModel.setFalse()
        infoViewModel.updateInfo(viewModel.uiState.value)
        navController.navigate(Screen.againLostScreen.route)
    }

    if(uiState.wonGame){
        viewModel.setFalse()
        infoViewModel.updateInfo(viewModel.uiState.value)
        navController.navigate(Screen.againWonScreen.route)
    }


}


@Preview(showBackground = true)
@Composable
fun PreviewMainGameUI() {
    MainGameUI(navController = rememberNavController(), infoViewModel = InfoViewModel())
}