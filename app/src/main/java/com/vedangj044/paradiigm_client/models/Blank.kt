package com.vedangj044.paradiigm_client.models

import com.squareup.moshi.Json

data class Blank (

        @Json(name = "answer") val answer : String,
        @Json(name = "blank") val blank : String,
        @Json(name = "option1") val option1: String,
        @Json(name = "option2") val option2: String,
        @Json(name = "option3") val option3: String

)