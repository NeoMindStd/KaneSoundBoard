package com.neomind.kanesoundboard

import android.media.MediaPlayer

object SoundPlayer {
    private val playerMap = mutableMapOf<String, MediaPlayer>()

    fun playSound(soundFilePath: String) {
        val player = playerMap.getOrPut(soundFilePath) {
            val player = MediaPlayer()
            player.setDataSource(soundFilePath)
            player
        }

        when {
            player.isPlaying -> {
                player.release()
                playerMap.remove(soundFilePath)
            }
            else -> {
                player.isLooping = true
                player.start()
            }
        }
    }
}