package com.example.kotlinflows.data.network

import com.example.kotlinflows.core.RetrofitHelper
import com.example.kotlinflows.data.model.RickAndMorty
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class RickAndMortyService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getCharacter(id: Int): RickAndMorty? {
        return withContext(Dispatchers.IO) {
            val response: Response<RickAndMorty> =
                retrofit.create(RickAndMortyApiClient::class.java).getCharacter(urlPokemon + id)
            response.body()
        }
    }

    companion object {
        const val urlPokemon = "https://rickandmortyapi.com/api/character/"
    }
}