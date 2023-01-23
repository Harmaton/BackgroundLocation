package com.njagi.kuri

import android.Manifest
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.njagi.kuri.components.SearchInputBox
import com.njagi.kuri.ui.theme.KuriTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION,
            ),
            0
        )

        setContent {
            KuriTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color(R.color.blue)),

                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 15.dp)
                    ) {
                        TopBarApp()

                        Spacer(modifier = Modifier
                            .height(15.dp)
                            .background(color = Color.Blue))

                        SearchInputBox(modifier = Modifier.background(color = Color.Transparent), text = "Parcel location")
                        Spacer(modifier = Modifier.height(10.dp))
                        SearchInputBox(modifier = Modifier.background(color = Color.Transparent), text = "Delivery Location")
                        Spacer(modifier = Modifier.height(5.dp))

                        Row(modifier = Modifier.fillMaxWidth()) {
                            Button(onClick = {
                                Intent(applicationContext, LocationService::class.java).apply {
                                    action = LocationService.ACTION_START
                                    startService(this)
                                }
                            }) {
                                Text(text = "Start")
                            }
                            Spacer(modifier = Modifier.height(16.dp))
                            Button(onClick = {
                                Intent(applicationContext, LocationService::class.java).apply {
                                    action = LocationService.ACTION_STOP
                                    startService(this)
                                }
                            }) {

                                Text(text = "Stop")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TopBarApp(){
Row(modifier = Modifier
    .fillMaxWidth()
        ){
    Column(modifier = Modifier.fillMaxWidth(),

        ){
       Row( modifier = Modifier
           .fillMaxWidth()
           .height(90.dp)
           .padding(start = 30.dp, end = 5.dp, bottom = 20.dp, top = 10.dp),
           horizontalArrangement = Arrangement.End,
           verticalAlignment = Alignment.CenterVertically
           ){

                Image(painter = painterResource(id = R.drawable.avatar),
                    contentDescription = "icon",
                    modifier = Modifier.clip(shape = RoundedCornerShape(12.dp))
                    )

           Column(Modifier.padding(start = 10.dp)){
               Text(text = "Petre Smith", fontWeight = FontWeight.Normal,
                   color = Color.Gray, fontSize = 20.sp)


               Text(text = "Welcome Back!", fontWeight = FontWeight.Bold,
                   color = Color.White , fontSize = 25.sp)

           }

           Spacer(modifier = Modifier
               .width(250.dp)
               .weight(2f))

               IconButton(onClick = { /*TODO*/ },
               modifier = Modifier
                   .background(color = Color.Transparent)
                   .size(40.dp)
                   ) {
                   Icon(imageVector = Icons.Default.Notifications,
                       contentDescription = "",
                       modifier = Modifier
                           .padding(end = 5.dp)
                           .clip(shape = RoundedCornerShape(12.dp)) ,
                   )
               }


           }

       }

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KuriTheme {
    TopBarApp()
    }
}