package com.example.testappp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.testappp.data.local.model.Restaurants
import com.example.testappp.data.local.model.RestaurantsItem

@Dao
interface RestaurantDao {

    @Query("SELECT * from restaurants")
   suspend fun getAllRestaurants(): List<RestaurantsItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRestaurants(restaurant: List<RestaurantsItem>)

    @Query("DELETE FROM restaurants")
    suspend fun deleteAllRestaurants()

}