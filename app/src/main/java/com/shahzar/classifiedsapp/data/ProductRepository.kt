package com.shahzar.classifiedsapp.data

import com.shahzar.classifiedsapp.data.local.UserPreferences
import com.shahzar.classifiedsapp.data.remote.ApiService
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val remoteDataSrc: ApiService,
    private val prefs: UserPreferences,
): BaseRepository() {

    suspend fun getProducts() = safeApiCall {
        val response = remoteDataSrc.productList()
        return@safeApiCall response
    }



}