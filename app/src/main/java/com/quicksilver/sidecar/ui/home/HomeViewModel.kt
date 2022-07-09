package com.quicksilver.sidecar.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quicksilver.sidecar.data.DrinkRepository
import com.quicksilver.sidecar.model.Drink
import com.quicksilver.sidecar.model.Ingredient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class HomeState(val drinks: List<Drink>)

class HomeViewModel(
    private val drinkRepository: DrinkRepository = DrinkRepository()
) : ViewModel() {

    private val _state: MutableStateFlow<HomeState> = MutableStateFlow(HomeState(drinks = emptyList()))

    val state: StateFlow<HomeState>
        get() = _state

    init {
        refreshForIngredient(ingredient = Ingredient("vodka"))
    }

    private fun refreshForIngredient(ingredient: Ingredient) {
        viewModelScope.launch {
            val drinkEntities = drinkRepository.getDrinksWithIngredient(ingredient)
            val drinks = drinkEntities.map { entity ->
                Drink(
                    id = entity.id.orEmpty(),
                    name = entity.name.orEmpty(),
                    thumbnail = entity.thumbnail.orEmpty()
                )
            }
            _state.value = HomeState(drinks = drinks)
        }
    }
}
