package com.quicksilver.sidecar.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.quicksilver.sidecar.ui.theme.SidecarTheme

@Composable
fun SidecarApp() {
    SidecarTheme {
        Surface(color = MaterialTheme.colors.background) {
            NavigationGraph()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SidecarAppPreview() {
    SidecarApp()
}