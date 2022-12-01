package com.example.wordguesser.MVVM.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
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
import com.example.wordguesser.MVVM.ViewModel.InfoViewModel
import com.example.wordguesser.MVVM.ViewModel.MainGameViewModel
import com.example.wordguesser.Navigation.Screen
import com.example.wordguesser.R


@Composable
fun PauseUI(
    navController: NavHostController
) {
    InitialStartBackground()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = R.string.Pausescreen),
            color = Color(0xFFF5F5F5),
            fontSize = 55.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif
        )

        Image(
            painter = painterResource(id = R.drawable.play),
            contentDescription = "",
            modifier = Modifier
                .size(100.dp)
                .padding(
                    start = 15.dp,
                )
                .clickable { navController.popBackStack() },
            colorFilter = ColorFilter.tint(Color(0xFF143600))
        )

        Spacer(modifier = Modifier.size(70.dp))

        Button(
            onClick = {
                navController.popBackStack()
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFFDCF9D7),
                contentColor = Color(0xFF054A75)
            ),
            modifier = Modifier.size(225.dp, 50.dp),
            shape = RoundedCornerShape(size = 10.dp),
        )
        {
            Text(
                text = stringResource(id = R.string.Continueplaying),
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif,
                fontSize = 20.sp
            )
        }

        Spacer(modifier = Modifier.size(40.dp))

        Button(
            onClick = {
                navController.popBackStack()
                navController.popBackStack()
                navController.navigate(Screen.gameScreen.route)
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFFCAE7C5),
                contentColor = Color(0xFF054A75)
            ),
            modifier = Modifier.size(175.dp, 50.dp),
            shape = RoundedCornerShape(size = 10.dp),
        )
        {
            Text(
                text = stringResource(id = R.string.Restart),
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif,
                fontSize = 20.sp
            )
        }

        Spacer(modifier = Modifier.size(40.dp))

        Button(
            onClick = {
                navController.popBackStack()
                navController.popBackStack()
                navController.navigate(Screen.StartScreen.route)
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFFBED8B9),
                contentColor = Color(0xFF054A75)
            ),
            modifier = Modifier.size(175.dp, 50.dp),
            shape = RoundedCornerShape(size = 10.dp),
        )
        {
            Text(
                text = stringResource(id = R.string.Mainmenu),
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif,
                fontSize = 20.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PauseUIPreview() {
    PauseUI(
        navController = rememberNavController()
    )
}