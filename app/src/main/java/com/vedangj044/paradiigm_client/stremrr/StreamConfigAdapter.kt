package com.vedangj044.paradiigm_client.stremrr

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.vedangj044.paradiigm_client.R

class StreamConfigAdapter: RecyclerView.Adapter<StreamConfigAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class ViewHolder(private val itemview: View): RecyclerView.ViewHolder (itemview) {

        val dataBack = itemview.findViewById<CardView>(R.id.data_back)
        val dataName = itemview.findViewById<TextView>(R.id.data_name)

    }

}