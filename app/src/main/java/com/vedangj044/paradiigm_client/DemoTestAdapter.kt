package com.vedangj044.paradiigm_client

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vedangj044.paradiigm_client.models.QuestionDemo
import retrofit2.http.POST

class DemoTestAdapter(var mDataset: List<QuestionDemo>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val answer = mutableListOf(false, false, false)

    override fun getItemViewType(position: Int): Int {
        return mDataset[position].questionTypeID
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            1 -> FillBlanksViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.demo_fill_blanks, parent, false))
            2 -> TrueFalseViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.demo_true_false, parent, false))
            3 -> MultiCorrectViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.demo_multiple_correct, parent, false))
            4 -> IntergerViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.demo_itergar, parent, false))
            else -> FillBlanksViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.demo_fill_blanks, parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(getItemViewType(position)) {
            1 -> {
                (holder as FillBlanksViewHolder).apply {
                    val quest = mDataset.get(position)

                    text.text = quest.text
                    option1.text = quest.option1
                    option2.text = quest.option2
                    option3.text = quest.option3
                    option4.text = quest.option4

                    option1.setOnClickListener {
                        option1i.visibility = if (option1i.visibility == View.VISIBLE) View.GONE else View.VISIBLE
                        option2i.visibility = View.GONE
                        option3i.visibility = View.GONE
                        option4i.visibility = View.GONE

                        answer[position] = quest.answer == quest.option1 && option1i.visibility == View.VISIBLE
                    }

                    option2.setOnClickListener {
                        option1i.visibility = View.GONE
                        option2i.visibility = if (option2i.visibility == View.VISIBLE) View.GONE else View.VISIBLE
                        option3i.visibility = View.GONE
                        option4i.visibility = View.GONE

                        answer[position] = quest.answer == quest.option2 && option2i.visibility == View.VISIBLE
                    }

                    option3.setOnClickListener {
                        option1i.visibility = View.GONE
                        option2i.visibility = View.GONE
                        option3i.visibility = if (option3i.visibility == View.VISIBLE) View.GONE else View.VISIBLE
                        option4i.visibility = View.GONE

                        answer[position] = quest.answer == quest.option3 && option3i.visibility == View.VISIBLE
                    }

                    option4.setOnClickListener {
                        option1i.visibility = View.GONE
                        option2i.visibility = View.GONE
                        option3i.visibility = View.GONE
                        option4i.visibility = if (option4i.visibility == View.VISIBLE) View.GONE else View.VISIBLE

                        answer[position] = quest.answer == quest.option4 && option4i.visibility == View.VISIBLE
                    }
                }
            }
            2 -> {
                (holder as TrueFalseViewHolder).apply {

                    val quest = mDataset.get(position)

                    text.text = quest.text

                    option1.setOnClickListener {
                        option1i.visibility = if (option1i.visibility == View.VISIBLE) View.GONE else View.VISIBLE
                        option2i.visibility = View.GONE
                        answer[position] = quest.answer == "true" && option1i.visibility == View.VISIBLE
                    }

                    option2.setOnClickListener {
                        option1i.visibility = View.GONE
                        option2i.visibility = if (option2i.visibility == View.VISIBLE) View.GONE else View.VISIBLE
                        answer[position] = quest.answer == "false" && option2i.visibility == View.VISIBLE
                    }

                }
            }
            3 -> {
                (holder as MultiCorrectViewHolder).apply {
                    val quest = mDataset.get(position)

                    var resp = 0

                    text.text = quest.text
                    option1.text = quest.option1
                    option2.text = quest.option2
                    option3.text = quest.option3
                    option4.text = quest.option4

                    option1.setOnClickListener {
                        option1i.visibility = if (option1i.visibility == View.VISIBLE) View.GONE else View.VISIBLE
                        answer[position] = option1i.visibility == View.VISIBLE && option2i.visibility == View.VISIBLE && option3i.visibility == View.GONE && option4i.visibility == View.GONE
                    }

                    option2.setOnClickListener {
                        option2i.visibility = if (option2i.visibility == View.VISIBLE) View.GONE else View.VISIBLE
                        answer[position] = option1i.visibility == View.VISIBLE && option2i.visibility == View.VISIBLE && option3i.visibility == View.GONE && option4i.visibility == View.GONE
                    }

                    option3.setOnClickListener {
                        option3i.visibility = if (option3i.visibility == View.VISIBLE) View.GONE else View.VISIBLE
                        answer[position] = option1i.visibility == View.VISIBLE && option2i.visibility == View.VISIBLE && option3i.visibility == View.GONE && option4i.visibility == View.GONE
                    }

                    option4.setOnClickListener {
                        option4i.visibility = if (option4i.visibility == View.VISIBLE) View.GONE else View.VISIBLE
                        answer[position] = option1i.visibility == View.VISIBLE && option2i.visibility == View.VISIBLE && option3i.visibility == View.GONE && option4i.visibility == View.GONE
                    }
                }
            }
            4 -> {
                (holder as IntergerViewHolder).apply {
                    val quest = mDataset.get(position)

                    text.text = quest.text
                    interger.addTextChangedListener(object: TextWatcher {

                        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

                        }

                        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                        }

                        override fun afterTextChanged(s: Editable?) {
                            answer[position] = s.toString() == quest.answer
                        }
                    })
                }
            }
        }



    }

    override fun getItemCount(): Int {
        return mDataset.size
    }

    private inner class FillBlanksViewHolder(private val view: View): RecyclerView.ViewHolder(view){

        val text: TextView = view.findViewById(R.id.question_text_test)
        val option1: TextView = view.findViewById(R.id.option_1_text_test)
        val option2: TextView = view.findViewById(R.id.option_2_text_test)
        val option3: TextView = view.findViewById(R.id.option_3_text_test)
        val option4: TextView = view.findViewById(R.id.option_4_text_test)

        val option1i: ImageView = view.findViewById(R.id.option_1_check_test)
        val option2i: ImageView = view.findViewById(R.id.option_2_check_test)
        val option3i: ImageView = view.findViewById(R.id.option_3_check_test)
        val option4i: ImageView = view.findViewById(R.id.option_4_check_test)

    }

    private inner class TrueFalseViewHolder(private val view: View): RecyclerView.ViewHolder(view){

        val text: TextView = view.findViewById(R.id.question_text_testtf)
        val option1: TextView = view.findViewById(R.id.option_1_text_testtf)
        val option2: TextView = view.findViewById(R.id.option_2_text_testtf)

        val option1i: ImageView = view.findViewById(R.id.option_1_check_testtf)
        val option2i: ImageView = view.findViewById(R.id.option_2_check_testtf)

    }

    private inner class MultiCorrectViewHolder(private val view: View): RecyclerView.ViewHolder(view){

        val text: TextView = view.findViewById(R.id.question_text_test)
        val option1: TextView = view.findViewById(R.id.option_1_text_test)
        val option2: TextView = view.findViewById(R.id.option_2_text_test)
        val option3: TextView = view.findViewById(R.id.option_3_text_test)
        val option4: TextView = view.findViewById(R.id.option_4_text_test)

        val option1i: ImageView = view.findViewById(R.id.option_1_check_test)
        val option2i: ImageView = view.findViewById(R.id.option_2_check_test)
        val option3i: ImageView = view.findViewById(R.id.option_3_check_test)
        val option4i: ImageView = view.findViewById(R.id.option_4_check_test)

    }

    private inner class IntergerViewHolder(private val view: View): RecyclerView.ViewHolder(view) {

        val text: TextView = view.findViewById(R.id.question_text_testtf)
        val interger: EditText = view.findViewById(R.id.intergaranswer)

    }


}