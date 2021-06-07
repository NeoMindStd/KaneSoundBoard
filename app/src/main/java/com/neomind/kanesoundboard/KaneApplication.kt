package com.neomind.kanesoundboard

import android.app.Application
import com.neomind.kanesoundboard.dagger.component.AppComponent
import com.neomind.kanesoundboard.dagger.component.DaggerAppComponent
import com.neomind.kanesoundboard.dagger.module.store.ContextModule

class KaneApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .contextModule(ContextModule(applicationContext))
            .build()
    }

    companion object {
        lateinit var appComponent: AppComponent
    }
}