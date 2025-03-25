package wallee.tech.purchase_impl.presentation.receipt

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import wallee.tech.presentation.base.BaseIntentViewModel
import wallee.tech.purchase_impl.domain.model.PurchaseTransactionAmountDomainModel
import wallee.tech.purchase_impl.domain.repository.PurchaseRepository

internal class ReceiptViewModel(
    private val amount: String,
    private val purchaseRepository: PurchaseRepository,
) : BaseIntentViewModel<ReceiptState, Nothing>(ReceiptState()) {

    init {
        handleLoadingState(isLoading = true)
        loadTransactionReceipt()
        handleLoadingState(isLoading = false)
    }

    override fun handleIntent(intent: Nothing) {
        TODO("Not yet implemented")
    }

    private fun loadTransactionReceipt() {
        viewModelScope.launch {
            val response = purchaseRepository.getTransactionReceipt()
            _viewState.update {
                it.copy(
                    transactionId = response.transactionId,
                    transactionStatus = response.status,
                    transactionFinalAmount = calculateFinalAmount(response.amount),
                    transactionTax = getTaxAmount(
                        response.amount.taxableAmount,
                        response.amount.taxRate
                    ).toString(),
                    transactionDate = response.transactionDetails.timestamp,
                )
            }
        }
    }

    private fun calculateFinalAmount(amountData: PurchaseTransactionAmountDomainModel): String {
        val taxAmount = getTaxAmount(amountData.taxableAmount, amountData.taxRate)
        val totalSumAfterTax = amountData.purchaseAmount.toBigDecimal().minus(taxAmount)
        val totalSumAfterDiscount = totalSumAfterTax.minus(amountData.discountAmount.toBigDecimal())
        val totalSumAfterTips = totalSumAfterDiscount.plus(amountData.tipAmount.toBigDecimal())
        return totalSumAfterTips.toString()
    }

    private fun getTaxAmount(taxableAmount: String, taxRate: String) =
        taxableAmount.toBigDecimal().multiply(taxRate.toBigDecimal())

    private fun handleLoadingState(isLoading: Boolean) {
        _viewState.update {
            it.copy(isLoading = isLoading)
        }
    }
}
