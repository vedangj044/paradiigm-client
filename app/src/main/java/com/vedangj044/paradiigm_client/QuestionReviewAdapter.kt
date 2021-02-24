package com.vedangj044.paradiigm_client

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vedangj044.paradiigm_client.databinding.LayoutQuestionReviewBinding
import com.vedangj044.paradiigm_client.models.QuestionList

class QuestionReviewAdapter(private val dataset: List<QuestionList>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun getItemViewType(position: Int): Int {
        return dataset[position].questionTypeID
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            1 -> FillBlanksViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.demo_fill_blanks, parent, false))
            2 -> TrueFalseViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.demo_true_false, parent, false))
            3 -> MultiCorrectViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.demo_multiple_correct, parent, false))
            4 -> IntergerViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.review_integar, parent, false))
            else -> FillBlanksViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.demo_fill_blanks, parent, false))
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(getItemViewType(position)) {
            1 -> (holder as FillBlanksViewHolder).apply {
                val quest = dataset.get(position)

                text.text = quest.text
                option1.text = quest.option1
                option2.text = quest.option2
                option3.text = quest.option3
                option4.text = quest.option4

                if (quest.answer == quest.option1) option1i.visibility = View.VISIBLE else option1i.visibility = View.GONE
                if (quest.answer == quest.option2) option2i.visibility = View.VISIBLE else option2i.visibility = View.GONE
                if (quest.answer == quest.option3) option3i.visibility = View.VISIBLE else option3i.visibility = View.GONE
                if (quest.answer == quest.option4) option4i.visibility = View.VISIBLE else option4i.visibility = View.GONE

                yourans.visibility = View.VISIBLE
                corre.text = if (quest.response == 1) "Correct" else "Wrong"
                corre.visibility = View.VISIBLE
            }
            2 -> (holder as TrueFalseViewHolder).apply {
                val quest = dataset.get(position)

                text.text = quest.text

                if (quest.answer == "true") option1i.visibility = View.VISIBLE else option1i.visibility = View.GONE
                if (quest.answer == "false") option2i.visibility = View.VISIBLE else option2i.visibility = View.GONE

                yourans.visibility = View.VISIBLE
                corre.text = if (quest.response == 1) "Correct" else "Wrong"
                corre.visibility = View.VISIBLE
            }
            3 -> (holder as MultiCorrectViewHolder).apply {
                val quest = dataset.get(position)

                text.text = quest.text
                option1.text = quest.option1
                option2.text = quest.option2
                option3.text = quest.option3
                option4.text = quest.option4

                if (quest.answer1 == quest.option1) option1i.visibility = View.VISIBLE else option1i.visibility = View.GONE
                if (quest.answer2 == quest.option2) option2i.visibility = View.VISIBLE else option2i.visibility = View.GONE

                yourans.visibility = View.VISIBLE
                corre.text = if (quest.response == 1) "Correct" else "Wrong"
                corre.visibility = View.VISIBLE
            }
            4 -> (holder as IntergerViewHolder).apply {
                val quest = dataset.get(position)

                text.text = quest.text
                interger.text = quest.answer

                yourans.visibility = View.VISIBLE
                corre.text = if (quest.response == 1) "Correct" else "Wrong"
                corre.visibility = View.VISIBLE
            }
        }

    }

    private inner class FillBlanksViewHolder(private val view: View): RecyclerView.ViewHolder(view){

        val text: TextView = view.findViewById(R.id.question_text_test)
        val option1: TextView = view.findViewById(R.id.option_1_text_test)
        val option2: TextView = view.findViewById(R.id.option_2_text_test)
        val option3: TextView = view.findViewById(R.id.option_3_text_test)
        val option4: TextView = view.findViewById(R.id.option_4_text_test)
        val yourans: TextView = view.findViewById(R.id.your_andwer)

        val option1i: ImageView = view.findViewById(R.id.option_1_check_test)
        val option2i: ImageView = view.findViewById(R.id.option_2_check_test)
        val option3i: ImageView = view.findViewById(R.id.option_3_check_test)
        val option4i: ImageView = view.findViewById(R.id.option_4_check_test)

        val corre: TextView = view.findViewById(R.id.materialTextView2)

    }

    private inner class TrueFalseViewHolder(private val view: View): RecyclerView.ViewHolder(view){

        val text: TextView = view.findViewById(R.id.question_text_testtf)
        val option1: TextView = view.findViewById(R.id.option_1_text_testtf)
        val option2: TextView = view.findViewById(R.id.option_2_text_testtf)
        val yourans: TextView = view.findViewById(R.id.your_andwer)


        val option1i: ImageView = view.findViewById(R.id.option_1_check_testtf)
        val option2i: ImageView = view.findViewById(R.id.option_2_check_testtf)

        val corre: TextView = view.findViewById(R.id.materialTextView2)


    }

    private inner class MultiCorrectViewHolder(private val view: View): RecyclerView.ViewHolder(view){

        val text: TextView = view.findViewById(R.id.question_text_test)
        val option1: TextView = view.findViewById(R.id.option_1_text_test)
        val option2: TextView = view.findViewById(R.id.option_2_text_test)
        val option3: TextView = view.findViewById(R.id.option_3_text_test)
        val option4: TextView = view.findViewById(R.id.option_4_text_test)
        val yourans: TextView = view.findViewById(R.id.your_andwer)


        val option1i: ImageView = view.findViewById(R.id.option_1_check_test)
        val option2i: ImageView = view.findViewById(R.id.option_2_check_test)
        val option3i: ImageView = view.findViewById(R.id.option_3_check_test)
        val option4i: ImageView = view.findViewById(R.id.option_4_check_test)

        val corre: TextView = view.findViewById(R.id.materialTextView2)


    }

    private inner class IntergerViewHolder(private val view: View): RecyclerView.ViewHolder(view) {

        val text: TextView = view.findViewById(R.id.question_text_testtf)
        val interger: TextView = view.findViewById(R.id.materialTextView3)
        val yourans: TextView = view.findViewById(R.id.your_andwer)

        val corre: TextView = view.findViewById(R.id.materialTextView2)


    }

}