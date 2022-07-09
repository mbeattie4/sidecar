package com.quicksilver.sidecar.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DrinksEntity(
    @Json(name = "drinks") val drinks: List<DrinkEntity>
)

@JsonClass(generateAdapter = true)
data class DrinkEntity(
    @Json(name = "idDrink") val id: String?,
    @Json(name = "strDrink") val name: String?,
    @Json(name = "strDrinkThumb") val thumbnail: String?
)
