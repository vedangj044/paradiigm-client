package com.vedangj044.paradiigm_client

import android.util.Log
import com.vedangj044.paradiigm_client.models.QuestionTest
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import java.text.SimpleDateFormat
import java.util.*

class TestLiveDataSource (private val basicInfoApiService: Retrofit, private val classID: Int, private val studentID: Int) {

    var flow: Flow<QuestionTest?>
    private lateinit var tim: String

    init {

        flow = flow {

            while (true) {

                Log.v("hel", "hel")
                tim = SimpleDateFormat("mm").format(Date(System.currentTimeMillis()))

                Log.v("fe", tim[1].toString())
                emit(getData())
                delay(100000)
//                if (tim[1].toString().equals("1") || tim[1].toString().equals("6")) {
//                    emit(getData())
//                }
            }

        }

    }

    suspend fun getData(): QuestionTest? {
        try {
            val resp = null
            return resp
        }
        catch (e: Exception){
            return null
        }
    }
}