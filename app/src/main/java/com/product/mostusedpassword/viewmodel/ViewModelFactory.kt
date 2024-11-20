package com.product.mostusedpassword.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.product.mostusedpassword.data.repository.PasswordRepository
import com.product.mostusedpassword.data.usecase.GetPasswordsUseCase

class ViewModelFactory(
    private val repository: PasswordRepository
) : ViewModelProvider.Factory {

    private val getPasswordsUseCase = GetPasswordsUseCase(repository)

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PasswordViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PasswordViewModel(getPasswordsUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
