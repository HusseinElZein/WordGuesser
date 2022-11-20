package com.example.wordguesser.Components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InitialStartBackground() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .size(size = 300.dp)
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFD2D2D2),
                        Color(0xFFB2BFAF)
                    )
                )
            )
    )
}

/**
 * This is for whenever i want to use a letter, that is building up a word*/
@Composable
fun letter(letter: String) {
    Surface(
        modifier = Modifier.size(30.dp, 40.dp),
        color = Color.LightGray,
        shape = RoundedCornerShape(size = 8.dp),
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = letter,
                color = Color.Black,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif
            )
        }
    }
}


@Composable
fun LetterPreview() {
    letter("?")
}


/**
 * This is for whenever the user/player presses a letter on the keyboard*/
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LetterForKeyboard(
    letter: String,
    onClick: () -> Unit
) {
    Surface(
        modifier = Modifier.size(35.dp, 45.dp),
        color = Color.LightGray,
        shape = RoundedCornerShape(size = 8.dp),
        onClick = onClick,
        indication = rememberRipple()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = letter,
                color = Color.Black,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif
            )
        }
    }
}

@Preview
@Composable
fun CreateKeyboard() {
    val keyboardFirstRow = "QWERTYUIOP"
    val keyboardSecondRow = "ASDFGHJKL"
    val keyboardThirdRow = "ZXCVBNM"

    val keyboardArray = arrayOf(keyboardFirstRow, keyboardSecondRow, keyboardThirdRow)

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        for (keyRow in keyboardArray) {

            Row() {
                for (i in 0..keyRow.length - 1) {
                    LetterForKeyboard(
                        letter = keyRow.get(i).toString(),
                        onClick = {Log.d("dinfar", keyRow.get(i).toString())}
                    )
                    Spacer(modifier = Modifier.size(3.dp))
                }
            }
            Spacer(modifier = Modifier.size(5.dp))
        }
    }
}

