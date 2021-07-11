package com.neomind.kanesoundboard.common.dagger.presentation

import androidx.lifecycle.ViewModel
import com.neomind.kanesoundboard.ui.main.kanesounds.KaneSoundsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(KaneSoundsViewModel::class)
    abstract fun mainViewModel(kaneSoundsViewModel: KaneSoundsViewModel): ViewModel
}