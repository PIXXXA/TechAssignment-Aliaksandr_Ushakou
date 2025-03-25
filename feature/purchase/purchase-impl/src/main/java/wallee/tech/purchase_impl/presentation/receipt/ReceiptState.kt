package wallee.tech.purchase_impl.presentation.receipt

import androidx.compose.runtime.Stable
import wallee.tech.presentation.EMPTY_STRING

@Stable
internal data class ReceiptState(
    val transactionId: String = EMPTY_STRING,
    val transactionStatus: String = EMPTY_STRING,
    val transactionFinalAmount: String = EMPTY_STRING,
    val transactionTax: String = EMPTY_STRING,
    val transactionDate: String = EMPTY_STRING,

    val isLoading: Boolean = false,
)
