package com.vedangj044.paradiigm_client

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.vedangj044.paradiigm_client.models.*
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query
import java.util.concurrent.TimeUnit


interface BasicInfoApiService {

    @Headers("Accept: application/json")
    @GET("basicinfodemo")
    suspend fun getBasicInfo(@Query("studntID") studentID: Int): Response<BasicInfo>

    @GET("questionset")
    suspend fun getQuestionSet(@Query("classID") classID: Int, @Query("set1") set: Int)

    @GET("stopclass")
    suspend fun endClass(@Query("classID") classID: Int)

    @Headers("Accept: application/json")
    @GET("testreview")
    suspend fun getTestReview(@Query("stundentID") studentID: Int, @Query("classID") classID: Int): Response<TestReview>

    @Headers("Accept: application/json")
    @GET("getquestion")
    suspend fun getLastQuestion(@Query("classID") classID: Int, @Query("studentID") studentID: Int): Response<QuestionDemoList>

    @Headers("Accept: application/json")
    @GET("enrollclass")
    suspend fun getEnrollment(@Query("studntID") studentID: Int, @Query("classID") classID: Int): Response<Enroll>

    @Headers("Accept: application/json")
    @GET("submitresponse")
    suspend fun submitResponse(@Query("studentID") studentID: Int, @Query("questionID") questionID: Int, @Query("valid") valid: Boolean): Response<Enroll>

    companion object{

        private val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        private val client = OkHttpClient().newBuilder()
                .connectTimeout(100, TimeUnit.SECONDS)
                .readTimeout(100, TimeUnit.SECONDS)
                .writeTimeout(100, TimeUnit.SECONDS)
                .build()

        fun getApiService() = Retrofit.Builder()
            .baseUrl("http://168.63.210.246:8000/").client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }


}
