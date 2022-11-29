package com.example.wordguesser.MVVM.View

import android.icu.text.IDNA.Info
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.wordguesser.Components.InitialStartBackground
import com.example.wordguesser.MVVM.ViewModel.InfoViewModel
import com.example.wordguesser.MVVM.ViewModel.MainGameViewModel
import com.example.wordguesser.Navigation.Screen

@Preview(showBackground = true)
@Composable
fun AgainLostGameUIPreciew(){
    AgainWonGameUI(navController = rememberNavController(), viewModel = InfoViewModel())
}

@Composable
fun AgainLostGameUI(
    navController: NavHostController,
    viewModel: InfoViewModel
) {

    val uiState by viewModel.uiState.collectAsState()

    InitialStartBackground()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "You've lost :(",
            color = Color(0xFFE48484),
            fontSize = 55.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif
        )

        Text(
            text = "Points: ${uiState.points}\n" +
                    "word: ${uiState.chosenWord.word}",
            color = Color(0xFFE08585),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif,
            textAlign = TextAlign.Center
        )



        Spacer(modifier = Modifier.size(40.dp))

        Button(
            onClick = {
                navController.popBackStack()
                navController.popBackStack()
                navController.navigate(Screen.gameScreen.route)
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFFB9AC82),
                contentColor = Color.White
            ),
            modifier = Modifier.size(175.dp, 50.dp)
        )
        {
            Text(
                text = "Play again",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif,
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun AgainWonGameUI(
    navController: NavHostController,
    viewModel: InfoViewModel
) {
    val uiState by viewModel.uiState.collectAsState()

    InitialStartBackground()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Congrats! You've won!",
            color = Color(0xFF7CBE8A),
            fontSize = 60.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif,
            textAlign = TextAlign.Center
        )

        Text(
            text = "Points: ${uiState.points}\n" +
                    "Word: ${uiState.chosenWord.word}\n" +
                    "Lives: ${uiState.lives}",
            color = Color(0xFF56AC69),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.size(40.dp))

        Button(
            onClick = {
                navController.popBackStack()
                navController.popBackStack()
                navController.navigate(Screen.gameScreen.route)
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFFB9AC82),
                contentColor = Color.White
            ),
            modifier = Modifier.size(175.dp, 50.dp)
        )
        {
            Text(
                text = "Play again",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif,
                fontSize = 20.sp
            )
        }
    }
}