package com.vedangj044.paradiigm_client

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vedangj044.paradiigm_client.models.BasicInfo
import kotlinx.coroutines.launch
import retrofit2.Retrofit


class BasicInfoViewModel(private val basicInfoApiService: Retrofit, private val studentID: Int): ViewModel() {

    val sendObj = MutableLiveData<BasicInfo>()

    init {
        getData()
    }

    fun getData() {

        viewModelScope.launch {
            val resp = basicInfoApiService.create(BasicInfoApiService::class.java).getBasicInfo(studentID)
            val response = resp.body()
            sendObj.value = response
        }

    }

    fun enrollTrigger(classID: Int, index: Int) {

        viewModelScope.launch {
            val resp = basicInfoApiService.create(BasicInfoApiService::class.java).getEnrollment(studentID, classID)
            getData()
        }


    }


}