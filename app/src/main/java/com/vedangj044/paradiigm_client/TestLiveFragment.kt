package com.vedangj044.paradiigm_client

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
                if (it != null) {
                    testlive.testQuestion = it
                }
            }
        }
    }

}