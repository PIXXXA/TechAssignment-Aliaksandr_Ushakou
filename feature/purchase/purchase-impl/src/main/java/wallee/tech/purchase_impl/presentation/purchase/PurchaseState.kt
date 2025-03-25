package wallee.tech.purchase_impl.presentation.purchase

import androidx.compose.runtime.Stable
import java.math.BigDecimal

@Stable
data class PurchaseState(
    val amount: String = BigDecimal.ZERO.toString(),
)
