package com.jahez.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jahez.core.IoDispatcher
import com.jahez.home.state.HomeUiState
import com.jahez.home_data.repository.IHomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    @IoDispatcher private val io: CoroutineDispatcher,
    homeRepository: IHomeRepository
) : ViewModel() {

    val homeUiState: StateFlow<HomeUiState> =
        homeRepository.fetchHomePageContent().map(HomeUiState::Success).stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000),
            HomeUiState.Loading
        )
}