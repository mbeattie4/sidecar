package com.quicksilver.sidecar.ui.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.quicksilver.sidecar.model.testDrinks
import com.quicksilver.sidecar.ui.components.DrinkCards
import com.quicksilver.sidecar.ui.theme.SidecarTheme
import com.quicksilver.sidecar.ui.theme.Teal200

@Composable
fun Home(drinkSelected: (String) -> Unit = {}) {
    Surface(color = Teal200, modifier = Modifier.fillMaxSize()) {
        DrinkCards(drinks = testDrinks, drinkSelected = drinkSelected)
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    SidecarTheme {
        Home()
    }
}