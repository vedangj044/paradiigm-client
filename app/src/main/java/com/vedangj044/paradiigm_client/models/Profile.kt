package com.vedangj044.paradiigm_client.models

import com.squareup.moshi.Json

data class Profile (

	@Json(name = "studentID") val studentID : Int,
	@Json(name = "age") val age : Int,
	@Json(name = "name") val name : String,
	@Json(name = "profilePicture") val profilePicture : String,
	@Json(name = "gender") val gender : String
)