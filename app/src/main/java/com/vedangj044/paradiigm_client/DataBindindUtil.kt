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

@BindingAdapter("setWelcomeText")
fun TextView.setWelcomeText(string: String?) {
    text = "Welcome, " + string
}

@BindingAdapter("setAttendees")
fun TextView.setAttendees(string: Int) {
    text = string.toString() + " Attendees"
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

@BindingAdapter("setImageCoil")
fun setImageCoil(view: ImageView, url: String?){

    Glide.with(view).load(url)
        .apply(RequestOptions().placeholder(ColorDrawable(ContextCompat.getColor(view.context, R.color.placeholder_color)))
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE))
        .circleCrop()
        .into(view)
}