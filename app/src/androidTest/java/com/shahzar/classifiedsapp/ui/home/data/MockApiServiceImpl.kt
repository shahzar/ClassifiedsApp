package com.shahzar.classifiedsapp.ui.home.data

import com.google.gson.Gson
import com.shahzar.classifiedsapp.data.model.response.ProductListResponse
import com.shahzar.classifiedsapp.data.remote.ApiService

class MockApiServiceImpl(): ApiService {

    override suspend fun productList(): ProductListResponse {
        return Gson().fromJson(RawData.productList, ProductListResponse::class.java)
    }
}