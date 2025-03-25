package wallee.tech.purchase_impl.navigation

import wallee.tech.presentation.PURCHASE_ROUTE
import wallee.tech.presentation.RECEIPT_ROUTE
import wallee.tech.presentation.RECEIPT_ROUTE_AMOUNT

sealed class Screen(val route: String) {

    data object Purchase : Screen(PURCHASE_ROUTE)
    data object Receipt : Screen(RECEIPT_ROUTE.plus("{$RECEIPT_ROUTE_AMOUNT}"))
}
