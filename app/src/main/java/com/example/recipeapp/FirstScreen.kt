package com.example.recipeapp

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FirstScreen(navigationToSecondScreen:(String,Int)->Unit){
    val name= remember{
        mutableStateOf("")
    }
    val age= remember{
        mutableStateOf(0)
    }
    Column(
        modifier= Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "This is the First Screen", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Name: ")
        OutlinedTextField(value = name.value, onValueChange ={
            name.value=it
        })
        Text(text = "Age: ")
        OutlinedTextField(value = age.value.toString(), onValueChange ={
            age.value=it.toInt()
        })
        Button(onClick = { navigationToSecondScreen(name.value,age.value) }) {
            Text(text = "Go to Second Screen")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FirstPreview(){
//    FirstScreen({})
}
