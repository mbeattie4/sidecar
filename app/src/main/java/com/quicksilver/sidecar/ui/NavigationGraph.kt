package com.quicksilver.sidecar.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.quicksilver.sidecar.ui.Destination.HOME
import com.quicksilver.sidecar.ui.home.Home

enum class Destination(val route: String) {
    HOME("home")
}

@Composable
fun NavigationGraph(startDestination: Destination = HOME) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startDestination.route
    ) {
        composable(HOME.route) { Home() }
    }
}