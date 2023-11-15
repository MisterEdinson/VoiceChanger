package com.example.voicechanger.ui.record

import android.Manifest
import android.content.pm.PackageManager
import android.media.MediaRecorder
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.voicechanger.R
import com.example.voicechanger.databinding.FragmentRecordBinding
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class RecordFragment : Fragment() {

    private lateinit var binding: FragmentRecordBinding
    private var record: Boolean = false
    private var mediaRecorder: MediaRecorder? = null
    private var outputFile: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnBack.setOnClickListener { findNavController().popBackStack() }
            btnRecord.setOnClickListener {
                if (!record) {
                    if (
                        ContextCompat.checkSelfPermission(requireContext(),Manifest.permission.RECORD_AUDIO)
                        != PackageManager.PERMISSION_GRANTED
                    ) {
                        ActivityCompat.requestPermissions(requireActivity(),arrayOf(Manifest.permission.RECORD_AUDIO),200)
                    } else {
                        btnRecord.setImageResource(R.drawable.btn_circle_green)
                        tvRecord.text = "Идет запись"
                        startRecording()
                        record = true
                    }
                } else {
                    stopRecording()
                    record = false
                    Toast.makeText(context, getOutputFilePath() , Toast.LENGTH_SHORT).show()
                    val bundle: Bundle = bundleOf()
                    bundle.putString("file", getOutputFilePath())
                    findNavController().navigate(R.id.action_recordFragment_to_playFragment, bundle)
                }
            }
        }
    }

    private fun startRecording() {
        if (!record) {
            manifestWriteExternalStorage()
            try {
                val recordingsDir = File(
                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC),"VoiceSwitch/Records"
                )
                if (!recordingsDir.exists()) { recordingsDir.mkdirs() }

                val simpleDateFormat = SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault())
                val time = Calendar.getInstance().time
                val fileName = "Record_${simpleDateFormat.format(time)}.ogg"
                outputFile = File(recordingsDir, fileName).absolutePath

                mediaRecorder = MediaRecorder().apply {
                    reset()
                    setAudioSource(MediaRecorder.AudioSource.MIC)
                    setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)
                    setAudioEncoder(MediaRecorder.AudioEncoder.AAC)
                    setOutputFile(outputFile)
                    prepare()
                    start()
                }
                record = true
            } catch (e: IOException) {
                e.printStackTrace()
                Log.e("RecordFragment", "IOException during recording", e)
            }
        }
    }

    private fun stopRecording() {
        if (record) {
            mediaRecorder?.apply {
                stop()
                release()
            }
            record = false
        }
    }

    fun getOutputFilePath(): String? {
        return outputFile
    }

    override fun onDestroy() {
        super.onDestroy()
        stopRecording()
    }

    private fun manifestWriteExternalStorage(){
        if (ContextCompat.checkSelfPermission( requireContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ) {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                200
            )
        }
    }
}