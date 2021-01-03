package com.vedangj044.paradiigm_client

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.viewModelScope
import com.vedangj044.paradiigm_client.models.QuestionTest
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class TestLiveViewModel(private val  basicInfoApiService: Retrofit, private val classId: Int): ViewModel() {

    val sendTest = MutableLiveData<QuestionTest>()
    var dataSource: TestLiveDataSource = TestLiveDataSource(basicInfoApiService, classId)

}