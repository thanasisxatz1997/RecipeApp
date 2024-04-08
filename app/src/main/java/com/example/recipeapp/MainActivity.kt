package com.example.recipeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.recipeapp.ui.theme.RecipeAppTheme
import java.security.AllPermission

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecipeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyApp()
//                    RecipeScreen()
                }
            }
        }
    }
}

@Composable
fun MyApp(){
    val navController= rememberNavController()
    NavHost(navController=navController, startDestination = "firstscreen"){
        composable("firstscreen"){
            FirstScreen {name,age->
                println("Name and age are: $name $age")
                navController.navigate("secondscreen/$name/$age")}

//            if (name!=""){
//                navController.navigate("secondscreen/$name")}
//                else{
//                    navController.navigate("secondscreen/noName")
//                }
//            }
        }
        composable("secondscreen/{name}/{age}",){
            val name = it.arguments?.getString("name") ?:"no name"
            val age= it.arguments?.getString("age") ?:"12"
            SecondScreen(name,age) {
                navController.navigate("firstscreen")
            }
        }
    }
}