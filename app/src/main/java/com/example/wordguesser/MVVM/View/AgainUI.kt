package com.example.wordguesser.MVVM.View

import android.icu.text.IDNA.Info
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.res.stringResource
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
import com.example.wordguesser.R

@Preview(showBackground = true)
@Composable
fun AgainLostGameUIPreciew() {
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
            text = stringResource(id = R.string.youvelost),
            color = Color(0xFFFFD985),
            fontSize = 55.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif
        )

        Text(
            text = stringResource(id = R.string.Points) + ": ${uiState.points}\n" +
                    stringResource(id = R.string.word) + ": ${uiState.chosenWord.word}",
            color = Color(0xFFFFD985),
            fontSize = 30.sp,
            fontWeight = FontWeight.ExtraBold,
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
                backgroundColor = Color(0xFFDCF9D7),
                contentColor = Color(0xFF054A75)
            ),
            modifier = Modifier.size(175.dp, 50.dp),
            shape = RoundedCornerShape(size = 10.dp),
        )
        {
            Text(
                text = stringResource(id = R.string.Playagain),
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
            text = stringResource(id = R.string.youvewon),
            color = Color(0xFFF3FCF2),
            fontSize = 60.sp,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.Serif,
            textAlign = TextAlign.Center
        )

        Text(
            text = stringResource(id = R.string.Points) + ": ${uiState.points}\n" +
                    stringResource(id = R.string.word) + ": ${uiState.chosenWord.word}\n" +
                    stringResource(id = R.string.Lives) + ": ${uiState.lives}",
            color = Color(0xFFF3FCF2),
            fontSize = 30.sp,
            fontWeight = FontWeight.ExtraBold,
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
                backgroundColor = Color(0xFFDCF9D7),
                contentColor = Color(0xFF054A75)
            ),
            shape = RoundedCornerShape(size = 10.dp),
            modifier = Modifier.size(175.dp, 50.dp)
        )
        {
            Text(
                text = stringResource(id = R.string.Playagain),
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif,
                fontSize = 20.sp
            )
        }
    }
}