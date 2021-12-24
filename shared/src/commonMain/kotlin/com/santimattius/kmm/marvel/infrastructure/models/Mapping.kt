package com.santimattius.kmm.marvel.infrastructure.models


internal fun Character.asCharacter() = object :
    com.santimattius.kmm.marvel.domain.entities.Character {
    override val id: Long
        get() = this@asCharacter.id
    override val name: String
        get() = this@asCharacter.name
    override val thumbnail: String
        get() = this@asCharacter.thumbnail.asString()
    override val description: String
        get() = this@asCharacter.description
}