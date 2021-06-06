package com.neomind.kanesoundboard.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.neomind.kanesoundboard.KaneApplication
import com.neomind.kanesoundboard.ViewModelFactory
import javax.inject.Inject

open class BaseActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        KaneApplication.appComponent.inject(this)
    }
}