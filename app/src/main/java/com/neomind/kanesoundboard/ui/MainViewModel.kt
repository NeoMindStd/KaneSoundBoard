package com.neomind.kanesoundboard.ui

import android.content.res.AssetFileDescriptor
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.neomind.kanesoundboard.model.KaneSound
import com.neomind.kanesoundboard.util.SoundPlayer

class MainViewModel : ViewModel() {
    var kaneSounds = MutableLiveData<List<KaneSound>>()

    fun init(kaneSounds: List<KaneSound>) {
        this.kaneSounds.value = kaneSounds

        for (kaneSound in kaneSounds) {
            Log.d("init", "loaded kaneSound - $kaneSound")
        }
    }

    fun playSound(assetFileDescriptor: AssetFileDescriptor) {
        SoundPlayer.playSound(assetFileDescriptor)
    }
}