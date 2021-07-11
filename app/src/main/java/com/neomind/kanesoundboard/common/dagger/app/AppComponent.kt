package com.neomind.kanesoundboard.common.dagger.app

import com.neomind.kanesoundboard.common.dagger.activity.ActivityComponent
import dagger.Component

@AppScope
@Component(
    modules = [
        AppModule::class,
//        StoreModule::class,
    ]
)
interface AppComponent {
    fun newActivityComponent(): ActivityComponent
}