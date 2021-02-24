package com.vedangj044.paradiigm_client

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.vedangj044.paradiigm_client.databinding.DemoFillBlanksBinding
import com.vedangj044.paradiigm_client.databinding.DemoItergarBinding
import com.vedangj044.paradiigm_client.databinding.DemoMultipleCorrectBinding
import com.vedangj044.paradiigm_client.databinding.DemoTrueFalseBinding
import com.vedangj044.paradiigm_client.models.QuestionDemo
import retrofit2.http.POST

class DemoTestAdapter(private val mDataset: List<QuestionDemo>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return mDataset[position].questionTypeID
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            1 -> FillBlanksViewHolder(DemoFillBlanksBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            2 -> TrueFalseViewHolder(DemoTrueFalseBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            3 -> MultiCorrectViewHolder(DemoMultipleCorrectBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            4 -> IntergerViewHolder(DemoItergarBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            else -> FillBlanksViewHolder(DemoFillBlanksBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(getItemViewType(position)) {
            1 -> {
                val hold = (holder as FillBlanksViewHolder)
                hold.bind(mDataset.get(position))

                hold.itemView.

            }
            2 -> {
                (holder as TrueFalseViewHolder).bind(mDataset.get(position))
            }
            3 -> {
                (holder as MultiCorrectViewHolder).bind(mDataset.get(position))
            }
            4 -> {
                (holder as IntergerViewHolder).bind(mDataset.get(position))
            }
        }



    }

    override fun getItemCount(): Int {
        return mDataset.size
    }

    private class FillBlanksViewHolder: RecyclerView.ViewHolder(view.root){

        constructor(itemView: View) : {
            super
        }


        fun bind(quest: QuestionDemo){
            view.testQuestion = quest
        }


    }

    private inner class TrueFalseViewHolder(private val view: DemoTrueFalseBinding): RecyclerView.ViewHolder(view.root){
        fun bind(quest: QuestionDemo){
            view.testQuestion = quest
        }

    }

    private inner class MultiCorrectViewHolder(private val view: DemoMultipleCorrectBinding): RecyclerView.ViewHolder(view.root){
        fun bind(quest: QuestionDemo){
            view.testQuestion = quest
        }

    }

    private inner class IntergerViewHolder(private val view: DemoItergarBinding): RecyclerView.ViewHolder(view.root) {
        fun bind(quest: QuestionDemo){
            view.testQuestion = quest
        }

    }


}