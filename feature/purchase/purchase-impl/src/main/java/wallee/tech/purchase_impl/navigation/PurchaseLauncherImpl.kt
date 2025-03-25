package wallee.tech.purchase_impl.navigation

import androidx.compose.runtime.Composable
import wallee.tech.purchase_api.PurchaseLauncher

class PurchaseLauncherImpl : PurchaseLauncher{

    @Composable
    override fun LaunchPurchase() {
        NavigationStack()
    }
}
