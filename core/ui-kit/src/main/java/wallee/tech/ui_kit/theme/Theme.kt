package wallee.tech.ui_kit.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import wallee.tech.ui_kit.colors.WalleeColors
import wallee.tech.ui_kit.typography.Typography

private val LightColorScheme = lightColorScheme(
    primary = WalleeColors.Primary,
    secondary = WalleeColors.Secondary,
    tertiary = WalleeColors.Tertiary,
    background = WalleeColors.White,
)

@Composable
fun WalleeMainTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content
    )
}