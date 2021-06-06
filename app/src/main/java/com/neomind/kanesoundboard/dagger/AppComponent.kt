package com.neomind.kanesoundboard.dagger

import com.neomind.kanesoundboard.dagger.module.store.ContextModule
import com.neomind.kanesoundboard.dagger.module.store.StoreModule
import com.neomind.kanesoundboard.dagger.module.viewmodel.ViewModelFactoryModule
import com.neomind.kanesoundboard.dagger.module.viewmodel.ViewModelModule
import com.neomind.kanesoundboard.ui.BaseActivity
import com.neomind.kanesoundboard.ui.MainActivity
import dagger.Component

@Component(
    modules = [
        ContextModule::class,
        StoreModule::class,
        ViewModelFactoryModule::class,
        ViewModelModule::class,
    ]
)
interface AppComponent {
    fun inject(activity: BaseActivity)

    fun inject(activity: MainActivity)
}