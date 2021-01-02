package com.vedangj044.paradiigm_client

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vedangj044.paradiigm_client.databinding.LayoutScoreItemBinding
import com.vedangj044.paradiigm_client.models.Active
import com.vedangj044.paradiigm_client.models.History

class ScoreClassAdapter(private val dataset: List<History>): RecyclerView.Adapter<ScoreClassAdapter.ViewHolder>() {

    class ViewHolder(private val view: LayoutScoreItemBinding): RecyclerView.ViewHolder(view.root) {

        fun bind(score: History){
            view.scoreBinding = score
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutScoreItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }


    override fun onBindViewHolder(holder: ScoreClassAdapter.ViewHolder, position: Int) {
        dataset.get(position).let { holder.bind(it) }
    }

}