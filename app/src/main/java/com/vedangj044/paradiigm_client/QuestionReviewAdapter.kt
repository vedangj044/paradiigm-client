package com.vedangj044.paradiigm_client

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vedangj044.paradiigm_client.databinding.LayoutQuestionReviewBinding
import com.vedangj044.paradiigm_client.models.QuestionList

class QuestionReviewAdapter(private val dataset: List<QuestionList>): RecyclerView.Adapter<QuestionReviewAdapter.ViewHolder>() {

    class ViewHolder(private val view: LayoutQuestionReviewBinding): RecyclerView.ViewHolder(view.root) {

        fun bindBlank(testReview: QuestionList) {

            view.questionText.text = testReview.questionText

            view.option1Text.text = testReview.option.get(0)
            view.option2Text.text = testReview.option.get(1)
            view.option3Text.text = testReview.option.get(2)
            view.option4Text.text = "None of the above"

            view.option3.visibility = View.VISIBLE
            view.option3Text.visibility = View.VISIBLE
            view.option3Check.visibility = View.VISIBLE
            view.option4.visibility = View.VISIBLE
            view.option4Text.visibility = View.VISIBLE
            view.option4Check.visibility = View.VISIBLE

            view.option1Check.visibility = View.GONE
            view.option2Check.visibility = View.GONE
            view.option3Check.visibility = View.GONE
            view.option4Check.visibility = View.GONE

            when (testReview.correctOption) {
                1 -> view.option1Check.visibility = View.VISIBLE
                2 -> view.option2Check.visibility = View.VISIBLE
                3 -> view.option3Check.visibility = View.VISIBLE
                else -> view.option4Check.visibility = View.VISIBLE
            }

            when (testReview.response) {
                1 -> view.materialTextView2.text = "Correct"
                2 -> view.materialTextView2.text = "Incorrect"
            }

        }

        fun bindBool(testReview: QuestionList) {

            view.questionText.text = testReview.questionText

            view.option1Text.text = "True"
            view.option2Text.text = "False"

            view.option3.visibility = View.GONE
            view.option3Text.visibility = View.GONE
            view.option3Check.visibility = View.GONE
            view.option4.visibility = View.GONE
            view.option4Text.visibility = View.GONE
            view.option4Check.visibility = View.GONE

            view.option1Check.visibility = View.GONE
            view.option2Check.visibility = View.GONE
            view.option3Check.visibility = View.GONE
            view.option4Check.visibility = View.GONE


            when (testReview.correctTF) {
                1 -> view.option1Check.visibility = View.VISIBLE
                2 -> view.option2Check.visibility = View.VISIBLE
            }

            when (testReview.response) {
                1 -> view.materialTextView2.text = "Correct"
                0 -> view.materialTextView2.text = "Incorrect"
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutQuestionReviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when(dataset.get(position).questionType) {
            1 -> holder.bindBlank(dataset.get(position))
            2 -> holder.bindBool(dataset.get(position))
        }
    }

}