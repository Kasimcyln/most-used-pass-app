package com.product.mostusedpassword.data.usecase

import com.product.mostusedpassword.data.model.Password
import com.product.mostusedpassword.data.repository.PasswordRepository

class GetPasswordsUseCase(
    private val repository: PasswordRepository
) {
    suspend operator fun invoke(): List<Password> {
        return repository.getPasswords()
    }
}