package com.neomind.kanesoundboard

import android.content.res.AssetFileDescriptor

data class KaneSound(val name: String, val assetFileDescriptor: AssetFileDescriptor) {
    var isPlaying = false

    override fun equals(other: Any?): Boolean {
        return other is KaneSound && other.assetFileDescriptor == this.assetFileDescriptor
    }

    override fun hashCode(): Int {
        return assetFileDescriptor.hashCode()
    }

    override fun toString(): String {
        return "name: $name, fullPath: $assetFileDescriptor, isPlaying: $isPlaying"
    }
}
