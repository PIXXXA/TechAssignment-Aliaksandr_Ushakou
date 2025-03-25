package wallee.tech.assignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import org.koin.android.ext.android.inject
import wallee.tech.purchase_api.PurchaseLauncher
import wallee.tech.ui_kit.ui.theme.WalleeMainTheme

class WalleeActivity : ComponentActivity() {
    private val purchaseLauncher: PurchaseLauncher by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WalleeMainTheme {
                purchaseLauncher.LaunchPurchase()
            }
        }
    }
}