package com.example.testappp.ui.show

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.testappp.R
import com.example.testappp.data.local.model.Restaurant
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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        showViewModel.getAllRestaurantApi.load()

        showViewModel.getAllRestaurantApi.state.observe(viewLifecycleOwner, restaurantsObserve)

    }

    private val restaurantsObserve = Observer<UIState<Restaurant>> { state ->
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