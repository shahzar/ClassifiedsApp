package com.shahzar.classifiedsapp.di.modules

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.shahzar.classifiedsapp.NavMgr
import com.shahzar.classifiedsapp.R
import com.shahzar.classifiedsapp.util.Constants
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val application: Application) {

    @Provides
    fun getString(): String {
        return application.getString(R.string.app_name)
    }

    @Provides
    fun getContext(): Context {
        return application
    }

    @Provides
    fun getNavMgr(): NavMgr {
        return NavMgr()
    }

    @Singleton
    @Provides
    fun getSharedPrefs(): SharedPreferences {
        return application.getSharedPreferences(Constants.SHARED_PREFS_NAME, Context.MODE_PRIVATE)
    }

}