package com.vedangj044.paradiigm_client.models

import com.squareup.moshi.Json

data class QuestionList (

	@Json(name = "questionText") val questionText : String,
	@Json(name = "option") val option : List<String>,
	@Json(name = "correctOption") val correctOption : Int,
	@Json(name = "questionType") val questionType : Int,
	@Json(name = "response") val response : Int
)