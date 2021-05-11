package com.neomind.kanesoundboard

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    fun playSound(soundFilePath: String) {
        SoundPlayer.playSound(soundFilePath)
    }
}