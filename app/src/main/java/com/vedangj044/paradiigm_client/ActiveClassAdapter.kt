package com.vedangj044.paradiigm_client

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vedangj044.paradiigm_client.databinding.LayoutActiveItemBinding
import com.vedangj044.paradiigm_client.models.Active

class ActiveClassAdapter(private val dataset: List<Active>, val clickLis: (Active, Int) -> Unit): RecyclerView.Adapter<ActiveClassAdapter.ViewHolder>() {

    class ViewHolder(private val view: LayoutActiveItemBinding): RecyclerView.ViewHolder(view.root) {

        fun bind(active: Active){
            view.itemBinding = active
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutActiveItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ActiveClassAdapter.ViewHolder, position: Int) {
        dataset.get(position).let { holder.bind(it) }


    }

}