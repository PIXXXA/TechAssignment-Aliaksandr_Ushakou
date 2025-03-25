package wallee.tech.design_system.components.loading

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import wallee.tech.ui_kit.theme.WalleeColors

@Composable
fun LoadingIndicator() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(WalleeColors.White),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(color = WalleeColors.Primary)
    }
}
