package com.neomind.kanesoundboard.dagger.module.viewmodel

import androidx.lifecycle.ViewModel
import com.neomind.kanesoundboard.ui.MainViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class ViewModelModule {
    @Provides
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun provideMainViewModel(): ViewModel = MainViewModel()
}