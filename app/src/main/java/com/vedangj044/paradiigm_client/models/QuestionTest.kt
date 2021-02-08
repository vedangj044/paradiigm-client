package com.vedangj044.paradiigm_client.models

import com.squareup.moshi.Json

data class QuestionTest (

        @Json(name = "blank") val blank: Blank,
        @Json(name = "bool") val boolc: Boolc,
        @Json(name = "tags") val tags: List<String>

)