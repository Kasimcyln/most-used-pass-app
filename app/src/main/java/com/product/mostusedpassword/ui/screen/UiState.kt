package com.product.mostusedpassword.ui.screen

import com.product.mostusedpassword.data.model.Password


sealed class UiState {
    object Loading : UiState()
    data class Success(val passwords: List<Password>) : UiState()
    data class Error(val message: String) : UiState()
}