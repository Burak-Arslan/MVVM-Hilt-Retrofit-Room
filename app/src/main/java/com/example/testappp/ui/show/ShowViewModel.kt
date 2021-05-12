package com.example.testappp.ui.show

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testappp.data.local.model.Restaurant
import com.example.testappp.data.repository.DataRepository
import com.example.testappp.data.state.StateLiveData
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShowViewModel @ViewModelScoped constructor(private val dataRepository: DataRepository) :
    ViewModel() {
    val restaurants = MutableLiveData<List<Restaurant>>()

    fun getAllRestaurants() {
        viewModelScope.launch {
            restaurants.value = dataRepository.getAllRestaurantsData()
        }
    }

    fun insertRestaurants(restaurant: List<Restaurant>){
        viewModelScope.launch {
         dataRepository.insertRestaurants(restaurant)
        }
    }

    public val getAllRestaurantApi =
        StateLiveData(viewModelScope.coroutineContext + Dispatchers.Main) {
            dataRepository.getAllRestaurantApi()
        }
}