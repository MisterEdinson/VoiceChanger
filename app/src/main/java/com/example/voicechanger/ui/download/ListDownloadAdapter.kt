package com.example.voicechanger.ui.download

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.voicechanger.R
import com.example.voicechanger.data.utils.models.MusicModel
import com.example.voicechanger.databinding.ItemStudioWaveBinding

class ListDownloadAdapter (val selectSong: (data:String?) -> Unit):RecyclerView.Adapter<ListDownloadAdapter.DownloadHolder>() {
    class DownloadHolder(view: View): RecyclerView.ViewHolder(view)

    private val callback = object : DiffUtil.ItemCallback<MusicModel>(){
        override fun areItemsTheSame(oldItem: MusicModel, newItem: MusicModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: MusicModel, newItem: MusicModel): Boolean {
            return oldItem.id == newItem.id
        }
    }

    var list = AsyncListDiffer(this, callback)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DownloadHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_studio_wave, parent, false)
        return DownloadHolder(view)
    }

    override fun getItemCount(): Int {
        return list.currentList.size
    }

    override fun onBindViewHolder(holder: DownloadHolder, position: Int) {
        val item = list.currentList[position]
        val binding = ItemStudioWaveBinding.bind(holder.itemView)
        binding.apply {
            tvDateWave.text = item.name
            tvTimeWave.text = item.duration
            binding.lyItemMusic.setOnClickListener {
                if(!item.data.isNullOrEmpty()) selectSong(item.data)
                Toast.makeText(binding.root.context, item.data, Toast.LENGTH_SHORT).show()
            }
        }
    }
}