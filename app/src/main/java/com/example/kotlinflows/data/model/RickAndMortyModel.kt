package com.example.kotlinflows.data.model

data class PokemonModel(
    val count: Long? = 0,
    val next: String? = null,
    val previous: String? = null,
    val results: List<Pokemon>
)

data class Pokemon(
    val name: String? = null,
    val url: String? = null,
)
