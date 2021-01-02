package com.vedangj044.paradiigm_client

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.vedangj044.paradiigm_client.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var basicInfoViewModel: BasicInfoViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        title = "Paradigm"
        setupViewModel()
        setupView()
    }

    private fun setupView() {

        basicInfoViewModel.sendObj.observe(this, Observer {
            value ->
            run {
                binding.basic = value
                binding.activeRecycler.adapter = ActiveClassAdapter(value.active)
                binding.scoreboardRecycler.adapter = ScoreClassAdapter(value.history)
            }
        })

    }

    private fun setupViewModel() {

        basicInfoViewModel = ViewModelProvider(
            this,
            BasicInfoViewModelFactory(BasicInfoApiService.getApiService())
        )[BasicInfoViewModel::class.java]
    }
}