package com.vedangj044.paradiigm_client.models

import com.squareup.moshi.Json

data class TestReview (

	@Json(name = "date") val date : String,
	@Json(name = "course_name") val course_name : String,
	@Json(name = "score") val score : Int,
	@Json(name = "rank") val rank : Int,
	@Json(name = "questionList") val questionList : List<QuestionList>
)