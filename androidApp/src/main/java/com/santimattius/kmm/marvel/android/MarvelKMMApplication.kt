package com.santimattius.kmm.marvel.android

import android.app.Application
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.santimattius.kmm.marvel.MarvelSDK
import com.santimattius.kmm.marvel.android.di.detailModules
import com.santimattius.kmm.marvel.android.di.homeModules
import com.santimattius.kmm.marvel.android.theme.MarvelComposableTheme
import com.santimattius.kmm.marvel.di.Credentials
import com.santimattius.kmm.marvel.di.initModule
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

class MarvelKMMApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initModule(Credentials(
            publicKey = "c17a941d0c8f54ddcc8bb410bae88856",
            privateKey = "529b1e011df9f86cfe5439c76353ac3d318b2336",
        )) {
            loadKoinModules(module {
                factory { MarvelSDK() }
            } + homeModules + detailModules)
        }
    }
}

@Composable
fun MarvelApplication(content: @Composable () -> Unit) {
    MarvelComposableTheme {
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}