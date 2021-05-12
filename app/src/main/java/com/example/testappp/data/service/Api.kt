package com.example.testappp.data.service

import androidx.lifecycle.MutableLiveData
import com.example.testappp.data.local.model.Restaurant
import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET("restaurant/random_restaurant?size=20")
    suspend fun getRestaurants(): Response<Restaurant>
}