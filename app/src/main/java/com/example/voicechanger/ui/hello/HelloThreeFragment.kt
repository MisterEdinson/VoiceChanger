package com.example.voicechanger.ui.hello

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.voicechanger.R
import com.example.voicechanger.databinding.FragmentHelloThreeBinding

class HelloThreeFragment : Fragment() {

    private lateinit var binding : FragmentHelloThreeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHelloThreeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnNext.setOnClickListener {
                findNavController().navigate(R.id.action_helloThreeFragment2_to_helloFourFragment2)
            }
        }
    }
}