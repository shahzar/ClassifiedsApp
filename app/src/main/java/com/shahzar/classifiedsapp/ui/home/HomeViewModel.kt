package com.shahzar.classifiedsapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.shahzar.classifiedsapp.data.ProductRepository
import com.shahzar.classifiedsapp.data.local.UserPreferences
import com.shahzar.classifiedsapp.data.model.response.Product
import com.shahzar.classifiedsapp.ui.base.BaseViewModel
import com.shahzar.classifiedsapp.util.livedata.Resource
import com.shahzar.classifiedsapp.util.livedata.Status
import javax.inject.Inject

class HomeViewModel @Inject constructor (
    private val productRepository: ProductRepository) : BaseViewModel(){

    private val _onProductList = MutableLiveData<List<Product>>()
    val onProductList: LiveData<List<Product>>
        get() = _onProductList

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean>
        get() = _loading

    init {
        getProducts()
    }

     private fun getProducts() {
        _loading.value = true
         ioLaunch(
             block = {
                productRepository.getProducts()
             },
             onSuccess = { res ->
                 when (res.status) {
                     Status.SUCCESS -> {
                         _loading.value = false
                         _onProductList.value = res.data?.products
                     }
                     Status.ERROR -> {
                         _loading.value = false
                         _onError.value = res.message
                     }
                     Status.LOADING -> {
                         _loading.value = false
                     }
                 }

             }
         )

     }



}
