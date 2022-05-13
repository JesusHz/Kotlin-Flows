package com.example.kotlinflows.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    private const val urlPokemon = "https://pokeapi.co/api/v2/"
    private const val urlRick = "https://rickandmortyapi.com/api/"

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(urlRick)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}