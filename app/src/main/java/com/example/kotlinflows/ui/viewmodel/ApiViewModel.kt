package com.example.kotlinflows.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinflows.data.PokemonRepository
import com.example.kotlinflows.data.RickAndMortyRepository
import com.example.kotlinflows.data.model.Pokemon
import com.example.kotlinflows.data.model.PokemonProvider
import com.example.kotlinflows.data.model.RickAndMorty
import com.example.kotlinflows.data.model.RickAndMortyProvider
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class ApiViewModel: ViewModel() {
    val pokemonModel = MutableLiveData<Pokemon>()
    val isLoading = MutableLiveData<Boolean>()
    private val pokemonRepository = PokemonRepository()
    private var pokemonProvider = PokemonProvider.pokemons

    val rickAndMortyModel = MutableLiveData<RickAndMorty>()
    private val rickAndMortyRepository = RickAndMortyRepository()
    private var rickAndMortyProvider = RickAndMortyProvider.rickAndMorty

    fun onCreatePokemon() {
        viewModelScope.launch {
            isLoading.postValue(true)
            flow {
                while (true) {
                    val id = random()
                    val result = pokemonRepository.getPokemon(id)
                    if (result != null) {
                        emit(result)
                    }
                    delay(2000)
                }
            }
                .collect {
                isLoading.postValue(false)
                pokemonModel.postValue(it)
            }
        }
    }

    fun onCreateRickAndMorty() {
        viewModelScope.launch {
            isLoading.postValue(true)
            flow {
                while (true) {
                    val id = random()
                    val result = rickAndMortyRepository.getCharacter(id)
                    if (result != null) {
                        emit(result)
                    }
                    delay(2000)
                }
            }.collect {
                isLoading.postValue(false)
                rickAndMortyModel.postValue(it)
            }
        }
    }

    private fun random(): Int {
        return (0..826).random()
    }
}