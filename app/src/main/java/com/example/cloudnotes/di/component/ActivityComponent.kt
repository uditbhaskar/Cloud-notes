package com.example.cloudnotes.di.component

import com.example.cloudnotes.di.ActivityScope
import com.example.cloudnotes.di.module.ActivityModule
import com.example.cloudnotes.ui.login.LoginActivity
import com.example.cloudnotes.ui.splash.SplashActivity
import dagger.Component

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ActivityModule::class]
)
interface ActivityComponent {

    fun inject(activity: SplashActivity)
    // we have to scan the class of type Splash Activity and provide dependencies to all
    // the places with @inject in the class (be it constructor,method,or field) and also its base class ie., the class it implements.
    fun inject(activity: LoginActivity)
}