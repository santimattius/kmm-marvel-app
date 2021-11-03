package com.santimattius.kmm.marvel.domain.entities

interface Character {
    val id: Long
    val name: String
    val thumbnail: String
    val description: String
}