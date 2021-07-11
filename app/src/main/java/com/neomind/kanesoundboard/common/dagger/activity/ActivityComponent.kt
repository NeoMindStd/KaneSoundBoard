package com.neomind.kanesoundboard.common.dagger.activity

import com.neomind.kanesoundboard.common.dagger.presentation.PresentationComponent
import dagger.Subcomponent

@ActivityScope
@Subcomponent()
interface ActivityComponent {
    fun newPresentationComponent(): PresentationComponent
}