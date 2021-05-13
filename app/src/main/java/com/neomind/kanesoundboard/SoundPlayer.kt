package com.neomind.kanesoundboard

import android.content.res.AssetFileDescriptor
import android.media.MediaPlayer

object SoundPlayer {
    private val playerMap = mutableMapOf<AssetFileDescriptor, MediaPlayer>()

    fun playSound(assetFileDescriptor: AssetFileDescriptor) {
        val player = playerMap.getOrPut(assetFileDescriptor) {
            val player = MediaPlayer()
            player.setDataSource(assetFileDescriptor)
            player
        }

        when {
            player.isPlaying -> {
                player.stop()
                player.release()
                playerMap.remove(assetFileDescriptor)
            }
            else -> {
                player.prepareAsync()
                player.isLooping = true
                player.setOnPreparedListener {
                    it.start()
                }
            }
        }
    }
}