package com.quicksilver.sidecar.data

import retrofit2.http.GET
import retrofit2.http.Query

interface DrinkService {

    @GET("filter.php")
    suspend fun getDrinksWithIngredient(@Query("i") ingredient: String): DrinksEntity //List<DrinkEntity>
}
