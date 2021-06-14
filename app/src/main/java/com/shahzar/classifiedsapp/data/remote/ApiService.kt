package com.shahzar.classifiedsapp.data.remote

import com.shahzar.classifiedsapp.data.model.response.ProductListResponse
import retrofit2.http.GET

interface ApiService {

    @GET("dynamodb-writer")
    suspend fun productList(): ProductListResponse


}