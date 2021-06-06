package com.neomind.kanesoundboard.dagger.module.store

import android.content.Context
import com.neomind.kanesoundboard.store.KaneSoundStore
import dagger.Module
import dagger.Provides

@Module
class StoreModule {
    @Provides
    fun provideKaneSoundStore(context: Context) = KaneSoundStore(context)
}