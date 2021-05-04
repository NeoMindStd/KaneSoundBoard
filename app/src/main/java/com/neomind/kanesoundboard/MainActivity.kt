package com.neomind.kanesoundboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.neomind.kanesoundboard.databinding.ActivityMainBinding
import kotlin.math.max

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initView()
    }

    private fun initView() {
        viewModel.count.observe(this) {
            binding.mainText.text = it.toString()
        }

        binding.mainDecreaseButton.setOnClickListener {
            viewModel.decreaseCount()
        }
        binding.mainIncreaseButton.setOnClickListener {
            viewModel.increaseCount()
        }
    }
}