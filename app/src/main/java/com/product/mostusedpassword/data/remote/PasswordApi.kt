package com.product.mostusedpassword.data.remote


import retrofit2.Response
import retrofit2.http.GET


interface PasswordApi {
    @GET("Kasimcyln/most-used-passwords-list/main/10-million-password-list-top-10000.txt")
    suspend fun getPasswords(): Response<String>
}