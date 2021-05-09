package com.neomind.kanesoundboard

import android.media.MediaPlayer
import androidx.annotation.RawRes

object SoundPlayer {
    private val playerMap = mutableMapOf<Int, MediaPlayer>()

    fun playSound(@RawRes rawId: Int) {
        val player = playerMap.getOrPut(rawId) {
            MediaPlayer.create(
                KaneApplication.instance.applicationContext,
                rawId
            )
        }

        when {
            player.isPlaying -> {
                player.release()
                playerMap.remove(rawId)
            }
            else -> {
                player.isLooping = true
                player.start()
            }
        }
    }
}