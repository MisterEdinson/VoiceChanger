package com.example.voicechanger

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.audiosoundeffects.e_pack.b_e_class

class MainActivity : AppCompatActivity(), b_e_class.a {
    external fun changeState(
        f: Float,
        f2: Float,
        f3: Float,
        f4: Float,
        f5: Float,
        f6: Float,
        f7: Float,
        f8: Float
    )
    external fun frequencyDomain(
        i: Int,
        i2: Int,
        i3: Int,
        f: Float,
        f2: Float,
        f3: Float,
        f4: Float,
        f5: Float,
        f6: Float,
        str2: String,
        str3: String
    )
    external fun getBuffer(): ShortArray
    external fun stopDomain()
    external fun SuperpoweredExample(
        i: Int,
        i2: Int,
        str2: String,
        f: Float,
        f2: Float,
        f3: Float,
        f4: Float,
        f5: Float,
        f6: Float,
        f7: Float,
        f8: Float
    )
    external fun onPlayPause(z: Boolean)
    external fun release()
    external fun saveRecord(str2: String, str3: String)
    external fun onSeed(i: Int)
    external fun updateSeed()


    init {
        try {
            System.loadLibrary("SuperpoweredExample")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun eventCompleted(strArr: Array<out String>?) {

    }
}