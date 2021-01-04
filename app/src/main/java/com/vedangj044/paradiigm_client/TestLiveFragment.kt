package com.vedangj044.paradiigm_client

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.vedangj044.paradiigm_client.databinding.LayoutTestQuestionBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class TestLiveFragment(private val classID: Int): Fragment() {

    private lateinit var testlive:  LayoutTestQuestionBinding
    private lateinit var testFlow: TestLiveViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        testlive = DataBindingUtil.inflate(inflater, R.layout.layout_test_question, container, false)
        return testlive.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        testFlow = ViewModelProvider(this, TestLiveViewModelProvider(BasicInfoApiService.getApiService(), classID))[TestLiveViewModel::class.java]

        lifecycleScope.launch {
            testFlow.dataSource.flow.collect {
                valf ->
                if (valf != null) {
                    testlive.testQuestion = valf
                    testlive.executePendingBindings()


                    testlive.option1TextTest.setOnClickListener {
                        testlive.option1CheckTest.visibility = View.VISIBLE
                        testlive.option2CheckTest.visibility = View.GONE
                        testlive.option3CheckTest.visibility = View.GONE
                        testlive.option4CheckTest.visibility = View.GONE
                    }

                    testlive.option2TextTest.setOnClickListener {
                        testlive.option1CheckTest.visibility = View.GONE
                        testlive.option2CheckTest.visibility = View.VISIBLE
                        testlive.option3CheckTest.visibility = View.GONE
                        testlive.option4CheckTest.visibility = View.GONE
                    }

                    testlive.option3TextTest.setOnClickListener {
                        testlive.option1CheckTest.visibility = View.GONE
                        testlive.option2CheckTest.visibility = View.GONE
                        testlive.option3CheckTest.visibility = View.VISIBLE
                        testlive.option4CheckTest.visibility = View.GONE
                    }

                    testlive.option4TextTest.setOnClickListener {
                        testlive.option1CheckTest.visibility = View.GONE
                        testlive.option2CheckTest.visibility = View.GONE
                        testlive.option3CheckTest.visibility = View.GONE
                        testlive.option4CheckTest.visibility = View.VISIBLE
                    }

                    testlive.option1TextTesttf.setOnClickListener {
                        testlive.option1CheckTesttf.visibility = View.VISIBLE
                        testlive.option2CheckTesttf.visibility = View.GONE
                    }

                    testlive.option2TextTesttf.setOnClickListener {
                        testlive.option1CheckTesttf.visibility = View.GONE
                        testlive.option2CheckTesttf.visibility = View.VISIBLE
                    }

                    testlive.submit.setOnClickListener {
                        testlive.submit.icon = context?.applicationContext?.let { it1 -> ContextCompat.getDrawable(it1, R.drawable.ic_baseline_lock_24) }

                        var ansBlank = false

                        when (valf.blank.answer) {
                            1 -> ansBlank = testlive.option1CheckTest.visibility == View.VISIBLE
                            2 -> ansBlank = testlive.option2CheckTest.visibility == View.VISIBLE
                            3 -> ansBlank = testlive.option3CheckTest.visibility == View.VISIBLE
                            4 -> ansBlank = testlive.option4CheckTest.visibility == View.VISIBLE
                        }

                        var ansBool = false

                        if (valf.boolc.answer) {
                            ansBool = testlive.option1CheckTesttf.visibility == View.VISIBLE
                        }
                        else{
                            ansBool = testlive.option2CheckTesttf.visibility == View.VISIBLE
                        }

                        testFlow.submitResponse(valf.blank.id, ansBlank)
                        testFlow.submitResponse(valf.boolc.id, ansBool)

                        testlive.submit.isClickable = false
                    }
                }
            }
        }
    }

}