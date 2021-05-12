package com.neomind.kanesoundboard

import android.app.Application

class KaneApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .contextModule(ContextModule(applicationContext))
            .build()

        instance = this
    }

    companion object {
        lateinit var instance: KaneApplication
        lateinit var appComponent: AppComponent
    }
}