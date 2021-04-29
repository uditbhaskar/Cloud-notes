package com.example.cloudnotes.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.cloudnotes.R
import com.example.cloudnotes.di.component.ActivityComponent
import com.example.cloudnotes.ui.base.BaseActivity
import com.example.cloudnotes.ui.login.LoginActivity

class SplashActivity : BaseActivity<SplashViewModel>() {
    override fun provideLayoutId(): Int = R.layout.activity_splash


    override fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun setupView(savedInstanceState: Bundle?) {

    }

    override fun setupObservers() {
        super.setupObservers()

        viewModel.launchLogin.observe(this, Observer {
            it.getIfNotHandled()?.run {
                startActivity(Intent(applicationContext, LoginActivity::class.java))
            }
        })
    }


}