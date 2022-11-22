package com.example.wordguesser.Components

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wordguesser.MVVM.Model.Word
import com.example.wordguesser.MVVM.ViewModel.MainGameViewModel
import com.example.wordguesser.R

@Composable
fun InitialStartBackground() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .size(size = 300.dp)
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF858585),
                        Color(0xFFB2BFAF)
                    )
                )
            )
    )
}

/**
 * This is for whenever i want to use a letter, that is building up a word*/
@Composable
fun Letter(letter: String) {
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BuildWord(word: Word) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(9),
        content = {

            itemsIndexed(word.letters) { index, letter ->
                val foundWord by remember { mutableStateOf(letter) }
                if (foundWord.isFound.value) Letter(letter.letter) else Letter("")
            }
        },
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 10.dp),
        verticalArrangement = Arrangement.spacedBy(3.dp),
        horizontalArrangement = Arrangement.spacedBy(3.dp),

        )
}

@Preview
@Composable
fun BuildWordTest() {
    val word = Word("Animal", "123456789112")
    BuildWord(word = word)
}

/**
 * This is for whenever the user/player presses a letter on the keyboard*/

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LetterForKeyboard(
    letter: String,
    onClick: () -> Unit,
    bgColor: MutableState<Color> = mutableStateOf(Color.LightGray),
    isClicked: Boolean = false,
    hasToSpin: Boolean
) {
    Surface(
        modifier = Modifier.size(35.dp, 45.dp),
        color = bgColor.value,
        shape = RoundedCornerShape(size = 8.dp),
        indication = if(!isClicked && !hasToSpin) rememberRipple() else null,
        onClick = if (!isClicked && !hasToSpin) onClick else {
            {}
        }
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = letter,
                color = if(!hasToSpin) Color.Black else Color.LightGray,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif
            )
        }
    }
}


@Composable
fun CreateKeyboard(
    mainGameViewModel: MainGameViewModel,
    hasToSpin: Boolean
) {
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
                    val hasClickedLetter = remember { mutableStateOf(false) }
                    val letterExistsInWord = remember { mutableStateOf(false) }

                    val trueColor =
                        if (hasClickedLetter.value && letterExistsInWord.value) remember {
                            mutableStateOf(
                                Color.Green
                            )
                        }
                        else if (hasClickedLetter.value && !letterExistsInWord.value) remember {
                            mutableStateOf(
                                Color.Red
                            )
                        } else {
                            remember { mutableStateOf(Color.LightGray) }
                        }

                    LetterForKeyboard(
                        letter = keyRow.get(i).toString(),
                        onClick = {
                            hasClickedLetter.value = true
                            mainGameViewModel.onPressedKeyboardLetter(
                                keyRow.get(i).toString(),
                                letterExistsInWord
                            )
                        },
                        bgColor = trueColor,
                        isClicked = hasClickedLetter.value,
                        hasToSpin = hasToSpin
                    )
                    Spacer(modifier = Modifier.size(3.dp))
                }
            }
            Spacer(modifier = Modifier.size(5.dp))
        }
    }
}

@Preview
@Composable
fun CreateKeyboardPreview(){
    CreateKeyboard(mainGameViewModel = MainGameViewModel(), hasToSpin = true)
}



@Composable
fun ShowCategory(category: String) {
    Text(
        text = "Category: $category",
        color = Color.Black,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Serif
    )
}

@Preview
@Composable
fun showCategoryPreview() {
    ShowCategory(category = "Religion")
}

@Composable
fun ShowSpin(spin: String) {

    Surface(
        color = Color(0xFFB9AC82),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.size(width = 140.dp, 42.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = spin,
                color = Color.Black,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Cursive
            )
        }
    }
}

@Preview
@Composable
fun ShowSpinPreview() {
    ShowSpin("1000")
}

@Composable
fun PressForSpin(onClick: () -> Unit, hasToSpin: Boolean) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            contentColor = Color(0xFFAC8923),
            backgroundColor = Color(0xFFFFDD77),
        ),
        enabled = hasToSpin
    ) {
        Text(
            text = "Spin", fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif
        )
    }
}

@Preview
@Composable
fun PressForSpinPreview() {
    PressForSpin ({}, true)
}

@Composable
fun InsertHearts(lives: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        for (i in 0..lives - 1) {
            Image(
                painter = painterResource(id = R.drawable.heart),
                contentDescription = "",
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(1.dp))
        }
    }
}

@Preview
@Composable
fun InsertHeartsPreview() {
    InsertHearts(lives = 5)
}

@Composable
fun ShowPoints(points: Int) {
    Text(
        text = "Points: $points",
        fontSize = 17.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Serif,
        color = Color.White
    )
}

@Preview
@Composable
fun ShowActualPointsPreview() {
    ShowPoints(200)
}

@Composable
fun Table(points: Int, lives: Int) {
    Surface(
        modifier = Modifier
            .height(46.dp)
            .width(220.dp),
        color = Color(0xFF707070),
        shape = RoundedCornerShape(size = 3.dp),
    ) {
        Column(modifier = Modifier.padding(start = 10.dp)) {
            ShowPoints(points = points)
        }
        Column(modifier = Modifier
            .padding(start = 105.dp)
            .padding(top = 18.dp)) {
            InsertHearts(lives = lives)
        }
    }
}

@Preview
@Composable
fun TablePreview() {
    Table(points = 200, lives = 5)
}