package wallee.tech.purchase_impl.presentation.purchase

import androidx.navigation.NavController
import kotlinx.coroutines.flow.update
import wallee.tech.presentation.RECEIPT_ROUTE
import wallee.tech.presentation.base.BaseIntentViewModel

internal class PurchaseViewModel(
    private val navController: NavController,
) : BaseIntentViewModel<PurchaseState, PurchaseIntent>(PurchaseState()) {

    override fun handleIntent(intent: PurchaseIntent) {
        when (intent) {
            PurchaseIntent.OnContinueClick ->
                navController.navigate(
                    RECEIPT_ROUTE.plus("{${viewState.value.amount}}")
                )

            is PurchaseIntent.UpdateAmount -> {
                _viewState.update {
                    it.copy(amount = (viewState.value.amount.plus(intent.amount)))
                }
            }
        }
    }
}
