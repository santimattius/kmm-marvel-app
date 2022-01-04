package com.santimattius.kmm.marvel.android

import android.app.Application
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.santimattius.kmm.marvel.android.di.initialize
import com.santimattius.kmm.marvel.android.theme.MarvelComposableTheme

class MarvelKMMApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initialize()
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