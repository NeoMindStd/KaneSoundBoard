package com.neomind.kanesoundboard.common.dagger.presentation

import com.neomind.kanesoundboard.ui.main.MainActivity
import com.neomind.kanesoundboard.ui.main.kanesounds.KaneSoundsFragment
import dagger.Subcomponent

@PresentationScope
@Subcomponent(
    modules = [
        ViewModelModule::class,
    ]
)
interface PresentationComponent {
    fun inject(mainActivity: MainActivity)

    fun inject(kaneSoundsFragment: KaneSoundsFragment)
}