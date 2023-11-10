package com.example.voicechanger.data.utils

import com.example.voicechanger.R

class EffectsData {
    data class EffectModel(
        var id:Int? = null,
        var name:String? = null,
        var desc:String? = null,
        var img: Int? = null,
        var value: Boolean? = null
    )

    var massEffect = listOf(
        EffectModel(
            0,
            "default",
            "Без эффектов",
            R.drawable.ic_default,
            true
        ),
        EffectModel(
            1,
            "man",
            "Мужской",
            R.drawable.ic_man,
            true
        ),
        EffectModel(
            2,
            "woman",
            "Женский",
            R.drawable.ic_woman,
            true
        ),EffectModel(
            3,
            "fast",
            "Быстро",
            R.drawable.ic_fast,
            true
        ),
        EffectModel(
            4,
            "slowly",
            "Медленно",
            R.drawable.ic_slowly,
            true
        ),
        EffectModel(
            5,
            "child",
            "Детский",
            R.drawable.ic_child,
            true
        ),
        EffectModel(
            6,
            "chipmunk",
            "Бурундук",
            R.drawable.ic_chipmunk,
            true
        ),
        EffectModel(
            7,
            "bee",
            "Пчела",
            R.drawable.ic_bee,
            true
        ),
        EffectModel(
            8,
            "monster",
            "Монстр",
            R.drawable.ic_monster,
            false
        ),
        EffectModel(
            9,
            "alien",
            "Пришелец",
            R.drawable.ic_alien,
            false
        ),
        EffectModel(
            10,
            "diablo",
            "Дьявол",
            R.drawable.ic_diablo,
            false
        ),
        EffectModel(
            11,
            "karaoke",
            "Караоке",
            R.drawable.ic_speeker,
            false
        ),
        EffectModel(
            12,
            "radio",
            "Радио",
            R.drawable.ic_radio,
            false
        ),
        EffectModel(
            13,
            "phone",
            "Телефон",
            R.drawable.ic_phone,
            false
        ),
        EffectModel(
            14,
            "big man",
            "Великан",
            R.drawable.ic_bigman,
            false
        ),
        EffectModel(
            15,
            "dead",
            "Смерть",
            R.drawable.ic_dead,
            false
        ),
        EffectModel(
            16,
            "cave",
            "Пещера",
            R.drawable.ic_cave,
            false
        ),
        EffectModel(
            17,
            "bass",
            "Басс",
            R.drawable.ic_bass,
            false
        ),
        EffectModel(
            18,
            "middle",
            "Средний",
            R.drawable.ic_meadle,
            false
        ),
        EffectModel(
            19,
            "helium",
            "Гелий",
            R.drawable.ic_helium,
            false
        )
    )
}