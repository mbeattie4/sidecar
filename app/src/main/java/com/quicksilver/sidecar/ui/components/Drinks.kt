package com.quicksilver.sidecar.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.quicksilver.sidecar.model.Drink
import com.quicksilver.sidecar.model.testDrinks
import com.quicksilver.sidecar.ui.theme.Purple200
import com.quicksilver.sidecar.ui.theme.SidecarTheme

@Composable
fun DrinkCard(drink: Drink, modifier: Modifier = Modifier, drinkSelected: (String) -> Unit = {}) {
    Card(
        shape = MaterialTheme.shapes.medium.copy(CornerSize(16.dp)),
        elevation = 4.dp,
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable { drinkSelected(drink.id) }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Image(
                painter = rememberImagePainter(
                    data = drink.thumbnail,
                    builder = { crossfade(true) }
                ),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.requiredSize(100.dp)
            )
            Text(
                text = drink.name,
                style = MaterialTheme.typography.h5,
                modifier = Modifier
                    .weight(1.0f)
                    .padding(start = 8.dp)
            )
            DrinkChip(
                drink = drink,
                modifier = Modifier.align(Alignment.CenterVertically).padding(horizontal = 8.dp)
            )
        }
    }
}

@Composable
fun DrinkChip(drink: Drink, modifier: Modifier = Modifier) {
    Image(
        painter = rememberImagePainter(
            data = drink.thumbnail,
            builder = { crossfade(true) }
        ),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = modifier
            .requiredSize(60.dp)
            .clip(CircleShape)
            .border(width = 2.dp, color = Purple200, shape = CircleShape)
    )
}

@Composable
fun DrinkCards(
    drinks: List<Drink>,
    modifier: Modifier = Modifier,
    drinkSelected: (String) -> Unit = {}
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = spacedBy(16.dp)
    ) {
        items(drinks) { drink -> DrinkCard(drink = drink, drinkSelected = drinkSelected) }
    }
}

@Preview(showBackground = false)
@Composable
fun DrinkCardPreview() {
    SidecarTheme {
        DrinkCard(drink = testDrinks[0], modifier = Modifier.padding(16.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun DrinkCardsPreview() {
    SidecarTheme {
        DrinkCards(drinks = testDrinks)
    }
}
