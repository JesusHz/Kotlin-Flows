package com.example.kotlinflows.data.network

import com.example.kotlinflows.data.model.RickAndMortyModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface RickAndMortyApiClient {
    @GET
    suspend fun getAll(@Url url: String): Response<RickAndMortyModel>
}