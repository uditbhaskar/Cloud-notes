package com.example.cloudnotes.di.component

import com.example.cloudnotes.di.ViewModelScope
import com.example.cloudnotes.di.component.ApplicationComponent
import com.example.cloudnotes.di.module.ViewHolderModule


import dagger.Component

@ViewModelScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ViewHolderModule::class]
)
interface ViewHolderComponent {


}