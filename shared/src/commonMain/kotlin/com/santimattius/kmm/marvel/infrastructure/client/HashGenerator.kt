package com.santimattius.kmm.marvel.infrastructure.client

import com.soywiz.krypto.md5
import io.ktor.utils.io.core.*

internal fun generateHash(time: Long, privateKey: String, publicKey: String): String =
    md5(time.toString() + privateKey + publicKey)

private fun md5(stringToHash: String): String {
    return stringToHash.toByteArray().md5().toString()
}
