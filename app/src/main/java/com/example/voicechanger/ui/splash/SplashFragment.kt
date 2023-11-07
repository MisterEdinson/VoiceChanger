
package com.example.voicechanger.ui.splash

import android.animation.ValueAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.voicechanger.R
import com.example.voicechanger.databinding.FragmentSplashBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SplashFragment : Fragment() {

    private lateinit var binding: FragmentSplashBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(layoutInflater)
        val progressBar = binding.progressBar
        progressBar.visibility = View.VISIBLE
        lifecycleScope.launch {
            val animator = createProgressBarAnimator(progressBar)
            animator.start()

            withContext(Dispatchers.Default) {
                delay(2100)
            }

            animator.cancel()
            progressBar.visibility = View.GONE

            findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
        }
        return binding.root
    }

    private fun createProgressBarAnimator(progressBar: ProgressBar): ValueAnimator {
        val animator = ValueAnimator.ofInt(0, 100)
        animator.interpolator = LinearInterpolator()
        animator.duration = 2000
        animator.addUpdateListener { animation ->
            val progress = animation.animatedValue as Int
            progressBar.progress = progress
        }
        return animator
    }
}