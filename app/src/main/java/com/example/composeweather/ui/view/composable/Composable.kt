package com.example.composeweather.ui.view.composable

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
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
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
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
import com.example.composeweather.ui.theme.ButtonLight
import com.example.composeweather.ui.theme.DarkBlue
import com.example.composeweather.ui.theme.LightBlue
import com.example.composeweather.ui.theme.LightWhite

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
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(name: String) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = name, color = LightWhite) },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = DarkBlue),
                modifier = Modifier
                    .padding(top = 23.dp, start = 10.dp, end = 10.dp)
                    .clip(shape = RoundedCornerShape(35.dp)),
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
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
        WeatherCard()
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