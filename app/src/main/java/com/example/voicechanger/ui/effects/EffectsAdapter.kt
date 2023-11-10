package com.example.voicechanger.ui.effects

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.voicechanger.R
import com.example.voicechanger.data.utils.EffectsData
import com.example.voicechanger.databinding.ItemEffectBinding

class EffectsAdapter: RecyclerView.Adapter<EffectsAdapter.EffectsHolder>() {
    class EffectsHolder(view: View) : RecyclerView.ViewHolder(view)

    private val callback = object : DiffUtil.ItemCallback<EffectsData.EffectModel>(){
        override fun areItemsTheSame(
            oldItem: EffectsData.EffectModel,
            newItem: EffectsData.EffectModel
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: EffectsData.EffectModel,
            newItem: EffectsData.EffectModel
        ): Boolean {
            return oldItem.value == newItem.value
        }
    }

    var list = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EffectsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_effect, parent, false)
        return EffectsHolder(view)
    }

    override fun getItemCount(): Int {
        return list.currentList.size
    }

    override fun onBindViewHolder(holder: EffectsHolder, position: Int) {
        val item = list.currentList[position]
        val binding = ItemEffectBinding.bind(holder.itemView)

        binding.apply {
            item.img?.let { imgLogoEffect.setImageResource(it) }
            if (item.value == true) imgBlock.visibility = View.GONE
            tvLogoDesc.text = item.desc
        }
    }
}