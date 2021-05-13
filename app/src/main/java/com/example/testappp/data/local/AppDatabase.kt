package com.example.testappp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.testappp.data.local.dao.RestaurantDao
import com.example.testappp.data.local.model.RestaurantsItem

@Database(entities = [RestaurantsItem::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun restaurantDao(): RestaurantDao
}