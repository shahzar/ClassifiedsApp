package com.shahzar.classifiedsapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.shahzar.classifiedsapp.data.ProductRepository
import com.shahzar.classifiedsapp.data.local.UserPreferences
import com.shahzar.classifiedsapp.data.model.response.Product
import com.shahzar.classifiedsapp.ui.base.BaseViewModel
import com.shahzar.classifiedsapp.util.livedata.Status
import javax.inject.Inject

class ProductDetailsViewModel @Inject constructor (
    private val productRepository: ProductRepository) : BaseViewModel(){


}
