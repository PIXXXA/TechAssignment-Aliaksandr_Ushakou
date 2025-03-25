package wallee.tech.purchase_impl.data.dto

import wallee.tech.purchase_impl.domain.model.PurchaseTransactionAmountDomainModel
import wallee.tech.purchase_impl.domain.model.PurchaseTransactionDetailsDomainModel
import wallee.tech.purchase_impl.domain.model.PurchaseTransactionDomainModel

internal class PurchaseTransactionDto(
    val amount: PurchaseTransactionAmountDto = PurchaseTransactionAmountDto(),
    val status: String? = null,
    val transactionDetails: PurchaseTransactionDetailsDto = PurchaseTransactionDetailsDto(),
    val transactionId: String? = null
)

internal class PurchaseTransactionAmountDto(
    val currency: String? = null,
    val discountAmount: String? = null,
    val purchaseAmount: String? = null,
    val taxRate: String? = null,
    val taxableAmount: String? = null,
    val tipAmount: String? = null
)

internal class PurchaseTransactionDetailsDto(
    val timestamp: String? = null
)

internal fun PurchaseTransactionDto.toDomainModel() = PurchaseTransactionDomainModel(
    amount = amount.toDomainModel(),
    status = status.orEmpty(),
    transactionDetails = transactionDetails.toDomainModel(),
    transactionId = transactionId.orEmpty()
)

internal fun PurchaseTransactionAmountDto.toDomainModel() = PurchaseTransactionAmountDomainModel(
    currency = currency.orEmpty(),
    discountAmount = discountAmount.orEmpty(),
    purchaseAmount = purchaseAmount.orEmpty(),
    taxRate = taxRate.orEmpty(),
    taxableAmount = taxableAmount.orEmpty(),
    tipAmount = tipAmount.orEmpty(),
)

internal fun PurchaseTransactionDetailsDto.toDomainModel() = PurchaseTransactionDetailsDomainModel(
    timestamp = timestamp.orEmpty()
)
