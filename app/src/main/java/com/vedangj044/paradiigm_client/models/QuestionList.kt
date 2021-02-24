package com.vedangj044.paradiigm_client.models

import com.squareup.moshi.Json

data class QuestionList (

	@Json(name = "answer1") val answer1: String?,
	@Json(name = "answer") val answer: String?,
	@Json(name = "answer2") val answer2: String?,
	@Json(name = "option1") val option1: String?,
	@Json(name = "option3") val option3: String?,
	@Json(name = "asked") val asked: Int,
	@Json(name = "classID") val classID: Int,
	@Json(name = "questionTypeID") val questionTypeID: Int,
	@Json(name = "score") val score: Int,
	@Json(name = "option4") val option4: String?,
	@Json(name = "option2") val option2: String?,
	@Json(name = "flagged") val flagged: Int,
	@Json(name = "text") val text: String,
	@Json(name = "questionID") val questionID: Int,
	@Json(name = "answer3") val answer3: String?,
	@Json(name = "response") val response : Int

)