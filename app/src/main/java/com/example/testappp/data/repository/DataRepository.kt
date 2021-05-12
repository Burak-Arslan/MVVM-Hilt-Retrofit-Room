package com.example.testappp.data.repository


import com.example.testappp.data.local.LocalDataRepository
import com.example.testappp.data.local.model.Restaurant
import com.example.testappp.data.service.Api
import javax.inject.Inject
import javax.inject.Singleton
import retrofit2.Response


@Singleton
class DataRepository @Inject constructor(
    val apiService: Api,
    val localDataRepository: LocalDataRepository
) {

    suspend fun getAllRestaurantsData(): List<Restaurant> {
        return localDataRepository.getAllRestaurants()
    }

    suspend fun insertRestaurants(restaurant: List<Restaurant>) {
        return localDataRepository.insertRestaurants(restaurant)
    }

    suspend fun getAllRestaurantApi(): Response<Restaurant> {
        return apiService.getRestaurants()
    }
}
