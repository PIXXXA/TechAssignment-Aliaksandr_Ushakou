package wallee.tech.purchase_impl.presentation.receipt

import androidx.activity.compose.BackHandler
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import wallee.tech.design_system.components.loading.LoadingIndicator
import wallee.tech.ui_kit.ui.dimens.size_16
import wallee.tech.ui_kit.ui.dimens.size_24
import wallee.tech.ui_kit.ui.theme.WalleeColors
import wallee.tech.ui_kit.ui.theme.WalleeMainTheme
import wallee.tech.ui_kit.ui.theme.WalleeTextStyle
import wallee.tech.purchase_impl.R as Purchase
import wallee.tech.ui_kit.R as UiKit

@Composable
internal fun BaseReceiptScreen(
    screenState: ReceiptState,
    goBack: () -> Unit
) {
    BackHandler { goBack() }

    if (screenState.isLoading) LoadingIndicator()
    else InitReceiptScreen(screenState) { goBack() }
}

@Composable
private fun InitReceiptScreen(screenState: ReceiptState, goBack: () -> Unit) {
    Scaffold(
        modifier = Modifier
            .padding(size_16)
            .fillMaxSize()
            .systemBarsPadding(),
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = size_16),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Icon(
                    modifier = Modifier.clickable { goBack() },
                    painter = painterResource(UiKit.drawable.baseline_arrow_back_24),
                    contentDescription = null,
                    tint = WalleeColors.Primary
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(Purchase.string.transaction_title),
                    style = WalleeTextStyle.textXl1,
                    textAlign = TextAlign.Center
                )
            }
        }
    ) { paddingValues ->
        Column(
            Modifier
                .padding(paddingValues)
                .fillMaxWidth()
                .background(
                    shape = RoundedCornerShape(size_24),
                    color = WalleeColors.Secondary
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            BaseTextLine(Purchase.string.transaction_title, screenState.transactionId)
            BaseTextLine(Purchase.string.transaction_status_title, screenState.transactionStatus)
            BaseTextLine(
                Purchase.string.transaction_amount_title,
                screenState.transactionFinalAmount
            )
            BaseTextLine(Purchase.string.transaction_tax_title, screenState.transactionTax)
            BaseTextLine(Purchase.string.transaction_date_title, screenState.transactionDate)
        }
    }
}

@Composable
private fun BaseTextLine(
    @StringRes label: Int,
    content: String,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(size_16),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(label),
            style = WalleeTextStyle.textM1,
            textAlign = TextAlign.Start
        )
        Text(
            text = content,
            style = WalleeTextStyle.textM,
            textAlign = TextAlign.End
        )
    }
}

@Composable
@Preview
private fun PreviewReceiptScreen() {
    WalleeMainTheme {
        BaseReceiptScreen(
            screenState = ReceiptState(),
            goBack = {}
        )
    }
}