package com.vedangj044.paradiigm_client

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.vedangj044.paradiigm_client.databinding.ActivityMainBinding
import com.vedangj044.paradiigm_client.databinding.LayoutProfileBinding

class ProfileFragment : Fragment() {

    private lateinit var basicInfoViewModel: BasicInfoViewModel
    private lateinit var profile: LayoutProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        profile = DataBindingUtil.inflate(inflater, R.layout.layout_profile, container, false)
        return profile.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        basicInfoViewModel = ViewModelProvider(
            this,
            BasicInfoViewModelFactory(BasicInfoApiService.getApiService())
        )[BasicInfoViewModel::class.java]

        basicInfoViewModel.sendObj.observe(this, Observer {
            value ->
            run {
                Log.v("asas", value.profile.name)
                profile.profile = value.profile
            }
        })
    }

}