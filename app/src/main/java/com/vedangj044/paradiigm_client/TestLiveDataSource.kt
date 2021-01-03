package com.vedangj044.paradiigm_client

import com.vedangj044.paradiigm_client.models.QuestionTest
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import java.text.SimpleDateFormat
import java.util.*

class TestLiveDataSource (private val basicInfoApiService: Retrofit, private val classID: Int) {

    lateinit var flow: Flow<QuestionTest?>
    private lateinit var tim: String

    init {

        flow = flow {
            delay(10000)
            tim = SimpleDateFormat("mm").format(Date(System.currentTimeMillis()))

            if (tim[1] == '1' && tim[1] == '6') {
                emit(getData())
            }

        }

    }

    suspend fun getData(): QuestionTest? {
        val resp = basicInfoApiService.create(BasicInfoApiService::class.java).getLastQuestion(classID)
        return resp.body()
    }
}