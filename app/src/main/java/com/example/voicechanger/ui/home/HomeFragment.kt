package com.example.voicechanger.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.voicechanger.R
import com.example.voicechanger.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private var moreVis: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            itemMic.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_recordFragment) }
            itemDownload.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_downloadFragment) }
            itemText.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_textToAudioFragment) }
            itemStudio.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_studioFragment) }
            itemEffects.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_effectsFragment) }
            itemConfig.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_settingsFragment) }

            btnMore.setOnClickListener {
                if(!moreVis){
                    modalMore.lyMore.visibility = View.VISIBLE
                    moreVis = true
                }else{
                    modalMore.lyMore.visibility = View.GONE
                    moreVis = false
                }
            }
        }
    }
}