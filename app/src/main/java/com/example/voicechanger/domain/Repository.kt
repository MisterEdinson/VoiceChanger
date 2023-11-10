package com.example.voicechanger.domain

import com.example.voicechanger.data.utils.EffectsData

class Repository {
    fun getEffects(): List<EffectsData.EffectModel>{
        return EffectsData().massEffect
    }
}