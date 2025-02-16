package com.jahez.merchant_menu.state

import com.jahez.merchant_menu.model.MenuSectionUiModel
import com.jahez.merchant_menu.model.MerchantUiModel


sealed interface MerchantMenuUiState {
    data object Loading: MerchantMenuUiState
    data object LoadingFailed: MerchantMenuUiState
    data class Success(
        val merchant: MerchantUiModel,
        val menuSections: List<MenuSectionUiModel>,
    ): MerchantMenuUiState
}