package com.vedangj044.paradiigm_client

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.vedangj044.paradiigm_client.databinding.ActivityMainBinding
import com.vedangj044.paradiigm_client.models.Active

class MainActivity : AppCompatActivity() {


    private lateinit var basicInfoViewModel: BasicInfoViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var scoreAdapter: ScoreClassAdapter
    private lateinit var activeAdapter: ActiveClassAdapter
    private var studentid = 0

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

                activeAdapter = ActiveClassAdapter(value.active) {
                    item: Active, pos: Int ->
                    run {
                        if (item.isEnrolled){
                            val tf = DemoTestFragment(item.class_id, studentid)
                            supportFragmentManager.beginTransaction().replace(android.R.id.content, tf, "Test Live").addToBackStack("Live").commit()
                        }
                        else{
                            basicInfoViewModel.enrollTrigger(item.class_id, pos)
                        }

                    }
                }
                binding.activeRecycler.adapter = activeAdapter

                scoreAdapter = ScoreClassAdapter(value.history){
                    val hf = TestReviewFragment(it.classID)
                    supportFragmentManager.beginTransaction().replace(android.R.id.content, hf, "Test Review").addToBackStack("review").commit()
                }
                binding.scoreboardRecycler.adapter = scoreAdapter

            }
        })

        binding.profilePic.setOnClickListener {

            val pf = ProfileFragment()
            supportFragmentManager.beginTransaction().replace(android.R.id.content, pf, "PROFILE").addToBackStack("profile").commit()

        }


    }

    private fun setupViewModel() {

        val sharedPreferences = getSharedPreferences("Student", Context.MODE_PRIVATE)

        if (sharedPreferences.contains("studentID")) {
            studentid = sharedPreferences.getInt("studentID", 0)
        }
        else{
            studentid = (10..1000000).random()
            val edit = sharedPreferences.edit()
            edit.putInt("studentID", studentid)
            edit.apply()
        }

        basicInfoViewModel = ViewModelProvider(
            this,
            BasicInfoViewModelFactory(BasicInfoApiService.getApiService(), studentid)
        )[BasicInfoViewModel::class.java]
    }
}