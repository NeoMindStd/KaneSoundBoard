package com.neomind.kanesoundboard

import android.app.Application

class KaneApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        instance = this
    }

    companion object {
        lateinit var instance: KaneApplication
    }
}