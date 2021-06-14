package com.shahzar.classifiedsapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.shahzar.classifiedsapp.data.ProductRepository
import com.shahzar.classifiedsapp.data.local.UserPreferences
import com.shahzar.classifiedsapp.data.model.response.Product
import com.shahzar.classifiedsapp.ui.base.BaseViewModel
import javax.inject.Inject

class HomeViewModel @Inject constructor (
    private val productRepository: ProductRepository,
    private val prefs: UserPreferences) : BaseViewModel(){

    private val _onProductList = MutableLiveData<List<Product>>()

    val onProductList: LiveData<List<Product>>
        get() = _onProductList

    init {
        getProducts()
    }

     private fun getProducts() {

         ioLaunch(
             block = {
                productRepository.getProducts()
             },
             onSuccess = {
                _onProductList.value = it.products
             }
         )

     }



}
