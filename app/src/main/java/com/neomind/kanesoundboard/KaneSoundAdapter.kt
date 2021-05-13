package com.neomind.kanesoundboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.neomind.kanesoundboard.databinding.RecyclerItemMainBinding

class KaneSoundAdapter(activity: MainActivity) :
    RecyclerView.Adapter<KaneSoundAdapter.ViewHolder>() {
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(activity).get(MainViewModel::class.java)
    }

    private var kaneSounds: List<KaneSound> = viewModel.kaneSounds.value ?: emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<RecyclerItemMainBinding>(
            LayoutInflater.from(parent.context),
            R.layout.recycler_item_main,
            parent,
            false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(kaneSounds[position])
    }

    override fun getItemCount(): Int {
        return kaneSounds.size
    }

    inner class ViewHolder(private val binding: RecyclerItemMainBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(kaneSound: KaneSound) {
            binding.mainRecyclerPlayButton.text = kaneSound.name
            binding.mainRecyclerPlayButton.setOnClickListener {
                viewModel.playSound(kaneSound.assetFileDescriptor)
            }
        }
    }
}