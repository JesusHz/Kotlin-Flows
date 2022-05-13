package com.example.kotlinflows.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinflows.data.PokemonRepository
import com.example.kotlinflows.data.RickAndMortyRepository
import com.example.kotlinflows.data.model.Pokemon
import com.example.kotlinflows.data.model.PokemonProvider
import com.example.kotlinflows.data.model.RickAndMorty
import com.example.kotlinflows.data.model.RickAndMortyProvider
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
            val result = pokemonRepository.getPokemon()
            pokemonProvider = result
            if (!result.isNullOrEmpty()) {
                pokemonModel.postValue(result.first())
                isLoading.postValue(false)
            }
        }
    }

    fun onCreateRickAndMorty() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = rickAndMortyRepository.getAll()
            rickAndMortyProvider = result
            if (!result.isNullOrEmpty()) {
                rickAndMortyModel.postValue(result.first())
                isLoading.postValue(false)
            }
        }
    }

    fun pokemonRandom() {
        isLoading.postValue(true)
        if (!pokemonProvider.isNullOrEmpty()) {
            val random = (0..pokemonProvider.size).random()
            pokemonModel.postValue(pokemonProvider[random])
            isLoading.postValue(false)
        }
    }

    fun rickAndMortyRandom() {
        isLoading.postValue(true)
        if (!rickAndMortyProvider.isNullOrEmpty()) {
            val random = (0..19).random()
            Log.i("RANDOM", random.toString())
            rickAndMortyModel.postValue(rickAndMortyProvider[random])
            isLoading.postValue(false)
        }
    }
}