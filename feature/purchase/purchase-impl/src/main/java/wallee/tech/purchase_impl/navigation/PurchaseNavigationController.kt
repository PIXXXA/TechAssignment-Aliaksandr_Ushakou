package wallee.tech.purchase_impl.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import org.koin.androidx.compose.navigation.koinNavViewModel
import org.koin.core.parameter.parametersOf
import wallee.tech.presentation.RECEIPT_ROUTE_AMOUNT
import wallee.tech.presentation.extension.asStateWithLifecycle
import wallee.tech.purchase_impl.presentation.purchase.PurchaseScreen
import wallee.tech.purchase_impl.presentation.purchase.PurchaseViewModel
import wallee.tech.purchase_impl.presentation.receipt.BaseReceiptScreen
import wallee.tech.purchase_impl.presentation.receipt.ReceiptViewModel

@Composable
fun NavigationStack() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Purchase.route) {

        composable(route = Screen.Purchase.route) {
            val viewModel: PurchaseViewModel = koinNavViewModel { parametersOf(navController) }

            PurchaseScreen(
                screenState = viewModel.viewState.asStateWithLifecycle(),
                onIntent = viewModel::handleIntent,
                exitFlow = { navController.popBackStack() }
            )
        }

        composable(
            route = Screen.Receipt.route,
            arguments = listOf(
                navArgument(RECEIPT_ROUTE_AMOUNT) {
                    type = NavType.StringType
                    nullable = true
                }
            )
        ) { backStackEntry ->
            val amount = backStackEntry.arguments?.getString(RECEIPT_ROUTE_AMOUNT)
            val viewModel: ReceiptViewModel = koinNavViewModel { parametersOf(amount) }

            BaseReceiptScreen(
                screenState = viewModel.viewState.asStateWithLifecycle(),
                goBack = { navController.popBackStack() }
            )
        }
    }
}