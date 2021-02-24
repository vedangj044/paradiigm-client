package com.vedangj044.paradiigm_client

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class DemoTestViewModel(private val  basicInfoApiService: Retrofit, private val classId: Int, private val studentID: Int): ViewModel() {

    fun submitResponse(questionID: Int, valid: Boolean) {
        viewModelScope.launch {
            val resp = basicInfoApiService.create(BasicInfoApiService::class.java).submitResponse(studentID, questionID, valid)
        }
    }

    fun generateQuestion(set: Int) {
        viewModelScope.launch {
            basicInfoApiService.create(BasicInfoApiService::class.java).getQuestionSet(classId, set)
        }
    }

    fun getQuestion() {
        viewModelScope.launch {
            val resp = basicInfoApiService.create(BasicInfoApiService::class.java).getLastQuestion(classID = classId, studentID = studentID)
        }
    }

    fun endClass() {
        viewModelScope.launch {
            basicInfoApiService.create(BasicInfoApiService::class.java).endClass(classId)
        }
    }

}