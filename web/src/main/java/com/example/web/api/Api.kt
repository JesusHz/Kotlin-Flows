package com.example.web.api

import com.example.domain.models.PokemonModel
import retrofit2.Response
import retrofit2.http.GET

interface Api {
    @GET("")
    suspend fun getPokemon(): Response<List<PokemonModel>>
}