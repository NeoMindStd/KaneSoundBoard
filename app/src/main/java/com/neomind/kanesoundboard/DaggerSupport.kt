package com.neomind.kanesoundboard

import android.content.Context
import dagger.Component
import dagger.Module
import dagger.Provides

@Component(modules = [ContextModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
}

@Module
class ContextModule(private val context: Context) {
    @Provides
    fun provideKaneSoundProvider(context: Context) = KaneSoundProvider(context)

    @Provides
    fun provideContext() = context
}