package com.vedangj044.paradiigm_client

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import retrofit2.Retrofit

class DemoTestViewModelFactory(private val basicInfoApiService: Retrofit, private val classID: Int, private val studentID: Int): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DemoTestViewModel::class.java)){
            return DemoTestViewModel(basicInfoApiService, classID, studentID) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}