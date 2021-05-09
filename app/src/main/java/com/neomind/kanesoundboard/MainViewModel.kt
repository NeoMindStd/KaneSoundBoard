package com.neomind.kanesoundboard

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    fun playSound() {
        SoundPlayer.playSound(R.raw.winter_pear_is_delicious)
    }
}