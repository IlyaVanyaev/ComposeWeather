package com.example.composeweather.ui.view.composable

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemColors
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeweather.R
import com.example.composeweather.data.model.NavigationModel
import com.example.composeweather.ui.theme.ButtonLight
import com.example.composeweather.ui.theme.DarkBlue
import com.example.composeweather.ui.theme.LightBlue
import com.example.composeweather.ui.theme.LightWhite
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.composeweather.data.navigation.NavigationScreen
import com.example.composeweather.ui.theme.BlueBlue
import com.example.composeweather.ui.theme.ButtonLightLight
import com.example.composeweather.ui.theme.DarkDarkBlue
import kotlinx.coroutines.CoroutineScope

@Composable
fun InfoCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier
                .width(300.dp)
                .height(450.dp)
                .offset(0.dp, (-45).dp),
            shape = RoundedCornerShape(25.dp),
            colors = CardDefaults.cardColors(
                Color(0xB34C6D8E)
            )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp), Alignment.BottomCenter
            ) {
                Text(
                    text = "KotlinWeather", style = TextStyle(
                        fontSize = 35.sp,
                        fontStyle = FontStyle.Italic,
                        color = LightWhite,
                        textAlign = TextAlign.Center
                    )
                )
            }
            Box(
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth(), Alignment.BottomCenter
            ) {
                Text(
                    text = "This app was made by MIREA student, Ilya Vanyaev, IKBO-07-21",
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontStyle = FontStyle.Italic,
                        color = LightWhite,
                        textAlign = TextAlign.Center
                    )
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(), Alignment.Center
            ) {
                //WeatherAnimation()
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SetNavHost(navHostController: NavHostController){
    androidx.navigation.compose.NavHost(navController = navHostController, startDestination = NavigationScreen.Home.route){
        composable(NavigationScreen.Home.route){
            WeatherCard()
        }
        composable(NavigationScreen.Info.route){
            InfoCard()
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Menu(navHostController: NavHostController){
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }

    val scope = rememberCoroutineScope()

    val items = listOf(
        NavigationModel("Home", Icons.Filled.Home, Icons.Outlined.Home, NavigationScreen.Home.route),
        //NavigationModel("Settings", Icons.Filled.Settings, Icons.Outlined.Settings, NavigationScreen.Settings.route),
        NavigationModel("Info", Icons.Filled.Info, Icons.Outlined.Info, NavigationScreen.Info.route)
    )

    ModalNavigationDrawer(
        drawerContent = {
                   ModalDrawerSheet (drawerContainerColor = LightBlue, drawerShape = RoundedCornerShape(40.dp)) {
                       Spacer(modifier = Modifier.height(20.dp))
                        items.forEachIndexed {index, navigationModel ->  
                            NavigationDrawerItem(
                                label = { Text(text = navigationModel.title) },
                                selected = index == selectedItemIndex,
                                onClick = {
                                    selectedItemIndex = index
                                    navHostController.navigate(route = navigationModel.route){
                                        popUpTo(route = navigationModel.route){
                                            inclusive = true
                                        }
                                    }
                                    scope.launch { drawerState.close() }
                                },
                                icon = {
                                    Icon(
                                        imageVector = if (index == selectedItemIndex){navigationModel.selectedIcon} else {navigationModel.unselectedIcon},
                                        contentDescription = navigationModel.title
                                    )
                                },
                                modifier = Modifier
                                    .padding(NavigationDrawerItemDefaults.ItemPadding)
                                    .padding(vertical = 5.dp),
                                colors = NavigationDrawerItemDefaults.colors(BlueBlue, DarkBlue, LightWhite, LightWhite, LightWhite, LightWhite))
                        }
                   }
        },
        drawerState = drawerState) {
        MainScreen(name = "Menu", ds = drawerState, scope = scope, navHostController)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(name: String, ds:DrawerState, scope: CoroutineScope, navHostController: NavHostController) {


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = name, color = LightWhite) },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = DarkBlue),
                modifier = Modifier
                    .padding(top = 23.dp, start = 10.dp, end = 10.dp)
                    .clip(shape = RoundedCornerShape(35.dp)),
                navigationIcon = {
                    IconButton(onClick = {scope.launch { ds.open() } }) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menu",
                            tint = LightWhite
                        )
                    }
                },
                actions = {

                    Image(painter = painterResource(id = R.drawable.weather), contentDescription = "Weather_icon", modifier = Modifier.padding(end = 10.dp))

                    IconButton(modifier = Modifier.padding(end = 5.dp), onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Filled.Refresh, contentDescription = "Update", tint = ButtonLight, modifier = Modifier.size(40.dp, 40.dp))
                    }
                }
            )
        },
    ) {
        Background(resource = R.drawable.background_default, description = "app_background")
        SetNavHost(navHostController = navHostController)
    }
}

@Composable
fun Background(resource: Int, description: String) {
    Image(
        painter = painterResource(id = resource),
        contentDescription = description,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )
}

@Composable
fun WeatherCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            shape = RoundedCornerShape(25.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .offset(0.dp, (-35).dp)
                .padding(horizontal = 10.dp),
            colors = CardDefaults.cardColors(
                DarkBlue
            )
        ) {

            Box(modifier = Modifier
                .fillMaxSize(), Alignment.TopCenter
            )
            {

                IconButton(modifier = Modifier.offset(x = (-155).dp), onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Settings, contentDescription = "Settings", tint = ButtonLight, modifier = Modifier.size(40.dp, 40.dp))
                }

                IconButton(modifier = Modifier.offset(x = 155.dp), onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Info, contentDescription = "Info", tint = ButtonLight, modifier = Modifier.size(40.dp, 40.dp))
                }




                Text(
                    text = "Moscow()", style = TextStyle(
                        fontSize = 30.sp,
                        color = LightWhite,
                        textAlign = TextAlign.Center
                    ), modifier = Modifier.offset(y = 5.dp)
                )
                Text(
                    text = "0\u00B0", style = TextStyle(
                        fontSize = 70.sp,
                        color = LightWhite,
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier.offset(y = 35.dp, x = 8.dp)
                )
                Text(
                    text = "0/0", style = TextStyle(
                        fontSize = 20.sp,
                        color = LightWhite,
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier.offset(y = 125.dp)
                )
                Text(
                    text = "Cloudy", style = TextStyle(
                        fontSize = 20.sp,
                        color = LightWhite,
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier.offset(y = 160.dp)
                )
            }
        }
    }
}