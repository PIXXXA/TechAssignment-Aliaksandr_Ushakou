package wallee.tech.purchase_impl.presentation.purchase

import androidx.activity.compose.BackHandler
import androidx.annotation.StringRes
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import wallee.tech.design_system.components.keyboard.DigitsKeyboard
import wallee.tech.presentation.extension.convertToAmountFormat
import wallee.tech.purchase_impl.R
import wallee.tech.ui_kit.ui.dimens.size_16
import wallee.tech.ui_kit.ui.dimens.size_2
import wallee.tech.ui_kit.ui.dimens.size_64
import wallee.tech.ui_kit.ui.dimens.size_8
import wallee.tech.ui_kit.ui.theme.WalleeColors
import wallee.tech.ui_kit.ui.theme.WalleeMainTheme
import wallee.tech.ui_kit.ui.theme.WalleeTextStyle

@Composable
internal fun PurchaseScreen(
    screenState: PurchaseState,
    onIntent: (PurchaseIntent) -> Unit,
    exitFlow: () -> Unit
) {
    BackHandler { exitFlow() }

    Column(
        modifier = Modifier
            .padding(WindowInsets.statusBars.asPaddingValues())
            .fillMaxSize()
            .systemBarsPadding()
    ) {
        PurchaseTitleGroup()
        PurchaseAmount(screenState)
        Spacer(Modifier.weight(1f))
        DigitsKeyboard(
            onDigitPress = { onIntent(PurchaseIntent.UpdateAmount(it)) },
            onEnterPress = { onIntent(PurchaseIntent.OnContinueClick) },
            withRemoveButton = false
        )
    }
}

@Composable
private fun PurchaseTitleGroup() {
    Column(modifier = Modifier.padding(top = size_64, bottom = size_16)) {
        BaseTextField(
            label = R.string.purchase_title,
            textStyle = WalleeTextStyle.text4Xl1,
            color = WalleeColors.Primary
        )
        BaseTextField(
            label = R.string.purchase_subtitle,
            textStyle = WalleeTextStyle.textL,
            color = WalleeColors.Tertiary
        )
    }
}

@Composable
private fun PurchaseAmount(screenState: PurchaseState) {
    Box(
        modifier = Modifier
            .padding(size_16)
            .border(size_2, WalleeColors.SecondaryDark, RoundedCornerShape(size_16)),
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(size_8),
            text = screenState.amount.toBigDecimal().convertToAmountFormat(),
            style = WalleeTextStyle.text4Xl1,
            maxLines = 1,
            color = WalleeColors.Primary,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun BaseTextField(
    @StringRes label: Int,
    textStyle: TextStyle,
    color: Color,
) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(size_8),
        text = stringResource(label),
        style = textStyle,
        color = color,
        textAlign = TextAlign.Center
    )
}

@Composable
@Preview
private fun PreviewPurchaseScreen() {
    WalleeMainTheme {
        PurchaseScreen(
            screenState = PurchaseState(),
            onIntent = {},
            exitFlow = {}
        )
    }
}