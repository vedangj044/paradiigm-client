package com.vedangj044.paradiigm_client.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

//{
//    "answer1": null,
//    "answer": "3",
//    "option3": null,
//    "option1": null,
//    "asked": 0,
//    "classID": 9,
//    "questionTypeID": 4,
//    "answer2": null,
//    "score": 1,
//    "option4": null,
//    "option2": null,
//    "flagged": 0,
//    "text": "Second figure is of a mathematical puzzle, called tower of Hanoi, where we have ____ rods or ____ pegs and multiple disks and the game is about moving a stack of discs, from one peg to another with this constraint that, a disc can not go on top of a smaller disc.",
//    "questionID": 63,
//    "answer3": null
//}

@JsonClass(generateAdapter = true)
data class QuestionDemo (

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
    @Json(name = "answer3") val answer3: String?

)