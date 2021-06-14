package com.shahzar.classifiedsapp.di.components

import android.app.Application
import com.shahzar.classifiedsapp.ui.main.MainActivity
import com.shahzar.classifiedsapp.di.ViewModelBuilder
import com.shahzar.classifiedsapp.di.modules.AppModule
import com.shahzar.classifiedsapp.di.modules.NetworkModule
import com.shahzar.classifiedsapp.ui.home.HomeFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, ViewModelBuilder::class])
interface AppComponent {

    fun application(application: Application)
    fun inject(mainActivity: MainActivity)
    fun inject(homeFragment: HomeFragment)

}