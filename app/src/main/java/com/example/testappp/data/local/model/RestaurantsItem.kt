package com.example.testappp.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "restaurants")
data class RestaurantsItem(
   //val zip: String,
   //val streetAddress: String,
   //val country: String,
   //val cityPrefix: String,
   //val secondaryAddress: String,
   //val mailBox: String,
   //val city: String,
   //val latitude: Double,
   //val postcode: String,
   //val citySuffix: String,
   //val fullAddress: String,
   //val community: String,
    val timeZone: String,
    @PrimaryKey
    val streetName: String,
  // val zipCode: String,
  // val streetSuffix: String,
  // val uid: String,
  // val countryCode: String,
  // val stateAbbr: String,
  // val id: Int,
  // val state: String,
  // val buildingNumber: String,
  // val longitude: Double
)