package com.quicksilver.sidecar.ui.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.quicksilver.sidecar.ui.components.DrinkCards
import com.quicksilver.sidecar.ui.theme.SidecarTheme
import com.quicksilver.sidecar.ui.theme.Teal200

@Composable
fun Home(drinkSelected: (String) -> Unit = {}) {
    val viewModel = viewModel(HomeViewModel::class.java)
    val viewState by viewModel.state.collectAsState()

    Surface(color = Teal200, modifier = Modifier.fillMaxSize()) {
        DrinkCards(drinks = viewState.drinks, drinkSelected = drinkSelected)
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    SidecarTheme {
        Home()
    }
}