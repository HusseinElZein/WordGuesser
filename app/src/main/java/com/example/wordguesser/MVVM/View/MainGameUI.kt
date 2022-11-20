package com.example.wordguesser.MVVM.View

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.wordguesser.Components.CreateKeyboard
import com.example.wordguesser.Components.InitialStartBackground


@Composable
fun MainGameUI(navController: NavHostController) {
    InitialStartBackground()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.size(570.dp))
        CreateKeyboard()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainGameUI(){
    MainGameUI(navController = rememberNavController())
}