package com.neomind.kanesoundboard

import android.app.Application
import com.neomind.kanesoundboard.common.dagger.app.AppComponent
import com.neomind.kanesoundboard.common.dagger.app.AppModule
import com.neomind.kanesoundboard.common.dagger.app.DaggerAppComponent

class KaneApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    companion object {
        lateinit var appComponent: AppComponent
    }
}