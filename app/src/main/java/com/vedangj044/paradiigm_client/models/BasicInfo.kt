package com.vedangj044.paradiigm_client.models

import com.squareup.moshi.Json


data class BasicInfo (

	@Json(name = "profile") val profile : Profile,
	@Json(name = "history") val history : List<History>,
	@Json(name = "active") val active : List<Active>
)