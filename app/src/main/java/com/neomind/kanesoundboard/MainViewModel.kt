package com.neomind.kanesoundboard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.math.max

class MainViewModel: ViewModel() {
    val count = MutableLiveData<Int>()

    init {
        count.value = 0
    }

    fun increaseCount() {
        count.value = (count.value ?: 0) + 1
    }

    fun decreaseCount() {
        count.value = max(0, (count.value ?: 0) - 1)
    }
}