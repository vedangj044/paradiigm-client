package com.vedangj044.paradiigm_client

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.vedangj044.paradiigm_client.databinding.LayoutReviewBinding

class TestReviewFragment(private val classID: Int, private val studentID: Int): Fragment() {

    private lateinit var testReviewViewModel: TestReviewViewModel
    private lateinit var history: LayoutReviewBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        history = DataBindingUtil.inflate(inflater, R.layout.layout_review, container, false)
        return history.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        testReviewViewModel = ViewModelProvider(
            this,
           TestReviewViewModelFactory(BasicInfoApiService.getApiService(), classID, studentID)
        )[TestReviewViewModel::class.java]

        testReviewViewModel.sendObj.observe(this, Observer {
                value ->
            run {
                history.historyTest = value
                history.questionRecycle.adapter = QuestionReviewAdapter(value.questionList)
            }
        })

    }


}