package com.example.composeweather.ui.view.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.composeweather.ui.theme.ComposeWeatherTheme
import com.example.composeweather.ui.view.composable.Menu

class MainActivity : ComponentActivity() {

    private lateinit var navHostController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeWeatherTheme {
                navHostController = rememberNavController()
                Menu(navHostController = navHostController)
            }
        }
    }
}
