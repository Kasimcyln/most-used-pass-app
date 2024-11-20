package com.product.mostusedpassword.data.repository


import com.product.mostusedpassword.data.remote.PasswordApi
import com.product.mostusedpassword.data.model.Password
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class PasswordRepositoryImpl(
    private val api: PasswordApi
) : PasswordRepository {

    override suspend fun getPasswords(): List<Password> {
        return withContext(Dispatchers.IO) {
            val response = api.getPasswords()
            if (response.isSuccessful) {
                val body = response.body() ?: ""
                body.lines()
                    .filter { it.isNotBlank() }
                    .map { Password(value = it) }
            } else {
                throw Exception("Error ${response.code()}: ${response.message()}")
            }
        }
    }
}