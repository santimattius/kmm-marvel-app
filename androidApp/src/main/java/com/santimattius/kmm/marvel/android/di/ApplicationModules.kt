package com.santimattius.kmm.marvel.android.di

import android.app.Application
import com.santimattius.kmm.marvel.MarvelSDK
import com.santimattius.kmm.marvel.android.BuildConfig
import com.santimattius.kmm.marvel.di.Credentials
import com.santimattius.kmm.marvel.di.initModule
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

private val sharedModules = module {
    factory { MarvelSDK() }
}

val applicationModules: List<Module> = sharedModules + homeModules + detailModules

fun Application.initialize() {
    val credentials = Credentials(
        publicKey = BuildConfig.PUBLIC_KEY,
        privateKey = BuildConfig.PRIVATE_KEY,
    )
    initModule(credentials) {
        loadKoinModules(applicationModules)
    }
}