package com.example.kotlinflows.data

import com.example.kotlinflows.data.model.Pokemon
import com.example.kotlinflows.data.model.PokemonModel
import com.example.kotlinflows.data.model.PokemonProvider
import com.example.kotlinflows.data.network.PokemonService

class PokemonRepository {
    private val api = PokemonService()

    suspend fun getPokemon(): List<Pokemon> {
        val response: PokemonModel? = api.getPokemon()
        return response?.results ?: emptyList()
    }
}