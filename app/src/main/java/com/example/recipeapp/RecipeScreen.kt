package com.example.recipeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter

@Composable
fun RecipeScreen(modifier: Modifier = Modifier){
    val recipeViewModel:MainViewModel= viewModel()
    val viewState by recipeViewModel.categoriesState
    Box(modifier=Modifier.fillMaxSize()){
        when{
            //We are loading
            viewState.loading->{
                CircularProgressIndicator(modifier.align(Alignment.Center))
            }
            //There was an error while loading
            viewState.error!=null->{
                Text("ERROR OCCURRED: ${viewState.error}")
            }
            //We are done loading without any errors
            else->{
                //Display Categories
                CategoryScreen(categories = viewState.list)
            }
        }
    }
}
@Composable
fun CategoryScreen(categories:List<Category>) {
    LazyVerticalGrid(GridCells.Fixed(2), modifier = Modifier.fillMaxSize()){
        items(categories){
            category->
            CategoryItem(category = category)
        }
    }
}
//How each Category Item looks like
@Composable
fun CategoryItem(category:Category){
    Column(modifier = Modifier
        .padding(8.dp)
        .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = rememberAsyncImagePainter(model = category.strCategoryThumb),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .aspectRatio(1f)
        )
        Text(
            text=category.strCategory,
            color = Color.Black,
            style= TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(top=4.dp)
            )
    }
}