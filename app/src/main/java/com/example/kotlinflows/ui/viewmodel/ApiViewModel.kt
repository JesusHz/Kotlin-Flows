package com.example.kotlinflows.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinflows.data.PokemonRepository
import com.example.kotlinflows.data.model.Pokemon
import com.example.kotlinflows.data.model.PokemonProvider
import kotlinx.coroutines.launch

class PokemonViewModel: ViewModel() {
    val pokemonModel = MutableLiveData<Pokemon>()
    val isLoading = MutableLiveData<Boolean>()
    private val pokemonRepository = PokemonRepository()
    private var pokemonProvider = PokemonProvider.pokemons

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = pokemonRepository.getPokemon()
            pokemonProvider = result
            if (!result.isNullOrEmpty()) {
                pokemonModel.postValue(result.first())
                isLoading.postValue(false)
            }
        }
    }

    fun random() {
        isLoading.postValue(true)
        if (!pokemonProvider.isNullOrEmpty()) {
            val random = (0..pokemonProvider.size).random()
            pokemonModel.postValue(pokemonProvider[random])
            isLoading.postValue(false)
        }
    }
}