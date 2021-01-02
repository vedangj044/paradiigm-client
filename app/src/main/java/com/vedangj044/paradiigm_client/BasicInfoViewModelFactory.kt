package com.vedangj044.paradiigm_client

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import retrofit2.Retrofit

class BasicInfoViewModelFactory(private val basicInfoApiService: Retrofit): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BasicInfoViewModel::class.java)){
            return BasicInfoViewModel(basicInfoApiService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}