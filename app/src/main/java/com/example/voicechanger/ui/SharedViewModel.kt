package com.example.voicechanger.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.voicechanger.data.utils.EffectsData
import com.example.voicechanger.domain.Repository
import kotlinx.coroutines.launch

class SharedViewModel(private val repo: Repository): ViewModel() {
    private var effectsLiveData: MutableLiveData<List<EffectsData.EffectModel>> = MutableLiveData()
    var _effectsLiveData: LiveData<List<EffectsData.EffectModel>> = effectsLiveData

    init {
        getEffects()
    }
    fun getEffects(){
        viewModelScope.launch {
            val response = repo.getEffects()
            effectsLiveData.value = response
        }
    }
}