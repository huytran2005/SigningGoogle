package com.example.signinggoogle.view

import android.app.Activity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.signinggoogle.R
import com.example.signinggoogle.ui.theme.buttoncolor
import com.example.signinggoogle.ui.theme.contentcolor
import com.example.signinggoogle.ui.theme.titlecolor
import com.google.android.gms.auth.api.signin.GoogleSignIn
import handleSignInResult
import signInWithGoogle
import toast

@Composable
fun LoginLogo() {
    Image(
        painter = painterResource(R.drawable.bg_uthlogo),
        contentDescription = "UTH Logo",
        modifier = Modifier.width(200.dp).height(200.dp),

    )
}
@Composable
fun LoginTitle (content1:String,content2: String){
    Text(content1, fontSize = 24.sp, fontWeight = FontWeight.Bold, color = titlecolor)
    Text(content2, fontSize = 12.sp, color = titlecolor)
}


@Composable
fun LoginContent(title: String,content:String){
    Text(title, fontSize = 24.sp, fontWeight = FontWeight.Bold,)
    Text(content, fontSize = 12.sp)
}


@Composable
fun LoginButtonSigningGoogle(navController: NavController){
    val context = LocalContext.current
    val googleSignInLauncher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                handleSignInResult(task, context)
                toast("Sign-in successful", context)
                navController.navigate("UserProfile")
            } else {
                toast("Failed to sign-in", context)
            }
        }
    Button(onClick = {
        signInWithGoogle(googleSignInLauncher, context)
        },
        shape = RoundedCornerShape(12),
        modifier = Modifier.
        fillMaxWidth().
        padding(start = 50.dp, end = 50.dp,top=30.dp),
        colors = ButtonDefaults.buttonColors(buttoncolor)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            Image(
                painter =painterResource(R.drawable.ic_google),
                contentDescription = "Icon_google",
                modifier = Modifier.width(20.dp).height(20.dp).padding(end = 5.dp)
            )
            Text("Sign in with Google", color = contentcolor)

        }

    }
}
@Composable
fun LoginScreen(
    paddingValues: PaddingValues,
    navController: NavController
) {
    Box(modifier= Modifier.fillMaxSize().padding(paddingValues)){

    }
    Column(
        modifier = Modifier.fillMaxSize().padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier= Modifier.weight(1f))
        LoginLogo()
        var title ="SmartTasks"
        var content= "A simple and efficient to-do app"
        LoginTitle(title,content)
        Spacer(modifier= Modifier.weight(1f))

        title = "Welcome"
        content = "Ready to explore? Log in to get started."
        LoginContent(title,content)
        LoginButtonSigningGoogle(navController)
        Spacer(modifier= Modifier.weight(1f))



    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen(){
    val navController = rememberNavController()
    val paddingValues = PaddingValues()
    LoginScreen(paddingValues,navController = navController) // Gọi hàm với tên mới
}