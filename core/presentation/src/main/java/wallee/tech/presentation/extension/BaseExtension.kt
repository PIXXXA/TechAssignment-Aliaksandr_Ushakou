package wallee.tech.presentation.extension

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.flow.StateFlow
import wallee.tech.presentation.AMOUNT_SCALE_2
import wallee.tech.presentation.int_100
import java.math.BigDecimal
import java.math.RoundingMode

@Composable
fun <T> StateFlow<T>.asStateWithLifecycle(): T {
    val state by collectAsStateWithLifecycle()
    return state
}

fun BigDecimal.convertToAmountFormat(): String =
    (this.divide(BigDecimal(int_100)).setScale(AMOUNT_SCALE_2, RoundingMode.HALF_UP)).toString()
