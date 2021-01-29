package com.vedangj044.paradiigm_client.stremrr

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vedangj044.paradiigm_client.R
import java.util.*

class StreamConfigFragment: Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = LayoutInflater.from(activity).inflate(R.layout.layout_profile, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.data_recycler)
        recyclerView.layoutManager = GridLayoutManager(activity, 3)

        recyclerView.adapter = StreamConfigAdapter()

        return view
    }
}