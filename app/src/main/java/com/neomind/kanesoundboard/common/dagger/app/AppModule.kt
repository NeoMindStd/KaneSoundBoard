package com.neomind.kanesoundboard.common.dagger.app

import android.content.Context
import com.neomind.kanesoundboard.KaneApplication
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val application: KaneApplication) {
    @Provides
    @AppScope
    fun application(): KaneApplication = application

    @Provides
    @AppScope
    fun context(application: KaneApplication): Context = application.applicationContext
}