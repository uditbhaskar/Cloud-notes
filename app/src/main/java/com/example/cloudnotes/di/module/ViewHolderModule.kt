package com.example.cloudnotes.di.module

import androidx.lifecycle.LifecycleRegistry
import com.example.cloudnotes.di.ViewModelScope
import com.example.cloudnotes.ui.base.BaseItemViewHolder

import dagger.Module
import dagger.Provides

@Module
class ViewHolderModule(private val viewHolder: BaseItemViewHolder<*, *>) {

    @Provides
    @ViewModelScope
    fun provideLifecycleRegistry(): LifecycleRegistry = LifecycleRegistry(viewHolder)
}