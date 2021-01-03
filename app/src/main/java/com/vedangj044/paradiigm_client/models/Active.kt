package com.vedangj044.paradiigm_client.models

import com.squareup.moshi.Json


data class Active (

	@Json(name = "class_id") val class_id : Int,
	@Json(name = "course_name") val course_name : String,
	@Json(name = "participants") val participants : Int,
	@Json(name = "isEnrolled") var isEnrolled : Boolean
)