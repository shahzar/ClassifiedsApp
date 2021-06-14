package com.shahzar.classifiedsapp.ui.main

import com.shahzar.classifiedsapp.data.ProductRepository
import com.shahzar.classifiedsapp.data.local.UserPreferences
import com.shahzar.classifiedsapp.ui.base.BaseViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor (
    private val productRepository: ProductRepository,
    private val prefs: UserPreferences
) : BaseViewModel()