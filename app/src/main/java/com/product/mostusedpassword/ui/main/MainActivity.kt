package com.product.mostusedpassword.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.product.mostusedpassword.viewmodel.PasswordViewModel
import com.product.mostusedpassword.viewmodel.ViewModelFactory
import com.product.mostusedpassword.data.remote.RetrofitInstance
import com.product.mostusedpassword.data.repository.PasswordRepository
import com.product.mostusedpassword.data.repository.PasswordRepositoryImpl
import com.product.mostusedpassword.ui.theme.MostUsedPasswordTheme

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: PasswordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository: PasswordRepository = PasswordRepositoryImpl(RetrofitInstance.api)
        val factory = ViewModelFactory(repository)

        // ViewModel'i oluşturmak için ViewModelProvider kullanın
        viewModel = ViewModelProvider(this, factory)[PasswordViewModel::class.java]

        setContent {
            MostUsedPasswordTheme {
                val navController = rememberNavController()
                NavGraph(navController = navController, viewModel = viewModel)
            }
        }
    }
}