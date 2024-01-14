package com.example.apiproject

import MyData
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("products")    // api url ka last string

    fun getProductData():Call<MyData>
}