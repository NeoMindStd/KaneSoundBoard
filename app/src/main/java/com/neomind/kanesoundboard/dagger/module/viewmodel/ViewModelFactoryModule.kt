package com.neomind.kanesoundboard.dagger.module.viewmodel

import androidx.lifecycle.ViewModel
import com.neomind.kanesoundboard.ViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module
class ViewModelFactoryModule {
    @Provides
    fun provideViewModelFactory(
        providerMap: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
    ) = ViewModelFactory(providerMap)
}