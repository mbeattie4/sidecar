package com.quicksilver.sidecar.ui.detail

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.quicksilver.sidecar.ui.theme.SidecarTheme

@Composable
fun DrinkDetail(drinkId: String) {
    Text(text = "Drink with ID: $drinkId")
}

@Preview
@Composable
fun PreviewDrinkDetail() {
    SidecarTheme {
        DrinkDetail(drinkId = "0")
    }
}
