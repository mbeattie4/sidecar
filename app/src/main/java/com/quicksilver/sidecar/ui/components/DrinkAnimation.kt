package com.quicksilver.sidecar.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.quicksilver.sidecar.model.Drink
import com.quicksilver.sidecar.model.testDrinks
import com.quicksilver.sidecar.ui.theme.SidecarTheme

@Composable
fun DrinkSelection(
    drink: Drink,
    modifier: Modifier = Modifier,
    favorite: Boolean = false,
    onTap: () -> Unit
) {
    Card(
        elevation = 4.dp,
        shape = RoundedCornerShape(size = 8.dp),
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .wrapContentWidth(align = Alignment.CenterHorizontally)
                .padding(16.dp)
        ) {
            val color by animateColorAsState(
                targetValue = if (favorite) Color.Blue else Color.DarkGray
            )
            Text(
                text = drink.name,
                style = MaterialTheme.typography.h6.copy(color = color),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(end = 8.dp)
            )
            IconButton(onClick = { onTap() }) {
                Icon(
                    modifier = Modifier.size(20.dp),
                    imageVector = if (favorite) {
                        Icons.Filled.Favorite
                    } else {
                        Icons.Outlined.FavoriteBorder
                    },
                    tint = color,
                    contentDescription = ""
                )
            }
        }
    }
}

@Preview
@Composable
fun DrinkSelectionPreview() {
    SidecarTheme {
        var favorite by remember { mutableStateOf(false) }
        DrinkSelection(
            drink = testDrinks[0],
            modifier = Modifier.padding(8.dp),
            favorite = favorite,
            onTap = { favorite = !favorite }
        )
    }
}
