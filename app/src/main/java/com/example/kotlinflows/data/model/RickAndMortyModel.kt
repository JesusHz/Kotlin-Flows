package com.example.kotlinflows.data.model

data class RickAndMortyModel(
    val info: Info,
    val results: List<RickAndMorty>
)

data class RickAndMorty(
    val id: Long? = 0,
    val name: String? = null,
    val species: String? = null,
    val status: String? = null,
    val type: String? = null,
    val gender: String? = null,
    val image: String? = null,
)

data class Info(
    val count: Long? = 0,
    val pages: Long? = 0,
    val next: String? = null,
    val prev: String? = null,
)
