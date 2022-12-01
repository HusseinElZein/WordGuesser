package com.example.wordguesser.MVVM.View

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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
import com.example.wordguesser.Navigation.Screen
import com.example.wordguesser.R

@Composable
fun StartGameUI(navController: NavHostController) {

    InitialStartBackground()

    val infiniteTransition = rememberInfiniteTransition()
    val angle by infiniteTransition.animateFloat(
        initialValue = 0F,
        targetValue = 360F,
        animationSpec = infiniteRepeatable(
            animation = tween(10000, easing = LinearEasing)
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 85.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = stringResource(id = R.string.lykkehjulet),
            color = Color(0xFFFFFFFF),
            fontSize = 50.sp,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.Serif,
            textAlign = TextAlign.Center
        )
        Text(
            text = stringResource(id = R.string.myname),
            color = Color(0xFFD8F3FF),
            fontSize = 15.sp,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = FontFamily.Serif,
            textAlign = TextAlign.Start
        )

        Spacer(modifier = Modifier.size(250.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {


            Image(
                painter = painterResource(id = R.drawable.circle),
                contentDescription = "",
                modifier = Modifier
                    .rotate(angle)
                    .size(60.dp)
            )

            Spacer(modifier = Modifier.size(5.dp))

            Button(
                onClick = { navController.navigate(Screen.gameScreen.route) },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFDCF9D7)),
                modifier = Modifier.size(250.dp, 50.dp),
                shape = RoundedCornerShape(100)
            )
            {
                Text(
                    text = stringResource(id = R.string.Launchgame),
                    color = Color(0xFF054A75),
                    fontSize = 23.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif,
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.size(5.dp))

            Image(
                painter = painterResource(id = R.drawable.circle),
                contentDescription = "",
                modifier = Modifier
                    .rotate(angle)
                    .size(60.dp)
            )

        }


    }


}

@Preview(showBackground = true)
@Composable
fun StartGameUIScreenPreview() {
    StartGameUI(navController = rememberNavController())
}