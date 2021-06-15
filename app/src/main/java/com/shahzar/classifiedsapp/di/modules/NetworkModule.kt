package com.shahzar.classifiedsapp.di.modules

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.google.gson.GsonBuilder
import com.shahzar.classifiedsapp.BuildConfig
import com.shahzar.classifiedsapp.R
import com.shahzar.classifiedsapp.data.remote.ApiService
import com.shahzar.classifiedsapp.ui.home.ItemListAdapter
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {

    private val BASE_URL = "https://ey3f2y0nre.execute-api.us-east-1.amazonaws.com/default/"


    @Provides
    fun provideApiService(okHttpClient: OkHttpClient, gsonConverterFactory: GsonConverterFactory): ApiService {

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .client(okHttpClient)
            .build().create(ApiService::class.java)

    }

    @Provides
    fun provideNoAuthOkHttp(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val okHttpBuilder = OkHttpClient.Builder()
        okHttpBuilder.addInterceptor(loggingInterceptor)
        return okHttpBuilder.build()
    }

    @Singleton
    @Provides
    fun provideLogInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        } else {
            logging.setLevel(HttpLoggingInterceptor.Level.NONE)
        }
        return logging
    }


    @Provides
    fun provideGson(): GsonConverterFactory = GsonConverterFactory.create(GsonBuilder().create())

    @Provides
    fun provideGlideRequestManager(context: Context, requestOptions: RequestOptions): RequestManager {
        return Glide.with(context)
            .setDefaultRequestOptions(requestOptions)
    }

    @Provides
    fun providesGlideRequestOptions(): RequestOptions {
        return RequestOptions()
            .placeholder(R.drawable.anim_progress)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
    }

    @Provides
    fun getItemListAdapter(requestManager: RequestManager): ItemListAdapter {
        return ItemListAdapter(requestManager)
    }

}