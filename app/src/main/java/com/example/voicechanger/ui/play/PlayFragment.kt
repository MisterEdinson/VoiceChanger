package com.example.voicechanger.ui.play

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.audiosoundeffects.e_pack.b_e_class
import com.example.voicechanger.R
import com.example.voicechanger.databinding.FragmentPlayBinding

class PlayFragment : Fragment(), b_e_class.a {

    private lateinit var binding: FragmentPlayBinding
    private var isPlay: Boolean = false
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPlayBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val file = arguments?.getString("file")

        binding.apply {
            tvTitleMusic.text = file
            btnPlay.setOnClickListener {
                isPlay = if(!isPlay){
                    btnPlay.setImageResource(R.drawable.ic_pause)

                    true
                } else {
                    btnPlay.setImageResource(R.drawable.ic_play)

                    false
                }
            }
        }
    }

    override fun eventCompleted(strArr: Array<out String>?) {
        // Обработка событий от Superpowered
    }

    override fun initMain() {
        // Инициализация Superpowered, если требуется
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}