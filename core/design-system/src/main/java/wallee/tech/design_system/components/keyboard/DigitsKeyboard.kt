package wallee.tech.design_system.components.keyboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import wallee.tech.presentation.EMPTY_STRING
import wallee.tech.presentation.GRID_CELLS_3
import wallee.tech.ui_kit.R as UiKit
import wallee.tech.design_system.R as DesignSystem
import wallee.tech.ui_kit.ui.dimens.size_16
import wallee.tech.ui_kit.ui.theme.WalleeColors
import wallee.tech.ui_kit.ui.theme.WalleeTextStyle

@Composable
fun DigitsKeyboard(
    withRemoveButton: Boolean = false,
    onRemovePress: () -> Unit = {},
    onDigitPress: (String) -> Unit,
    onEnterPress: () -> Unit,
) {
    val digitsRow = listOf(
        stringResource(DesignSystem.string.one_title),
        stringResource(DesignSystem.string.two_title),
        stringResource(DesignSystem.string.three_title),
        stringResource(DesignSystem.string.four_title),
        stringResource(DesignSystem.string.five_title),
        stringResource(DesignSystem.string.six_title),
        stringResource(DesignSystem.string.seven_title),
        stringResource(DesignSystem.string.eight_title),
        stringResource(DesignSystem.string.nine_title),
        EMPTY_STRING,
        stringResource(DesignSystem.string.zero_title),
        stringResource(DesignSystem.string.ok_title),
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(GRID_CELLS_3),
        modifier = Modifier
            .fillMaxWidth()
            .background(WalleeColors.Secondary)
            .padding(horizontal = size_16)
            .aspectRatio(1f),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalArrangement = Arrangement.SpaceEvenly,
    ) {
        items(digitsRow.size) { index ->
            when (val currentElement = digitsRow[index]) {
                "" ->
                    KeyboardButton(
                        title = currentElement,
                        isRemove = withRemoveButton,
                        onClick = { onRemovePress() }
                    )

                stringResource(DesignSystem.string.ok_title) ->
                    KeyboardButton(
                        title = currentElement,
                        isButton = true,
                        onClick = { onEnterPress() }
                    )

                else -> KeyboardButton(
                    title = currentElement,
                    onClick = { onDigitPress(currentElement) })
            }

        }
    }
}

@Composable
private fun KeyboardButton(
    title: String,
    isRemove: Boolean = false,
    isButton: Boolean = false,
    onClick: () -> Unit
) {
    Button(
        shape = MaterialTheme.shapes.medium,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isButton) WalleeColors.Submit else WalleeColors.Ghost
        ),
        onClick = onClick,
        content = {
            if (!isRemove)
                Text(
                    text = title,
                    style = WalleeTextStyle.text4Xl,
                    color = if (isButton) WalleeColors.White else WalleeColors.Tertiary,
                    textAlign = TextAlign.Center
                )
            else
                Icon(
                    painter = painterResource(UiKit.drawable.baseline_backspace_24),
                    tint = WalleeColors.Tertiary,
                    contentDescription = null
                )
        }
    )
}
