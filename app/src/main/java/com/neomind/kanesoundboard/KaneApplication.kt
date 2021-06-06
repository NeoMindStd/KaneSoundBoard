package com.neomind.kanesoundboard

import android.app.Application
import com.neomind.kanesoundboard.dagger.AppComponent
import com.neomind.kanesoundboard.dagger.DaggerAppComponent
import com.neomind.kanesoundboard.dagger.module.ContextModule

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