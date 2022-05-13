package com.example.web.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiPokemon {

    private const val url = ""

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}