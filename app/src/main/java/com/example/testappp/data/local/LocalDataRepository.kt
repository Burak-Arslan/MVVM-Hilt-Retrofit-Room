package com.example.testappp.data.local

import android.app.Application
import com.example.testappp.data.local.dao.RestaurantDao
import com.example.testappp.data.local.model.Restaurant

interface LocalDataRepository {
    suspend fun getAllRestaurants(): List<Restaurant>
    suspend fun insertRestaurants(restaurant: List<Restaurant>)
}

class LocalDataReLpositoryImp(application: Application) : LocalDataRepository {

    private var restaurantDao: RestaurantDao =
        AppDatabase.getDatabase(application)!!.restaurantDao()

    override suspend fun getAllRestaurants(): List<Restaurant>{
        return restaurantDao.getAllRestaurants()
    }

    override suspend fun insertRestaurants(restaurant: List<Restaurant>) {
        return restaurantDao.insertRestaurants(restaurant)
    }
}