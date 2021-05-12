package com.neomind.kanesoundboard

import android.content.Context

class KaneSoundProvider constructor(private val context: Context) {
    fun getKaneSoundAssets() = (context.assets.list("") ?: emptyArray()).map { path ->
        arrayOf(path) + path.split("/", ".")
    }.filter { elements ->
        elements.size > 2 && elements.last() == "flac"
    }.map { elements ->
        KaneSound(
            name = elements[elements.lastIndex - 1],
            fullPath = elements.first()
        )
    }
}