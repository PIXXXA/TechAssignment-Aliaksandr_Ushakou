package wallee.tech.purchase_impl.presentation.purchase

internal sealed interface PurchaseIntent {

    data class UpdateAmount(val amount: String) : PurchaseIntent
    data object OnContinueClick : PurchaseIntent
}