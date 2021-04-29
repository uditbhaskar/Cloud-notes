package com.example.cloudnotes.ui.splash

import android.os.Bundle
import com.example.cloudnotes.R
import com.example.cloudnotes.di.component.ActivityComponent
import com.example.cloudnotes.ui.base.BaseActivity

class SplashActivity : BaseActivity<SplashViewModel>() {
    override fun provideLayoutId(): Int = R.layout.activity_splash


    override fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun setupView(savedInstanceState: Bundle?) {

    }

    override fun setupObservers() {
        super.setupObservers()

    }


}