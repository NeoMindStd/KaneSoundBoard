package com.neomind.kanesoundboard.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.neomind.kanesoundboard.KaneApplication
import com.neomind.kanesoundboard.R
import com.neomind.kanesoundboard.databinding.ActivityMainBinding
import com.neomind.kanesoundboard.store.KaneSoundStore
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var kaneSoundStore: KaneSoundStore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        KaneApplication.appComponent.inject(this)

        initViewModel()
        initView()
    }

    private fun initViewModel() {
        val kaneSounds = kaneSoundStore.getKaneSoundAssets()

        viewModel.init(kaneSounds)
    }

    private fun initView() {
        val adapter = KaneSoundAdapter(this)
        binding.mainRecycler.layoutManager = GridLayoutManager(this, 3)
        binding.mainRecycler.adapter = adapter

        viewModel.kaneSounds.observe(this) {
            adapter.notifyDataSetChanged()
        }
    }
}