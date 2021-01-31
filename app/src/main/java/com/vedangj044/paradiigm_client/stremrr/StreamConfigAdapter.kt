package com.vedangj044.paradiigm_client.stremrr

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.vedangj044.paradiigm_client.R

class StreamConfigAdapter: RecyclerView.Adapter<StreamConfigAdapter.ViewHolder>() {

    public val mdataset = LinkedHashMap<String, Boolean>()
    private val data = listOf<String>("Age", "Gender", "Response")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_datacard, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.dataName.setText(data.get(position))

        if (mdataset[data.get(position)] == true) {
            holder.dataBack.alpha = 1f
        }
        else {
            holder.dataBack.alpha = 0.7f
        }

        holder.dataBack.setOnClickListener {
            if (mdataset[data.get(position)] == true) {
                holder.dataBack.alpha = 0.7f
                mdataset[data.get(position)] = false
            }
            else {
                holder.dataBack.alpha = 1f
                mdataset[data.get(position)] = true
            }
        }



    }

    override fun getItemCount(): Int {
        return mdataset.size
    }


    class ViewHolder(private val itemview: View): RecyclerView.ViewHolder (itemview) {

        val dataBack = itemview.findViewById<CardView>(R.id.data_back)
        val dataName = itemview.findViewById<TextView>(R.id.data_name)

    }

}