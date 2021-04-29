package com.example.cloudnotes.ui.splash

import androidx.lifecycle.MutableLiveData
import com.example.cloudnotes.ui.base.BaseViewModel
import com.example.cloudnotes.utils.common.Event
import com.example.cloudnotes.utils.network.NetworkHelper
import com.example.cloudnotes.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class SplashViewModel(schedulerProvider: SchedulerProvider,
                      compositeDisposable: CompositeDisposable,
                      networkHelper: NetworkHelper
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {

    val launchLogin: MutableLiveData<Event<Map<String, String>>> = MutableLiveData()

    override fun onCreate() {
        launchLogin.postValue(Event(emptyMap()))
    }
}