package com.example.mathapp.ui.exam.quiz

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.mathapp.R
import com.example.mathapp.databinding.FragmentNavBinding
import com.example.mathapp.ui.base.BaseFragment
import com.example.mathapp.ui.exam.ExamViewModel
import com.example.mathapp.util.SettingsManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuizFragment : BaseFragment<FragmentNavBinding>() {

    private val viewModel: ExamViewModel by viewModels()
    private lateinit var mediaPlayer: MediaPlayer
    private var currentMusicResourceId: Int = R.raw.quizaudio
    private var shouldReplayAudio: Boolean = true

    private val args : QuizFragmentArgs by navArgs()

    override fun getViewBinding(): FragmentNavBinding =
        FragmentNavBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mediaPlayer = MediaPlayer.create(requireContext(), currentMusicResourceId)
        if (SettingsManager.isMusicEnabled()) {
            mediaPlayer.start()
        }
    }

    override fun onPause() {
        super.onPause()
        if (SettingsManager.isMusicEnabled() && !mediaPlayer.isPlaying) { mediaPlayer.pause() }
    }

    override fun onResume() {
        super.onResume()
        if (SettingsManager.isMusicEnabled() && !mediaPlayer.isPlaying) {
            mediaPlayer.start()
        }
    }

    override fun onDestroyView() {
        mediaPlayer.release()
        super.onDestroyView()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.composeView.setContent {
            viewModel.getRandomQuestions(args.unit)
            QuizScreen(viewModel, args.unit) { newMusicResId ->
                shouldReplayAudio = false
                mediaPlayer.stop()
                mediaPlayer.release()
                currentMusicResourceId = newMusicResId
                if (SettingsManager.isMusicEnabled()) {
                    mediaPlayer = MediaPlayer.create(requireContext(), currentMusicResourceId)
                    mediaPlayer.start()
                }
            }
        }

        mediaPlayer.setOnCompletionListener {
            if (shouldReplayAudio) {
                mediaPlayer.stop()
                mediaPlayer.release()
                mediaPlayer = MediaPlayer.create(requireContext(), currentMusicResourceId)
                mediaPlayer.start()
            }
        }
    }
}