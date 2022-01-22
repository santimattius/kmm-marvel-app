package com.santimattius.kmm.marvel.android.detail.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.santimattius.kmm.marvel.android.detail.domain.FindCharacter
import com.santimattius.kmm.marvel.domain.entities.Character
import kotlinx.coroutines.launch

class DetailViewModel(id: Long, private val findCharacter: FindCharacter) :
    ViewModel() {
    private val _state = MutableLiveData<DetailState>()
    val state: LiveData<DetailState>
        get() = _state

    init {
        find(id)
    }

    private fun find(id: Long) {
        _state.value = DetailState.Loading
        viewModelScope.launch {
            _state.postValue(DetailState.Complete(findCharacter(id)))
        }
    }
}


sealed class DetailState {
    object Loading : DetailState()
    data class Complete(val data: Character) : DetailState()
}