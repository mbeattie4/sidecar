package com.quicksilver.sidecar.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.quicksilver.sidecar.ui.Destination.Detail
import com.quicksilver.sidecar.ui.Destination.Home
import com.quicksilver.sidecar.ui.detail.DrinkDetail
import com.quicksilver.sidecar.ui.home.Home

sealed class Destination(val route: String) {

    object Home : Destination(route = "home")

    object Detail : Destination(route = "detail") {
        fun placeholderRoute(): String = "${route}/{$DETAIL_ID_KEY}"
        fun populatedRoute(id: String): String = "${route}/$id"
    }
}

@Composable
fun NavigationGraph(startDestination: Destination = Home) {
    val navController = rememberNavController()
    val navActions = remember(navController) { NavigationActions(navController) }

    NavHost(
        navController = navController,
        startDestination = startDestination.route
    ) {
        composable(route = Home.route) {
            Home(drinkSelected = { id -> navActions.drink(id) })
        }
        composable(
            route = Detail.placeholderRoute(),
            arguments = listOf(navArgument(name = DETAIL_ID_KEY) { type = NavType.StringType})
        ) { backStackEntry ->
            val arguments = requireNotNull(backStackEntry.arguments)
            DrinkDetail(drinkId = arguments.getString(DETAIL_ID_KEY).orEmpty())
        }
    }
}

class NavigationActions(navController: NavController) {
    val home: () -> Unit = { navController.navigate(Home.route) }
    val drink: (String) -> Unit = { id -> navController.navigate(Detail.populatedRoute(id)) }
    val up: () -> Unit = { navController.navigateUp() }
}

private const val DETAIL_ID_KEY = "drinkId"
