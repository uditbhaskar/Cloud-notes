package com.example.cloudnotes.di.module


import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cloudnotes.ui.base.BaseActivity
import com.example.cloudnotes.ui.splash.SplashViewModel
import com.example.cloudnotes.utils.ViewModelProviderFactory
import com.example.cloudnotes.utils.network.NetworkHelper
import com.example.cloudnotes.utils.rx.SchedulerProvider

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable


/**
 * Kotlin Generics Reference: https://kotlinlang.org/docs/reference/generics.html
 * Basically it means that we can pass any class that extends BaseActivity which take
 * BaseViewModel subclass as parameter
 */

@Module
class ActivityModule(private val activity: BaseActivity<*>) {

    @Provides
    fun provideLinearLayoutManager(): LinearLayoutManager = LinearLayoutManager(activity)

    @Provides
    fun providesSplashViewModel(
            schedulerProvider: SchedulerProvider,
            compositeDisposable: CompositeDisposable,
            networkHelper: NetworkHelper
    ): SplashViewModel = ViewModelProviders.of(
            activity, ViewModelProviderFactory(SplashViewModel::class) {
        SplashViewModel(
                schedulerProvider,
                compositeDisposable,
                networkHelper
        )
    }).get(SplashViewModel::class.java)
}

