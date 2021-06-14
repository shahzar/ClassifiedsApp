package com.shahzar.classifiedsapp

import android.app.Application
import com.shahzar.classifiedsapp.di.components.AppComponent
import com.shahzar.classifiedsapp.di.components.DaggerAppComponent
import com.shahzar.classifiedsapp.di.modules.AppModule

class BaseApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
        appComponent.application(this)
    }

}