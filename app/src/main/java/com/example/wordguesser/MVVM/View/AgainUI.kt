package com.example.wordguesser.MVVM.View

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import com.example.wordguesser.Navigation.Screen

@Composable
fun AgainLostGameUI(navController: NavHostController) {

    InitialStartBackground()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        Text(
            text = "You've lost :(",
            color = Color(0xFFFC5656),
            fontSize = 55.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif
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
fun AgainWoneGameUI(navController: NavHostController) {
    InitialStartBackground()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Congrats! You've wone!",
            color = Color(0xFF56D672),
            fontSize = 60.sp,
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