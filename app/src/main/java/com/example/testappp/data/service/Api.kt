package com.example.testappp.data.service


import com.example.testappp.data.local.model.Restaurants
import retrofit2.Response
import retrofit2.http.GET


interface Api {
    @GET("address/random_address?size=20")
    suspend fun getRestaurants(): Response<Restaurants>
}