package com.neomind.kanesoundboard

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.neomind.kanesoundboard.databinding.ActivityMainBinding

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
        val files = (assets.list("") ?: emptyArray()).map { path ->
            arrayOf(path) + path.split("/", ".")
        }.filter { elements -> elements.size > 2 && elements.last() == "flac" }

        for (file in files) {
            Log.d("initView", "found sound file - ${file.first()}")
            val kaneSound = KaneSound(
                name = file[file.lastIndex - 1],
                fullPath = file.first()
            )
            Log.d("initView", "kaneSound - $kaneSound")
        }
    }
}