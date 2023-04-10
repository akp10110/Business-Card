package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.DarkGray
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier:Modifier = Modifier) {
    Column(modifier = modifier.background(Color(0xFF083042))) {
        Row(
            modifier = modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            LogoNameAndTitle()
        }
        Row(
            modifier = modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            ContactDetails()
        }
    }
}

@Composable
fun LogoNameAndTitle(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        val image = painterResource(id = R.drawable.android_logo)
        Image(
            painter = image,
            contentDescription = null,
            modifier = modifier
                .width(80.dp)
                .height(80.dp)
        )
        Text(
            text = "Jennifer Doe",
            fontSize = 42.sp,
            color = Color.White,
            modifier = modifier.padding(12.dp)
        )
        Text(
            text = "Android Developer Extraordinaire",
            color = Color(0xFF3ddc84)
        )
    }

}

@Composable
fun ContactDetails(modifier: Modifier = Modifier) {
    Column (
        modifier = modifier.fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ){
        Divider(color = Color(0xFF526e7b), modifier = Modifier.fillMaxWidth().width(0.5.dp))
        ContactDetailsLineItem(imageVector = Icons.Rounded.Call,
            information = "+11 (123) 444 555 666")
        Divider(color = Color(0xFF526e7b), modifier = Modifier.fillMaxWidth().width(0.5.dp))
        ContactDetailsLineItem(imageVector = Icons.Rounded.Share,
            information = "@AndroidDev")
        Divider(color = Color(0xFF526e7b), modifier = Modifier.fillMaxWidth().width(0.5.dp))
        ContactDetailsLineItem(imageVector = Icons.Rounded.Email,
            information = "jen.doe@android.com")
        Spacer(modifier = modifier.height(50.dp))
    }
}

@Composable
fun ContactDetailsLineItem(imageVector: ImageVector, information: String,
                           modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        Icon(
            imageVector,
            contentDescription = null,
            tint = Color(0xFF3ddc84),
            modifier = modifier.padding(start = 75.dp, end = 8.dp, top = 8.dp, bottom = 8.dp)
        )
        Text(
            text = information,
            color = Color.White,
            modifier = modifier.padding(8.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}