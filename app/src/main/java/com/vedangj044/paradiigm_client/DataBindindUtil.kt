package com.vedangj044.paradiigm_client

import android.graphics.drawable.ColorDrawable
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.vedangj044.paradiigm_client.models.QuestionList
import com.vedangj044.paradiigm_client.models.TestReview

@BindingAdapter("setWelcomeText")
fun TextView.setWelcomeText(string: String?) {
    text = "Welcome, " + string
}

@BindingAdapter("setAttendees")
fun TextView.setAttendees(string: Int) {
    text = string.toString() + " Attendees"
}

@BindingAdapter("setClassid")
fun TextView.setClassid(string: Int) {
    text = "Class: " + string.toString()
}

@BindingAdapter("setRank")
fun TextView.setRank(ine: Int){
    text = ine.toString()
}

@BindingAdapter("isEnrolled")
fun Button.isEnrolled(enrolled: Boolean) {
    if (enrolled) {
        text = "Resume"
    }
    else {
        text = "Enroll"
    }
}

@BindingAdapter("isCorrect")
fun TextView.setCorrect(tr: Int) {
    if (tr == 1){
        text = "Correct"
    }
    else{
        text = "Wrong"
    }
}

@BindingAdapter("setScore")
fun TextView.setScore(tr: TestReview?){
    if (tr != null) {
        text = tr.score.toString() + "/" +tr.questionList.size.toString()
    }
}

@BindingAdapter("setImageCoil")
fun setImageCoil(view: ImageView, url: String?){

    Glide.with(view).load(url)
        .apply(RequestOptions().placeholder(ColorDrawable(ContextCompat.getColor(view.context, R.color.placeholder_color)))
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE))
        .circleCrop()
        .into(view)
}