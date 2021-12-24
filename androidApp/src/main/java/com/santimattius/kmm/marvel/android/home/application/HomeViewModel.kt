package com.santimattius.kmm.marvel.android.home.application

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.santimattius.kmm.marvel.android.home.domain.GetCharacters

class HomeViewModel(getCharacters: GetCharacters) : ViewModel() {
    val characters = getCharacters().cachedIn(viewModelScope)
}