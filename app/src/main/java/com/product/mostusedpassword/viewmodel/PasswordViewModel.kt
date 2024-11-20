package com.product.mostusedpassword.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.product.mostusedpassword.data.usecase.GetPasswordsUseCase
import com.product.mostusedpassword.ui.screen.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PasswordViewModel(
    private val getPasswordsUseCase: GetPasswordsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState

    init {
        fetchPasswords()
    }

    fun fetchPasswords() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            try {
                val passwordList = getPasswordsUseCase()
                _uiState.value = UiState.Success(passwordList)
            } catch (e: Exception) {
                _uiState.value = UiState.Error(e.localizedMessage ?: "Unknown Error")
            }
        }
    }
}