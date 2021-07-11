package com.neomind.kanesoundboard.ui.base

import androidx.appcompat.app.AppCompatActivity
import com.neomind.kanesoundboard.KaneApplication
import com.neomind.kanesoundboard.common.dagger.activity.ActivityComponent
import com.neomind.kanesoundboard.common.dagger.presentation.PresentationComponent

open class BaseActivity : AppCompatActivity() {
    private val appComponent
        get() = KaneApplication.appComponent

    val activityComponent: ActivityComponent by lazy {
        appComponent.newActivityComponent()
    }

    private val presentationComponent: PresentationComponent by lazy {
        activityComponent.newPresentationComponent()
    }

    protected val injector
        get() = presentationComponent
}