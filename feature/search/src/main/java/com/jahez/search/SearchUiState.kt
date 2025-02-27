package com.jahez.search


sealed class SearchUiState {
    object Loading : SearchUiState()
    data class Success(val searchResults: List<String>) : SearchUiState()
    data object Idle: SearchUiState()
}