package com.neomind.kanesoundboard.dagger.module.store

import android.content.Context
import com.neomind.kanesoundboard.dagger.scope.AppScope
import dagger.Module
import dagger.Provides

@Module
class ContextModule(private val context: Context) {
    @Provides
    @AppScope
    fun provideContext() = context
}