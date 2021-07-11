package com.neomind.kanesoundboard.ui.base

import androidx.fragment.app.Fragment
import com.neomind.kanesoundboard.KaneApplication
import com.neomind.kanesoundboard.common.dagger.presentation.PresentationComponent

open class BaseFragment : Fragment() {
    private val appComponent
        get() = KaneApplication.appComponent

    private val presentationComponent: PresentationComponent by lazy {
        (requireActivity() as BaseActivity).activityComponent.newPresentationComponent()
    }

    protected val injector
        get() = presentationComponent
}
