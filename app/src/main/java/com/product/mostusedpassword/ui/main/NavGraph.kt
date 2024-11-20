package com.product.mostusedpassword.ui.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.product.mostusedpassword.ui.screen.MainScreen
import com.product.mostusedpassword.viewmodel.PasswordViewModel
import com.product.mostusedpassword.ui.splash.SplashScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    viewModel: PasswordViewModel
) {
    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") {
            SplashScreen(navController = navController)
        }
        composable("main") {
            MainScreen(viewModel = viewModel, navController = navController)
        }
    }
}