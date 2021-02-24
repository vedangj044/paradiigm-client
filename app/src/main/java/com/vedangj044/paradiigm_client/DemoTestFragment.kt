package com.vedangj044.paradiigm_client

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.VideoView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.ui.views.YouTubePlayerSeekBar

class DemoTestFragment(private val classID: Int, private val studentID: Int): Fragment() {

    private lateinit var questionRecycle: RecyclerView
    private lateinit var youTubePlayer: YouTubePlayer
    private lateinit var viewModel: DemoTestViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.layout_demo_test, container, false)
        viewModel = ViewModelProvider(this, DemoTestViewModelFactory(BasicInfoApiService.getApiService(), classID, studentID))[DemoTestViewModel::class.java]

        val videoDemo = view.findViewById<YouTubePlayerView>(R.id.demo_video)
        lifecycle.addObserver(videoDemo)

        val y = abs()
        videoDemo.addYouTubePlayerListener(y)

        youTubePlayer = y.getPlayer()
        youTubePlayer.addListener(listener = listener(viewModel))

        questionRecycle = view.findViewById(R.id.question_recycle)



        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        questionRecycle.adapter

    }

    class abs(): AbstractYouTubePlayerListener() {

        private lateinit var youTubePlayer1: YouTubePlayer

        override fun onReady(youTubePlayer: YouTubePlayer) {
            youTubePlayer1 = youTubePlayer
        }

        fun getPlayer(): YouTubePlayer {
            return youTubePlayer1
        }
    }

    class listener(private val demoViewModel: DemoTestViewModel): YouTubePlayerListener {

        override fun onApiChange(youTubePlayer: YouTubePlayer) {

        }

        override fun onCurrentSecond(youTubePlayer: YouTubePlayer, second: Float) {

            when (second.toInt()) {
                180 -> {
                    demoViewModel.generateQuestion(0)
                    Log.v("demo", "Generated question set 1")
                }
                250 -> {
                    demoViewModel.getQuestion()
                    Log.v("demo", "Get lateset question set 1")
                }
                420 -> {
                    demoViewModel.generateQuestion(1)
                    Log.v("demo", "Generated question set 2")
                }
                450 -> {
                    demoViewModel.getQuestion()
                    Log.v("demo", "Get latest question set 2")
                }
                500 -> {
                    demoViewModel.endClass()
                    Log.v("demo", "class ended")
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