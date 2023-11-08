package com.example.voicechanger.ui.hello

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.voicechanger.R
import com.example.voicechanger.databinding.FragmentHelloFourBinding

class HelloFourFragment : Fragment() {

    private lateinit var binding: FragmentHelloFourBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHelloFourBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            btnNext.setOnClickListener {
                findNavController().navigate(R.id.action_helloFourFragment2_to_helloFinallFragment2)
            }
        }
    }
}