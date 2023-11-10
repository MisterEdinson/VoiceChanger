package com.example.voicechanger.ui.effects

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.voicechanger.R
import com.example.voicechanger.data.utils.EffectsData
import com.example.voicechanger.databinding.FragmentEffectsBinding
import com.example.voicechanger.ui.SharedViewModel

class EffectsFragment : Fragment() {

    private lateinit var binding: FragmentEffectsBinding
    private val viewModel: SharedViewModel by activityViewModels()
    private var adapter: EffectsAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEffectsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()

        adapter?.list?.submitList(EffectsData().massEffect)

        binding.apply {
            btnBack.setOnClickListener { findNavController().popBackStack() }
        }
    }

    private fun initAdapter() {
        adapter = EffectsAdapter()
        binding.rvEffects.adapter = adapter
    }
}