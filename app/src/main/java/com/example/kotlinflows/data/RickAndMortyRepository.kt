package com.example.kotlinflows.data

import com.example.kotlinflows.data.model.RickAndMorty
import com.example.kotlinflows.data.model.RickAndMortyModel
import com.example.kotlinflows.data.network.RickAndMortyService

class RickAndMortyRepository {
    private val api = RickAndMortyService()

    suspend fun getCharacter(id: Int): RickAndMorty? {
        return api.getCharacter(id)
    }
}