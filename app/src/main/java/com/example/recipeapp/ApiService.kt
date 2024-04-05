package com.example.recipeapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private val retrofit=Retrofit.Builder().baseUrl("https://www.themealdb.com/api/json/v1/1/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

    val recipeService= retrofit.create(ApiService::class.java)


interface ApiService{
    @GET("categories.php")
    suspend fun getCategories():CategoriesResponse
}


fun main(){
    var number:Int
    println("Please enter a number")
    try{
        //error prone code we want to execute
        number=readln().toInt()
        println("User entered $number")
    }catch (e:Exception){
        //What should happen when an error occurs
        println("Error ${e.message}")
    }
    finally {
        println("This will be executed regardless. Error or no error!")
    }
}
