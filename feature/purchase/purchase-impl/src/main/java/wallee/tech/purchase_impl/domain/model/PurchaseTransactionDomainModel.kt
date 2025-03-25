package wallee.tech.purchase_impl.domain.model

import wallee.tech.presentation.EMPTY_STRING

internal class PurchaseTransactionDomainModel(
    val amount: PurchaseTransactionAmountDomainModel = PurchaseTransactionAmountDomainModel(),
    val status: String = EMPTY_STRING,
    val transactionDetails: PurchaseTransactionDetailsDomainModel =
        PurchaseTransactionDetailsDomainModel(),
    val transactionId: String = EMPTY_STRING
)

internal class PurchaseTransactionAmountDomainModel(
    val currency: String = EMPTY_STRING,
    val discountAmount: String = EMPTY_STRING,
    val purchaseAmount: String = EMPTY_STRING,
    val taxRate: String = EMPTY_STRING,
    val taxableAmount: String = EMPTY_STRING,
    val tipAmount: String = EMPTY_STRING
)

internal class PurchaseTransactionDetailsDomainModel(
    val timestamp: String = EMPTY_STRING
)
