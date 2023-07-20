package com.example.mathapp.ui.composable.ButtonItem

import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.example.mathapp.ui.dashboard.LobbyViewModel
import com.example.mathapp.ui.theme.FbColor
import com.example.mathapp.ui.theme.SpacingQuarter_4dp
import com.example.mathapp.util.HomeButtonsDC
import com.example.mathapp.util.HomeButtonsDCVector

@Composable
fun ButtonItem(modifier: Modifier, item: HomeButtonsDC, viewModel: LobbyViewModel) {

    Button(
        onClick = { viewModel.onItemClicked(item.action) },
        modifier = modifier,
        contentPadding = ButtonDefaults.TextButtonContentPadding,
        colors = ButtonDefaults.buttonColors(FbColor)
    ) {
        Icon(painter = painterResource(id = item.icon), contentDescription = "Localized description", modifier = Modifier.size(item.iconSize.dp))
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text(item.text, fontSize = item.textSize.em)
    }
    Spacer(modifier = Modifier.height(16.dp))

}

@Composable
fun ButtonItem(modifier: Modifier, item: HomeButtonsDCVector, viewModel: LobbyViewModel) {

    Button(
        onClick = { viewModel.onItemClicked(item.action) },
        modifier = modifier,
        contentPadding = ButtonDefaults.TextButtonContentPadding,
        colors = ButtonDefaults.buttonColors(FbColor)
    ) {
        Icon(item.icon, contentDescription = "Localized description", modifier = Modifier.size(item.iconSize.dp),)
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text(item.text, fontSize = item.textSize.em)
    }
    Spacer(modifier = Modifier.height(16.dp))

}

@Composable
fun RoundedButton(text: String, onClick: () -> Unit, modifier: Modifier = Modifier, icon: Int? = null, vector: ImageVector? = null,iconSize: Int = 20)
{
    androidx.compose.material.Button(
        onClick = onClick,
        modifier = modifier.padding(horizontal = SpacingQuarter_4dp).height(IntrinsicSize.Min),
        shape = RoundedCornerShape(16.dp),
        colors = androidx.compose.material.ButtonDefaults.buttonColors(backgroundColor = FbColor)
    ) {
        if (vector == null) {
            icon?.let { painterResource(id = it) }
                ?.let { Icon(painter = it, contentDescription = "Localized description", modifier = Modifier.size(iconSize.dp), tint = Color.White) }
        }
        else { Icon(vector, tint = Color.White, contentDescription = "Localized description", modifier = Modifier.size(iconSize.dp),) }
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        androidx.compose.material.Text(text = text, style = MaterialTheme.typography.body1, color = Color.White)
    }
}