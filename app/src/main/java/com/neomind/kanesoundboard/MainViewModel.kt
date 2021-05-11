package com.neomind.kanesoundboard

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var kaneSounds = MutableLiveData<List<KaneSound>>()

    fun init(kaneSounds: List<KaneSound>) {
        this.kaneSounds.value = kaneSounds

        for (kaneSound in kaneSounds) {
            Log.d("init", "loaded kaneSound - $kaneSound")
        }
    }

    fun playSound(soundFilePath: String) {
        SoundPlayer.playSound(soundFilePath)
    }
}