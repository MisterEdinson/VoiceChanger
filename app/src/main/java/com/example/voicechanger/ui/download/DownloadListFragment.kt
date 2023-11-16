package com.example.voicechanger.ui.download

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import com.example.voicechanger.R
import com.example.voicechanger.data.utils.MusicSearch
import com.example.voicechanger.databinding.FragmentDownloadListBinding

class DownloadListFragment : Fragment() {

    private lateinit var binding: FragmentDownloadListBinding
    private var adapter: ListDownloadAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDownloadListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        binding.apply {
            manifestReadExternalStorage()
            val searchFile = MusicSearch.getMusicFiles(requireContext())
            Toast.makeText(context, searchFile.size.toString(), Toast.LENGTH_SHORT).show()
            adapter?.list?.submitList(searchFile)
        }
    }

    private fun initAdapter() {
        adapter = ListDownloadAdapter{select -> selectSong(select)}
        binding.rvDownloadList.adapter = adapter
        binding.rvDownloadList.itemAnimator = DefaultItemAnimator()
    }

    private fun selectSong(select: String?) {
        val bund:Bundle = bundleOf()
        bund.putString("file", select)
        findNavController().navigate(R.id.action_downloadListFragment_to_playActivity, bund)
    }

    private fun manifestReadExternalStorage() {
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                200
            )
        }
    }
}