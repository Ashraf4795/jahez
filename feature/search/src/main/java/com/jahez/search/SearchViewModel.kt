package com.jahez.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor() : ViewModel() {
    val searchUiState = flow {
        emit(SearchUiState.Success(listOf("Result 1", "Result 2", "Result 3")))
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        SearchUiState.Loading
    )
}