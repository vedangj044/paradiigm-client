package com.vedangj044.paradiigm_client.stremrr

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.datastore.preferences.createDataStore
import androidx.lifecycle.lifecycleScope
import com.vedangj044.paradiigm_client.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class StreamConfigFragment: Fragment() {

    private lateinit var dataStore: DataStore<Preferences>
    private lateinit var adapter: StreamConfigAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.layout_streamer, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.data_recycler)

        dataStore = activity!!.createDataStore(name = "stremer")

        adapter = StreamConfigAdapter()

        lifecycleScope.run {
            launch {
                setArr()
            }
        }

        recyclerView.adapter = adapter

        return view
    }


    suspend fun setArr() {

        val ageKey = booleanPreferencesKey("Age")
        adapter.mdataset["Age"] = dataStore.data.first()[ageKey] ?: true

        val genderKey = booleanPreferencesKey("genderKey")
        adapter.mdataset["Gender"] = dataStore.data.first()[genderKey] ?: true

        val responseKey = booleanPreferencesKey("responseKey")
        adapter.mdataset["Response time"] = dataStore.data.first()[responseKey] ?: true

        adapter.notifyDataSetChanged()

    }
}