package com.example.composeweather.ui.view.activities

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.composeweather.R
import com.example.composeweather.ui.theme.ComposeWeatherTheme
import com.example.composeweather.ui.view.composable.MainScreen
import com.example.composeweather.ui.view.composable.Menu

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeWeatherTheme {
                Menu()
            }
        }
    }
}
