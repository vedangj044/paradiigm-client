package com.vedangj044.paradiigm_client

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vedangj044.paradiigm_client.models.BasicInfo
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import kotlin.coroutines.CoroutineContext

class BasicInfoViewModel(private val basicInfoApiService: Retrofit): ViewModel() {

    val studentID: Int = 1
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


}