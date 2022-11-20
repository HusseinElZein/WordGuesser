package com.example.wordguesser.MVVM.View

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.wordguesser.Components.BuildWord
import com.example.wordguesser.Components.CreateKeyboard
import com.example.wordguesser.Components.InitialStartBackground
import com.example.wordguesser.Components.ShowCategory
import com.example.wordguesser.MVVM.Model.main
import com.example.wordguesser.MVVM.ViewModel.MainGameViewModel

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

        Spacer(modifier = Modifier.size(200.dp))
        BuildWord(word = mainGameViewModel.chosenWord)
        ShowCategory(category = mainGameViewModel.chosenWord.category)
        
        Spacer(modifier = Modifier.size(330.dp))
        CreateKeyboard(mainGameViewModel)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainGameUI() {
    MainGameUI(navController = rememberNavController())
}