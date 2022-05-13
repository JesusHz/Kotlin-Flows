package com.example.kotlinflows.data

import com.example.kotlinflows.data.model.RickAndMorty
import com.example.kotlinflows.data.model.RickAndMortyModel
import com.example.kotlinflows.data.network.RickAndMortyService

class RickAndMortyRepository {
    private val api = RickAndMortyService()

    suspend fun getAll(): List<RickAndMorty> {
        val response: RickAndMortyModel? = api.getAll()
        return response?.results ?: emptyList()
    }
}