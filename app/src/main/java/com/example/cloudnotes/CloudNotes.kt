package com.example.cloudnotes

import android.app.Application
import com.example.cloudnotes.di.component.ApplicationComponent
import com.example.cloudnotes.di.component.DaggerApplicationComponent
import com.example.cloudnotes.di.module.ApplicationModule

class CloudNotes : Application() {

    lateinit var applicationComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        injectDependencies()
    }

    private fun injectDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }

}