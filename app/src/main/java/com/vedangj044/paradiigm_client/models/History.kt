package com.vedangj044.paradiigm_client.models

import com.squareup.moshi.Json

data class History (

	@Json(name = "classID") val classID : Int,
	@Json(name = "course_name") val course_name : String,
	@Json(name = "date") val date : String,
	@Json(name = "rank") val rank : Int,
	@Json(name = "score") val score : String
)