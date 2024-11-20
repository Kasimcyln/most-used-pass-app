package com.product.mostusedpassword.data.repository

import com.product.mostusedpassword.data.model.Password

interface PasswordRepository {
    suspend fun getPasswords(): List<Password>
}