package com.vedangj044.paradiigm_client

import android.net.Uri
import android.os.Bundle
import android.text.method.TextKeyListener.clear
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.VideoView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.ui.views.YouTubePlayerSeekBar
import com.vedangj044.paradiigm_client.models.QuestionDemo
import com.vedangj044.paradiigm_client.models.QuestionDemoList

class DemoTestFragment(private val classID: Int, private val studentID: Int): Fragment() {

    private lateinit var questionRecycle: RecyclerView
    private lateinit var youTubePlayer: YouTubePlayer
    private lateinit var viewModel: DemoTestViewModel
    private lateinit var submitButton: MaterialButton

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.layout_demo_test, container, false)
        viewModel = ViewModelProvider(this, DemoTestViewModelFactory(BasicInfoApiService.getApiService(), classID, studentID))[DemoTestViewModel::class.java]

        val videoDemo = view.findViewById<YouTubePlayerView>(R.id.demo_video)
        lifecycle.addObserver(videoDemo)

        val y = abs()
        videoDemo.addYouTubePlayerListener(y)

        y.player.observe(this, Observer {
            youTubePlayer = it
            youTubePlayer.addListener(listener = listener(viewModel))
        })

        questionRecycle = view.findViewById(R.id.question_recycle)
        submitButton = view.findViewById(R.id.submit)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter =  DemoTestAdapter(listOf())
        questionRecycle.adapter = adapter

        viewModel.questions.observe(this, Observer {
            adapter.mDataset = it.question
            adapter.notifyDataSetChanged()

            submitButton.icon = context?.applicationContext?.let { it1 -> ContextCompat.getDrawable(it1, R.drawable.ic_round_lock_open_24) }
            submitButton.isClickable = true
        })

        submitButton.setOnClickListener {

            submitButton.icon = context?.applicationContext?.let { it1 -> ContextCompat.getDrawable(it1, R.drawable.ic_baseline_lock_24) }
            submitButton.isClickable = false

            var pos = 0
            for (q in adapter.mDataset){
                viewModel.submitResponse(q.questionID, adapter.answer[pos])
                pos += 1
            }

            adapter.mDataset = listOf()
            adapter.notifyDataSetChanged()

        }

    }

    class abs(): AbstractYouTubePlayerListener() {

        val player = MutableLiveData<YouTubePlayer>()

        override fun onReady(youTubePlayer: YouTubePlayer) {
            player.value = youTubePlayer
        }
    }

    class listener(private val demoViewModel: DemoTestViewModel): YouTubePlayerListener {

        var d1 = true
        var d2 = true
        var d3 = true
        var d4 = true
        var d5 = true

        override fun onApiChange(youTubePlayer: YouTubePlayer) {

        }

        override fun onCurrentSecond(youTubePlayer: YouTubePlayer, second: Float) {

            when (second.toInt()) {
//                180 -> {
//                    if (d1){
//                        demoViewModel.generateQuestion(1)
//                        Log.v("demo", "Generated question set 1")
//                        d1 = false
//                    }
//
//                }
                10 -> {
                    if (d2) {
                        demoViewModel.getQuestion()
                        Log.v("demo", "Get lateset question set 1")
                        d2 = false
                    }

                }
                420 -> {
                    if (d3){
                        demoViewModel.generateQuestion(0)
                        Log.v("demo", "Generated question set 2")
                        d3 = false
                    }

                }
                450 -> {
                    if (d4){
                        demoViewModel.getQuestion()
                        Log.v("demo", "Get latest question set 2")
                        d4 = false
                    }

                }
                500 -> {
                    if (d5){
                        demoViewModel.endClass()
                        Log.v("demo", "class ended")
                        d5 = false
                    }

                }
            }

        }

        override fun onError(youTubePlayer: YouTubePlayer, error: PlayerConstants.PlayerError) {

        }

        override fun onPlaybackQualityChange(youTubePlayer: YouTubePlayer, playbackQuality: PlayerConstants.PlaybackQuality) {

        }

        override fun onPlaybackRateChange(youTubePlayer: YouTubePlayer, playbackRate: PlayerConstants.PlaybackRate) {

        }

        override fun onReady(youTubePlayer: YouTubePlayer) {

        }

        override fun onStateChange(youTubePlayer: YouTubePlayer, state: PlayerConstants.PlayerState) {

        }

        override fun onVideoDuration(youTubePlayer: YouTubePlayer, duration: Float) {

        }

        override fun onVideoId(youTubePlayer: YouTubePlayer, videoId: String) {

        }

        override fun onVideoLoadedFraction(youTubePlayer: YouTubePlayer, loadedFraction: Float) {

        }
    }

}