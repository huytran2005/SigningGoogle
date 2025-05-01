package com.example.signinggoogle.view

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState


import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.navigation.NavController

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.navigation.compose.rememberNavController
import com.example.signinggoogle.R
import com.example.signinggoogle.ui.theme.titlecolor
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


@Composable
fun UserProfileScreen(navController: NavController,paddingValues: PaddingValues){
    Column (
        modifier= Modifier.fillMaxSize().padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally){
        Row(modifier= Modifier
            .fillMaxWidth()
        ){
            Spacer(modifier= Modifier.weight(0.1f))
            UserProfileBackButton(navController)
            Spacer(modifier= Modifier.weight(1f))
            UserProfileTitle()
            Spacer(modifier= Modifier.weight(1f))

        }
        UserProfileAvata()
        Content()
    }
}




@Composable
fun UserProfileTitle(){
    Text("Profile", fontSize =26.sp, color = titlecolor , fontWeight = FontWeight.Bold)
}




@Composable
fun UserProfileAvata(){

    val avatasize = 120.dp
    Box(modifier = Modifier.wrapContentSize(Alignment.BottomEnd).padding(top=30.dp)){
    Image(painter = painterResource(R.drawable.bg_avata),
                contentDescription = "Avata",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(avatasize)
                .clip(CircleShape))

    Image(painter = painterResource(R.drawable.ic_camera),
                contentDescription = "Avata",
        alignment = Alignment.BottomEnd,
        modifier = Modifier.size(25.dp).offset(avatasize-30.dp,avatasize-15.dp))
    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Content(name: String="Name",email: String="Email",dateofbirth:String="Date of Birth"){
    var nameLabel by remember { mutableStateOf("Melissa Peters")}
    var emailLabel by remember { mutableStateOf("melpeters@gmail.com")}



        Column (modifier = Modifier.fillMaxWidth()){
        Text(name, Modifier.padding(start = 16.dp), fontWeight = FontWeight.Bold)
            OutlinedTextField(
                value = nameLabel,
                onValueChange = { nameLabel = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
        Text(email,Modifier.padding(start = 16.dp), fontWeight = FontWeight.Bold)
            OutlinedTextField(
                value = emailLabel,
                onValueChange = { emailLabel = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
            Text(dateofbirth,Modifier.padding(start = 16.dp), fontWeight = FontWeight.Bold)
            DatePickerFieldToModal()


        }

    }
@Composable
fun UserProfileBackButton(navController: NavController){
    Image(
        painter = painterResource(R.drawable.bt_back),
        contentDescription = null,
        modifier = Modifier
            .width(40.dp)
            .height(40.dp)
            .clickable{navController.popBackStack()},
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewUserProfile(){
    val navController = rememberNavController()
    val paddingValues = PaddingValues()
    UserProfileScreen(navController,paddingValues)
}