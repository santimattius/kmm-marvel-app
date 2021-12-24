package com.santimattius.kmm.marvel.android.detail.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.santimattius.kmm.marvel.android.R
import com.santimattius.kmm.marvel.android.detail.application.DetailState
import com.santimattius.kmm.marvel.android.detail.application.DetailViewModel
import com.santimattius.kmm.marvel.domain.entities.Character
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

@ExperimentalCoilApi
@ExperimentalMaterialApi
@Composable
fun DetailScreen(characterId: Int, onUpClick: () -> Unit) {
    val viewModel = getViewModel<DetailViewModel> { parametersOf(characterId) }
    val currentState: DetailState by viewModel.state.observeAsState(DetailState.Loading)
    when (currentState) {
        is DetailState.Complete -> {
            DetailScreen((currentState as DetailState.Complete).data, onUpClick)
        }
        DetailState.Loading -> Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }
}

@ExperimentalCoilApi
@ExperimentalMaterialApi
@Composable
fun DetailScreen(character: Character, onUpClick: () -> Unit) {
    CharacterDetailScaffold(
        character = character,
        onUpClick = onUpClick
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(padding)
        ) {
            item {
                Header(character)
            }
        }
    }
}

@ExperimentalCoilApi
@Composable
private fun Header(character: Character) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = rememberImagePainter(character.thumbnail),
            contentDescription = character.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .aspectRatio(1f)
        )
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.medium)))
        Text(
            text = character.name,
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier.padding(
                dimensionResource(R.dimen.medium),
                dimensionResource(R.dimen.none)
            )
        )
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.medium)))
        Text(
            text = character.description,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.body1,
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.medium), dimensionResource(R.dimen.none))
        )
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.medium)))
    }
}