package com.quicksilver.sidecar.model

data class Drink(
    val id: String,
    val name: String,
    val thumbnail: String
)

data class Ingredient(val name: String)

val testDrinks = listOf(
    Drink(
        id = "0",
        name = "Sidecar",
        thumbnail = "https://www.thecocktaildb.com/images/media/drink/x72sik1606854964.jpg"
    ),
    Drink(
        id = "1",
        name = "Mojito",
        thumbnail = "https://www.thecocktaildb.com/images/media/drink/metwgh1606770327.jpg"
    ),
    Drink(
        id = "2",
        name = "Gin and Tonic",
        thumbnail = "https://www.thecocktaildb.com/images/media/drink/z0omyp1582480573.jpg"
    ),
    Drink(
        id = "3",
        name = "Manhattan",
        thumbnail = "https://www.thecocktaildb.com/images/media/drink/yk70e31606771240.jpg"
    ),
)