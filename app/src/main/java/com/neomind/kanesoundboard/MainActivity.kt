package com.neomind.kanesoundboard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.neomind.kanesoundboard.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var kaneSoundProvider: KaneSoundProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        KaneApplication.appComponent.inject(this)

        initViewModel()
        initView()
    }

    private fun initViewModel() {
        val kaneSounds = kaneSoundProvider.getKaneSoundAssets()

        viewModel.init(kaneSounds)
    }

    private fun initView() {
    }
}