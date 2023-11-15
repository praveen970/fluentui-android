package com.microsoft.fluentuidemo.demos

import android.os.Bundle
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.microsoft.fluentui.theme.FluentTheme
import com.microsoft.fluentui.theme.token.ControlTokens
import com.microsoft.fluentui.theme.token.FluentAliasTokens
import com.microsoft.fluentui.theme.token.controlTokens.AppBarSize
import com.microsoft.fluentui.theme.token.controlTokens.BadgeInfo
import com.microsoft.fluentui.theme.token.controlTokens.BadgeTokens
import com.microsoft.fluentui.theme.token.controlTokens.BadgeType
import com.microsoft.fluentui.theme.token.controlTokens.ColorStyle
import com.microsoft.fluentui.theme.token.controlTokens.LabelDataTokens
import com.microsoft.fluentui.theme.token.controlTokens.LabelInfo
import com.microsoft.fluentui.theme.token.controlTokens.LabelTokens
import com.microsoft.fluentui.tokenized.controls.Button
import com.microsoft.fluentui.tokenized.controls.Label
import com.microsoft.fluentui.util.dpToPx
import com.microsoft.fluentuidemo.V2DemoActivity

class TokenTestingActivity : V2DemoActivity() {
    override val appBarSize = AppBarSize.Medium

    init {
        setupActivity(this)
    }

    override val paramsUrl = "https://github.com/microsoft/fluentui-android/wiki/Controls#params-4"
    override val controlTokensUrl =
        "https://github.com/microsoft/fluentui-android/wiki/Controls#control-tokens-4"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setActivityContent {
            //FluentTest()
            var text by remember { mutableStateOf(1) }
            Column {
                Row {
                    Badge(badgeTokens = BadgeTokens())
                    Badge(badgeTokens = BadgeTokens())
                    Badge(badgeTokens = BadgeTokens())
                    Badge(badgeTokens = BadgeTokens())
                    Badge(badgeTokens = BadgeTokens())
                }
                Row {
                    Badge(badgeTokens = BadgeTokens())
                    Badge(badgeTokens = BadgeTokens())
                    Badge(badgeTokens = BadgeTokens())
                    Badge(badgeTokens = BadgeTokens())
                    Badge(badgeTokens = BadgeTokens())
                }
                Row {
                    Badge(badgeTokens = BadgeTokens())
                    Badge(badgeTokens = BadgeTokens())
                    Badge(badgeTokens = BadgeTokens())
                    Badge(badgeTokens = BadgeTokens())
                    Badge(badgeTokens = BadgeTokens())
                }
                Row {
                    Badge(badgeTokens = BadgeTokens())
                    Badge(badgeTokens = BadgeTokens())
                    Badge(badgeTokens = BadgeTokens())
                    Badge(badgeTokens = BadgeTokens())
                    Badge(badgeTokens = BadgeTokens())
                }
                Row {
                    Badge(badgeTokens = BadgeTokens())
                    Badge(badgeTokens = BadgeTokens())
                    Badge(badgeTokens = BadgeTokens())
                    Badge(badgeTokens = BadgeTokens())
                    Badge(badgeTokens = BadgeTokens())
                }
                Row {
                    Badge(badgeTokens = BadgeTokens())
                    Badge(badgeTokens = BadgeTokens())
                    Badge(badgeTokens = BadgeTokens())
                    Badge(badgeTokens = BadgeTokens())
                    Badge(badgeTokens = BadgeTokens())
                }
                //BasicTextField(value = text, onValueChange = { text = it })
                Button(onClick = { text += 1 }, text = "Value is $text")
                //BadgeD(badgeDataTokens = BadgeDataTokens())
            }
        }
    }
    @Composable
    fun TextBoxDataTokens(text: String, labelTokens: LabelDataTokens) {
        Label(
            text = text,
            labelTokens = labelTokens
        )
    }
    @Composable
    fun TextBoxFluentTokens(text: String, labelTokens: LabelTokens) {
        Label(
            text = text,
            labelTokens = labelTokens
        )
    }

    @Composable
    fun FluentTest() {
        var text by remember { mutableStateOf("") }
        val tokens: LabelTokens = LTokens()
        val dataTokens = LabelDataTokens()
        Column {
            TextBoxDataTokens(text = "Microsoft", dataTokens)
            TextBoxFluentTokens(text = "Microsoft", tokens)
            BasicTextField(value = text, onValueChange = { text = it })
        }
    }
    class LTokens: LabelTokens(){
        @Composable
        override fun textColor(labelInfo: LabelInfo): Color {
            return when (labelInfo.colorStyle) {
                ColorStyle.Primary -> FluentTheme.aliasTokens.neutralForegroundColor[FluentAliasTokens.NeutralForegroundColorTokens.Foreground1].value()
                ColorStyle.Secondary -> FluentTheme.aliasTokens.neutralForegroundColor[FluentAliasTokens.NeutralForegroundColorTokens.Foreground2].value()
                ColorStyle.White -> FluentTheme.aliasTokens.neutralForegroundColor[FluentAliasTokens.NeutralForegroundColorTokens.Foreground3].value()
                else ->{
                    Color.Red
                }
            }
        }
    }

}
@Composable
fun Label(
    text: String,
    textStyle: FluentAliasTokens.TypographyTokens = FluentAliasTokens.TypographyTokens.Display,
    colorStyle: ColorStyle = ColorStyle.Primary,
    modifier: Modifier = Modifier,
    labelTokens: LabelDataTokens? = null
) {
    val textStyle = labelTokens?.typography
    val textColor = labelTokens?.textColor
    if (textStyle != null) {
        BasicText(
            modifier = modifier,
            text = text,
            style = textStyle.merge(textColor?.let { TextStyle(color = it) })
        )
    }
}

@Composable
fun BadgeD(badgeDataTokens: BadgeDataTokens = BadgeDataTokens(), modifier: Modifier = Modifier) {
    val background = badgeDataTokens.backgroundBrush
    val border = badgeDataTokens.borderStroke
    Box(
        modifier = modifier
            .defaultMinSize(16.dp, 16.dp)
    ) {
        Canvas(
            modifier = Modifier
                .padding(start = 5.dp, end = 3.dp, top = 3.dp, bottom = 5.dp)
                .sizeIn(minWidth = 8.dp, minHeight = 8.dp)
        ) {
            drawCircle(
                brush = border.brush,
                radius = dpToPx(border.width + 4.dp)
            )
            drawCircle(
                brush = background,
                style = Fill,
                radius = dpToPx(4.dp)
            )
        }
    }
}

@Composable
fun Badge(badgeTokens: BadgeTokens, modifier: Modifier = Modifier) {
    var badgeInfo = BadgeInfo(BadgeType.Character)
    val background = badgeTokens.backgroundBrush(badgeInfo)
    val border = badgeTokens.borderStroke(badgeInfo)
    Box(
        modifier = modifier
            .defaultMinSize(16.dp, 16.dp)
    ) {
        Canvas(
            modifier = Modifier
                .padding(start = 5.dp, end = 3.dp, top = 3.dp, bottom = 5.dp)
                .sizeIn(minWidth = 8.dp, minHeight = 8.dp)
        ) {
            drawCircle(
                brush = border.brush,
                radius = dpToPx(border.width + 4.dp)
            )
            drawCircle(
                brush = background,
                style = Fill,
                radius = dpToPx(4.dp)
            )
        }
    }
}