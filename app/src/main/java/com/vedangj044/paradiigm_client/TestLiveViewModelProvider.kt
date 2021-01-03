package com.vedangj044.paradiigm_client

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import retrofit2.Retrofit

class TestLiveViewModelProvider(private val basicInfoApiService: Retrofit, private val classID: Int): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TestLiveViewModel::class.java)){
            return TestLiveViewModel(basicInfoApiService, classID) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}