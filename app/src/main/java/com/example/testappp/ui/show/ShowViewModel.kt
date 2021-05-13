package com.example.testappp.ui.show

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testappp.data.local.model.Restaurants
import com.example.testappp.data.local.model.RestaurantsItem
import com.example.testappp.data.repository.DataRepository
import com.example.testappp.data.state.StateLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ShowViewModel @Inject constructor(private val dataRepository: DataRepository) :
    ViewModel() {

    val restaurants = MutableLiveData<List<RestaurantsItem>>()

     fun getAllRestaurants() {
        viewModelScope.launch {
            restaurants.value = dataRepository.getAllRestaurantsData()
        }
    }

    fun insertRestaurants(restaurant: List<RestaurantsItem>){
        viewModelScope.launch {
         dataRepository.insertRestaurants(restaurant)
        }
    }

    public val getAllRestaurantApi =
        StateLiveData(viewModelScope.coroutineContext + Dispatchers.Main) {
            dataRepository.getAllRestaurantApi()
        }
}