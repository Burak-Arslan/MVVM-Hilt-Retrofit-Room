package com.example.testappp.data.repository


import com.example.testappp.data.local.AppDatabase
import com.example.testappp.data.local.model.Restaurants
import com.example.testappp.data.local.model.RestaurantsItem
import com.example.testappp.data.service.Api
import javax.inject.Inject
import retrofit2.Response


class DataRepository @Inject constructor(
    private val apiService: Api,
    private val localDataRepository: AppDatabase
) {

    private val restaurantsDatabase = localDataRepository.restaurantDao()

    suspend fun getAllRestaurantsData(): List<RestaurantsItem> {
        return restaurantsDatabase.getAllRestaurants()
    }

    suspend fun insertRestaurants(restaurant: List<RestaurantsItem>) {
        return restaurantsDatabase.insertRestaurants(restaurant)
    }

    suspend fun getAllRestaurantApi(): Response<Restaurants> {
        return apiService.getRestaurants()
    }
}
