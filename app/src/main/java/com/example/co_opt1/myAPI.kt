package com.example.co_opt1

import retrofit2.Call
import retrofit2.http.GET

interface myAPI {

    @GET("/products")
    fun getProducts(): Call<Products>

}