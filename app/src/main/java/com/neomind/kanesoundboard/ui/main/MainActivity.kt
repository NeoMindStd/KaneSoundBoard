package com.neomind.kanesoundboard.ui.main

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.neomind.kanesoundboard.KaneApplication
import com.neomind.kanesoundboard.R
import com.neomind.kanesoundboard.databinding.ActivityMainBinding
import com.neomind.kanesoundboard.ui.base.BaseActivity
import com.neomind.kanesoundboard.ui.main.kanesounds.KaneSoundsFragment
import javax.inject.Inject

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var app: KaneApplication

    override fun onCreate(savedInstanceState: Bundle?) {
        injector.inject(this)

        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initView()
    }

    private fun initView() {
        supportFragmentManager.beginTransaction()
            .add(R.id.main_fragment_container, KaneSoundsFragment.newInstance())
            .commit()
    }
}