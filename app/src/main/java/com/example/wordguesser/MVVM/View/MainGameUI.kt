package com.example.wordguesser.MVVM.View

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.wordguesser.Components.*
import com.example.wordguesser.MVVM.ViewModel.MainGameViewModel

@SuppressLint("UnrememberedMutableState")
@Composable
fun MainGameUI(
    navController: NavHostController,
    mainGameViewModel: MainGameViewModel = MainGameViewModel()
) {
    InitialStartBackground()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        mainGameViewModel.onStartGame()

        Spacer(modifier = Modifier.size(100.dp))
        BuildWord(word = mainGameViewModel.chosenWord)
        ShowCategory(category = mainGameViewModel.chosenWord.category)
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
            ShowSpin(spin = mainGameViewModel.lastSpin.value)
            PressForSpin { mainGameViewModel.onSpinWheel() }
        }
        Spacer(modifier = Modifier.height(18.dp))

        CreateKeyboard(mainGameViewModel)
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewMainGameUI() {
    MainGameUI(navController = rememberNavController())
}