package com.neomind.kanesoundboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Provider

class ViewModelFactory(
    private val providerMap: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) :
    ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        providerMap[modelClass]?.get() as T
}