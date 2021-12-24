package com.santimattius.kmm.marvel.android.detail.presentation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import com.santimattius.kmm.marvel.domain.entities.Character
import com.santimattius.marvel.composable.detail.presentation.ArrowBackIcon

@ExperimentalMaterialApi
@Composable
fun CharacterDetailScaffold(
    character: Character,
    onUpClick: () -> Unit,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(character.name) },
                navigationIcon = { ArrowBackIcon(onUpClick) }

            )
        },
        content = content
    )
}
