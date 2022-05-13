package com.example.kotlinflows.data.network

import com.example.kotlinflows.core.RetrofitHelper
import com.example.kotlinflows.data.model.Pokemon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class PokemonService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getPokemon(id: Int): Pokemon? {
        return withContext(Dispatchers.IO) {
            val response: Response<Pokemon> =
                retrofit.create(PokemonApiClient::class.java).getPokemon(urlPokemon + id)
            response.body()
        }
    }

    companion object {
        const val urlPokemon = "https://pokeapi.co/api/v2/pokemon/"
    }
}