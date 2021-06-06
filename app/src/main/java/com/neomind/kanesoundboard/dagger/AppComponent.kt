package com.neomind.kanesoundboard.dagger

import com.neomind.kanesoundboard.dagger.module.ContextModule
import com.neomind.kanesoundboard.dagger.module.StoreModule
import com.neomind.kanesoundboard.ui.MainActivity
import dagger.Component

@Component(modules = [ContextModule::class, StoreModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
}