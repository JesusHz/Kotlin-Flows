package com.example.kotlinflows.data.model

import com.google.gson.annotations.SerializedName

data class PokemonModel(
    val count: Long? = 0,
    val next: String? = null,
    val previous: String? = null,
    val results: List<Pokemon>
)

data class Pokemon(
    val id: Long? = 0,
    val name: String? = null,
    val sprites: Sprite,
)

data class Sprite(
    @SerializedName("front_default")
    val image: String? = null
)
