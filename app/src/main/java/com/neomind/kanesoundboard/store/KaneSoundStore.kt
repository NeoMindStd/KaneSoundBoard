package com.neomind.kanesoundboard.store

import android.content.Context
import com.neomind.kanesoundboard.model.KaneSound
import javax.inject.Inject

class KaneSoundStore @Inject constructor(private val context: Context) {
    fun getKaneSoundAssets() = (context.resources.assets.list("") ?: emptyArray()).map { path ->
        arrayOf(path) + path.split("/", ".")
    }.filter { elements ->
        elements.size > 2 && elements.last() == "mp3"
    }.map { elements ->
        KaneSound(
            name = elements[elements.lastIndex - 1],
            assetFileDescriptor = context.resources.assets.openFd(elements.first())
        )
    }
}