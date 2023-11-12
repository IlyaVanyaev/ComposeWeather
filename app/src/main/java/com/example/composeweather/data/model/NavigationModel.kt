package com.example.composeweather.data.model

import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationModel(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val route: String
    )
