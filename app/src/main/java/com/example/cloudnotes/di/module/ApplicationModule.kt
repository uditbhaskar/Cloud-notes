package com.example.cloudnotes.di.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.example.cloudnotes.BuildConfig
import com.example.cloudnotes.CloudNotes
import com.example.cloudnotes.R
import com.example.cloudnotes.data.local.DatabaseService
import com.example.cloudnotes.data.remote.NetworkService
import com.example.cloudnotes.data.remote.Networking

import com.example.cloudnotes.di.ApplicationContext
import com.example.cloudnotes.utils.network.NetworkHelper
import com.example.cloudnotes.utils.rx.RxSchedulerProvider
import com.example.cloudnotes.utils.rx.SchedulerProvider
import com.google.android.gms.auth.api.signin.GoogleSignInOptions

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class ApplicationModule(private val applicationMy: CloudNotes) {

    @Provides
    @Singleton
    fun provideApplication(): Application = applicationMy

    @Provides
    @Singleton
    @ApplicationContext
    fun provideContext(): Context = applicationMy


    @Provides
    fun providesGoogleSignInOptions(): GoogleSignInOptions =
        GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(applicationMy.getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

    /**
     * Since this function do not have @Singleton then each time CompositeDisposable is injected
     * then a new instance of CompositeDisposable will be provided
     */
    @Provides
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    fun provideSchedulerProvider(): SchedulerProvider = RxSchedulerProvider()

    @Provides
    @Singleton
    fun provideSharedPreferences(): SharedPreferences =
        applicationMy.getSharedPreferences("bootcamp-instagram-project-prefs", Context.MODE_PRIVATE)

    /**
     * We need to write @Singleton on the provide method if we are create the instance inside this method
     * to make it singleton. Even if we have written @Singleton on the instance's class
     */
    @Provides
    @Singleton
    fun provideDatabaseService(): DatabaseService =
        Room.databaseBuilder(
            applicationMy, DatabaseService::class.java,
            "bootcamp-instagram-project-db"
        ).build()

    @Provides
    @Singleton
    fun provideNetworkService(): NetworkService =
        Networking.create(
            BuildConfig.API_KEY,
            BuildConfig.BASE_URL,
            applicationMy.cacheDir,
            10 * 1024 * 1024 // 10MB
        )

    @Singleton
    @Provides
    fun provideNetworkHelper(): NetworkHelper = NetworkHelper(applicationMy)
}