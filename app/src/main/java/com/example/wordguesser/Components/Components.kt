package com.example.wordguesser.Components

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.wordguesser.MVVM.Model.KeyLetter
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
                        Color(0xFF4FB14E),
                        Color(0xFF009F6B),
                        Color(0xFF008B7C),
                    )
                )
            )
    )
    Image(
        painter = painterResource(id = R.drawable.bground),
        contentDescription = "",
        modifier = Modifier
            .fillMaxSize()
            .blur(4.dp)
            .size(600.dp),
        contentScale = ContentScale.Crop,
        alpha = 0.07f
    )


}

/**
 * This is for whenever i want to use a letter, that is building up a word*/
@Composable
fun Letter(letter: String) {
    Surface(
        modifier = Modifier.size(30.dp, 40.dp),
        color = Color(0xFFDCF9D7),
        shape = RoundedCornerShape(size = 8.dp),
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = letter,
                color = Color(0xFF054A75),
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
        indication = if (!isClicked && !hasToSpin) rememberRipple() else null,
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
                color = if (!hasToSpin) Color(0xFF054A75) else Color(0xFFE4E3D6),
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
    val keyboardFirstRow = stringResource(id = R.string.keyboardFirstRow)
    val keyboardSecondRow = stringResource(id = R.string.keyboardSecondRow)
    val keyboardThirdRow = stringResource(id = R.string.keyboardThirdRow)

    val keyboardArray = arrayOf(keyboardFirstRow, keyboardSecondRow, keyboardThirdRow)

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        for (keyRow in keyboardArray) {

            Row() {
                for (i in 0..keyRow.length - 1) {
                    val keyLetter = remember{mainGameViewModel.newKeyLetter()}
                    val hasClickedLetter = remember { keyLetter.isClicked }
                    val letterExistsInWord = remember { keyLetter.isFoundInWord }

                    val trueColor =
                        if (hasClickedLetter.value && letterExistsInWord.value) remember {
                            mutableStateOf(
                                Color(0xFFB0FFA7)
                            )
                        }
                        else if (hasClickedLetter.value && !letterExistsInWord.value) remember {
                            mutableStateOf(
                                Color(0xFFF97825)
                            )
                        } else {
                            remember { mutableStateOf(Color(0xFFD8F3FF)) }
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
fun CreateKeyboardPreview() {
    CreateKeyboard(mainGameViewModel = MainGameViewModel(), hasToSpin = true)
}

@Composable
fun ShowCategory(category: String) {
    Text(
        text = stringResource(id = R.string.Category)+": $category",
        color = Color(0xFF003400),
        fontSize = 20.sp,
        fontWeight = FontWeight.ExtraBold,
        fontFamily = FontFamily.Serif
    )
}

@Preview
@Composable
fun ShowCategoryPreview() {
    ShowCategory(category = "Religion")
}

@Composable
fun ShowSpin(spin: String, onClick: () -> Unit, hasToSpin: Boolean) {

    Surface(
        color = Color.Transparent,
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.size(width = 100.dp, 100.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            SeeCircle(onClick, hasToSpin)
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = spin,
                color = Color(0xFF000000),
                fontSize = 23.sp,
                fontWeight = FontWeight.ExtraBold,
                //fontFamily = FontFamily.Cursive
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = spin,
                color = Color(0xFFFFFFFF),
                fontSize = 24.sp,
                fontWeight = FontWeight.ExtraBold,
                //fontFamily = FontFamily.Cursive,
            )
        }
    }
}

@Preview
@Composable
fun ShowSpinPreview() {
    ShowSpin("1000", {}, true)
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
                modifier = Modifier.size(20.dp),
                colorFilter = ColorFilter.tint(Color(0xFFE73E0B))
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
        text = stringResource(id = R.string.Points)+": $points",
        fontSize = 17.sp,
        fontWeight = FontWeight.ExtraBold,
        fontFamily = FontFamily.Serif,
        color = Color(0xFF054A75)
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
        color = Color(0xFFDCF9D7),
        shape = RoundedCornerShape(size = 10.dp),
    ) {
        Column(modifier = Modifier.padding(start = 10.dp)) {
            ShowPoints(points = points)
        }
        Column(
            modifier = Modifier
                .padding(start = 105.dp)
                .padding(top = 18.dp)
        ) {
            InsertHearts(lives = lives)
        }
    }
}

@Preview
@Composable
fun TablePreview() {
    Table(points = 200, lives = 5)
}


@Composable
fun SeeCircle(onClick: () -> Unit, hasToSpin: Boolean) {

    var float by remember { mutableStateOf(0f) }
    val angle by animateFloatAsState(
        targetValue = float,
        animationSpec = tween(durationMillis = 1000)
    )

    Image(
        painter = painterResource(id = R.drawable.circle),
        contentDescription = "",
        modifier = Modifier
            .rotate(angle)
            .size(160.dp)
            .clickable(indication = null, interactionSource = MutableInteractionSource()) {
                if (hasToSpin) {
                    val rnds = (0..10).random()
                    float += 2160 + 11 * rnds
                    onClick.invoke()
                }
            },
    )
}


@Composable
fun PauseButton(onClick: () -> Unit) {
    Image(
        painter = painterResource(id = R.drawable.pause),
        contentDescription = "",
        modifier = Modifier
            .size(50.dp)
            .padding(
                start = 15.dp,
            )
            .clickable { onClick.invoke() },
        colorFilter = ColorFilter.tint(Color(0xFF143600))
    )
}