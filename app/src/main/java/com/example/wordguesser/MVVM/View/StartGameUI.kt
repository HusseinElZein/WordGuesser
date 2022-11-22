package com.example.wordguesser.MVVM.View

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
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
fun StartGameUI(navController: NavHostController) {

    InitialStartBackground()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 85.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Welcome to Lykkehjulet",
            color = Color.White,
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.size(240.dp))

        Button(
            onClick = { navController.navigate(Screen.gameScreen.route) },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFD4A73B1)),
            modifier = Modifier.size(250.dp, 50.dp),
            shape = RoundedCornerShape(100)
        )
        {
            Text(
                text = "Launch game",
                color = Color.White,
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif,
                textAlign = TextAlign.Center
            )
        }

    }


}

@Preview(showBackground = true)
@Composable
fun StartGameUIScreenPreview() {
    StartGameUI(navController = rememberNavController())
}