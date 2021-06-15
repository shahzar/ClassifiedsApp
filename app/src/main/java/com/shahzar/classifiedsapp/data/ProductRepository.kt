package com.shahzar.classifiedsapp.data

import com.shahzar.classifiedsapp.data.local.UserPreferences
import com.shahzar.classifiedsapp.data.remote.ApiService
import com.shahzar.classifiedsapp.util.livedata.Resource
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val remoteDataSrc: ApiService
): BaseRepository() {

    suspend fun getProducts() = safeApiCall {
        val response = remoteDataSrc.productList()
        return@safeApiCall Resource.success(response)
    }



}