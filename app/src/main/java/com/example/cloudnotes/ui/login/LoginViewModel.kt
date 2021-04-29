package com.example.cloudnotes.ui.login

import com.example.cloudnotes.ui.base.BaseViewModel
import com.example.cloudnotes.utils.network.NetworkHelper
import com.example.cloudnotes.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class LoginViewModel(schedulerProvider: SchedulerProvider,
                     compositeDisposable: CompositeDisposable,
                     networkHelper: NetworkHelper)
    : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {
    override fun onCreate() {

    }
}