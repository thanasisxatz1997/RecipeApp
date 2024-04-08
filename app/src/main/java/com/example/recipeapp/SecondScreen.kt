package com.example.recipeapp

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SecondScreen(name:String, age:String, navigateToFirstScreen:(String)->Unit){
    Column(
        modifier= Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "This is the Second Screen", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Welcome $age year old $name!", fontSize = 24.sp)
        Button(onClick = { navigateToFirstScreen(name)}) {
            Text(text = "Go to First Screen")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SecondPreview(){
//    SecondScreen("Thanasis",3,{})
}
