package com.example.testappp.ui.show

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.testappp.R
import com.example.testappp.data.local.model.Restaurants
import com.example.testappp.data.local.model.RestaurantsItem
import com.example.testappp.data.state.UIState
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ShowFragment @Inject constructor() : Fragment() {

    private val showViewModel: ShowViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_show, container, false)
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showViewModel.getAllRestaurantApi.load()
        showViewModel.getAllRestaurantApi.state.observe(viewLifecycleOwner, restaurantsObserve)
        showViewModel.insertRestaurants(listOf(RestaurantsItem("", "")))

        returnViewModel()
    }

    private  fun returnViewModel() {
        showViewModel.getAllRestaurants()
        showViewModel.restaurants.observe(viewLifecycleOwner, Observer {
            it.let {
                var test = ""
            }
        })
    }


    private val restaurantsObserve = Observer<UIState<Restaurants>> { state ->
        when (state) {
            is UIState.Loading -> {
                if (state.isLoading) {

                } else {

                }
            }
            is UIState.Failure -> {
                var test = ""
            }
            is UIState.Success -> {
                var test = ""
            }
        }
    }
}