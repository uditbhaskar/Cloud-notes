package com.example.cloudnotes.di.component

import com.example.cloudnotes.di.ActivityScope
import com.example.cloudnotes.di.module.ActivityModule
import dagger.Component

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ActivityModule::class]
)
interface ActivityComponent {

}