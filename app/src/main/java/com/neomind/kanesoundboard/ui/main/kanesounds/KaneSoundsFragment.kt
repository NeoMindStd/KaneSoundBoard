package com.neomind.kanesoundboard.ui.main.kanesounds

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.neomind.kanesoundboard.KaneApplication
import com.neomind.kanesoundboard.R
import com.neomind.kanesoundboard.common.ViewModelFactory
import com.neomind.kanesoundboard.databinding.FragmentKaneSoundsBinding
import com.neomind.kanesoundboard.store.KaneSoundStore
import com.neomind.kanesoundboard.ui.base.BaseFragment
import javax.inject.Inject

class KaneSoundsFragment : BaseFragment() {

    @Inject
    lateinit var app: KaneApplication

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var kaneSoundStore: KaneSoundStore

    private val viewModel: KaneSoundsViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(KaneSoundsViewModel::class.java)
    }

    private lateinit var binding: FragmentKaneSoundsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        injector.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_kane_sounds, container, false)

        initViewModel()
        initView()

        return binding.root
    }

    private fun initViewModel() {
        val kaneSounds = kaneSoundStore.getKaneSoundAssets()

        viewModel.init(kaneSounds)
    }

    private fun initView() {
        val adapter = KaneSoundAdapter(this)
        binding.mainRecycler.layoutManager = GridLayoutManager(context, 3)
        binding.mainRecycler.adapter = adapter

        viewModel.kaneSounds.observe(this) {
            adapter.notifyDataSetChanged()
        }
    }

    companion object {
        fun newInstance() = KaneSoundsFragment()
    }
}