package com.microsoft.fluentuidemo.demos

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.microsoft.fluentui.theme.FluentTheme
import com.microsoft.fluentui.theme.token.FluentAliasTokens
import com.microsoft.fluentui.theme.token.FluentGlobalTokens

enum class BadgeDType {
    Character,
    List
}
data class BadgeDataTokens(
    private val backgroundBrushOverride: Brush? = null,
    private val textColorOverride: Color? = null,
    private val typographyOverride: TextStyle? = null,
    private val paddingOverride: PaddingValues? = null,
    private val borderStrokeOverride: BorderStroke? = null,
    private val cornerRadiusOverride: Dp? = null
) {

    val backgroundBrush: Brush
        @Composable get() = backgroundBrushOverride
            ?: SolidColor(
                FluentTheme.aliasTokens.errorAndStatusColor[FluentAliasTokens.ErrorAndStatusColorTokens.DangerBackground2].value()
            )

    val textColor: Color
        @Composable get() = textColorOverride
            ?: FluentTheme.aliasTokens.neutralForegroundColor[FluentAliasTokens.NeutralForegroundColorTokens.ForegroundLightStatic].value()

    val typography: TextStyle
        @Composable get() = typographyOverride
            ?: FluentTheme.aliasTokens.typography[FluentAliasTokens.TypographyTokens.Caption2]

    val padding: PaddingValues
        @Composable get() = paddingOverride
            ?: PaddingValues(
                horizontal = FluentGlobalTokens.size(FluentGlobalTokens.SizeTokens.Size60)
            )

    val borderStroke: BorderStroke
        @Composable get() = borderStrokeOverride
            ?: BorderStroke(
                FluentGlobalTokens.strokeWidth(FluentGlobalTokens.StrokeWidthTokens.StrokeWidth20),
                FluentTheme.aliasTokens.neutralStrokeColor[FluentAliasTokens.NeutralStrokeColorTokens.StrokeFocus1].value()
            )

    val cornerRadius: Dp
        @Composable get() = cornerRadiusOverride ?: 100.dp
}