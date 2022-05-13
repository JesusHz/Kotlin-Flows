package com.example.kotlinflows.data.network

import com.example.kotlinflows.data.model.Pokemon
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface PokemonApiClient {
    @GET
    suspend fun getPokemon(@Url url: String): Response<Pokemon>
}