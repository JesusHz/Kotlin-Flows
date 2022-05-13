package com.example.kotlinflows.data.network

import com.example.kotlinflows.data.model.RickAndMorty
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface RickAndMortyApiClient {
    @GET
    suspend fun getCharacter(@Url url: String): Response<RickAndMorty>
}