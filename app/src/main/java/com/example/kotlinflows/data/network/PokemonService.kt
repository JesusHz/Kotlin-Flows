package com.example.kotlinflows.data.network

import com.example.kotlinflows.core.RetrofitHelper
import com.example.kotlinflows.data.model.PokemonModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class PokemonService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getPokemon(): PokemonModel? {
        return withContext(Dispatchers.IO) {
            val response: Response<PokemonModel> =
                retrofit.create(PokemonApiClient::class.java).getPokemon(urlPokemon)
            response.body()
        }
    }

    companion object {
        const val urlPokemon = "https://pokeapi.co/api/v2/pokemon/?limit=1000"
    }
}