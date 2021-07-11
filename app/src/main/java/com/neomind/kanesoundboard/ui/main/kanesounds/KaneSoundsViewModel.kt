package com.neomind.kanesoundboard.ui.main.kanesounds

import android.content.res.AssetFileDescriptor
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.neomind.kanesoundboard.model.KaneSound
import com.neomind.kanesoundboard.util.SoundPlayer
import javax.inject.Inject

class KaneSoundsViewModel @Inject constructor() : ViewModel() {
    private val _kaneSounds = MutableLiveData<List<KaneSound>>()
    val kaneSounds: LiveData<List<KaneSound>>
        get() = _kaneSounds

    fun init(kaneSounds: List<KaneSound>) {
        _kaneSounds.value = kaneSounds

        for (kaneSound in kaneSounds) {
            Log.d("init", "loaded kaneSound - $kaneSound")
        }
    }

    fun playSound(assetFileDescriptor: AssetFileDescriptor) {
        SoundPlayer.playSound(assetFileDescriptor)
    }
}