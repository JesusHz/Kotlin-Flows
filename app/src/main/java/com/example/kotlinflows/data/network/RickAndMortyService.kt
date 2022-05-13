package com.example.kotlinflows.data.network

import com.example.kotlinflows.core.RetrofitHelper
import com.example.kotlinflows.data.model.PokemonModel
import com.example.kotlinflows.data.model.RickAndMortyModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class RickAndMortyService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getAll(): RickAndMortyModel? {
        return withContext(Dispatchers.IO) {
            val response: Response<RickAndMortyModel> =
                retrofit.create(RickAndMortyApiClient::class.java).getAll(urlPokemon)
            response.body()
        }
    }

    companion object {
        const val urlPokemon = "https://rickandmortyapi.com/api/character"
    }
}