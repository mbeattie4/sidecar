package com.quicksilver.sidecar.data

import com.quicksilver.sidecar.data.DrinkApi.drinkApiService
import com.quicksilver.sidecar.model.Ingredient
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DrinkRepository(
    private val drinkService: DrinkService = drinkApiService,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend fun getDrinksWithIngredient(ingredient: Ingredient): List<DrinkEntity> = withContext(ioDispatcher) {
        drinkService.getDrinksWithIngredient(ingredient = ingredient.name).drinks
    }
}
