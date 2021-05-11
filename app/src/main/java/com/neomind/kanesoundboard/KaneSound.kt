package com.neomind.kanesoundboard

data class KaneSound(val name: String, val fullPath: String) {
    var isPlaying = false

    override fun equals(other: Any?): Boolean {
        return other is KaneSound && other.fullPath == this.fullPath
    }

    override fun hashCode(): Int {
        return fullPath.hashCode()
    }

    override fun toString(): String {
        return "name: $name, fullPath: $fullPath, isPlaying: $isPlaying"
    }
}
