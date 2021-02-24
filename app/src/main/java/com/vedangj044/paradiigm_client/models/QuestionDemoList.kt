package com.vedangj044.paradiigm_client.models

import com.squareup.moshi.Json

data class QuestionDemoList(

    @Json(name = "question") val question: List<QuestionDemo>

)
