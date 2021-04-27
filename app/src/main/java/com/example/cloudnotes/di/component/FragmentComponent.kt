package com.example.cloudnotes.di.component

import com.example.cloudnotes.di.FragmentScope
import com.example.cloudnotes.di.component.ApplicationComponent
import com.example.cloudnotes.di.module.FragmentModule
import dagger.Component

@FragmentScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [FragmentModule::class]
)
interface FragmentComponent {


}