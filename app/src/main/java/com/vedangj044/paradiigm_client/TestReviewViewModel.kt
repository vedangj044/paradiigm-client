package com.vedangj044.paradiigm_client

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vedangj044.paradiigm_client.models.TestReview
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import kotlin.reflect.jvm.internal.impl.name.ClassId

class TestReviewViewModel(private val  basicInfoApiService: Retrofit, private val classId: Int): ViewModel() {

    val studentID = 1
    val sendObj = MutableLiveData<TestReview>()

    init {
        getData()
    }

    fun getData() {

        viewModelScope.launch {
            val resp = basicInfoApiService.create(BasicInfoApiService::class.java).getTestReview(studentID, classId)
            val response = resp.body()
            sendObj.value = response
        }
    }
}