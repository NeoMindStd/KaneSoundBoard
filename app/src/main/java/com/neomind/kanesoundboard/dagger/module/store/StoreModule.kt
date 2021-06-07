package com.neomind.kanesoundboard.dagger.module.store

import android.content.Context
import com.neomind.kanesoundboard.dagger.scope.AppScope
import com.neomind.kanesoundboard.store.KaneSoundStore
import dagger.Module
import dagger.Provides

@Module
class StoreModule {
    @Provides
    @AppScope
    fun provideKaneSoundStore(context: Context) = KaneSoundStore(context)
}