package com.product.mostusedpassword.ui.splash

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.product.mostusedpassword.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    // Animasyon başlatma durumu
    var startAnimation by remember { mutableStateOf(false) }

    // Ölçek animasyonu
    val scale: Float by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0.5f,
        animationSpec = tween(
            durationMillis = 1000 // 1 saniye süren animasyon
        )
    )

    // Döndürme animasyonu
    val infiniteTransition = rememberInfiniteTransition()
    val rotation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 2000, easing = LinearEasing)
        )
    )

    // Animasyonu başlat ve navigasyonu gerçekleştir
    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(2000) // 2 saniye bekleme
        navController.navigate("main") {
            popUpTo("splash") { inclusive = true }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White), // Arka plan rengini beyaz olarak ayarladık
        contentAlignment = Alignment.Center
    ) {
        // Şifre resmi
        Image(
            painter = painterResource(id = R.drawable.ic_password), // Resminizin adı
            contentDescription = "Password Icon",
            modifier = Modifier
                .scale(scale)    // Ölçek animasyonu
                .rotate(rotation) // Döndürme animasyonu
        )
    }
}
