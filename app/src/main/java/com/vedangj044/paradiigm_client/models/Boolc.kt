package com.vedangj044.paradiigm_client.models

import com.squareup.moshi.Json

data class Boolc (

        @Json(name = "answer") val answer : Boolean,
        @Json(name = "bool") val blank : String

)